package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.PatientMgmtService;
import com.example.libs.service.PatientMgmtServiceImpl;

public class Input {
	private Scanner scan;
	private PatientMgmtService service; // 여기서 핵심은 자식 클래스 타입이 아니다. 부모 인터페이스 타입이다. 왜? 다형성 때문에
	
	public Input(Scanner scan) {
		this.scan = scan;
		this.service = new PatientMgmtServiceImpl(); // 다형성... 선언형은 부모형, 실제형은 자식형
	}

	public void input() {
		String i_o=null; // 지역변수니까 초기화
		do {
			System.out.print(" 번 호 : ");
			int bunho = this.scan.nextInt();
			System.out.print(" 진료 코드 : ");
			String code = this.scan.next();
			System.out.print(" 입원 일수 : ");
			int days = this.scan.nextInt();
			System.out.print(" 나 이 : ");
			int age = this.scan.nextInt();
			System.out.print(" 입력/출력(I/O) ? ");
			i_o = this.scan.next();
			
			
		} while(i_o.toUpperCase().equals("I"));		
	}

	
	
}
