package com.example.libs.service;

import java.util.ArrayList;

import com.example.libs.vo.PatientVO;

public interface PatientMgmtService {
	int create(PatientVO patient);
	// UI�κ��� �Է��� ȯ�ڸ� �Ѱܹ޾Ƽ� �� ���� dao���� �����ϰ�, �ݴ�� dao�� ������ �Է��� ���� ������ �Ѱ��ָ� �� ���� UI���� �Ѱ��ش�.
	ArrayList<PatientVO> read();
	// UI�� ���� ȣ���ϸ�, �� ���� dao���� ��û�ϰ�, �� ���� dao�� �÷����� �Ѱ��ָ� �� ���� UI���� �����Ѵ�.
}
