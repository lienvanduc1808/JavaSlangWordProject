package menufunction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
	public void saveFile() {
		fileHandle.saveFileData("slang.txt");
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
	       
	       
	        String slangWord;
			slangWord = sc.nextLine();
			System.out.print("Nhập definition : ");
			String definition;
			definition = sc.nextLine();
			
		
				if(this.fileHandle.slangWordList.slangWords.containsKey(slangWord)) {
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
			       
			        	String new_definition = this.fileHandle.slangWordList.slangWords.get(slangWord)+"| "+definition;
			        	this.fileHandle.slangWordList.add(slangWord, new_definition);
			        	System.out.println("Duplicate thành công ! ");
			        }
			        
				
				
			}
				else {
		        	this.fileHandle.slangWordList.add(slangWord, definition);
		        	System.out.println("Them thành công !");
		        }
			
		
		this.saveFile();
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
		this.saveFile();
	}
	
	
	
	public void deleteSlangWord() {
		String slangWord;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập slang word bạn muốn xóa  : ");
		slangWord = sc.nextLine();
		if(this.fileHandle.slangWordList.slangWords.containsKey(slangWord)) {
			
			System.out.println("Xác nhận xóa . Nhấn 1");
			System.out.println("Hủy bỏ . Nhấn 0");
			int choose;
			System.out.println("Mời lựa chọn ");
			choose = Integer.parseInt(sc.nextLine());
			if(choose == 1) {
				this.fileHandle.slangWordList.slangWords.remove(slangWord);
				System.out.println("Xóa thành công !");
			}
			else if(choose ==0){
				System.out.println("Hủy Xóa ");
			}
		
		}
		else {
			System.out.println("Không có slang word nào được tìm thấy trong từ điển  !");
		}
		this.saveFile();
	}
	
	
	
	public void reset() {
		this.fileHandle.LoadFileData("slang_goc.txt");
		System.out.println("Reset thành công !");
	}
	
	public void randomSlangWord() {
		int rand = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int i=0;
		for(Map.Entry<String,String> entry : this.fileHandle.slangWordList.slangWords.entrySet() ) {
			
			  String key = entry.getKey();
			  String value = entry.getValue();
			  if(i ==rand) {
				  System.out.println(key + ": "+value);
			  }
			  i++;
	}
	}
	
	public void quizRandomSlangWord() {
		System.out.println("----------------------QUIZ-------------------------");
		
		int rand = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int rand2 = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int rand3 = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int rand4 = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int i=0;
		String def = "";
		String def2="";
		String def3="";
		String def4="";
		ArrayList<String> listDef = new ArrayList<>();

		for(Map.Entry<String,String> entry : this.fileHandle.slangWordList.slangWords.entrySet() ) {
			 
			  String key = entry.getKey();
			  String value = entry.getValue();
			  if(i ==rand) {
				  def =value;
				  System.out.println("** Đâu là definition cho slang word sau đây : " +key );
				  listDef.add(value);
				  
			  }
			  if(i==rand2) {
				  def2= value;
			  }
			  if(i==rand3) {
				  def3=value;
			  }
			  if(i==rand4) {
				  def4 = value;
			  }
			  
			  i++;
	}
		
			listDef.add(def2);
			listDef.add(def3);
			listDef.add(def4);
			Collections.sort(listDef);
			int index =1;
			HashMap<String, String> defMap  = new HashMap<String, String>();
			for (String definition : listDef) {
				System.out.println(index + ". "+ definition);
				defMap.put(index+"", definition);
				index++;
				
			}
			System.out.println("Mời lựa chọn đáp án : ");
			String choose;
			Scanner sc = new Scanner(System.in);
			choose = sc.nextLine();
			if(defMap.get(choose) == def ) {
				System.out.println("Chúc mừng . Bạn đã chọn đúng !");
			}
			else {
				System.out.println("Bạn chọn sai rồi ! Đáp án đúng là : " + def);
				
			}

	}
	
	public void quizRandomDefinition() {
		System.out.println("----------------------QUIZ-------------------------");
		
		int rand = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int rand2 = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int rand3 = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int rand4 = (int)(Math.random()*this.fileHandle.slangWordList.slangWords.size());
		int i=0;
		String slangword = "";
		String slangword4="";
		String slangword2="";
		String slangword3="";
		ArrayList<String> listWord = new ArrayList<>();

		for(Map.Entry<String,String> entry : this.fileHandle.slangWordList.slangWords.entrySet() ) {
			 
			  String key = entry.getKey();
			  String value = entry.getValue();
			  if(i ==rand) {
				  slangword =key;
				  System.out.println("** Đâu là slang word cho definition sau đây : " +value );
				  listWord.add(key);
				  
			  }
			  if(i==rand2) {
				  slangword2 = key;
				  
			  }
			  if(i==rand3) {
				  slangword3 = key;
				  
			  }
			  if(i==rand4) {
				  slangword4 = key;
				  
			  }
			  
			  i++;
	}
		
			listWord.add(slangword2);
			listWord.add(slangword3);
			listWord.add(slangword4);
			Collections.sort(listWord);
			int index =1;
			HashMap<String, String> wordMap  = new HashMap<String, String>();
			for (String word : listWord) {
				System.out.println(index + ". "+ word);
				wordMap.put(index+"", word);
				index++;
				
			}
			System.out.println("Mời lựa chọn đáp án : ");
			String choose;
			Scanner sc = new Scanner(System.in);
			choose = sc.nextLine();
			if(wordMap.get(choose) == slangword ) {
				System.out.println("Chúc mừng . Bạn đã chọn đúng !");
			}
			else {
				System.out.println("Bạn chọn sai rồi ! Đáp án đúng là : " + slangword);
				
			}

	}
	
}
