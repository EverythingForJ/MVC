package com.example.libs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.vo.PatientVO;

public interface PatientMgmtDao {
	int insert(PatientVO patient) throws SQLException;
	// 입력할 환자를 파라미터로 받아서 환자 테이블에 입력한다. 입력한 행의 갯수를 반환한다.
	ArrayList<PatientVO> select() throws SQLException;
	// 모든 환자 데이터를 테이블에서 넘겨받아서 서비스 쪽에 컬렉션으로 넘겨준다.
}
