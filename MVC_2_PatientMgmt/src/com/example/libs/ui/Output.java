package com.example.libs.ui;

import java.util.ArrayList;

import com.example.libs.service.PatientMgmtService;
import com.example.libs.service.PatientMgmtServiceImpl;
import com.example.libs.vo.PatientVO;

public class Output {
	private PatientMgmtService service; // �׻� ui�� ���񽺸� �θ� �غ� �Ǿ��־�� �Ѵ�.
	
	public Output() {
		this.service = new PatientMgmtServiceImpl(); // ������ ������ �����ϸ� ������ �����ڴ� dao�� �����ڸ� ȣ���Ѵ�.
	}
	
	public void output() {
		ArrayList<PatientVO> list = this.service.read();
		printLabel();
		if(list==null) { // ȯ�ڰ� �� �� ���ٸ�
			System.out.println("���� ȯ�� �����Ͱ� �����ϴ�.");
		}else { // ȯ�ڰ� �ִٸ�
			for(int i = 0; i<list.size(); i++) {
				PatientVO patient = list.get(i);
				System.out.println(patient); // toString()
			}
		}
	}
	
	private void printLabel() {
		System.out.println("		 	  << ȯ�� ���� ���α׷� >>");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("��ȣ\t\t�����μ�\t\t������\t\t�Կ���\t\t�����");
		System.out.println("------------------------------------------------------------------------------------");
	}

}
