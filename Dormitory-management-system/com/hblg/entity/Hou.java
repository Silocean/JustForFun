package com.hblg.entity;
/*
 * houId int primary key,				--¥�����
	houNum int,							--��������
	houFlr int,							--¥������
	houPeo int							--Ӧס����
 */
public class Hou {
	private int houId;					//¥�����
	private int houNum;					//��������
	private int houFlr;					//¥������
	private int houPeo;					//Ӧס����
	private int houFact;
	public Hou(int houId, int houNum, int houFlr, int houPeo, int houFact) {
		this.houId = houId;
		this.houNum = houNum;
		this.houFlr = houFlr;
		this.houPeo = houPeo;
		this.houFact = houFact;
	}
	public Hou() {
		// TODO Auto-generated constructor stub
	}
	public int getHouFlr() {
		return houFlr;
	}
	public void setHouFlr(int houFlr) {
		this.houFlr = houFlr;
	}
	public int getHouId() {
		return houId;
	}
	public void setHouId(int houId) {
		this.houId = houId;
	}
	public int getHouNum() {
		return houNum;
	}
	public void setHouNum(int houNum) {
		this.houNum = houNum;
	}
	public int getHouPeo() {
		return houPeo;
	}
	public void setHouPeo(int houPeo) {
		this.houPeo = houPeo;
	}
	public int getHouFact() {
		return houFact;
	}
	public void setHouFact(int houFact) {
		this.houFact = houFact;
	}
	
}
