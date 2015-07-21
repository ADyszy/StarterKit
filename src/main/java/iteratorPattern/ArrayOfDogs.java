package iteratorPattern;

class Dog {
	public Dog(String name, String color) {
		this.name = name;
		this.color = color;
	}
	String name;
	String color;
	
	public String toString(){
		return name + " " + color;
	}
}

public class ArrayOfDogs implements Aggregate {
	Dog[] dogs;

	public Iterator getIterator() {
		return new ArrayOfDogsIterator();
	}
	
	private class ArrayOfDogsIterator implements Iterator {

		int index = 0;

		public Object next() {
			if (this.hasNext())
				return dogs[index++];
			return null;
		}

		public boolean hasNext() {
			if (index >= dogs.length)
				return false;
			return true;
		}

	}

	public ArrayOfDogs(Dog ... dogs) {
		this.dogs = dogs;
	}
	
}
