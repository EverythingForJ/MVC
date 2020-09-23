package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.PatientMgmtService;

public class PatientMgmtUI {
	private Scanner scan;
	
	public PatientMgmtUI() { // 생성자
		this.scan = new Scanner(System.in);
		// Input input = new Input(this.scan);
		// input.input(); // 입력갔다왔음
		
		Output output = new Output();
		output.output();
		System.out.println("Bye!!");
	}
	
	
	
}
