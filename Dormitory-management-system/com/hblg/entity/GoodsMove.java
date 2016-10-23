package com.hblg.entity;


/*
 * godsStuId char(30) not null,		--物品所属学生学号
	godsId char(20) primary key,	--物品编号
	godsInTime varchar(50),				--物品进楼时间
	godsLevTime varchar(50),				--物品出楼时间
	godsWatchId char(10),			--值班人
	godsRemark nvarchar(50)			--备注
	foreign key(godsWatchId) references employee(empId)
 */
public class GoodsMove {
	private String godsStuId;				//物品所属学生学号
	private String godsId;					//物品编号
	private String godsInTime;				//物品进楼时间
	private String godsLevTime;				//物品出楼时间	
	private String godsWatchId;				//值班人ID
	private String godsRemark;				//备注
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
