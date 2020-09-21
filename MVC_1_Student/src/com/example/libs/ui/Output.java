package com.example.libs.ui;

import java.util.ArrayList;

import com.example.libs.service.SungjukMgmtService;
import com.example.libs.service.SungjukMgmtServiceImpl;
import com.example.libs.vo.StudentVO;

public class Output { // 나는 Front-end니까 Model에 직접 접근하지 않고, 서비스를 부른다. view는 model이 아닌 controller를 부른다.
	private SungjukMgmtService service;
	
	public Output() { // 생성자
		this.service = new SungjukMgmtServiceImpl(); // 자식은 부모로 형변환한다.
	}
	
	public void output() {
		ArrayList<StudentVO> list = this.service.readAll();
		// 학생이 한명이라도 있거나 아예 없거나
		if(list==null) {
			System.out.println("입력된 학생이 없습니다.");
		}else { // 학생이 한명이라도 있다면
			printLabel();
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i)); // 학생.toString
			}
		}
	}
	
	private void printLabel() {
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t평점");
		System.out.println("---------------------------------------------------");
	}
}
