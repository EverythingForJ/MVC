package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.PatientMgmtService;
import com.example.libs.service.PatientMgmtServiceImpl;

public class Input {
	private Scanner scan;
	private PatientMgmtService service; // ���⼭ �ٽ��� �ڽ� Ŭ���� Ÿ���� �ƴϴ�. �θ� �������̽� Ÿ���̴�. ��? ������ ������
	
	public Input(Scanner scan) {
		this.scan = scan;
		this.service = new PatientMgmtServiceImpl(); // ������... �������� �θ���, �������� �ڽ���
	}

	public void input() {
		String i_o=null; // ���������ϱ� �ʱ�ȭ
		do {
			System.out.print(" �� ȣ : ");
			int bunho = this.scan.nextInt();
			System.out.print(" ���� �ڵ� : ");
			String code = this.scan.next();
			System.out.print(" �Կ� �ϼ� : ");
			int days = this.scan.nextInt();
			System.out.print(" �� �� : ");
			int age = this.scan.nextInt();
			System.out.print(" �Է�/���(I/O) ? ");
			i_o = this.scan.next();
			
			
		} while(i_o.toUpperCase().equals("I"));		
	}

	
	
}
