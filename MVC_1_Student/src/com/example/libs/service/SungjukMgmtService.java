package com.example.libs.service;

import java.util.ArrayList;

import com.example.libs.vo.StudentVO;

public interface SungjukMgmtService {
	int create(StudentVO student); 
	// insert할 학생을 파라미터로 넘겨주면 DB에서 삽입 후 입력한 row 갯수를 반환
	StudentVO read(String hakbun); 
	// 검색할 학생의 학번을 파라미터로 넘겨주면 그 학생을 찾아서 학생 객체를 반환한다. 만일 찾으려는 학생이 없으면 null을 반환한다.
	ArrayList<StudentVO> readAll();
	// 모든 학생을 찾아서 컬렉션에 넣고 그 컬렉션 째로 반환한다. 만일 학생이 한명도 없으면 null을 반환한다.
	int update(StudentVO student);
	// 수정하려는 학생객체를 파라미터로 넘겨주면, 그 학생을 DB에서 수정한 다음 수정한 열 갯수를 반환한다.
	int delete(String hakbun);
	// 삭제하려는 학생의 학번을 파라미터로 넘겨주면, 그 학생을 데이터베이스에 삭제한 다음, 삭제한 열 갯수를 반환한다.
}
