package com.hblg.entity;
/*
 * empId char(10) primary key,			--��Ա���
	empName nvarchar(50) not null,		--��Ա����
	empAge int not null,				--��Ա����
	empSex char(2) not null,			--��Ա�Ա�
	empHouId int not null,				--��Ա����¥��
	empJob nvarchar(20),				--��Աְλ
	empAddress nvarchar(50),			--��ͥסַ
	empTel varchar(30),					--��ϵ�绰
	empRemark nvarchar(100)				--��ע
	foreign key(empHouId) references hou(houId)
 */
public class Employee {
	private String empId;						//��Ա���
	private String empName;						//��Ա����
	private int empAge;							//��Ա����
	private String empSex;						//��Ա�Ա�
	private int empHouId;						//��Ա����¥��
	private String empJob;						//��Աְλ	
	private String empAddress;					//��ͥסַ
	private String empTel;						//��ϵ�绰
	private String empRemark;					//��ע
	public Employee(String empId, String empName, int empAge, String empSex, int empHouId, String empJob, String empAddress, String empTel, String empRemark) {
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSex = empSex;
		this.empHouId = empHouId;
		this.empJob = empJob;
		this.empAddress = empAddress;
		this.empTel = empTel;
		this.empRemark = empRemark;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public int getEmpHouId() {
		return empHouId;
	}
	public void setEmpHouId(int empHouId) {
		this.empHouId = empHouId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpRemark() {
		return empRemark;
	}
	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getEmpTel() {
		return empTel;
	}
	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}
	
}
