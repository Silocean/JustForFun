package com.hblg.entity;


/*
 * godsStuId char(30) not null,		--��Ʒ����ѧ��ѧ��
	godsId char(20) primary key,	--��Ʒ���
	godsInTime varchar(50),				--��Ʒ��¥ʱ��
	godsLevTime varchar(50),				--��Ʒ��¥ʱ��
	godsWatchId char(10),			--ֵ����
	godsRemark nvarchar(50)			--��ע
	foreign key(godsWatchId) references employee(empId)
 */
public class GoodsMove {
	private String godsStuId;				//��Ʒ����ѧ��ѧ��
	private String godsId;					//��Ʒ���
	private String godsInTime;				//��Ʒ��¥ʱ��
	private String godsLevTime;				//��Ʒ��¥ʱ��	
	private String godsWatchId;				//ֵ����ID
	private String godsRemark;				//��ע
	public GoodsMove(String godsStuId, String godsId, String godsInTime, String godsLevTime, String godsWatchId, String godsRemark) {
		this.godsStuId = godsStuId;
		this.godsId = godsId;
		this.godsInTime = godsInTime;
		this.godsLevTime = godsLevTime;
		this.godsWatchId = godsWatchId;
		this.godsRemark = godsRemark;
	}
	public GoodsMove() {
		// TODO Auto-generated constructor stub
	}
	public String getGodsId() {
		return godsId;
	}
	public void setGodsId(String godsId) {
		this.godsId = godsId;
	}
	public String getGodsInTime() {
		return godsInTime;
	}
	public void setGodsInTime(String godsInTime) {
		this.godsInTime = godsInTime;
	}
	public String getGodsLevTime() {
		return godsLevTime;
	}
	public void setGodsLevTime(String godsLevTime) {
		this.godsLevTime = godsLevTime;
	}
	public String getGodsRemark() {
		return godsRemark;
	}
	public void setGodsRemark(String godsRemark) {
		this.godsRemark = godsRemark;
	}
	public String getGodsStuId() {
		return godsStuId;
	}
	public void setGodsStuId(String godsStuId) {
		this.godsStuId = godsStuId;
	}
	public String getGodsWatchId() {
		return godsWatchId;
	}
	public void setGodsWatchId(String godsWatchId) {
		this.godsWatchId = godsWatchId;
	}
	
}
