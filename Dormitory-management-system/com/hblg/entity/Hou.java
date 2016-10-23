package com.hblg.entity;
/*
 * houId int primary key,				--楼房编号
	houNum int,							--房间数量
	houFlr int,							--楼层数量
	houPeo int							--应住人数
 */
public class Hou {
	private int houId;					//楼房编号
	private int houNum;					//房间数量
	private int houFlr;					//楼层数量
	private int houPeo;					//应住人数
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
