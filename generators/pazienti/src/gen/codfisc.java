package gen;

import java.util.Random;

public class codfisc {

	String cognome;
	String nome;
	String nasc;
	String comune;
	String sesso;
	
	
	public codfisc(String cognome, String nome, String nasc,
			String comune, String sesso) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.nasc = nasc;
		this.comune = comune;
		this.sesso = sesso;
	}

	public String getCons(String s){
		
		String a  = "";
		
		for(int i=0; i < s.length(); i++)
			if (!(s.substring(i, i+1).equals("A") || s.substring(i, i+1).equals("E") || s.substring(i, i+1).equals("I") || s.substring(i, i+1).equals("O") || s.substring(i, i+1).equals("U") 
					|| s.substring(i, i+1).equals("a") || s.substring(i, i+1).equals("e") || s.substring(i, i+1).equals("i") || s.substring(i, i+1).equals("o") || s.substring(i, i+1).equals("u")))
						a += s.substring(i, i+1).toUpperCase();
		return a;
	}
	
	
	public String getGiorno(String s){
		
		String a  = "";
		int tratto = 0;
		
		for(int i=0; i < s.length(); i++)
			if ((s.substring(i, i+1).equals("-"))){
				tratto++;
			if(tratto >= 2){
				a = s.substring(i+1, i+2);
				break;
				}
			}
		
		return a;
	}

	public String calcoloCodiceFiscale () {
		String codFis = "";
		String cognomecf = cognome ;
		String nomecf = nome;
		String dataNascitacf = nasc;
		String comuneNascitacf = comune;

		try{
		codFis += getCons(cognomecf).substring(0,3);
		}catch(Exception e){
			codFis += getCons(cognomecf).substring(0,1) + "XX";
		}
			try{
		codFis += getCons(nomecf).substring(0,3);
		}catch(Exception ep){
			codFis += getCons(nomecf).substring(0,1) + "XX";
			;}
		
		codFis += getGiorno(dataNascitacf);
		
		codFis += "X";
		
		codFis += dataNascitacf.substring(2, 4);
		
		codFis += "" + Character.toChars(65 + new Random().nextInt(25))[0] + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) + Character.toChars(65 + new Random().nextInt(25))[0];
		
		return codFis;

		}
	
}
