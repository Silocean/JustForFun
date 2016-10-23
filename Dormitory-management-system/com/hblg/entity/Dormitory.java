package com.hblg.entity;
/*
 * dormId char(10) primary key,			--���Һ�
	dormSex char(2) not null,			--�����Ա�
	dormHouId int not null,				--����¥��
	dormNum int not null,				--Ӧס����
	dormFact int not null,				--ʵס����
	dormPrice money,					--ס�޷���
	dormTel varchar(30),				--�绰����
	dormRemark nvarchar(100)			--��ע
 */
public class Dormitory {
	private String dormId;						//���Һ�
	private String dormSex;						//�����Ա�
	private int dormHouId;						//����¥��
	private int dormNum;						//Ӧס����
	private int dormFact;						//ʵס����
	private double dormPrice;					//ס�޷���
	private String dormTel;						//�绰����
	private String dormRemark;					//��ע
	public Dormitory(String dormId, String dormSex, int dormHouId, int dormNum, int dormFact, double dormPrice, String dormTel, String dormRemark) {
		this.dormId = dormId;
		this.dormSex = dormSex;
		this.dormHouId = dormHouId;
		this.dormNum = dormNum;
		this.dormFact = dormFact;
		this.dormPrice = dormPrice;
		this.dormTel = dormTel;
		this.dormRemark = dormRemark;
	}
	public Dormitory() {
		// TODO Auto-generated constructor stub
	}
	public int getDormFact() {
		return dormFact;
	}
	public void setDormFact(int dormFact) {
		this.dormFact = dormFact;
	}
	public int getDormHouId() {
		return dormHouId;
	}
	public void setDormHouId(int dormHouId) {
		this.dormHouId = dormHouId;
	}
	public String getDormId() {
		return dormId;
	}
	public void setDormId(String dormId) {
		this.dormId = dormId;
	}
	public int getDormNum() {
		return dormNum;
	}
	public void setDormNum(int dormNum) {
		this.dormNum = dormNum;
	}
	public double getDormPrice() {
		return dormPrice;
	}
	public void setDormPrice(double dormPrice) {
		this.dormPrice = dormPrice;
	}
	public String getDormRemark() {
		return dormRemark;
	}
	public void setDormRemark(String dormRemark) {
		this.dormRemark = dormRemark;
	}
	public String getDormSex() {
		return dormSex;
	}
	public void setDormSex(String dormSex) {
		this.dormSex = dormSex;
	}
	public String getDormTel() {
		return dormTel;
	}
	public void setDormTel(String dormTel) {
		this.dormTel = dormTel;
	}
	@Override
	public String toString() {
		return "Dormitory [dormId=" + dormId + ", dormSex=" + dormSex
				+ ", dormHouId=" + dormHouId + ", dormNum=" + dormNum
				+ ", dormFact=" + dormFact + ", dormPrice=" + dormPrice
				+ ", dormTel=" + dormTel + ", dormRemark=" + dormRemark + "]";
	}
	
}
