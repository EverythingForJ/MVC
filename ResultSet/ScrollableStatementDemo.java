import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableStatementDemo {
	public static void main(String[] args) throws SQLException {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 2,3

		// Ŀ���� ���ϴ� ��ġ�� �ű��
		
		/* resultSetType : ResultSet.TYPE_FORWARD_ONLY : ������ next()�ۿ� �𸥴�.
		 * 				   ResultSet.TYPE_SCROLL_INSENSITIVE : �Ұ��ϴ�.
		 * 				   ResultSet.TYPE_SCROLL_SENSITIVE : �ΰ��ϴ�.
		 *
		 * resultSetConcurrency : ResultSet.CONCUR_READ_ONLY : ���� �Ұ���
		 * 						  ResultSet.CONCUR_UPDATABLE : ���� ����
		 */
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP"); // ���� ���̺��� �״�� RESULT SET�� ������ ��
		rs.last(); // cursor�� ���� ������ ���ڵ忡 ������.
		String ename = rs.getString("ename");
		System.out.println(ename);
		
		rs.first(); // cursur�� ���� ������
		String ename1 = rs.getString("ename");
		System.out.println(ename1);
		
		rs.absolute(9); // cursur�� ���ϴ� �����°��
		String ename2 = rs.getString("ename");
		System.out.println(ename2);
		
		rs.afterLast(); // cursur�� ���� ������ ���ڵ��� �ؿ� ������
		rs.previous(); 
		String ename3 = rs.getString("ename");
		System.out.println(ename3);
		
		DBClose.close(conn); // 7
	}
}
