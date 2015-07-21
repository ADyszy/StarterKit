package builderPattern;

public class Character {
	private String name;
	private String hairColor; // opcjonalny
	private String skinColor;
	private String moustache; // opcjonalny
	private boolean horns = false;
	private double height;
	private String attack;
			
	// [ ... ] getters, setters, toString etc.
	
	
	public String getName() {
		return name;
	}
	public String getHairColor() {
		return hairColor;
	}
	public String getSkinColor() {
		return skinColor;
	}
	public String getMoustache() {
		return moustache;
	}
	public boolean isHorns() {
		return horns;
	}
	public double getHeight() {
		return height;
	}
	public String getAttack() {
		return attack;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}
	public void setMoustache(String moustache) {
		this.moustache = moustache;
	}
	public void setHorns(boolean horns) {
		this.horns = horns;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setAttack(String attack) {
		this.attack = attack;
	}
	
	@Override
	public String toString() {
		String str =
				"Chatacter: " + name + 
				"\nSkin color: " + skinColor + 
				"\nHeight: " + height + 
				"\nCharacters attack: " + attack;
		if(moustache != null)
			str += "\nMoustache: " + moustache;
		if(hairColor != null)
			str += "\nHair Color: " + hairColor;
		if(horns)
			str += "\nHas horns: " + horns;
		return str;
	}
	
	
}
