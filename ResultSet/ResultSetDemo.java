import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {
	public static void main(String[] args) throws SQLException {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 2,3

		String sql = " SELECT * FROM EMP_DEPT_NAME "; // VIEW에서 select하기
		// 이름, 업무, 급여, 부서명, 위치
		Statement stmt = conn.createStatement(); // 4.
		
		ResultSet rs = stmt.executeQuery(sql); // 5.
		// ResultSet에 담겨있는 데이터가 next()가 되느냐의 여부가 데이터가 있느냐의 여부이다.
		if(rs.next()) { // 6
			// 만일 next() true를 리턴해서 레코드가 있다는 것이 밝혀지면, 이미 next()를 했기때문에 첫번째 레코드를 읽은 것이 된다.
			do {
				String name = rs.getString(1);
				String job = rs.getString(2);
				double sal = rs.getDouble(3);
				String dname = rs.getString(4);
				String loc = rs.getString(5);
				System.out.println(name+"\t"+job+"\t"+sal+"\t"+dname+"\t"+loc);
			}while(rs.next());
		}else { // 레코드가 없다면
			System.out.println("No data");
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		DBClose.close(conn); // 7
	}
}
