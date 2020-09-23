package com.example.libs.service;

import java.util.ArrayList;

import com.example.libs.vo.PatientVO;

public interface PatientMgmtService {
	int create(PatientVO patient);
	// UI로부터 입력한 환자를 넘겨받아서 내 뒤의 dao에게 전달하고, 반대로 dao는 나에게 입력한 행의 갯수를 넘겨주면 내 앞의 UI에게 넘겨준다.
	ArrayList<PatientVO> read();
	// UI가 나를 호출하면, 내 뒤의 dao에게 요청하고, 내 뒤의 dao가 컬렉션을 넘겨주면 내 앞의 UI에게 전달한다.
}
