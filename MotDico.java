package TD3;

public class MotDico {
	public int num;
	public String mot,definition;
	public MotDico(String mot, String definition) {
        this.mot = mot;
        this.definition = definition;
	}
	public String getMot() {
		return this.mot;
	}
	public String getDefinition() {
		return this.definition;
	}
	public void setDefinition(String s) {
		this.definition=s;
	}
	public void setMot(String s) {
		this.mot=s;
	}
	public boolean synonyme(MotDico m) {
		if(this.mot.equals(m.getMot()))
			return true;
		else 
			return false;
	}
	
}
