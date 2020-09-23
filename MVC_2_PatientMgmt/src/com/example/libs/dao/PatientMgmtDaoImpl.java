package com.example.libs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.libs.vo.PatientVO;

public class PatientMgmtDaoImpl implements PatientMgmtDao {
	private DBConnection dbconn;
	public PatientMgmtDaoImpl() { // 생성자
		this.dbconn = new DBConnection();
		
	}
	
	@Override
	public int insert(PatientVO patient) throws SQLException{
		return 0;
	}

	@Override
	public ArrayList<PatientVO> select() throws SQLException{
		Connection conn = this.dbconn.getConnection(); // 2,3
		Statement stmt = conn.createStatement(); // 4
		String sql = "SELECT BUNHO, DNAME, CHECKUP_FEE, HOSPITAL_FEE, SUM FROM PATIENT ORDER BY BUNHO ASC";
		ResultSet rs = stmt.executeQuery(sql); // 5.
		ArrayList<PatientVO> list = new ArrayList<PatientVO>(); // 10개 방 생성
		if(rs.next()) { // 환자가 있다는 뜻
			while(rs.next()) { 
				
			}
		}else {
			list = null;
		}
		
		DBClose.close(conn); // 7
		return list;
	}

}
