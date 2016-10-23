package com.hblg.entity;
/*
 * empId char(10) primary key,			--雇员编号
	empName nvarchar(50) not null,		--雇员姓名
	empAge int not null,				--雇员年龄
	empSex char(2) not null,			--雇员性别
	empHouId int not null,				--雇员所属楼栋
	empJob nvarchar(20),				--雇员职位
	empAddress nvarchar(50),			--家庭住址
	empTel varchar(30),					--联系电话
	empRemark nvarchar(100)				--备注
	foreign key(empHouId) references hou(houId)
 */
public class Employee {
	private String empId;						//雇员编号
	private String empName;						//雇员姓名
	private int empAge;							//雇员年龄
	private String empSex;						//雇员性别
	private int empHouId;						//雇员所属楼栋
	private String empJob;						//雇员职位	
	private String empAddress;					//家庭住址
	private String empTel;						//联系电话
	private String empRemark;					//备注
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
