package com.example.libs.vo;

public class PatientVO {
	private int bunho; 			//ȯ�� ��ȣ
	private String code; 		// ���� �μ��ڵ�
	private int days; 			// ȯ�� �Կ� �ϼ�
	private int age; 			// ȯ�� ����
	private String dname;		// ���� �μ� �̸�
	private int checkup_fee;	// ȯ�� ������
	private int hospital_fee;	// ȯ�� �Կ���
	private int sum;			// ȯ�� �����
	
	public PatientVO() {} // �⺻ ������

	public PatientVO(int bunho, String code, int days, int age) {
		this.bunho = bunho;
		this.code = code;
		this.days = days;
		this.age = age;
	}

	public int getBunho() {
		return bunho;
	}

	public void setBunho(int bunho) {
		this.bunho = bunho;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getCheckup_fee() {
		return checkup_fee;
	}

	public void setCheckup_fee(int checkup_fee) {
		this.checkup_fee = checkup_fee;
	}

	public int getHospital_fee() {
		return hospital_fee;
	}

	public void setHospital_fee(int hospital_fee) {
		this.hospital_fee = hospital_fee;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return String.format("%d\t\t%s\t\t%d\t\t%d\t\t%d\n", bunho, dname,
				checkup_fee, hospital_fee, sum);
	}
	
	
	
}
