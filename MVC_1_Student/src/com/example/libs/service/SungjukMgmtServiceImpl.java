package com.example.libs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.model.SungjukMgmtDao;
import com.example.libs.model.SungjukMgmtDaoImpl;
import com.example.libs.vo.StudentVO;

public class SungjukMgmtServiceImpl implements SungjukMgmtService {

	private SungjukMgmtDao dao; // interface
	
	public SungjukMgmtServiceImpl() {
		this.dao = new SungjukMgmtDaoImpl();
	}
	
	@Override
	public int create(StudentVO student) {
		int row = 0;
		try {
			row = this.dao.insert(student);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}

	@Override
	public StudentVO read(String hakbun) { // ui한테 학번넘겨받아서 dao에게주고, dao가 준 것을 다시 ui에게 반환
		StudentVO student=null; // 지역변수니까 초기화
		try {
			student = this.dao.select(hakbun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public ArrayList<StudentVO> readAll() { // 나 서비스는 Model을 부른다.
		// 모든 학생 가져오기
		ArrayList<StudentVO> list = null;
		try {
			list = this.dao.selectAll();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		return list;
	}

	@Override
	public int update(StudentVO student) {
		// UI에서 수정한 학생을 넘겨받고, 내 뒤의 DAO에게 넘겨주면, DAO는 나에게 수정한 열 갯수를 넘겨주고 나는 그것을 다시 UI에게 넘겨주면 끝
		int row = 0;
		try {
			row = this.dao.update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String hakbun) { // dao의 delete()를 호출한다. UI가 넘겨준다.
		int row = 0;
		try {
			row = this.dao.delete(hakbun);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}

}
