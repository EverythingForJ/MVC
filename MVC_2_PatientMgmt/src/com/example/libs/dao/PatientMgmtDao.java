package com.example.libs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.vo.PatientVO;

public interface PatientMgmtDao {
	int insert(PatientVO patient) throws SQLException;
	// �Է��� ȯ�ڸ� �Ķ���ͷ� �޾Ƽ� ȯ�� ���̺� �Է��Ѵ�. �Է��� ���� ������ ��ȯ�Ѵ�.
	ArrayList<PatientVO> select() throws SQLException;
	// ��� ȯ�� �����͸� ���̺��� �Ѱܹ޾Ƽ� ���� �ʿ� �÷������� �Ѱ��ش�.
}
