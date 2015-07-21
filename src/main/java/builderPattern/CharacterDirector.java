package builderPattern;

public class CharacterDirector {
	private CharacterBuilder characterBuilder;
	
	public CharacterDirector(CharacterBuilder characterBuilder) {
		this.setCharacterBuilder(characterBuilder);
	}

	public void setCharacterBuilder(CharacterBuilder characterBuilder) {
		this.characterBuilder = characterBuilder;
	}
	
	public Character getCharacter() {
		return characterBuilder.build();
	}
}
