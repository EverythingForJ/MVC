package com.example.libs.ui;

import java.util.Scanner;

public class SungjukMgmtUI {
	private Scanner scan;
	
	public SungjukMgmtUI() {
		this.scan = new Scanner(System.in);
		
		while(true) {
			int choice = showMenu();
			process(choice);
		}
	}
	
	private int showMenu() {
		System.out.println("\n*****Menu*****");
		System.out.println("1. 모든 학생 보기"); // SELECT (Read)
		System.out.println("2. 학생 검색 하기");
		System.out.println("3. 학생 입력 하기"); // INSERT (Create)
		System.out.println("4. 학생 정보 수정 하기"); // UPDATE (Update)
		System.out.println("5. 학생 삭제 하기"); // DELETE (Delete)
		System.out.println("9. 프로그램 종료");
		System.out.print("선택 >> ");
		return this.scan.nextInt();
	}
	
	private void process(int choice) {
		switch(choice) {
		case 1 : Output output = new Output(); 
				output.output(); break;
		case 2 : Search search = new Search(this.scan);
				search.serch(); break;
		case 3 : Input input = new Input(this.scan);
				input.input(); break;
		case 4 : Update update = new Update(this.scan);
				update.update(); break;
		case 5 : Delete delete = new Delete(this.scan);
				delete.delete(); break;
		case 9 : System.out.println("Bye!!"); System.exit(0); break;
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			
		}
	}
	
}
