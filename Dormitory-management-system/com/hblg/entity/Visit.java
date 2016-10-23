package com.hblg.entity;


/*
 * autoId int primary key,
 * visName nvarchar(50) not null,		--������Ա����
	visHost nvarchar(50),				--������Ա����
	visDormId char(10),					--�������Һ�
	visInTime time,						--����ʱ��
	visLevTime time,					--�뿪ʱ��
	visWatchId char(10),				--ֵ����
	visCred varchar(50),				--���֤��
	visRemark nvarchar(50),				--��ע
	foreign key(visDormId) references dormitory(dormId),
	foreign key(visWatchId) references employee(empId)
 */
public class Visit {
	private int autoId;									//�Զ����
	private String visName;						//����������
	private String visHost;						//����������
	private String visDormId;					//�������Һ�
	private String visInTime;						//����ʱ��
	private String visLevTime;					//�뿪ʱ��
	private String visWatchId;					//ֵ����ID
	private String visCred;						//���֤��
	private String visRemark;					//��ע
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
