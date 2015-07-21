package builderPattern;

public class GoodCharacterBuilder extends CharacterBuilder {
	
	@Override
	protected void composeCharacter() {
		character = new Character();
		character.setName("Alojzy");
		character.setSkinColor("Green");
		character.setHeight(1.8);
		character.setAttack("Dobre slowo");		
		character.setHairColor("Blond");
		character.setMoustache("Szlachecki");
	}
	
	@Override
	public Character build() {
		composeCharacter();
		return character;
	}
}
