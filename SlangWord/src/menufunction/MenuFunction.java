package menufunction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	public void addNewSlangWord() {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhập slang word : ");
	        BufferedReader bufferReader;
	        try {
	            bufferReader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
	            String slangWord = bufferReader.readLine();
	            System.out.print("Nhập definition : ");
	            String definition = bufferReader.readLine();
	            for(Map.Entry<String,String> entry : this.fileHandle.slangWordList.slangWords.entrySet() ) {
	            	String key = entry.getKey();
	            	if(slangWord.equalsIgnoreCase(key)) {
	            		System.out.println("Slang Word đã tồn tại !");
	            		System.out.println("Overwrite slang word . Nhấn 1");
			            System.out.println("Duplicate slang word . Nhấn 2 ");
			            System.out.println("Mời lựa chọn : ");
			            int choose;
			            choose = Integer.parseInt(sc.nextLine());
			            if(choose ==1) {
			            	this.fileHandle.slangWordList.add(slangWord, definition);
			            	System.out.println("Overwrite thành công !");
			            }
			            if(choose ==2) {
			           
			            	this.fileHandle.slangWordList.slangWords.put(slangWord, definition);
			            	System.out.println("Duplicate thành công ! ");
			            }
	            	}
	            	
	            }
	            
	           
	           
	  			 
	        
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
		
	}
	public void editSlangWord() {
		String slangWord;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập slang word bạn muốn edit : ");
		slangWord = sc.nextLine();
		if(this.fileHandle.slangWordList.slangWords.containsKey(slangWord)) {
			System.out.println("Nhập definition bạn muốn edit : ");
			String definition = sc.nextLine();
			this.fileHandle.slangWordList.add(slangWord, definition);
			System.out.println("Edit thành công !");
		}
		else {
			System.out.println("Không có slang word nào được tìm thấy trong từ điển  !");
		}
	}
}
