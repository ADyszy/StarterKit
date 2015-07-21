package builderPattern;

public class Main {
	public static void main(String[] args) {
		Character ch = new CharacterDirector(new BadCharacterBuilder()).getCharacter();
		System.out.println(ch + "\n-----------------------");
		ch = new CharacterDirector(new GoodCharacterBuilder()).getCharacter();
		System.out.println(ch);
	}
}
