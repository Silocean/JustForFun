package com.hblg.entity;


/*
 * stuId char(30) primary key,			--学号
	stuName nvarchar(50) not null,		--姓名
	stuDormId char(10),					--寝室号
	stuSex char(2) not null,			--性别
	stuInDate Date not null,			--入学日期
	stuBirDate Date not null,			--出生日期
	stuCollege nvarchar(50) not null,	--所属学院
	stuMajor nvarchar(50) not null,		--所学专业
	stuPolit nvarchar(20),				--政治面貌
	stuAddress nvarchar(50),			--家庭住址	
	stuTel varchar(30),					--联系电话
	stuRemark nvarchar(100),			--备注
	foreign key(stuDormID) references dormitory(dormId)
 */
public class Student {
	private String stuId;						//学号
	private String stuName;						//姓名
	private String stuDormId;					//寝室号
	private String stuSex;						//性别
	private String stuInDate;					//入学日期
	private String stuBirDate;					//出生日期
	private String stuCollege;					//所属学院
	private String stuClass;					//所属班级
	private String stuPolit;					//政治面貌
	private String stuAddress;					//家庭住址
	private String stuTel;						//联系电话
	private String stuRemark;					//备注
	
	
	
	public Student(String stuId, String stuName, String stuDormId,
			String stuSex, String stuInDate, String stuBirDate,
			String stuCollege, String stuClass, String stuPolit,
			String stuAddress, String stuTel, String stuRemark) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuDormId = stuDormId;
		this.stuSex = stuSex;
		this.stuInDate = stuInDate;
		this.stuBirDate = stuBirDate;
		this.stuCollege = stuCollege;
		this.stuClass = stuClass;
		this.stuPolit = stuPolit;
		this.stuAddress = stuAddress;
		this.stuTel = stuTel;
		this.stuRemark = stuRemark;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuDormId() {
		return stuDormId;
	}
	public void setStuDormId(String stuDormId) {
		this.stuDormId = stuDormId;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuInDate() {
		return stuInDate;
	}
	public void setStuInDate(String stuInDate) {
		this.stuInDate = stuInDate;
	}
	public String getStuBirDate() {
		return stuBirDate;
	}
	public void setStuBirDate(String stuBirDate) {
		this.stuBirDate = stuBirDate;
	}
	public String getStuCollege() {
		return stuCollege;
	}
	public void setStuCollege(String stuCollege) {
		this.stuCollege = stuCollege;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getStuPolit() {
		return stuPolit;
	}
	public void setStuPolit(String stuPolit) {
		this.stuPolit = stuPolit;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuTel() {
		return stuTel;
	}
	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}
	public String getStuRemark() {
		return stuRemark;
	}
	public void setStuRemark(String stuRemark) {
		this.stuRemark = stuRemark;
	}
	
}
