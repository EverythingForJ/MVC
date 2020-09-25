import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableStatementDemo {
	public static void main(String[] args) throws SQLException {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 2,3

		// 커서를 원하는 위치로 옮기기
		
		/* resultSetType : ResultSet.TYPE_FORWARD_ONLY : 오로지 next()밖에 모른다.
		 * 				   ResultSet.TYPE_SCROLL_INSENSITIVE : 불감하다.
		 * 				   ResultSet.TYPE_SCROLL_SENSITIVE : 민감하다.
		 *
		 * resultSetConcurrency : ResultSet.CONCUR_READ_ONLY : 수정 불가능
		 * 						  ResultSet.CONCUR_UPDATABLE : 수정 가능
		 */
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP"); // 실제 테이블을 그대로 RESULT SET에 복사한 꼴
		rs.last(); // cursor를 제일 마지막 레코드에 맞추자.
		String ename = rs.getString("ename");
		System.out.println(ename);
		
		rs.first(); // cursur를 제일 앞으로
		String ename1 = rs.getString("ename");
		System.out.println(ename1);
		
		rs.absolute(9); // cursur를 원하는 절대번째로
		String ename2 = rs.getString("ename");
		System.out.println(ename2);
		
		rs.afterLast(); // cursur를 제일 마지막 레코드의 밑에 맞추자
		rs.previous(); 
		String ename3 = rs.getString("ename");
		System.out.println(ename3);
		
		DBClose.close(conn); // 7
	}
}
