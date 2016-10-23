package com.hblg.entity;
/*
 * dormId char(10) primary key,			--寝室号
	dormSex char(2) not null,			--寝室性别
	dormHouId int not null,				--所属楼栋
	dormNum int not null,				--应住人数
	dormFact int not null,				--实住人数
	dormPrice money,					--住宿费用
	dormTel varchar(30),				--电话号码
	dormRemark nvarchar(100)			--备注
 */
public class Dormitory {
	private String dormId;						//寝室号
	private String dormSex;						//寝室性别
	private int dormHouId;						//所属楼栋
	private int dormNum;						//应住人数
	private int dormFact;						//实住人数
	private double dormPrice;					//住宿费用
	private String dormTel;						//电话号码
	private String dormRemark;					//备注
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
