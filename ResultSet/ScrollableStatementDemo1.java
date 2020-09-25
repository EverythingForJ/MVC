import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableStatementDemo1 {
	public static void main(String[] args) throws SQLException {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 2,3

		/* resultSetType : ResultSet.TYPE_FORWARD_ONLY : 오로지 next()밖에 모른다.
		 * 				   ResultSet.TYPE_SCROLL_INSENSITIVE : 불감하다.
		 * 				   ResultSet.TYPE_SCROLL_SENSITIVE : 민감하다.
		 *
		 * resultSetConcurrency : ResultSet.CONCUR_READ_ONLY : 수정 불가능
		 * 						  ResultSet.CONCUR_UPDATABLE : 수정 가능
		 */
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("SELECT empno, ename, job, sal FROM EMP"); // 실제 테이블을 그대로 RESULT SET에 복사한 꼴
		// * 전체출력은 사용 불가, *을 사용하면 resultSet자체가 read only가 된다.
		
		// rs.last(); // 마지막 miller에게 맞추자
		// rs.deleteRow();
//		rs.moveToInsertRow(); // insert를 하기 위한 row
//		rs.updateInt(1, 8888);
//		rs.updateString(2, "한지민");
//		rs.updateString(3, "Developer");
//		rs.insertRow();
		
//		rs.absolute(8); // scott
//		rs.deleteRow(); // ResultSet에서 삭제된 후 원본과 달라졌기 때문에 
		// 자동적으로 원본 테이블과 sync한다.
		
		rs.first(); // smith에 맞춤
		// rs.updateDouble("sal", 7000);
		rs.updateDouble(4, 7000); // 위와 동일
		rs.updateRow(); // 실제로 업데이트를 수행하자.
		
		DBClose.close(conn); // 7
	}
}
