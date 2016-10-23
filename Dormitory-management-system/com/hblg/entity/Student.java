package com.hblg.entity;


/*
 * stuId char(30) primary key,			--ѧ��
	stuName nvarchar(50) not null,		--����
	stuDormId char(10),					--���Һ�
	stuSex char(2) not null,			--�Ա�
	stuInDate Date not null,			--��ѧ����
	stuBirDate Date not null,			--��������
	stuCollege nvarchar(50) not null,	--����ѧԺ
	stuMajor nvarchar(50) not null,		--��ѧרҵ
	stuPolit nvarchar(20),				--������ò
	stuAddress nvarchar(50),			--��ͥסַ	
	stuTel varchar(30),					--��ϵ�绰
	stuRemark nvarchar(100),			--��ע
	foreign key(stuDormID) references dormitory(dormId)
 */
public class Student {
	private String stuId;						//ѧ��
	private String stuName;						//����
	private String stuDormId;					//���Һ�
	private String stuSex;						//�Ա�
	private String stuInDate;					//��ѧ����
	private String stuBirDate;					//��������
	private String stuCollege;					//����ѧԺ
	private String stuClass;					//�����༶
	private String stuPolit;					//������ò
	private String stuAddress;					//��ͥסַ
	private String stuTel;						//��ϵ�绰
	private String stuRemark;					//��ע
	
	
	
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
