package dbms;

import java.util.*;

public class PatologieBean {

	private String ICD10;
	private ArrayList<String> idPaziente;
	
	
	public PatologieBean(){
		
		ICD10 = "";
		idPaziente = new ArrayList<String>();
		
	}


	public String getICD10() {
		return ICD10;
	}


	public void setICD10(String iCD10) {
		ICD10 = iCD10;
	}


	public String getIdPaziente(int pos) {
		return idPaziente.get(pos);
	}

	public ArrayList<String> getIdPaziente() {
		return idPaziente;
	}


	public void setIdPaziente(ArrayList<String> idPaziente) {
		this.idPaziente = idPaziente;
	}
	

	public void setIdPaziente(String paziente) {
		this.idPaziente.add(paziente);
	}

	
}
