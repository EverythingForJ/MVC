package com.example.libs.ui;

import java.util.Scanner;
import java.util.Vector;

import com.example.libs.service.PatientMgmtService;
import com.example.libs.service.PatientMgmtServiceImpl;
import com.example.libs.vo.PatientVO;

public class Input {
	private Scanner scan;
	@SuppressWarnings("unused")
	private PatientMgmtService service;  //여기서 핵심은 자식 클래스타입이 아니다. 부모 인터페이스 타입이다. 왜? 다형성 때문에 
	
	public Input(Scanner scan) {
		this.scan = scan;
		this.service = new PatientMgmtServiceImpl();   //다형성...선언형은 부모형 실제형은 자식형
	}

	public Vector<PatientVO> input() {
		String i_o = null;  //지역변수니까 초기화
		Vector<PatientVO> vector = new Vector<PatientVO>(1,1);  //한개씩 증가, 지역변수니까 초기화
		do {
			System.out.print("번 호 : ");
			int bunho = this.scan.nextInt();
			System.out.print("진료코드 : ");
			String code = this.scan.next();
			System.out.print("입원일수 : ");
			int days = this.scan.nextInt();
			System.out.print("나 이 : ");
			int age = this.scan.nextInt();
			
			PatientVO patient = new PatientVO(bunho, code, days, age);
			vector.addElement(patient);
			//번호와 진료코드와 입원일수와 나이를 입력받아서 바로 환자형을 만들고, 계산까지 마친후, 이 환자를 컬렉션에 담는다. 
			//컬렉션에 환자들을 한명씩 담아서 컬렉션을 리턴할 것인가? 아니면 애초부터 컬렉션이 넘어와 있었는가?
			//이미 인서트까지 끝낼 것인가? 아니면 한꺼번에 인서트할 것인가?
			
			System.out.print("입력/출력(I/O) ? ");
			i_o = this.scan.next();
		}while(i_o.toUpperCase().equals("I"));
		return vector;
	}

}
