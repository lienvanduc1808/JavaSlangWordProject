package slangword;

import java.util.TreeMap;

public class SlangWord {
	public TreeMap<String, String > slangWords;

	public SlangWord() {
		
		slangWords = new TreeMap<String,String>();
	}

	public void add(String key , String value) {
		// TODO Auto-generated method stub
		if(!slangWords.containsKey(key)) {
			slangWords.put(key, value);
		}
	}
	public void getLine() {
		//
	}
	
	
}
