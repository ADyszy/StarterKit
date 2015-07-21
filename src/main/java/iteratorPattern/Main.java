package iteratorPattern;

public class Main {
	
	static void print(Aggregate agr) {
		for (Iterator iterator = agr.getIterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
	
	public static void main(String[] args) {
		
		ListOfWords words = new ListOfWords(
				"Woda", 
				"Deszcz", 
				"Huragan", 
				"Auto", 
				"Pies");
		
		ArrayOfDogs dogs = new ArrayOfDogs(
				new Dog("Owczarek Niemiecki", "Czarny"),
				new Dog("Bernardyn", "Brazowy"),
				new Dog("York", "Brazowy podpalany"),
				new Dog("Jamnik", "Czarny"),
				new Dog("Owczarek Podhalanski", "Bialy"));
		
		print(words);
		System.out.println("-------------------------");
		print(dogs);
	}
	
	
}
