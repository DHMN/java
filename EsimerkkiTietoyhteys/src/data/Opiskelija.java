package data;

import java.text.Collator;
import java.util.List;

public class Opiskelija implements Comparable<Opiskelija>{
	private int opiskelijaID;
	private String etunimi;
	private String sukunimi;
	private int opintoviikot;
	//konstruktori 1 lahetetaan kaikki tiedot
	/**
	 * @param etunimi
	 * @param sukunimi
	 * @param opintoviikot
	 */
	public Opiskelija(int opiskelijaID, String etunimi, String sukunimi, int opintoviikot) {
		this.opiskelijaID = opiskelijaID;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.opintoviikot = opintoviikot;
	}
	//konstruktori 2 l�hetet��n vain etu -ja sukunimi opintoviikot asetetaan 0:ksi.
	/**
	 * @param etunimi
	 * @param sukunimi
	 */
	public Opiskelija(int opiskelijaID, String etunimi, String sukunimi) {
		this.opiskelijaID = opiskelijaID;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.opintoviikot = 0;
	}
	
	//kaikille ominaisuuksille get- ja set-metodit
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public int getOpintoviikot() {
		return opintoviikot;
	}
	public void setOpintoviikot(int opintoviikot) {
		this.opintoviikot = opintoviikot;
	}
	
	public int getOpiskelijaID() {
		return opiskelijaID;
	}
	
	public void setOpiskelijaID(int opiskelijaID) {
		this.opiskelijaID = opiskelijaID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etunimi == null) ? 0 : etunimi.hashCode());
		result = prime * result + opintoviikot;
		result = prime * result + opiskelijaID;
		result = prime * result
				+ ((sukunimi == null) ? 0 : sukunimi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opiskelija other = (Opiskelija) obj;
		if (etunimi == null) {
			if (other.etunimi != null)
				return false;
		} else if (!etunimi.equals(other.etunimi))
			return false;
		if (opintoviikot != other.opintoviikot)
			return false;
		if (opiskelijaID != other.opiskelijaID)
			return false;
		if (sukunimi == null) {
			if (other.sukunimi != null)
				return false;
		} else if (!sukunimi.equals(other.sukunimi))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Opiskelija [opiskelijaID=" + opiskelijaID + ", etunimi="
				+ etunimi + ", sukunimi=" + sukunimi + ", opintoviikot="
				+ opintoviikot + "]";
	}
	@Override
	public int compareTo(Opiskelija olio) {
		Collator apu = Collator.getInstance();
		apu.setStrength(Collator.PRIMARY);
		int tulos = apu.compare(this.sukunimi, olio.sukunimi);
		if(tulos != 0){
			return tulos;
		}else{
			return apu.compare(this.etunimi, olio.etunimi);
		}
	}
		
	
	
	public static String listaMerkkijonona(List<Opiskelija> lista){
		String merkit = "";
		for(Opiskelija uusi:lista){
			merkit += uusi +"\n";
		}
		return merkit;
	}
	
}
