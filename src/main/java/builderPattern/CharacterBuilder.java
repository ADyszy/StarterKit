package builderPattern;

public abstract class CharacterBuilder {
	
	protected Character character;

	protected abstract void composeCharacter();

	public Character build() {
		return character;
	};
}
