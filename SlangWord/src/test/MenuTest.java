package test;

import java.util.Scanner;



import slangword.SlangWord;
import filehandle.*;
import menufunction.MenuFunction;
import slangword.SlangWord;

public class MenuTest {
	static Scanner sc= new Scanner(System.in);
	static MenuFunction menuFunction = new MenuFunction();
	public static void main(String[] args) {
		
		
		
		menuFunction.loadFile();
		
		menu();
		
		
		
		
		
		
}
	public static void menu() {
		int choose = 0;
		do {
		
		
		System.out.println("--------------------MENU------------------------");
		System.out.println("1.  Tìm kiếm theo slang word.");
		System.out.println("2.  Tìm kiếm theo definition.");
		System.out.println("3.  Hiển thị history.");
		System.out.println("4.  Add 1 slang words mới.");
		System.out.println("5.  Edit 1 slang word.");
		System.out.println("6.  Delete 1 slang word.");
		System.out.println("7.  Reset danh sách slang words gốc.");
		System.out.println("8.  Random 1 slang word .");
		System.out.println("9.  Đố vui (Random slang word )");
		System.out.println("10. Đố vui (Random Definition).");
		System.out.println("0. Thoát khỏi chương trình.");
		System.out.println("Mời lựa chọn : ");	
		choose = Integer.parseInt(sc.nextLine());
		switch (choose) {
		case 1:
			menuFunction.searchWord();
			break;
		case 2:
			menuFunction.searchDefintion();
			break;
		case 3:
			menuFunction.viewHistorySlangWord();
			break;
		case 4:
			menuFunction.addNewSlangWord();
			break;
		case 5:
			menuFunction.editSlangWord();
			break;
		case 6:
			menuFunction.deleteSlangWord();
			break;
		case 7:
			menuFunction.reset();
			break;
		case 8:
			menuFunction.randomSlangWord();
			break;
		case 9:
			menuFunction.quizRandomSlangWord();
			break;
		case 10:
			menuFunction.quizRandomDefinition();
			break;
		default:
			break;
		}
			
		}
		while(choose != 0 );
	}
}

