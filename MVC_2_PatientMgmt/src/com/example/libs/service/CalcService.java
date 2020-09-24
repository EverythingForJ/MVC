package com.example.libs.service;

import java.sql.SQLException;
import java.util.Vector;

import com.example.libs.dao.PatientMgmtDao;
import com.example.libs.dao.PatientMgmtDaoImpl;
import com.example.libs.vo.PatientVO;

//제일 어려운 클래스
public class CalcService {
	private PatientMgmtDao dao;
	
	public CalcService() {
		this.dao = new PatientMgmtDaoImpl(); 
	}

	public void calc(Vector<PatientVO> vector) {
		try {
			for(int i = 0 ; i < vector.size() ; i++) {
				PatientVO patient = vector.elementAt(i);
				String dname = this.dao.selectDName(patient.getCode().trim());  //부서코드로 진찰부서이름 알아오기 끝.
				//1일 입원비는 1일 25000원으로 하되 3일 이하는 30000원으로 처리한다.
				int days = patient.getDays();  //입원일수
				int one_days = (days <= 3) ? 30000 : 25000;  //1일 입원비
				
				//총입원비 = 1일 입원비 X 입원일수
				int fee = one_days * days;   //총 입원비
				//입원비 = 총입원비 X 입원일수 할인비율
				int hospital_fee = (int)(fee * this.dao.selectRate(days));     //입원비
				
				//진료비 = 진찰비 + 입원비
				int checkup_fee = this.dao.selectCheckup(patient.getAge());  //진찰비
				int sum = checkup_fee + hospital_fee;  //진료비
				
				patient.setDname(dname);
				patient.setCheckup_fee(checkup_fee);
				patient.setHospital_fee(hospital_fee);
				patient.setSum(sum);    //한 환자 계산 끝.
				int row = this.dao.insert(patient);
				if(row == 1) System.out.println("환자 입력 성공");
				else System.out.println("환자 입력 실패");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
	}
}
