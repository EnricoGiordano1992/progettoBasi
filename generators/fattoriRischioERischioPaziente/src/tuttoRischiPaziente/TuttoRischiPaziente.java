package tuttoRischiPaziente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TuttoRischiPaziente {


	private String s;
	private ArrayList<String> nomeRischi;
	private ArrayList<String> pazienti;
	
	public TuttoRischiPaziente() throws IOException{

		s = "";
		pazienti = new ArrayList<String>();
		nomeRischi = new ArrayList<String>();

		popoloPazieni(pazienti);
		
		nomeRischi.add("età");
		nomeRischi.add("sesso");
		nomeRischi.add("familiarità");
		nomeRischi.add("ereditarietà");
		nomeRischi.add("alimentazione");
		nomeRischi.add("tabagismo");
		nomeRischi.add("assunzione farmaci");
		nomeRischi.add("ormoni");
		nomeRischi.add("droghe");
		nomeRischi.add("consumo alcool");
		nomeRischi.add("ipertensione");
		nomeRischi.add("dislipidemia");
		nomeRischi.add("diabete");
		nomeRischi.add("agenti biologici");
		nomeRischi.add("radiazioni ioni");
		nomeRischi.add("agenti inquinanti");
	}

	
	
	private static void popoloPazieni(ArrayList<String> pazienti) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("paziente.sql"));
        while ((line = br.readLine()) != null) {
            pazienti.add(line.split("'")[1]);
        }
        br.close(); 
	}

	
	public static void main(String[] args) throws IOException{

		ArrayList<Integer> combo = new ArrayList<Integer>();
		int num1;
		int num2;
		int searcher;
		
		//FATTORI A RISCHIO
		TuttoRischiPaziente t = new TuttoRischiPaziente();
		FileWriter w;
		w=new FileWriter("fattori_a_rischio.sql");
		int i = t.nomeRischi.size()-1;
		do{
			w.write("INSERT INTO FATTORI_RISCHIO VALUES ('"+t.nomeRischi.get(i)+"');\n");
		}while(i-- > 0);
		
		w.flush();

		
		//RISCHI PAZIENTE
		FileWriter w2;
		w2=new FileWriter("rischi_paziente.sql");
		
		i = 1000;
		while(i-- > 0){
			
			num1 = new Random().nextInt(t.nomeRischi.size()-1);
			num2 = new Random().nextInt(t.pazienti.size()-1);
			
			searcher = num1*10 + num2;
			
			while(!newGeneratedCombo(searcher, combo)){

				num1 = new Random().nextInt(t.nomeRischi.size()-1);
				num2 = new Random().nextInt(t.pazienti.size()-1);
				
				searcher = num1*10 + num2;
			}
			
			w2.write("INSERT INTO RISCHI_PAZIENTE VALUES ('"+
					t.pazienti.get(num2)+ 
		"', '" +
		t.nomeRischi.get(num1)+"');\n");
		}
		w2.flush();

	}



	private static boolean newGeneratedCombo(int searcher,
			ArrayList<Integer> combo) {

		for(int i = 0; i < combo.size()-1; i++)
			if(combo.get(i) == searcher)
				return false;
		
		combo.add(searcher);
		
		return true;
	}

}
