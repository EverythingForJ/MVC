import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableStatementDemo1 {
	public static void main(String[] args) throws SQLException {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 2,3

		/* resultSetType : ResultSet.TYPE_FORWARD_ONLY : ������ next()�ۿ� �𸥴�.
		 * 				   ResultSet.TYPE_SCROLL_INSENSITIVE : �Ұ��ϴ�.
		 * 				   ResultSet.TYPE_SCROLL_SENSITIVE : �ΰ��ϴ�.
		 *
		 * resultSetConcurrency : ResultSet.CONCUR_READ_ONLY : ���� �Ұ���
		 * 						  ResultSet.CONCUR_UPDATABLE : ���� ����
		 */
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("SELECT empno, ename, job, sal FROM EMP"); // ���� ���̺��� �״�� RESULT SET�� ������ ��
		// * ��ü����� ��� �Ұ�, *�� ����ϸ� resultSet��ü�� read only�� �ȴ�.
		
		// rs.last(); // ������ miller���� ������
		// rs.deleteRow();
//		rs.moveToInsertRow(); // insert�� �ϱ� ���� row
//		rs.updateInt(1, 8888);
//		rs.updateString(2, "������");
//		rs.updateString(3, "Developer");
//		rs.insertRow();
		
//		rs.absolute(8); // scott
//		rs.deleteRow(); // ResultSet���� ������ �� ������ �޶����� ������ 
		// �ڵ������� ���� ���̺�� sync�Ѵ�.
		
		rs.first(); // smith�� ����
		// rs.updateDouble("sal", 7000);
		rs.updateDouble(4, 7000); // ���� ����
		rs.updateRow(); // ������ ������Ʈ�� ��������.
		
		DBClose.close(conn); // 7
	}
}
