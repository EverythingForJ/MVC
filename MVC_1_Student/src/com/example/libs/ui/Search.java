package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.SungjukMgmtService;
import com.example.libs.service.SungjukMgmtServiceImpl;
import com.example.libs.vo.StudentVO;

public class Search {
	private Scanner scan;
	private SungjukMgmtService service;
	
	public Search(Scanner scan) {
		this.scan = scan;
		this.service = new SungjukMgmtServiceImpl();
	}

	public void serch() {
		System.out.print("찾으려는 학생의 학번 : ");
		String hakbun = this.scan.next();
		StudentVO student = this.service.read(hakbun); // 찾았다면 학생형, 못찾았다면 null
		if(student == null) System.out.println("찾으시는 학생이 없습니다. 확인 후 다시 검색해 주세요.");
		else System.out.println(student); // student.toStirng();
	}

}
