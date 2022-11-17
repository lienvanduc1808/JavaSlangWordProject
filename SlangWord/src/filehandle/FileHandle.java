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
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import slangword.SlangWord;

public class FileHandle {
	SlangWord slangWordList = new SlangWord();
	
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
					if(line.isEmpty()) {
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
	public String getas(String word) {
		
		return (this.slangWordList.get(word));
	}
}
	
