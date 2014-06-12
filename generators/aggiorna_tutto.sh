echo genero i pazienti e li copio nella cartella database...
cd pazienti
./fai_pazienti.sh
cd ..

echo copio il file paziente.sql dove serve...
cp pazienti/paziente.sql cartelleCliniche/ 
cp pazienti/paziente.sql cartelleCliniche/bin
cp pazienti/paziente.sql sintomi_diagnosi_conferme_contraddizioni/

echo genero le cartelle cliniche...
cd cartelleCliniche/bin
java main > cartelle_cliniche.sql
cd ../..

echo copio cartelle_cliniche.sql dove serve...
cp cartelleCliniche/bin/cartelle_cliniche.sql ../database
cp cartelleCliniche/bin/cartelle_cliniche.sql terapie/terapie

echo genero le terapie...
cd terapie/terapie/
java -jar terapie.jar > terapie.sql
cd ../..

echo copio le terapie dove serve...
cp terapie/terapie/terapie.sql ../database

echo genero i medici e le specializzazioni...
cd Medico_Specializzazioni_SpecDelMedico/bin
java -jar tuttomedico.jar
cd ../..

echo copio i medici e le specializzazioni...
cp Medico_Specializzazioni_SpecDelMedico/bin/*.sql ../database
cp Medico_Specializzazioni_SpecDelMedico/bin/medico.sql sintomi_diagnosi_conferme_contraddizioni/

echo genero sintomi diagnosi conferme e contraddizioni...
cd sintomi_diagnosi_conferme_contraddizioni
java -jar sint_diagn_conf_contr.jar

echo copio sintomi diagnosi conferme e contraddizioni...
cp  diagnosi.sql sintomi.sql conferme.sql contraddizioni.sql ../../database
