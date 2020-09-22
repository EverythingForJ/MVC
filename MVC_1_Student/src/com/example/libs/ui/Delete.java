package com.example.libs.ui;

import java.util.Scanner;

import com.example.libs.service.SungjukMgmtService;
import com.example.libs.service.SungjukMgmtServiceImpl;

public class Delete {
	private Scanner scan;
	private SungjukMgmtService service;
	public Delete(Scanner scan) {
		this.scan = scan;
		this.service = new SungjukMgmtServiceImpl();
	}
	
	public void delete() {
		System.out.print("삭제할 학생의 학번 : ");
		String hakbun = this.scan.next();
		int row = this.service.delete(hakbun);
		if(row==1)System.out.println("학생 삭제 성공");
		else System.out.println("학생 삭제 실패");
	}
	
}
