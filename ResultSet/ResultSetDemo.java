import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {
	public static void main(String[] args) throws SQLException {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 2,3

		String sql = " SELECT * FROM EMP_DEPT_NAME "; // VIEW���� select�ϱ�
		// �̸�, ����, �޿�, �μ���, ��ġ
		Statement stmt = conn.createStatement(); // 4.
		
		ResultSet rs = stmt.executeQuery(sql); // 5.
		// ResultSet�� ����ִ� �����Ͱ� next()�� �Ǵ����� ���ΰ� �����Ͱ� �ִ����� �����̴�.
		if(rs.next()) { // 6
			// ���� next() true�� �����ؼ� ���ڵ尡 �ִٴ� ���� ��������, �̹� next()�� �߱⶧���� ù��° ���ڵ带 ���� ���� �ȴ�.
			do {
				String name = rs.getString(1);
				String job = rs.getString(2);
				double sal = rs.getDouble(3);
				String dname = rs.getString(4);
				String loc = rs.getString(5);
				System.out.println(name+"\t"+job+"\t"+sal+"\t"+dname+"\t"+loc);
			}while(rs.next());
		}else { // ���ڵ尡 ���ٸ�
			System.out.println("No data");
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		DBClose.close(conn); // 7
	}
}
