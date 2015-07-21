package builderPattern;

public class BadCharacterBuilder extends CharacterBuilder {

	@Override
	protected void composeCharacter() {
		character = new Character();
		character.setName("Belzebub");
		character.setSkinColor("Dark Blue");
		character.setHeight(2.0);
		character.setHorns(true);
		character.setAttack("Mroczne czary-mary");		
	}
	
	@Override
	public Character build() {
		composeCharacter();
		return character;
	}

}
