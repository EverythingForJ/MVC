package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.PatientMgmtService;

public class PatientMgmtUI {
	private Scanner scan;
	
	public PatientMgmtUI() { // ������
		this.scan = new Scanner(System.in);
		// Input input = new Input(this.scan);
		// input.input(); // �Է°��ٿ���
		
		Output output = new Output();
		output.output();
		System.out.println("Bye!!");
	}
	
	
	
}
