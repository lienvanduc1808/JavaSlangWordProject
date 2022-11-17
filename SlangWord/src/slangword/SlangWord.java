package slangword;

import java.util.Scanner;

import java.util.TreeMap;


public class SlangWord {
	public TreeMap<String, String > slangWords;

	
	public int size;

	public SlangWord() {
		
		slangWords = new TreeMap<String,String>();
		size =0;
	}

	public void add(String key , String value) {
		
		
			slangWords.put(key, value);
			size++;
		
	}
    public String get(String word) {
        return slangWords.get(word);
       
        
    }
    
    
	


	
	
	
}

