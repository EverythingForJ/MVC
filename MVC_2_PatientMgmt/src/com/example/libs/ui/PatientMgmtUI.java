package com.example.libs.ui;

import java.util.Scanner;
import java.util.Vector;

import com.example.libs.service.CalcService;
import com.example.libs.vo.PatientVO;

public class PatientMgmtUI {
	private Scanner scan;

	public PatientMgmtUI() {  //생성자
		this.scan = new Scanner(System.in);
		Input input = new Input(this.scan);
		Vector<PatientVO> vector = input.input();  //입력갔다왔음.  이미 환자들을 벡터에 담아서 왔음.
		
		CalcService calc = new CalcService();  //넘겨받은 벡터의 환자들을 각각 계산 한 뒤, 테이블에 insert까지 한다.
		calc.calc(vector);  //모든 환자 계산 끝.
		
		Output output = new Output();
		output.output();
		System.out.println("Bye!!!");
	}
}
