package com.example.libs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.dao.PatientMgmtDao;
import com.example.libs.dao.PatientMgmtDaoImpl;
import com.example.libs.vo.PatientVO;

public class PatientMgmtServiceImpl implements PatientMgmtService {
	private PatientMgmtDao dao; // 부모형으로 선언해야 다형성이다.
	public PatientMgmtServiceImpl() { // 생성자
		this.dao = new PatientMgmtDaoImpl(); // 왜!! 다형성이니까
	}
	
	@Override
	public int create(PatientVO patient) {
		return 0;
	}

	@Override
	public ArrayList<PatientVO> read() {
		ArrayList<PatientVO> list = null; // 지역변수라 초기화
		try {
			list = this.dao.select();
		}catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}

}
