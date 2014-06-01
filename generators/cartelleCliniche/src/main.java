import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<String> prognosilist = new ArrayList<String>();
		ArrayList<String> malattia = new ArrayList<String>();
		String line, idCartella, data_ricovero, data_dimissione, motivo, prognosi, codsan;
		BufferedReader br = new BufferedReader(new FileReader("paziente.sql"));
		while ((line = br.readLine()) != null) {
			ids.add(line.split("'")[1]);
			//			System.out.println(line.split("'")[1]);
		}
		br.close();
		BufferedReader buf = new BufferedReader(new FileReader("dolori.txt"));
		while ((line = buf.readLine()) != null) {
			malattia.add(line.replaceAll("\"", "\\\""));
			//			System.out.println(line.split("'")[1]);
		}
		buf.close();
		aggiungiAPrognosiList(prognosilist);
		
		ArrayList<String> tipologia = new ArrayList<String>();
		tipologia.add(" transitorio ");
		tipologia.add(" acuto ");
		tipologia.add(" recidivo ");
		tipologia.add(" transitorio ");
		tipologia.add(" persistente ");
		tipologia.add(" cronico ");

		
		
		int year, dayOfYear, prognosiid, malattiaId, mese;
		GregorianCalendar gc = new GregorianCalendar();
		for(String id : ids){
			int n_cart = randBetween(1, 10);
			for(int i = 0; i < n_cart; i++){
				
				year = randBetween(1990, 1999);
				mese = randBetween(1, 12);
				if(mese == 2)
					dayOfYear = randBetween(1, 28);
				else
					dayOfYear = randBetween(1, 30);
				
				data_ricovero = year + "-" + mese + "-" + dayOfYear;

				year = randBetween(2000, 2013);
				mese = randBetween(1, 12);
				if(mese == 2)
					dayOfYear = randBetween(1, 28);
				else
					dayOfYear = randBetween(1, 30);
				
				data_dimissione = year + "-" + mese + "-" + dayOfYear;

				String text = year + "-" + mese + "-" + dayOfYear + id + randBetween(100, 500);
				MessageDigest msg = MessageDigest.getInstance("MD5");
				msg.update(text.getBytes(), 0, text.length());
				String digest1 = new BigInteger(1, msg.digest()).toString(16);
				idCartella = digest1.substring(0,16);

				prognosiid = randBetween(0, prognosilist.size()-1);
				malattiaId = randBetween(0, malattia.size()-1);
				
				int tipo = randBetween(0, tipologia.size() - 1);
				
				if(!prognosilist.get(prognosiid).equals(""))
					if(!prognosilist.get(prognosiid).equals("Riservata"))
						System.out.println("INSERT INTO CARTELLA_CLINICA VALUES ('" + idCartella + "', '" + data_ricovero + "', '" + data_dimissione + "', '" + prognosilist.get(prognosiid) + tipologia.get(tipo) + "', '" +malattia.get(malattiaId)  + " guaribile in giorni " + randBetween(1, 200) + "', '" + id + "');");
					else
						System.out.println("INSERT INTO CARTELLA_CLINICA VALUES ('" + idCartella + "', '" + data_ricovero + "', '" + data_dimissione + "', '" + "dolore generalizzato" + tipologia.get(tipo) + "', '" + prognosilist.get(prognosiid) + "', '" + id + "');");
								
				else
					System.out.println("INSERT INTO CARTELLA_CLINICA VALUES ('" + idCartella + "', '" + data_ricovero + "', '" + data_dimissione + "', '" + malattia.get(malattiaId) + "', NULL, '" + id + "');");
			}
		}
	}

	private static void aggiungiAPrognosiList(ArrayList<String> prognosilist) {
		//		1) Globale: è la prognosi concernente l’evoluzione psicosomatica di una popolazione o le malattie prevalenti in determinate classi sociali o le conseguenze di un processo morboso che abbia colpito una collettività. Interessa, in modo particolare, la medicina sociale, la medicina assicurativa, la criminologia e si deduce soprattutto da accertamenti statistici.
		//		2) Individuale: è la prognosi che si riferisce a singoli casi.
		//		3) Provvisoria : è la prognosi espressa per soddisfare momentaneamente contingenze giudiziarie o professionali , sebbene non corrisponda ancora a un convincimento scientificamente provato di chi la esprime (ad esempio : previsione di durata di una malattia, di persistenza di postumi permanenti, etc.)
		//		4) Immediata, prossima, lontana, lontanissima : è la prognosi a seconda del tempo preso in considerazione rispetto ad essa. Così, nel caso di intervento chirurgico, vi può essere una prognosi immediata di anemizzazione acuta,una prognosi prossima per la possibilità di embolia
		//		dopo fratture di femore, una prognosi lontana se si tratta
		//		11
		//		per esempio del possibile verificarsi di cirrosi epatica da
		//		abuso di alcool , una prognosi lontanissima se è in
		//		questione la formazione di un epitelioma su ulcera cronica
		//		da ustione attualmente constatabile.
		//		5) Naturale si chiama la prognosi allorquando il fenomeno
		//		biologico preso in considerazione si presume debba
		//		verificarsi indipendentemente da provvidenze particolari.
		//		6) Relativa può essere la prognosi alla vita, alla salute, al
		//		lavoro, alle ordinarie occupazioni, al grado di rischio
		//		connesso a particolari attività (occupazione confacente o al
		//		contrario usurante), a speciali abitudini, all’uso di farmaci,
		//		all’indebolimento o alla perdita di organi, alla possibilità di
		//		compensi funzionali, all’adattamento, alla riabilitazione.
		//		7) Vi è prognosi medico-legale nel caso, per esempio, sia
		//		richiesto un giudizio circa la perpetuità di una impotenza
		//		alla congiunzione.
		//		8) Vi è prognosi sociale quando si tratta di determinare la
		//		pericolosità di un malato di mente o quella di un criminale
		//		agli effetti penalistici.
		//		9) Vi è prognosi clinica se ci si riferisce alla evoluzione di una
		//		malattia.
		//		Riservata 
		prognosilist.add("");
		
		prognosilist.add("dolore articolazioni ");
		prognosilist.add("dolore dorsale ");
		prognosilist.add("dolore lombare ");
		prognosilist.add("dolore alla testa ");
		prognosilist.add("ferita ");
		prognosilist.add("disturbi vari ");
		prognosilist.add("disturbi di deambulazione ");
		prognosilist.add("dolore interno ");
		prognosilist.add("dolore somatico ");
		prognosilist.add("dolore viscerale ");
		prognosilist.add("dolore misto ");
		prognosilist.add("dolore idiopatico ");
		prognosilist.add("grave ferita con dolore");
		prognosilist.add("perdita di liquido interno con dolore");
		prognosilist.add("tosse");
		prognosilist.add("incapacita respiratoria");
		
		prognosilist.add("Riservata");

	}
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}
}
