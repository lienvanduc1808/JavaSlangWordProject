package menufunction;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Scanner;

import filehandle.*;
import slangword.SlangWord;

public class MenuFunction {
	
	FileHandle fileHandle = new FileHandle();
	LinkedHashMap<String, String> slangWordHistory = new LinkedHashMap<String, String>();
	
	public void loadFile() {
		
		fileHandle.LoadFileData("slang.txt");
		
	}
	public void searchWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập từ muốn tìm : ");
		String word;
		word = sc.nextLine();
		
		System.out.println("Definition: " + this.fileHandle.getas(word));
		slangWordHistory.put(word, this.fileHandle.getas(word));
	}
	public void searchDefintion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập từ định nghĩa muốn tìm : ");
		String word;
		word = sc.nextLine();
		for(Map.Entry<String,String> entry : this.fileHandle.slangWordList.slangWords.entrySet() ) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  slangWordHistory.put(word, value);
			  if(value.contains(word)){
				  System.out.println(key + " => " + value);
			  }
			 
			 
			}
		
	}
	
	public void viewHistorySlangWord() {
		if(slangWordHistory.size()==0) {
			System.out.println("Chưa có từ nào được tìm kiếm ");
		}
		else {
			System.out.println("Danh sách các slang word đã được tìm kiếm : ");
			for(String word : slangWordHistory.keySet()){
                System.out.println( word );
                
            }
		}
	}
}
