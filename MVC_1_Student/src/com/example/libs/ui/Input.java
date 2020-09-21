package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.Calc;
import com.example.libs.service.SungjukMgmtService;
import com.example.libs.service.SungjukMgmtServiceImpl;
import com.example.libs.vo.StudentVO;

public class Input {
	private Scanner scan;
	private SungjukMgmtService service;
	public Input(Scanner scan) { // 생성자
		this.scan = scan;
		this.service = new SungjukMgmtServiceImpl();
	}
	
	public void input() {
		System.out.print("학번 : ");
		String hakbun = this.scan.next();
		System.out.print("이름 : ");
		String name = this.scan.next();
		System.out.print("국어 : ");
		int kor = this.scan.nextInt();
		System.out.print("영어 : ");
		int eng = this.scan.nextInt();
		System.out.print("수학 : ");
		int mat = this.scan.nextInt();
		StudentVO student = new StudentVO(hakbun, name, kor, eng, mat);
		Calc calc = new Calc();
		calc.calc(student); // 계산하고 왔음.
		int row = this.service.create(student); // 입력할 학생 보내기
		if(row==1) System.out.println("학생 입력 성공");
		else System.out.println("학생 입력 실패");
	}
}
