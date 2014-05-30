package gen;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;
import java.util.Vector;

public class Gen {

	Vector<String> cas_cogn;
	Vector<String> cas_nom;
	Vector<String> prov;
	
	Random r;
	
	
	public Gen(){
		
		
		cas_cogn = new Vector<String>();
		cas_nom = new Vector<String>();
		prov = new Vector<String>();
		
		cas_cogn.add("ba");
		cas_cogn.add("be");
		cas_cogn.add("bi");
		cas_cogn.add("bo");
		cas_cogn.add("bu");
		
		cas_cogn.add("ca");
		cas_cogn.add("ce");
		cas_cogn.add("ci");
		cas_cogn.add("co");
		cas_cogn.add("cu");
		cas_cogn.add("chi");
		cas_cogn.add("cca");
		cas_cogn.add("cce");
		cas_cogn.add("cci");
		cas_cogn.add("cco");
		cas_cogn.add("ccu");

		
		
		cas_cogn.add("da");
		cas_cogn.add("de");
		cas_cogn.add("di");
		cas_cogn.add("do");
		cas_cogn.add("du");
		cas_cogn.add("dda");
		cas_cogn.add("dde");
		cas_cogn.add("ddi");
		cas_cogn.add("ddo");
		cas_cogn.add("ddu");
		
		cas_cogn.add("fa");
		cas_cogn.add("fe");
		cas_cogn.add("fi");
		cas_cogn.add("fo");
		cas_cogn.add("fu");
		cas_cogn.add("ffa");
		cas_cogn.add("ffe");
		cas_cogn.add("ffi");
		cas_cogn.add("ffo");
		cas_cogn.add("ffu");
		
		cas_cogn.add("ga");
		cas_cogn.add("ge");
		cas_cogn.add("gi");
		cas_cogn.add("go");
		cas_cogn.add("gga");
		cas_cogn.add("gge");
		cas_cogn.add("ggi");
		cas_cogn.add("ggo");
		cas_cogn.add("ghi");
		
		cas_cogn.add("ba");
		cas_cogn.add("be");
		cas_cogn.add("bi");
		cas_cogn.add("bo");
		cas_cogn.add("bu");
		cas_cogn.add("bba");
		cas_cogn.add("bbe");
		cas_cogn.add("bbi");
		cas_cogn.add("bbo");
		cas_cogn.add("bbu");

		cas_cogn.add("la");
		cas_cogn.add("le");
		cas_cogn.add("li");
		cas_cogn.add("lo");
		cas_cogn.add("lu");
		cas_cogn.add("lla");
		cas_cogn.add("lle");
		cas_cogn.add("lli");
		cas_cogn.add("llo");
		cas_cogn.add("llu");
		
		cas_cogn.add("ma");
		cas_cogn.add("me");
		cas_cogn.add("mi");
		cas_cogn.add("mo");
		cas_cogn.add("mu");
		cas_cogn.add("mma");
		cas_cogn.add("mme");
		cas_cogn.add("mmi");
		cas_cogn.add("mmo");
		cas_cogn.add("mmu");
		
		cas_cogn.add("na");
		cas_cogn.add("ne");
		cas_cogn.add("ni");
		cas_cogn.add("no");
		cas_cogn.add("nu");
		cas_cogn.add("nna");
		cas_cogn.add("nne");
		cas_cogn.add("nni");
		cas_cogn.add("nno");
		cas_cogn.add("nnu");

		cas_cogn.add("pa");
		cas_cogn.add("pe");
		cas_cogn.add("pi");
		cas_cogn.add("po");
		cas_cogn.add("pu");
		cas_cogn.add("ppa");
		cas_cogn.add("ppe");
		cas_cogn.add("ppi");
		cas_cogn.add("ppo");
		cas_cogn.add("ppu");

		cas_cogn.add("qu");

		cas_cogn.add("ra");
		cas_cogn.add("re");
		cas_cogn.add("ri");
		cas_cogn.add("ro");
		cas_cogn.add("ru");
		cas_cogn.add("rra");
		cas_cogn.add("rre");
		cas_cogn.add("rri");
		cas_cogn.add("rro");
		cas_cogn.add("rru");

		cas_cogn.add("sa");
		cas_cogn.add("se");
		cas_cogn.add("si");
		cas_cogn.add("so");
		cas_cogn.add("su");
		cas_cogn.add("ssa");
		cas_cogn.add("sse");
		cas_cogn.add("ssi");
		cas_cogn.add("sso");
		cas_cogn.add("ssu");

		cas_cogn.add("ta");
		cas_cogn.add("te");
		cas_cogn.add("ti");
		cas_cogn.add("to");
		cas_cogn.add("tu");
		cas_cogn.add("tta");
		cas_cogn.add("tte");
		cas_cogn.add("tti");
		cas_cogn.add("tto");
		cas_cogn.add("ttu");

		cas_cogn.add("va");
		cas_cogn.add("ve");
		cas_cogn.add("vi");
		cas_cogn.add("vo");
		cas_cogn.add("vu");

		cas_cogn.add("za");
		cas_cogn.add("ze");
		cas_cogn.add("zi");
		cas_cogn.add("zo");
		cas_cogn.add("zu");

		cas_cogn.add("zza");
		cas_cogn.add("zze");
		cas_cogn.add("zzi");
		cas_cogn.add("zzo");
		cas_cogn.add("zzu");

		
		
		cas_nom.add("Andrea");
		cas_nom.add("Luca");
		cas_nom.add("Marco");
		cas_nom.add("Francesco");
		cas_nom.add("Matteo");
		cas_nom.add("Alessandro");
		cas_nom.add("Davide");
		cas_nom.add("Simone");
		cas_nom.add("Federico");
		cas_nom.add("Lorenzo");
		cas_nom.add("Mattia");
		cas_nom.add("Stefano");
		cas_nom.add("Giuseppe");
		cas_nom.add("Riccardo");
		cas_nom.add("Daniele");
		cas_nom.add("Michele");
		cas_nom.add("Alessio");
		cas_nom.add("Antonio");
		cas_nom.add("Giovanni");
		cas_nom.add("Nicola");
		cas_nom.add("Gabriele");
		cas_nom.add("Fabio");
		cas_nom.add("Alberto");
		cas_nom.add("Giacomo");
		cas_nom.add("Giulio");
		cas_nom.add("Filippo");
		cas_nom.add("Gianluca");
		cas_nom.add("Paolo");
		cas_nom.add("Roberto");
		cas_nom.add("Salvatore");
		cas_nom.add("Emanuele");
		cas_nom.add("Edoardo");
		cas_nom.add("Enrico");
		cas_nom.add("Vincenzo");
		cas_nom.add("Nicolò");
		cas_nom.add("Leonardo");
		cas_nom.add("Jacopo");
		cas_nom.add("Manuel");
		cas_nom.add("Mirko");
		cas_nom.add("Tommaso");
		cas_nom.add("Pietro");
		cas_nom.add("Luigi");
		cas_nom.add("Giorgio");
		cas_nom.add("Angelo");
		cas_nom.add("Dario");
		cas_nom.add("Valerio");
		cas_nom.add("Domenico");
		cas_nom.add("Claudio");
		cas_nom.add("Alex");
		cas_nom.add("Christian ");
		cas_nom.add("Giulia");
		cas_nom.add("Chiara");
		cas_nom.add("Francesca");
		cas_nom.add("Federica");
		cas_nom.add("Sara");
		cas_nom.add("Martina");
		cas_nom.add("Valentina");
		cas_nom.add("Alessia");
		cas_nom.add("Silvia");
		cas_nom.add("Elisa");
		cas_nom.add("Ilaria");
		cas_nom.add("Eleonora");
		cas_nom.add("Giorgia");
		cas_nom.add("Elena");
		cas_nom.add("Laura");
		cas_nom.add("Alice");
		cas_nom.add("Alessandra");
		cas_nom.add("Jessica");
		cas_nom.add("Arianna");
		cas_nom.add("Marta");
		cas_nom.add("Veronica");
		cas_nom.add("Roberta");
		cas_nom.add("Anna");
		cas_nom.add("Giada");
		cas_nom.add("Claudia ");
		cas_nom.add("Beatrice");
		cas_nom.add("Valeria");
		cas_nom.add("Michela");
		cas_nom.add("Serena");
		cas_nom.add("Camilla");
		cas_nom.add("Irene");
		cas_nom.add("Cristina");
		cas_nom.add("Simona");
		cas_nom.add("Maria");
		cas_nom.add("Noemi");
		cas_nom.add("Stefania");
		cas_nom.add("Erika");
		cas_nom.add("Sofia");
		cas_nom.add("Lucia");
		cas_nom.add("Vanessa");
		cas_nom.add("Greta");
		cas_nom.add("Debora");
		cas_nom.add("Nicole");
		cas_nom.add("Angela");
		cas_nom.add("Paola");
		cas_nom.add("Caterina");
		cas_nom.add("Monica");
		cas_nom.add("Erica");
		cas_nom.add("Lisa");
		cas_nom.add("Gaia");
		cas_nom.add("FRANCESCA");
		cas_nom.add("GIULIA");
		cas_nom.add("SARA");
		cas_nom.add("ALESSIA");
		cas_nom.add("ANNA");
		cas_nom.add("FEDERICA");
		cas_nom.add("FEDERICO");
		cas_nom.add("MARCO");
		cas_nom.add("DANIELA");
		cas_nom.add("DANIELE");
		cas_nom.add("DANILO");
		cas_nom.add("DANILA");
		cas_nom.add("MATTEO");
		cas_nom.add("LUCA");
		cas_nom.add("MARIA");
		cas_nom.add("MARTINA");
		cas_nom.add("STEFANIA");
		cas_nom.add("STEFANO");
		cas_nom.add("CHIARA");
		cas_nom.add("CLARA");
		cas_nom.add("CLARISSA");
		cas_nom.add("ELISA");
		cas_nom.add("LISA");
		cas_nom.add("ALESSANDRA");
		cas_nom.add("LORENZO");
		cas_nom.add("DAVIDE");
		cas_nom.add("GIUSEPPE");
		cas_nom.add("GIUSEPPINA");
		cas_nom.add("SIMONA");
		cas_nom.add("SIMONE");
		cas_nom.add("SIMEONE");
		cas_nom.add("SIMONETTA");
		cas_nom.add("ANDREA");
		cas_nom.add("ANDREINA");
		cas_nom.add("NICOLA");
		cas_nom.add("NICOLO");
		cas_nom.add("NICOLE");
		cas_nom.add("NICOLETTA");
		cas_nom.add("ALICE");
		cas_nom.add("ELENA");
		cas_nom.add("ELIANA");
		cas_nom.add("VALENTINA");
		cas_nom.add("ROBERTO");
		cas_nom.add("ROBERTA");
		cas_nom.add("MATTIA");
		cas_nom.add("MICHELE");
		cas_nom.add("ANTONIO");
		cas_nom.add("LAURA");
		cas_nom.add("ELEONORA");
		cas_nom.add("RICCARDO");
		cas_nom.add("FABIO");
		cas_nom.add("FABIA");
		cas_nom.add("SILVIA");
		cas_nom.add("NOEMI");
		cas_nom.add("NAOMI");
		cas_nom.add("GABRIELLA");
		cas_nom.add("GABRIELE");
		cas_nom.add("ALESSANDRO");
		cas_nom.add("ALEX");
		cas_nom.add("SABRINA");
		cas_nom.add("ILARIA");
		cas_nom.add("GIORGIO");
		cas_nom.add("LEONARDO");
		cas_nom.add("SOFIA");
		cas_nom.add("FRANCESCO");
		cas_nom.add("CATERINA");
		cas_nom.add("CATIA");
		cas_nom.add("VERONICA");
		cas_nom.add("PAOLA");
		cas_nom.add("EMANUELA");
		cas_nom.add("EMANUELE");
		cas_nom.add("MARTA");
		cas_nom.add("LUCIA");
		cas_nom.add("CARMELA");
		cas_nom.add("CARMELO");
		cas_nom.add("CARMINE");
		cas_nom.add("CARMEN");
		cas_nom.add("CAMILLA");
		cas_nom.add("SAMUELE");
		cas_nom.add("BEATRICE");
		cas_nom.add("BICE");
		cas_nom.add("GAIA");
		cas_nom.add("GAIO");
		cas_nom.add("MATILDE");
		cas_nom.add("PIETRO");
		cas_nom.add("PIERA");
		cas_nom.add("PIERO");
		cas_nom.add("ALBERTO");
		cas_nom.add("LUDOVICA");
		cas_nom.add("GINEVRA");
		cas_nom.add("ARIANNA");
		cas_nom.add("AURORA");
		cas_nom.add("JESSICA");
		cas_nom.add("VALERIA");
		cas_nom.add("IRENE");
		cas_nom.add("SALVATORE");
		cas_nom.add("SALVATRICE");
		cas_nom.add("BARBARA");
		cas_nom.add("CRISTINA");
		cas_nom.add("ANGELA");
		cas_nom.add("GIADA");
		cas_nom.add("CARLO");
		cas_nom.add("CARLETTO");
		cas_nom.add("MIRKO");
		cas_nom.add("GIACOMO");
		cas_nom.add("LUCREZIA");
		cas_nom.add("ELISABETTA");
		cas_nom.add("JACOPO");
		cas_nom.add("TOMMASO");
		cas_nom.add("EDOARDA");
		cas_nom.add("EDOARDO");
		cas_nom.add("EDUARDO");
		cas_nom.add("GIANLUCA");
		cas_nom.add("LUIGI");
		cas_nom.add("LARA");
		cas_nom.add("CLAUDIA");
		cas_nom.add("BENEDETTA");
		cas_nom.add("VINCENZO");
		cas_nom.add("ANGELICA");
		cas_nom.add("RAFFAELE");
		cas_nom.add("REBECCA");
		cas_nom.add("GIOVANNI");
		cas_nom.add("GIOVANNA");
		cas_nom.add("EMMA");
		cas_nom.add("GRAZIA");
		cas_nom.add("MARIA GRAZIA");
		cas_nom.add("FILIPPO");
		cas_nom.add("ERICA");
		cas_nom.add("ERIKA");
		cas_nom.add("ERIC");
		cas_nom.add("VITTORIA");
		cas_nom.add("NADIA");
		cas_nom.add("MANUELE");
		cas_nom.add("MANUEL");
		cas_nom.add("MANUELA");
		cas_nom.add("MARGHERITA");
		cas_nom.add("SERENA");
		cas_nom.add("DEBORA");
		cas_nom.add("MARIANNA"); 
		
		
		prov.add("Torino");
		prov.add("Vercelli");
		prov.add("Novara");
		prov.add("Cuneo");
		prov.add("Asti");
		prov.add("Alessandria");
		prov.add("Biella");
		prov.add("Verbano-Cusio-Ossola");
		prov.add("Aosta");
		prov.add("Varese");
		prov.add("Como");
		prov.add("Sondrio");
		prov.add("Milano");
		prov.add("Bergamo");
		prov.add("Brescia");
		prov.add("Pavia");
		prov.add("Cremona");
		prov.add("Mantova");
		prov.add("Lecco");
		prov.add("Lodi");
		prov.add("Bolzano");
		prov.add("Trento");
		prov.add("Verona");
		prov.add("Vicenza");
		prov.add("Belluno");
		prov.add("Treviso");
		prov.add("Venezia");
		prov.add("Padova");
		prov.add("Rovigo");
		prov.add("Udine");
		prov.add("Gorizia");
		prov.add("Trieste");
		prov.add("Pordenone");
		prov.add("Imperia");
		prov.add("Savona");
		prov.add("Genova");
		prov.add("La Spezia");
		prov.add("Piacenza");
		prov.add("Parma");
		prov.add("Reggio nell Emilia");
		prov.add("Modena");
		prov.add("Bologna");
		prov.add("Ferrara");
		prov.add("Ravenna");
		prov.add("Forli-Cesena");
		prov.add("Rimini");
		prov.add("Massa-Carrara");
		prov.add("Lucca");
		prov.add("Pistoia");
		prov.add("Firenze");
		prov.add("Livorno");
		prov.add("Pisa");
		prov.add("Arezzo");
		prov.add("Siena");
		prov.add("Grosseto");
		prov.add("Prato");
		prov.add("Perugia");
		prov.add("Terni");
		prov.add("Pesaro");
		prov.add("Urbino");
		prov.add("Ancona");
		prov.add("Macerata");
		prov.add("Ascoli Piceno");
		prov.add("Viterbo");
		prov.add("Rieti");
		prov.add("Roma");
		prov.add("Latina");
		prov.add("Frosinone");
		prov.add("Aquila");
		prov.add("Teramo");
		prov.add("Pescara");
		prov.add("Chieti");
		prov.add("Campobasso");
		prov.add("Isernia");
		prov.add("Caserta");
		prov.add("Benevento");
		prov.add("Napoli");
		prov.add("Avellino");
		prov.add("Salerno");
		prov.add("Foggia");
		prov.add("Bari");
		prov.add("Taranto");
		prov.add("Brindisi");
		prov.add("Lecce");
		prov.add("Potenza");
		prov.add("Matera");
		prov.add("Cosenza");
		prov.add("Catanzaro");
		prov.add("Reggio di Calabria");
		prov.add("Crotone");
		prov.add("Vibo Valentia");
		prov.add("Trapani");
		prov.add("Palermo");
		prov.add("Messina");
		prov.add("Agrigento");
		prov.add("Caltanissetta");
		prov.add("Enna");
		prov.add("Catania");
		prov.add("Ragusa");
		prov.add("Siracusa");
		prov.add("Sassari");
		prov.add("Nuoro");
		prov.add("Cagliari");
		prov.add("Oristano");
		
		r = new Random();

		
	}
	
	
	public String newNome(){
		
		String s = ""; 
		
		s = cas_nom.get(r.nextInt(cas_nom.size()));
		s = s.substring(0,1).toUpperCase() + s.substring(1,s.length()).toLowerCase();
		
		
		return s;
		
	}
	
	
	public String newCognome(int len){
		
		String s = "";
		
		while(len-- > 0)
			s += cas_cogn.get(r.nextInt(cas_cogn.size()));
		
		if(s.substring(0,1).equals(s.substring(1,2)))
			s = s.substring(1, s.length());
		
		s = s.substring(0,1).toUpperCase() + s.substring(1,s.length()).toLowerCase();
		
		return s;
	}
	
	
	@SuppressWarnings("deprecation")
	public String newDate(){
		
		int mese = 1 + r.nextInt(12);
		
		String d = (r.nextInt(2013 - 1930) + 1930) + "-" + (1 + r.nextInt(11)) + "-";
		
		if(mese == 2)
			d+= 1 + r.nextInt(30);
		else
			d+= 1 + r.nextInt(28);
		
		return d;
	}
	
	
	public static void main (String[] args) throws IOException{
		
		Gen g = new Gen();
		
		String nome = "";
		String cognome = "";
		String data = "";
		String comune = "";
		String via = "";
		String cap = "";
		String civico = "";
		String provincia = "";
		String psw = "";
		
		int i = 1000;
		
		comuni c = new comuni();
		
		codfisc cod;
		
		
		while(i-- > 0)
		{
			nome = g.newNome();
			cognome = g.newCognome(1 + g.r.nextInt(5));
			data = g.newDate();
			comune = c.newComune();
			via = "via ";
			via += g.newCognome(1 + g.r.nextInt(4));

			cap = "" + 1 + g.r.nextInt(9);
			cap += 1 + g.r.nextInt(9);
			cap += 1 + g.r.nextInt(9);
			cap += 1 + g.r.nextInt(9);
			cap += 1 + g.r.nextInt(9);
			
			civico = "" + g.r.nextInt(200);
			if(i % 5 == 0)
				civico += "/b";
			else if(i % 12 == 0)
				civico += "/c";
			
			cod = new codfisc(cognome, nome, data, comune, (i%2==0)?"F":"M");
			
			provincia = g.prov.get(g.r.nextInt(g.prov.size()));

			psw = g.newCognome(1 + g.r.nextInt(2)) + "@" + g.newCognome(1 + g.r.nextInt(1)) + "%";
			
			System.out.println("INSERT INTO PAZIENTE VALUES (" + 
			"'"+cod.calcoloCodiceFiscale()+"'" + ", " + "'"+nome+"'"+ ", " +"'"+cognome+"'" 
					+ ", " + "'"+data+"'" + ", " + "'"+psw+"'"+ ", " + "'"+comune+"'" 
			+ ", " + "'"+via+"'" + ", " +"'"+provincia+"'" + ", " + "'"+cap+"'" + ", " 
					+ "'"+civico+"'" + ");");
		}
		
	}
	
}
