package com.example.libs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.libs.vo.StudentVO;

public class SungjukMgmtDaoImpl implements SungjukMgmtDao {
	private DBConnection dbconn;
	
	public SungjukMgmtDaoImpl() { // 생성자
		this.dbconn = new DBConnection();
	}
	
	@Override
	public int insert(StudentVO student) throws SQLException {
		Connection conn = dbconn.getConnection(); // 2, 3
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, student.getHakbun());
		pstmt.setString(2, student.getName());
		pstmt.setInt(3, student.getKor());
		pstmt.setInt(4, student.getEng());
		pstmt.setInt(5, student.getMat());
		pstmt.setInt(6, student.getTot());
		pstmt.setDouble(7, student.getAvg());
		pstmt.setString(8, student.getGrade());	// 비로소 완전한 SQL문장
		int row = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn); // 6
		return row;
	}

	@Override
	public StudentVO select(String hakbun) throws SQLException {
		Connection conn = dbconn.getConnection(); // 2, 3
		String sql = "SELECT * FROM STUDENT WHERE HAKBUN = ? "; // 불완전 SQL문
		PreparedStatement pstmt = conn.prepareStatement(sql); // 4
		pstmt.setString(1, hakbun);
		ResultSet rs = pstmt.executeQuery(); // 5
		
		// 기본키로 검색했기때문에 찾았으면 한 명, 못찾았으면 null
		StudentVO student = null;
		if(rs.next()) { // rs에 레코드가 한개 있다면, 찾았다.
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			int tot = rs.getInt("tot");
			double avg = rs.getDouble("avg");
			String grade = rs.getString("grade");
			student = new StudentVO(hakbun, name, kor, eng, mat);
			student.setTot(tot);
			student.setAvg(avg);
			student.setGrade(grade);
		}else { // rs가 비워져있다면 못찾았다.
			student = null;
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		DBClose.close(conn); // 7
		return student;
	}

	@Override
	public ArrayList<StudentVO> selectAll() throws SQLException {
		Connection conn = dbconn.getConnection(); // 2, 3
		Statement stmt = conn.createStatement(); // 4
		String sql = " SELECT * FROM STUDENT ORDER BY TOT DESC ";
		ResultSet rs = stmt.executeQuery(sql); // 5
		ArrayList<StudentVO> list = new ArrayList<StudentVO>(); // 10개의 방이 생성된다.
		if(!(rs.next())) { // 학생이 한 명도 없다면
			list = null;
		}else { // 학생이 있다면
			// 중요한 것은 이미 한번 next()를 했다는 것. 즉 첫번째학생을 읽었다.
			do { // 이미 한번 next()를 했으니까
				String hakbun = rs.getString("hakbun");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");
				String grade = rs.getString("grade");
				StudentVO student = new StudentVO(hakbun, name, kor, eng, mat);
				student.setTot(tot);
				student.setAvg(avg);
				student.setGrade(grade);
				list.add(student); // list에 학생 담았다.
			}while(rs.next()); // 다른 학생이 있다면 다시 루프 돈다.
		}
		DBClose.close(conn); // 7
		return list; // 3명의 학생이 담겨있다.
	}

	@Override
	public int update(StudentVO student) throws SQLException {
		Connection conn = this.dbconn.getConnection(); // 2,3
		
		String sql = "UPDATE STUDENT SET KOR = ?, ENG = ?, MAT =?, TOT=?, AVG =?, GRADE =? WHERE HAKBUN = ? "; // 불완전 SQL문
		PreparedStatement pstmt = conn.prepareStatement(sql); // 4
		pstmt.setInt(1, student.getKor());
		pstmt.setInt(2, student.getEng());
		pstmt.setInt(3, student.getMat());
		pstmt.setInt(4, student.getTot());
		pstmt.setDouble(5, student.getAvg());
		pstmt.setString(6, student.getGrade());
		pstmt.setString(7, student.getHakbun());
		
		int row = pstmt.executeUpdate(); // 5
		
		if(pstmt!=null) pstmt.close();
		DBClose.close(conn); // 6
		return row;
	}

	@Override
	public int delete(String hakbun) throws SQLException { // 실제로 DB에 붙어서 삭제하는 메소드
		Connection conn = this.dbconn.getConnection(); // 2,3
		String sql = "DELETE FROM STUDENT WHERE HAKBUN = ?"; // 불완전 SQL문
		PreparedStatement pstmt = conn.prepareStatement(sql); // 4
		pstmt.setString(1, hakbun);
		int row = pstmt.executeUpdate(); // 파라미터에 sql넘기지말기 5
		if(pstmt!=null) pstmt.close();
 		DBClose.close(conn); // 6
		return row;
	}

}
