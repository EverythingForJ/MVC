package com.example.libs.ui;

import java.util.ArrayList;

import com.example.libs.service.PatientMgmtService;
import com.example.libs.service.PatientMgmtServiceImpl;
import com.example.libs.vo.PatientVO;

public class Output {
	private PatientMgmtService service; // 항상 ui는 서비스를 부를 준비가 되어있어야 한다.
	
	public Output() {
		this.service = new PatientMgmtServiceImpl(); // 서비스의 생성자 초훌하면 서비스의 생성자는 dao의 생성자를 호출한다.
	}
	
	public void output() {
		ArrayList<PatientVO> list = this.service.read();
		printLabel();
		if(list==null) { // 환자가 한 명도 없다면
			System.out.println("현재 환자 데이터가 없습니다.");
		}else { // 환자가 있다면
			for(int i = 0; i<list.size(); i++) {
				PatientVO patient = list.get(i);
				System.out.println(patient); // toString()
			}
		}
	}
	
	private void printLabel() {
		System.out.println("		 	  << 환자 관리 프로그램 >>");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("번호\t\t진찰부서\t\t진찰비\t\t입원비\t\t진료비");
		System.out.println("------------------------------------------------------------------------------------");
	}

}
