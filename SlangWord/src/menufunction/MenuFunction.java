package menufunction;
import java.util.Scanner;

import filehandle.*;
import slangword.SlangWord;

public class MenuFunction {
	FileHandle fileHandle = new FileHandle();
	
	public void loadFile() {
		
		fileHandle.LoadFileData("xy.txt");
		
	}
	public void searchWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập từ muốn tìm : ");
		String word;
		word = sc.nextLine();
		
		System.out.println("Definition: " + this.fileHandle.getas(word));
	}
}
