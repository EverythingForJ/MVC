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
		System.out.print("������ �л��� �й� : ");
		String hakbun = this.scan.next();
		StudentVO student = this.service.read(hakbun);
		
		if(student==null) {
			System.out.println("�����Ϸ��� �л��� ã�� ���߽��ϴ�.");
			return; // �л��� �� ã�����ϱ� �ٷ� ����
		}else { // �����Ϸ��� �л��� ã�Ҵٸ�
			System.out.println("�������� �������� �׳� ������ ���� �־��ְ�, �����Ϸ��� ������ ���� �־��ּ��� >> ");
			System.out.println(student.getHakbun()+"["+ student.getName()+"]");
			System.out.print("����("+student.getKor()+") : ");
			int kor = this.scan.nextInt(); 
			System.out.print("����("+student.getEng()+") : ");
			int eng = this.scan.nextInt(); 
			System.out.print("����("+student.getEng()+") : ");
			int mat = this.scan.nextInt(); 
			
			student.setKor(kor);
			student.setEng(eng);
			student.setMat(mat);
			
			Calc calc = new Calc();
			calc.calc(student); // ���ٿ��� ������ �� �����������̴�.
			
			int row = this.service.update(student);
			if(row==1) System.out.println("�л� ���� ����");
			else System.out.println("�л� ���� ����");
		}		
	}

}
