package filehandle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import slangword.SlangWord;

public class FileHandle {
	SlangWord slangWordList = new SlangWord();
	
	public void LoadFileData(String filename) {

		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fis = new FileInputStream(filename);
			reader = new InputStreamReader(fis);
			bufferedReader = new BufferedReader(reader);
			String line =null;
			try {
				while((line = bufferedReader.readLine())!=null) {
					if(line.isEmpty()) {
						continue;
					}
					String[] param = line.split("`");
					slangWordList.add(param[0],param[1]);
					
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
	
	
public void saveFile(String filename) {
		FileOutputStream fos =null;
		try {
			fos = new FileOutputStream(filename,true );
			for (String word : slangWordList.slangWords.keySet()) {
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
