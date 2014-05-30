package gen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class comuni {

	
	ArrayList<String> com;
	
	public comuni() throws IOException {
		
		com = new ArrayList<String>();
		
		initCom();
	}
	
	public void initCom() throws IOException{
		
		 FileReader f;
		    f=new FileReader("comuni.txt");

		    BufferedReader b;
		    b=new BufferedReader(f);
		    
		    String s;
		    
		    while(true) {
		        s=b.readLine();
		        if(s==null)
		          break;
		        else
		        	com.add(s);
		    }
	}

	
	public String newComune () {
				
		return com.get(new Random().nextInt(com.size()));
		
	}
	
}
