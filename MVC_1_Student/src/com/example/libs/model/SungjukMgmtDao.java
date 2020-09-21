package com.example.libs.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.vo.StudentVO;

public interface SungjukMgmtDao {
	int insert(StudentVO student) throws SQLException;
	// 입력할 학생이 파라미터로 들어오면 데이터베이스에 실제로 insert하고 그 행 갯수를 반환한다.
	StudentVO select(String hakbun) throws SQLException;
	// 검색할 학생의 학번이 파라미터로 들어오면 그 학생을 실제로 Database에서 찾은 후 그 학생을 반환한다.
	ArrayList<StudentVO> selectAll() throws SQLException;
	// 모든 학생을 실제로 데이터베이스에서 검색한 학생들을 컬렉션에 담아서 반환한다.
	int update(StudentVO student) throws SQLException;
	// 수정할 학생을 파라미터로 받아서 실제로 데이터베이스에서 수정한 다음 그 갯수를 반환한다.
	int delete(String hakbun) throws SQLException;
	// 삭제할 학생의 번호를 파라미터로 받은 후, 실제로 데이터베이스에서 삭제 후, 그 행 갯수를 반환한다.
}
