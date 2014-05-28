package gen;

import java.util.Random;
import java.util.Vector;

public class Gen {

	Vector<String> nomi;
	Vector<String> cognomi;
	
	Vector<String> cas_cogn;
	
	
	public Gen(){
		nomi = new Vector<String>();
		cognomi = new Vector<String>();
		
		cas_cogn = new Vector<String>();
		
		cas_cogn.add("cas");
		cas_cogn.add("nu");
		cas_cogn.add("len");
		cas_cogn.add("gi");
		cas_cogn.add("bo");
		cas_cogn.add("ra");
		cas_cogn.add("de");
		cas_cogn.add("sbo");
		cas_cogn.add("sa");

	}
	
	public String newCognome(int len){
		
		Random r = new Random();
		String s = "";
		
		while(len-- > 0)
			s += cas_cogn.get(r.nextInt(cas_cogn.size()));
		
		s = s.substring(0,1).toUpperCase() + s.substring(1,s.length()).toLowerCase();
		
		return s;
	}
	
	
	public static int main (){
		
		Gen g = new Gen();
		
		int i = 5;
		
		while(i-- > 5)
			System.out.println(g.newCognome(5));
		
		return 0;
		
	}
	
}
