package com.hblg.entity;


/*
 * autoId int primary key,
 * visName nvarchar(50) not null,		--来访人员姓名
	visHost nvarchar(50),				--被访人员姓名
	visDormId char(10),					--访问寝室号
	visInTime time,						--来访时间
	visLevTime time,					--离开时间
	visWatchId char(10),				--值班人
	visCred varchar(50),				--身份证号
	visRemark nvarchar(50),				--备注
	foreign key(visDormId) references dormitory(dormId),
	foreign key(visWatchId) references employee(empId)
 */
public class Visit {
	private int autoId;									//自动编号
	private String visName;						//来访人姓名
	private String visHost;						//被访人姓名
	private String visDormId;					//访问寝室号
	private String visInTime;						//来访时间
	private String visLevTime;					//离开时间
	private String visWatchId;					//值班人ID
	private String visCred;						//身份证号
	private String visRemark;					//备注
	public Visit(int autoId, String visName, String visHost, String visDormId, String visInTime, String visLevTime, String visWatchId, String visCred, String visRemark) {
		this.autoId = autoId;
		this.visName = visName;
		this.visHost = visHost;
		this.visDormId = visDormId;
		this.visInTime = visInTime;
		this.visLevTime = visLevTime;
		this.visWatchId = visWatchId;
		this.visCred = visCred;
		this.visRemark = visRemark;
	}
	public Visit() {
		// TODO Auto-generated constructor stub
	}
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	public String getVisCred() {
		return visCred;
	}
	public void setVisCred(String visCred) {
		this.visCred = visCred;
	}
	public String getVisDormId() {
		return visDormId;
	}
	public void setVisDormId(String visDormId) {
		this.visDormId = visDormId;
	}
	public String getVisHost() {
		return visHost;
	}
	public void setVisHost(String visHost) {
		this.visHost = visHost;
	}
	public String getVisInTime() {
		return visInTime;
	}
	public void setVisInTime(String visInTime) {
		this.visInTime = visInTime;
	}
	public String getVisLevTime() {
		return visLevTime;
	}
	public void setVisLevTime(String visLevTime) {
		this.visLevTime = visLevTime;
	}
	public String getVisName() {
		return visName;
	}
	public void setVisName(String visName) {
		this.visName = visName;
	}
	public String getVisRemark() {
		return visRemark;
	}
	public void setVisRemark(String visRemark) {
		this.visRemark = visRemark;
	}
	public String getVisWatchId() {
		return visWatchId;
	}
	public void setVisWatchId(String visWatchId) {
		this.visWatchId = visWatchId;
	}
	
}
