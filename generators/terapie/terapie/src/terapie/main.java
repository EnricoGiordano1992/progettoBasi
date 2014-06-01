package terapie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> cartelle = new ArrayList<String>();
		ArrayList<String> farmaci = new ArrayList<String>();
		ArrayList<String> inizio = new ArrayList<String>();
		ArrayList<String> fine = new ArrayList<String>();
		String line;
		BufferedReader br = new BufferedReader(new FileReader("cartelle_cliniche.sql"));
		while ((line = br.readLine()) != null) {
			cartelle.add(line.split("'")[1]);
			inizio.add(line.split("'")[3]);
			fine.add(line.split("'")[5]);
//			System.out.println(line.split("'")[1]);
		}
		br.close();
//		for(String i : cartelle)
//			System.out.println(i);
		br = new BufferedReader(new FileReader("farmaci.txt"));
		while ((line = br.readLine()) != null) {
			if(!line.equals(""))
				farmaci.add(line);
			//			System.out.println(line.split("'")[1]);
		}
		br.close();
		GregorianCalendar gc = new GregorianCalendar();
		String idCartella, _inizio, _fine, frequenza, dose, farmaco;
		for(int i = 0; i<cartelle.size()-1; i++){
//			IDCARTELLA
			idCartella = cartelle.get(i);

			gc.set(Integer.parseInt(fine.get(i).split("-")[0]), Integer.parseInt(fine.get(i).split("-")[1])-1, Integer.parseInt(fine.get(i).split("-")[0]));
			gc.add(Calendar.DAY_OF_MONTH, randBetween(0, 365));
			
//			INIZIO TERAPIA
			_inizio = gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH)+1) + "-" + gc.get(Calendar.DAY_OF_MONTH);
			
			gc.add(Calendar.DAY_OF_MONTH, randBetween(0, 1000));
			
//			FINE TERAPIA
			_fine = gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH)+1) + "-" + gc.get(Calendar.DAY_OF_MONTH);
			
//			FREQUENZA
			frequenza = String.valueOf(randBetween(1, 8));
			
//			DOSE
			dose = String.valueOf(randBetween(1,50));
			if(randBetween(0, 1) == 1)
				dose = dose + ".5";
			else
				dose = dose + ".0";
			
//			FARMACO
			farmaco = farmaci.get(randBetween(0, farmaci.size()-1));
			
			System.out.println("INSERT INTO TERAPIE VALUES ('" + idCartella + "', '" + _inizio + "', '" + _fine + "', '" + frequenza + "', '" + dose + "', '" + farmaco +"');");
			
		}
		System.out.println("FINE");
	}
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}

}
