package menufunction;
import java.util.Map;

import java.util.Scanner;

import filehandle.*;
import slangword.SlangWord;

public class MenuFunction {
	FileHandle fileHandle = new FileHandle();
	
	public void loadFile() {
		
		fileHandle.LoadFileData("slang.txt");
		
	}
	public void searchWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập từ muốn tìm : ");
		String word;
		word = sc.nextLine();
		
		System.out.println("Definition: " + this.fileHandle.getas(word));
	}
	public void searchDefintion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập từ định nghĩa muốn tìm : ");
		String word;
		word = sc.nextLine();
		for(Map.Entry<String,String> entry : this.fileHandle.slangWordList.slangWords.entrySet() ) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  if(value.contains(word)){
				  System.out.println(key + " => " + value);
			  }
			 
			}
		
	}
}
