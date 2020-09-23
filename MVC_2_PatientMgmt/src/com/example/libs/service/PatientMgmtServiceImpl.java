package com.example.libs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.dao.PatientMgmtDao;
import com.example.libs.dao.PatientMgmtDaoImpl;
import com.example.libs.vo.PatientVO;

public class PatientMgmtServiceImpl implements PatientMgmtService {
	private PatientMgmtDao dao; // �θ������� �����ؾ� �������̴�.
	public PatientMgmtServiceImpl() { // ������
		this.dao = new PatientMgmtDaoImpl(); // ��!! �������̴ϱ�
	}
	
	@Override
	public int create(PatientVO patient) {
		return 0;
	}

	@Override
	public ArrayList<PatientVO> read() {
		ArrayList<PatientVO> list = null; // ���������� �ʱ�ȭ
		try {
			list = this.dao.select();
		}catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}

}
