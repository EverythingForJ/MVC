package com.example.libs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.libs.vo.PatientVO;

public class PatientMgmtDaoImpl implements PatientMgmtDao {
	private DBConnection dbconn;
	public PatientMgmtDaoImpl() { //생성자
		this.dbconn = new DBConnection();
	}
	
	@Override
	public int insert(PatientVO patient) throws SQLException{
		Connection conn = this.dbconn.getConnection();   //2.3
		String sql = "INSERT INTO Patient VALUES(?,?,?,?,?,?,?)";  //불완전한 SQL문장
		PreparedStatement pstmt = conn.prepareStatement(sql);   //4. 아직까지 불완전한 SQL문장
		pstmt.setInt(1, patient.getBunho());  //번호
		pstmt.setString(2, patient.getCode()); //코드
		pstmt.setInt(3, patient.getDays());  //입원일수
		pstmt.setInt(4, patient.getAge());    //환자의 나이
		pstmt.setInt(5, patient.getCheckup_fee());  //진찰비
		pstmt.setInt(6, patient.getHospital_fee());   //입원비
		pstmt.setInt(7, patient.getSum());              //진료비, 비로소 완전한 SQL문장
		
		int row = pstmt.executeUpdate();   //5. 매우 주의하자. 파라미터에 sql을 넣지 말자.
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //6
		return row;
	}

	@Override
	public ArrayList<PatientVO> select() throws SQLException{
		Connection conn = this.dbconn.getConnection();  //2, 3
		Statement stmt = conn.createStatement();   //4
		String sql = "  SELECT bunho, dname, checkup_fee, hospital_fee, sum  " + 
		                  "  FROM Patient  NATURAL JOIN Department ORDER BY bunho ASC";
		ResultSet rs = stmt.executeQuery(sql);  //5. 
		ArrayList<PatientVO> list = new ArrayList<PatientVO>();   //10개 방 생성
		if(rs.next()) {  //6. 환자가 있다는 뜻
			do {
				int bunho = rs.getInt("bunho");
				String dname = rs.getString("dname");
				int checkup_fee = rs.getInt("checkup_fee");
				int hospital_fee = rs.getInt("hospital_fee");
				int sum = rs.getInt("sum");
				PatientVO patient = new PatientVO();  //기본생성자
				patient.setBunho(bunho);
				patient.setDname(dname);
				patient.setCheckup_fee(checkup_fee);
				patient.setHospital_fee(hospital_fee);
				patient.setSum(sum);
				list.add(patient); 
			}while(rs.next());
		}else {   //한명도 없다는 뜻
			list = null;
		}
		DBClose.close(conn);     //7.
		return list;
	}

	//부서코드가 넘어오면 부서이름을 찾는 메소드
	@Override
	public String selectDName(String code) throws SQLException{
		Connection conn = this.dbconn.getConnection();   //2.3
		String sql = "SELECT dname FROM Department WHERE code = ?";  //불완전한 SQL문장
		PreparedStatement pstmt = conn.prepareStatement(sql);   //4. 아직까지 불완전한 SQL문장
		pstmt.setString(1, code);  //비로소 완전한 SQL문장
		ResultSet rs = pstmt.executeQuery();   //5. 매우 주의하자. 파라미터에 sql을 넣지 말자.
		rs.next();  //왜? 기본키로 요청했으니까
		String dname = rs.getString("dname");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //7
		return dname;
	}
	
	//Discount에 가서 입원일수를 가지고 상한일수와 하한일수로 할인비율을 알아오자.
	@Override
	public double selectRate(int days) throws SQLException{
		Connection conn = this.dbconn.getConnection();   //2.3
		String sql = "   SELECT rate FROM  Discount   " + 
				           "  WHERE ? BETWEEN lodays AND hidays";      //불완전한 SQL문장
		PreparedStatement pstmt = conn.prepareStatement(sql);   //4. 아직까지 불완전한 SQL문장		
		pstmt.setInt(1, days);  //비로소 완전한 SQL문장
		ResultSet rs = pstmt.executeQuery();   //5. 매우 주의하자. 파라미터에 sql을 넣지 말자.
		rs.next();  //왜? 한개만 넘어오니까
		double rate = rs.getDouble("rate");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //7
		return rate;
	}
	
	//환자의 나이가 넘어오면 그 환자의 진찰비를 넘겨준다.
	@Override
	public int selectCheckup(int age) throws SQLException{
		Connection conn = this.dbconn.getConnection();   //2.3
		String sql = "   SELECT fee FROM Checkup   " + 
				          "   WHERE ? BETWEEN loage AND hiage";  //불완전한 SQL문장
		PreparedStatement pstmt = conn.prepareStatement(sql);   //4. 아직까지 불완전한 SQL문장	
		pstmt.setInt(1, age);  //비로소 완전한 SQL문장
		ResultSet rs = pstmt.executeQuery();   //5. 매우 주의하자. 파라미터에 sql을 넣지 말자.
		rs.next();  //왜? 한개만 넘어오니까
		int fee = rs.getInt("fee");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //7
		return fee;
	}
}
