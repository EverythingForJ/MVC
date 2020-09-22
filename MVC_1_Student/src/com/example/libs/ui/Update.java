package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.Calc;
import com.example.libs.service.SungjukMgmtService;
import com.example.libs.service.SungjukMgmtServiceImpl;
import com.example.libs.vo.StudentVO;

public class Update {
	private Scanner scan;
	private SungjukMgmtService service;
	public Update(Scanner scan) {
		this.scan = scan;
		this.service = new SungjukMgmtServiceImpl();
	}

	public void update() {
		System.out.print("수정할 학생의 학번 : ");
		String hakbun = this.scan.next();
		StudentVO student = this.service.read(hakbun);
		
		if(student==null) {
			System.out.println("수정하려는 학생을 찾지 못했습니다.");
			return; // 학생을 못 찾았으니까 바로 리턴
		}else { // 수정하려는 학생을 찾았다면
			System.out.println("수정하지 않으려면 그냥 동일한 값을 넣어주고, 수정하려면 수정할 값을 넣어주세요 >> ");
			System.out.println(student.getHakbun()+"["+ student.getName()+"]");
			System.out.print("국어("+student.getKor()+") : ");
			int kor = this.scan.nextInt(); 
			System.out.print("영어("+student.getEng()+") : ");
			int eng = this.scan.nextInt(); 
			System.out.print("수학("+student.getEng()+") : ");
			int mat = this.scan.nextInt(); 
			
			student.setKor(kor);
			student.setEng(eng);
			student.setMat(mat);
			
			Calc calc = new Calc();
			calc.calc(student); // 갔다오면 성적이 재 산정됐을것이다.
			
			int row = this.service.update(student);
			if(row==1) System.out.println("학생 수정 성공");
			else System.out.println("학생 수정 실패");
		}		
	}

}
