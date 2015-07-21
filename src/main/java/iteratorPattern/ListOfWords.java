package iteratorPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfWords implements Aggregate {

	private List<String> words = new ArrayList<String>();

	
	public Iterator getIterator() {
		return new WordListIterator();
	}

	private class WordListIterator implements Iterator {

		private int index = 0;

		public String next() {
			if (this.hasNext())
				return words.get(index++);
			return null;
		}

		public boolean hasNext() {
			if (index >= words.size())
				return false;
			return true;
		}

	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}
	
	public ListOfWords(String ... words) {
		this.words = Arrays.asList(words);
	}
	
}
