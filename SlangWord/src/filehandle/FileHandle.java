package filehandle;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import slangword.SlangWord;

public class FileHandle {
	public SlangWord slangWordList = new SlangWord();
	
	public void LoadFileData(String filename) {
		
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader  bufferedReader = null;
		
		try {
			fis= new FileInputStream(filename);
			reader = new InputStreamReader(fis);
			bufferedReader =  new BufferedReader(reader);
			String line =null;
			try {
				while((line = bufferedReader.readLine())!=null) {
					
					//gặp dòng trống thì bỏ qua 
					if(line.isEmpty()) {  
						continue; 
				}
					// găpj những từ không đúng định dạng thì bỏ qua
					if(!(line.contains("`"))) {
						continue; 
					}
					
					String[] params = line.split("`");
					
					slangWordList.add(params[0], params[1]);
					
					
				}
				
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (fis !=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bufferedReader !=null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		

	}
	public void saveFileData(String fileName) {
		System.out.println("Save File!!!");
		
		FileOutputStream fos= null;
		
		try {
			
			fos = new FileOutputStream(fileName);
			try {
				new FileOutputStream(fileName).close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (String key : this.slangWordList.slangWords.keySet()) {
				String line = key+"`"+ this.slangWordList.get(key)+"\n";
				try {
					byte[] b = line.getBytes("utf8");
					try {
					
						fos.write(b);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	public String getas(String word) {
		
		return (this.slangWordList.get(word));
	
	}
	
	
}
	
