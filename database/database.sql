DROP TABLE SPEC_DEL_MEDICO;
DROP TABLE SPECIALIZZAZIONI;
DROP TABLE CONTRADDIZIONI;
DROP TABLE CONFERME;
DROP TABLE DIAGNOSI;
DROP TABLE MEDICO;
DROP TABLE SINTOMI;
DROP TABLE RISCHI_PAZIENTE;
DROP TABLE FATTORI_RISCHIO;
DROP TABLE TERAPIE;
DROP TABLE CARTELLA_CLINICA;
DROP TABLE PAZIENTE;

drop function controlla_data (date, varchar(30));
drop function controlla_data_cartella ( DATE, VARCHAR(30) );



----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------              PAZIENTE             ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE PAZIENTE (

    CODSAN              VARCHAR(30)     NOT NULL,
    NOME                VARCHAR(30)     NOT NULL,
    COGNOME             VARCHAR(30)     NOT NULL,
    NASCITA				DATE            NOT NULL,
    PSW                 VARCHAR(30)     NOT NULL,
    CITTA               VARCHAR(60)     NOT NULL,
    VIA                 VARCHAR(30)     NOT NULL,
    PROV                VARCHAR(30)     NOT NULL,
    CAP                 INT             NOT NULL,
    -- varchar per gestire i civici tipo 10/b
    CIVICO              VARCHAR(10)     NOT NULL,
    
    PRIMARY KEY(CODSAN)
);





----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------        CARTELLA CLINICA           ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE CARTELLA_CLINICA (

    ID                  VARCHAR(30)     NOT NULL,
    DATA_RICOVERO       DATE            NOT NULL,
    DATA_DIMISSIONE     DATE            	,
    MOTIVO              VARCHAR(200)     NOT NULL,
    PROGNOSI            VARCHAR(200)             ,
    CODSAN              VARCHAR(30)     REFERENCES PAZIENTE(CODSAN) ON DELETE CASCADE ON UPDATE CASCADE,

    PRIMARY KEY(ID)
);


CREATE FUNCTION controlla_data_cartella ( data_c DATE, codsan_q VARCHAR(30) )
RETURNS VARCHAR(5)
AS
$BODY$
BEGIN
	IF EXISTS (select nascita from paziente as p where p.codsan = codsan_q and p.nascita < data_c ) then
	    return 'True';
	    end IF; 
	    return 'False';
    
END;$BODY$ LANGUAGE 'plpgsql';


ALTER TABLE CARTELLA_CLINICA ADD CONSTRAINT check_dataRicovero CHECK (controlla_data_cartella(DATA_RICOVERO, CODSAN) = 'True');


----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------             TERAPIE               ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE TERAPIE (

    ID_CARTELLA         VARCHAR(30)     NOT NULL,
    INIZIO              DATE            NOT NULL,
    FINE                DATE            NOT NULL,
    FREQUENZA           INT             NOT NULL,
    DOSE                FLOAT(5)        NOT NULL,
    FARMACO             VARCHAR(100)     NOT NULL,
    
    FOREIGN KEY(ID_CARTELLA) REFERENCES CARTELLA_CLINICA(ID) ON DELETE CASCADE ON UPDATE CASCADE
);


----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------        FATTORI_RISCHIO            ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE FATTORI_RISCHIO (

    NOME                VARCHAR(100)     PRIMARY KEY

);



----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------        RISCHI_PAZIENTE            ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE RISCHI_PAZIENTE (

    ID_PAZIENTE         VARCHAR(30)     NOT NULL,
    NOME_FATTORE        VARCHAR(100)     NOT NULL, 

    FOREIGN KEY(ID_PAZIENTE) REFERENCES PAZIENTE(CODSAN) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(NOME_FATTORE) REFERENCES FATTORI_RISCHIO(NOME) ON DELETE CASCADE ON UPDATE CASCADE
);



----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------             SINTOMI               ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE SINTOMI (

    ID_CARTELLA         VARCHAR(30)     REFERENCES CARTELLA_CLINICA(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    NOME                VARCHAR(200)     NOT NULL,
    INTENSITA           VARCHAR(10)     NOT NULL,
    DATA		DATE		NOT NULL,
    DURATA		INT		,


    PRIMARY KEY         (NOME, ID_CARTELLA),
    CHECK(INTENSITA IN  ('bassa', 'media', 'alta'))

);



----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------             MEDICO                ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE MEDICO (

    ID                  VARCHAR(30)     NOT NULL,
    NOME                VARCHAR(30)     NOT NULL,
    COGNOME             VARCHAR(30)     NOT NULL,
    PRIMARIO            VARCHAR(2)     NOT NULL,
    PSW                 VARCHAR(30)     NOT NULL,
    INIZIO_ATTIVITA     DATE            NOT NULL,

    PRIMARY KEY(ID)
);



----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------            DIAGNOSI               ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE DIAGNOSI (

    ID_PAZIENTE         VARCHAR(30)     REFERENCES PAZIENTE(CODSAN) ON DELETE CASCADE ON UPDATE CASCADE,
    ID_CARTELLA         VARCHAR(30)     REFERENCES CARTELLA_CLINICA(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    DATA                DATE            NOT NULL,
    ICD10               VARCHAR(30)     NOT NULL,
    PATOLOGIA           VARCHAR(200)     NOT NULL,
    ID_MEDICO           VARCHAR(30)     REFERENCES MEDICO(ID) ON DELETE CASCADE ON UPDATE CASCADE,

    PRIMARY KEY (ID_PAZIENTE, DATA, ID_CARTELLA)

    
);

CREATE FUNCTION controlla_data ( data_c DATE, id_cartella VARCHAR(30) )
RETURNS VARCHAR(5)
AS
$BODY$
BEGIN
	--se esiste la data dimissione la controllo dopo
	IF EXISTS (select data_dimissione from cartella_clinica as c where c.id = id_cartella ) then
	    IF EXISTS (select data_ricovero from cartella_clinica as c where c.id = id_cartella and c.data_ricovero < data_c and c.data_dimissione > data_c ) then
	    return 'True';
	    end IF; 
	    return 'False';
    else
	    IF EXISTS (select data_ricovero from cartella_clinica as c where c.id = id_cartella and c.data_ricovero < data_c ) then
	    return 'True';
	    end IF; 
	    return 'False';
		    	
    end IF;
    
END;$BODY$ LANGUAGE 'plpgsql';


ALTER TABLE DIAGNOSI ADD CONSTRAINT check_data CHECK (controlla_data(DATA, ID_CARTELLA) = 'True');

----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------            CONFERME               ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE CONFERME (

    ID_SINTOMO          VARCHAR(30)     NOT NULL,
    N_SINT              VARCHAR(200)     NOT NULL,
    ID_PAZIENTE         VARCHAR(30)     NOT NULL,
    DATA                DATE            NOT NULL,
    ID_CARTELLA         VARCHAR(30)     NOT NULL,

    FOREIGN KEY(ID_SINTOMO, N_SINT) REFERENCES SINTOMI(ID_CARTELLA, NOME) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(ID_PAZIENTE, DATA, ID_CARTELLA ) REFERENCES DIAGNOSI(ID_PAZIENTE, DATA, ID_CARTELLA) ON DELETE CASCADE ON UPDATE CASCADE

);




----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------          CONTRADDIZIONI           ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE CONTRADDIZIONI (

    ID_SINTOMO          VARCHAR(30)     NOT NULL,
    N_SINT              VARCHAR(200)     NOT NULL,
    ID_PAZIENTE         VARCHAR(30)     NOT NULL,
    DATA                DATE            NOT NULL,
    ID_CARTELLA         VARCHAR(30)     NOT NULL,

    FOREIGN KEY(ID_SINTOMO, N_SINT) REFERENCES SINTOMI(ID_CARTELLA, NOME) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(ID_PAZIENTE, DATA, ID_CARTELLA ) REFERENCES DIAGNOSI(ID_PAZIENTE, DATA, ID_CARTELLA) ON DELETE CASCADE ON UPDATE CASCADE

);


----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------         SPECIALIZZAZIONI          ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE SPECIALIZZAZIONI (

    NOME                VARCHAR(30)     PRIMARY KEY   

);



----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
-------------------------------------          SPEC_DEL_MEDICO          ----------------------------------------------------------------
-------------------------------------                                   ----------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE SPEC_DEL_MEDICO (

    ID_MEDICO               VARCHAR(30)     NOT NULL,
    NOME_SPECIALIZZAZIONE   VARCHAR(30)     NOT NULL,

    FOREIGN KEY(ID_MEDICO) REFERENCES MEDICO(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(NOME_SPECIALIZZAZIONE) REFERENCES SPECIALIZZAZIONI(NOME) ON DELETE CASCADE ON UPDATE CASCADE
);
