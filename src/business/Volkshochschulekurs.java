package business;

public class Volkshochschulekurs {
	
	
    private String kursname;
    private float kursbeitrag;
    private String wochentag;
    private float startuhrzeit;
    private String[] standVorkenntnisse;

  
    
	public Volkshochschulekurs(String kursname, float kursbeitrag, String wochentag, float startuhrzeit,
			String[] standVorkenntnisse) {
		super();
		this.kursname = kursname;
		this.kursbeitrag = kursbeitrag;
		this.wochentag = wochentag;
		this.startuhrzeit = startuhrzeit;
		this.standVorkenntnisse = standVorkenntnisse;
	}

	public String getKursname() {
		return kursname;
	}

	public void setKursname(String kursname) {
		this.kursname = kursname;
	}

	public float getKursbeitrag() {
		return kursbeitrag;
	}

	public void setKursbeitrag(float kursbeitrag) {
		this.kursbeitrag = kursbeitrag;
	}

	public String getWochentag() {
		return wochentag;
	}

	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}

	public float getStartuhrzeit() {
		return startuhrzeit;
	}

	public void setStartuhrzeit(float startuhrzeit) {
		this.startuhrzeit = startuhrzeit;
	}

	public String[] getStandVorkenntnisse() {
		return standVorkenntnisse;
	}

	public void setStandVorkenntnisse(String[] standVorkenntnisse) {
		this.standVorkenntnisse = standVorkenntnisse;
	}
	
	public String getStandVorkenntnisseAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getStandVorkenntnisse().length - 1; i++) {
			ergebnis = ergebnis + this.getStandVorkenntnisse()[i] + trenner; 
		}
		return ergebnis	+ this.getStandVorkenntnisse()[i];
	}
	
	public String gibVolkshochschulekursZurueck(char trenner){
  		return this.getKursname() + trenner 
  			+ this.getKursbeitrag() + trenner
  		    + this.getWochentag() + trenner
  		    + this.getStartuhrzeit() + trenner 
  		    + this.getStandVorkenntnisseAlsString(trenner) + "\n";
  	}
}

