package sintomi_diagnosi_conferme_contraddizioni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class sin_diagn_conf_contr {

	public static void main(String[] args) throws IOException {
//		creo le intensita'
		ArrayList<String> intensita = new ArrayList<String>();
		
		ArrayList<String> sintomidasintomi = new ArrayList<String>();
		ArrayList<String> cartelledasintomi = new ArrayList<String>();
		
		ArrayList<String> dataDiagnosi = new ArrayList<String>();
		
		intensita.add("bassa");intensita.add("media");intensita.add("alta");
//		creo l'elenco dei sintomi
		ArrayList<String> sintomi = new ArrayList<String>();
		popoloSintomi(sintomi);
		ArrayList<String> medici = new ArrayList<String>();
		popoloMedici(medici);
		ArrayList<String> icd = new ArrayList<String>();
		popoloICD10(icd);
//		PrintWriter writer = new PrintWriter("specializzazioni.sql", "UTF-8"); 
//		writer.close();
		
//		ottengo l'id delle cartelle
		ArrayList<String> cartelle = new ArrayList<String>();
		ArrayList<String> pazienti = new ArrayList<String>();
		ArrayList<String> data_nascita = new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
//		System.out.println(dateFormat.format(date));
		
		popoloCartelle(cartelle );
		popoloPazienti (pazienti);
//		dateDiagnosissime(dataDiagnosi);
		
//		popolo i sintomi
//		GregorianCalendar gc = new GregorianCalendar();
		PrintWriter writersintomi = new PrintWriter("sintomi.sql", "UTF-8"); 
		PrintWriter writerdiagnosi = new PrintWriter("diagnosi.sql", "UTF-8");
		PrintWriter writerconferme = new PrintWriter("conferme.sql", "UTF-8"); 
		PrintWriter writercontraddizioni = new PrintWriter("contraddizioni.sql", "UTF-8");
		for(int i = 0; i < cartelle.size()-1; i++){
			int rand = randBetween(-20, 5);
			ArrayList<Integer> elencoSintomi = new ArrayList<Integer>();
			if(rand <= 1){
				int sintomirand = randBetween(0, sintomi.size()-1);
				writersintomi.println("INSERT INTO SINTOMI VALUES ('" + cartelle.get(i) + "', '" + sintomi.get(sintomirand) + 
						"', '" + intensita.get(randBetween(0, intensita.size()-1)) + "', '" + setData() + "', " + randBetween(1, 100) + " );");
//				gc.set(gc.YEAR, randBetween(Integer.parseInt(data_nascita.get(i).split("-")[0]), Integer.parseInt(dateFormat.format(date).split("-")[0])));
//				gc.set(gc.MONTH, randBetween(1,12));
//				gc.set(gc.DAY_OF_MONTH, randBetween(0,28));
				String datainizio = cartelle.get(i).split("'")[3];
				String datafine = cartelle.get(i).split("'")[5];
				String data = "" + randBetween(Integer.parseInt(datainizio.split("-")[0]), Integer.parseInt(datafine.split("-")[0])) + "-" + 
						randBetween(Integer.parseInt(datainizio.split("-")[1]), Integer.parseInt(datafine.split("-")[1])) + "-" + 
						randBetween(Integer.parseInt(datainizio.split("-")[2]), Integer.parseInt(datafine.split("-")[2]));//dataDiagnosi.get(i);
				int icdrand = randBetween(0, icd.size()-1);
				writerdiagnosi.println("INSERT INTO DIAGNOSI VALUES ('" + pazienti.get(i) + "', '" + cartelle.get(i) + "', '" + data
						+ "', '" + icd.get(icdrand).split(";")[0].split("-")[0] + "', '" + 
						icd.get(icdrand).split(";")[1] + "', '" + medici.get(randBetween(0, medici.size()-1)) + 
						"');");
				int conferma = randBetween(0, 1);
				if(conferma==1){
					writerconferme.println("INSERT INTO CONFERME VALUES ('" + cartelle.get(i) + "', '" +
							sintomi.get(sintomirand) + "', '" + pazienti.get(i) + "', '" + data + "', '" + 
							cartelle.get(i) + "');");
				}else{
					writercontraddizioni.println("INSERT INTO CONTRADDIZIONI VALUES ('" + cartelle.get(i) + "', '" +
							sintomi.get(sintomirand) + "', '" + pazienti.get(i) + "', '" + data + "', '" + 
							cartelle.get(i) + "');");
				}
			}else{
				while ( rand != 0 ){
					int random = randBetween(0, sintomi.size()-1);
					while(elencoSintomi.contains(random)){
						random = randBetween(0, sintomi.size()-1);
					}
					elencoSintomi.add(random);
					writersintomi.println("INSERT INTO SINTOMI VALUES ('" + cartelle.get(i) + "', '" + sintomi.get(random) + 
							"', '" + intensita.get(randBetween(0, intensita.size()-1)) + "', '" + setData() + "', " + "null"+ " );");
//					gc.set(gc.YEAR, randBetween(Integer.parseInt(data_nascita.get(i).split("-")[0]), Integer.parseInt(dateFormat.format(date).split("-")[0])));
//					gc.set(gc.MONTH, randBetween(1,12));
//					gc.set(gc.DAY_OF_MONTH, randBetween(0,28));
					String datainizio = cartelle.get(i).split("'")[3];
					String datafine = cartelle.get(i).split("'")[5];
					String data = "" + randBetween(Integer.parseInt(datainizio.split("-")[0]), Integer.parseInt(datafine.split("-")[0])) + "-" + 
							randBetween(Integer.parseInt(datainizio.split("-")[1]), Integer.parseInt(datafine.split("-")[1])) + "-" + 
							randBetween(Integer.parseInt(datainizio.split("-")[2]), Integer.parseInt(datafine.split("-")[2]));//dataDiagnosi.get(i);
					int icdrand = randBetween(0, icd.size()-1);
					writerdiagnosi.println("INSERT INTO DIAGNOSI VALUES ('" + pazienti.get(i) + "', '" + cartelle.get(i) + "', '" + data
							+ "', '" + icd.get(icdrand).split(";")[0].split("-")[0] + "', '" + 
							icd.get(icdrand).split(";")[1] + "', '" + medici.get(randBetween(0, medici.size()-1)) + 
							"');");
					int conferma = randBetween(0, 1);
					if(conferma==1){
						if(conferma==1){
							writerconferme.println("INSERT INTO CONFERME VALUES ('" + cartelle.get(i) + "', '" +
									sintomi.get(random) + "', '" + pazienti.get(i) + "', '" + data + "', '" + 
									cartelle.get(i) + "');");
						}else{
							writercontraddizioni.println("INSERT INTO CONTRADDIZIONI VALUES ('" + cartelle.get(i) + "', '" +
									sintomi.get(random) + "', '" + pazienti.get(i) + "', '" + data + "', '" + 
									cartelle.get(i) + "');");
						}
					}
					--rand;
				}
			}
		}
		writerconferme.close();
		writercontraddizioni.close();
		writerdiagnosi.close();
		writersintomi.close();
		
		
		
	}

	private static void popoloPazienti(ArrayList<String> pazienti) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("cartelle_cliniche.sql"));
        while ((line = br.readLine()) != null) {
        	try{
            pazienti.add(line.split("'")[11]);
        	}catch(Exception e){
        		pazienti.add(line.split("'")[9]);
        	}
        }
        br.close(); 
	}

	private static void popoloSintomidaSintomi(ArrayList<String> sintomi) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("sintomi.sql"));
        while ((line = br.readLine()) != null)
            sintomi.add(line.split("'")[3]);
        br.close(); 
	}

	
	private static void popoloCartelledaSintomi(ArrayList<String> cartelle) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("sintomi.sql"));
        while ((line = br.readLine()) != null)
            cartelle.add(line.split("'")[3]);
        br.close(); 
	}


	private static String setData() {

		String res = "";
		
		res = randBetween(1980, 2000) + "-" + randBetween(1, 12) + "-" + randBetween(1, 28);
		
		return res;
	}

	private static void popoloICD10(ArrayList<String> icd) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("elenco_icd10.txt"));
        while ((line = br.readLine()) != null)
            icd.add(line);
        br.close(); 
	}

	private static void popoloMedici(ArrayList<String> medici) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("medico.sql"));
        while ((line = br.readLine()) != null)
            medici.add(line.split("'")[1]);
        br.close(); 
	}

	private static void popoloCartelle(ArrayList<String> cartelle ) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("cartelle_cliniche.sql"));
        while ((line = br.readLine()) != null) {
            cartelle.add(line.split("'")[1]);
            
        }
        br.close(); 
	}

	private static void popoloSintomi(ArrayList<String> sintomi) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("elenco_sintomi.txt"));
        while ((line = br.readLine()) != null) {
            sintomi.add(line);
        }
        br.close(); 
	}
	public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
	public static void dateDiagnosissime(ArrayList<String> dataDiagnosi){
		
		String line = "";
		try{
		BufferedReader br = new BufferedReader(new FileReader("diagnosi.sql"));
        while ((line = br.readLine()) != null)
            dataDiagnosi.add(line.split("'")[3]);
		}catch(Exception e){}
	}
}
