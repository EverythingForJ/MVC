package com.example.libs.service;

import com.example.libs.vo.StudentVO;

public class Calc {
	public void calc(StudentVO student) {
		int tot = student.getKor() + student.getEng()+student.getMat();
		double avg = tot/3.;
		String grade = (avg>=90)?"A":
						(avg>=80)?"B":
							(avg>=70)?"C":
								(avg>=60)?"D":"F";
		student.setTot(tot);
		student.setAvg(avg);
		student.setGrade(grade);
	}
}
