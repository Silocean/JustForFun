/*�����û���(user)*/
create table LoginIn (
	userName nvarchar(50) primary key,	--�û�����
	userPwd varchar(50),				--�û�����
	userPower int						--�û�Ȩ��
);

insert into LoginIn values('�޹�', '123456', 0);
insert into LoginIn values('˾�Ʒ�', '123456', 1);

select * from LoginIn;

/*����¥����(hou)*/
create table hou (
	houId int primary key,				--¥�����
	houNum int,							--��������
	houFlr int,							--¥������
	houPeo int							--Ӧס����
);

select * from hou;
insert into hou values(9, 155, 7, 1080);
insert into hou values(10, 134, 7, 990);
select houId from hou;
select * from hou where houId = 1;
select MAX(houId) from hou;

/*�������ұ�(dormitory)*/
create table dormitory (
	dormId char(10) primary key,		--���Һ�
	dormSex char(2) not null,			--�����Ա�
	dormHouId int not null,				--����¥��
	dormNum int not null,				--Ӧס����
	dormFact int,						--ʵס����
	dormPrice money,					--ס�޷���
	dormTel varchar(30),				--�绰����
	dormRemark nvarchar(100)			--��ע
	foreign key(dormHouId) references hou(houId)
);

-- drop table dormitory
select dormId from dormitory;
select * from Dormitory where dormId = '5410';
select dormId, dormSex, dormHouId, dormNum, dormPrice, dormTel, dormRemark from Dormitory where dormId = '5422';
select * from dormitory;
select dormId from Dormitory where dormHouId = 5;

-- delete from dormitory where dormId = 2214

insert into dormitory (dormId, dormSex, dormHouId, dormNum, dormPrice, dormTel, dormRemark)
 values ('5422', '��', 5, 4, 1200.00, '0714-2567', 'ԭ����Ϊ5712');


/*����ѧ����(student)*/
create table student(
	stuId char(30) primary key,			--ѧ��
	stuName nvarchar(50) not null,		--����
	stuDormId char(10),					--���Һ�
	stuSex char(2) not null,			--�Ա�
	stuInDate Date not null,			--��ѧ����
	stuBirDate Date not null,			--��������
	stuCollege nvarchar(50) not null,	--����ѧԺ
	stuClass nvarchar(50) not null,		--�����༶
	stuPolit nvarchar(20),				--������ò
	stuTel varchar(30),					--��ϵ�绰
	stuAddress nvarchar(50),			--��ͥסַ
	stuRemark nvarchar(100),			--��ע
	foreign key(stuDormID) references dormitory(dormId)
);
insert into student values('201140420101', '˾�Ʒ�', '5422', '��', '2013-6-1', '1992-8-22', '�����ѧԺ', '11�����繤��', '������Ա', '18271633177', '�ӱ�ʡ������������', '��');
insert into student values('201140420105', '·��', '5420', '��', '2013-6-1', '1992-8-22', '�����ѧԺ', '11�����繤��', '������Ա', '18271633177', '�ӱ�ʡ������������', '��');

select * from student;
select COUNT(*) from student where stuDormId = '5422';
select * from student where stuId = '201140420101';
select * from student where stuDormId = '5422';
update student set stuId = '201140420101', 
stuName = 'siyunfei', stuDormId = '5422',
stuSex = '��', stuInDate = '2013-6-1', stuBirDate = '1992-8-22',
stuCollege = '�����ѧԺ', stuClass = '11�����繤��',
stuPolit = '������Ա', stuTel = '18271633177', stuAddress = '�ӱ�ʡ������',
stuRemark = 'HelloWorld!'
where stuId = '201140420101';
-- drop table student

select COUNT(*) from student where stuDormId in (select dormId from Dormitory where dormHouId = 5); --��ѯ5��һ��ס�˶���ѧ��

select COUNT(*) from student where stuDormId in (select dormId from dormitory);

select dormId, COUNT(stuId) from dormitory, student group by dormId;


/* ����Ա����(employee)*/
create table employee (
	empId char(10) primary key,			--��Ա���
	empName nvarchar(50) not null,		--��Ա����
	empAge int not null,				--��Ա����
	empSex char(2) not null,			--��Ա�Ա�
	empHouId int not null,				--��Ա����¥��
	empJob nvarchar(20),				--��Աְλ
	empAddress nvarchar(50),			--��ͥסַ
	empTel varchar(30),					--��ϵ�绰
	empRemark nvarchar(100)				--��ע
	foreign key(empHouId) references hou(houId)
);

insert into employee values('005', '������', 35, 'Ů', 5, '����Ա', '����ʡ��ʯ����½��١�҉G', '15639857458', '��');
insert into employee values('006', '������', 35, 'Ů', 5, '����Ա', '����ʡ��ʯ����½��١�҉G', '15639857458', '��');
insert into employee values('007', '������', 35, 'Ů', 5, '����Ա', '����ʡ��ʯ����½��١�҉G', '15639857458', '��');
insert into employee values('008', '������', 35, 'Ů', 5, '����Ա', '����ʡ��ʯ����½��١�҉G', '15639857458', '��');
insert into employee values('009', '������', 35, 'Ů', 5, '����Ա', '����ʡ��ʯ����½��١�҉G', '15639857458', '��');
insert into employee values('010', '������', 35, 'Ů', 5, '����Ա', '����ʡ��ʯ����½��١�҉G', '15639857458', '��');
select * from employee;
select * from employee where empId = '001';



/*������Ա���ñ�(visit)*/
create table visit (
	autoId int primary key,
	visName nvarchar(50) not null,		--������Ա����
	visHost nvarchar(50),				--������Ա����
	visDormId char(10),					--��������
	visInTime varchar(50),				--����ʱ��,Ӧ��ΪDatetime���ͣ������и���
	visLevTime varchar(50),				--�뿪ʱ��,Ӧ��ΪDatetime���ͣ������и���
	visWatchId char(10),				--ֵ����
	visCred varchar(50),				--���֤��
	visRemark nvarchar(50),				--��ע
	foreign key(visDormId) references dormitory(dormId),
	foreign key(visWatchId) references employee(empId)
);
-- drop table visit
insert into visit values(1,'xiaobai', 'xiaoli', '5422', '2011-9-1', '2011-9-1', '001', '1325546464', 'buzhidao');
insert into visit values(2,'xiaobai', 'xiaoli', '5422', '2011-9-1', '2011-9-1', '001', '1325546464', 'buzhidao');
insert into visit values(3,'xiaobai', 'xiaoli', '5422', '2011-9-1', '2011-9-1', '001', '1325546464', 'buzhidao');

select * from visit;
select * from visit where visInTime like '%2011-9-1%' or visLevTIme like '%2011-9-1%';
-- delete from visit

-- ALTER TABLE visit
-- alter COLUMN visInTime Datetime
-- go

/*������Ʒ����¥��(goodsMove)*/
create table goodsMove (
	godsStuId char(30) not null,	--��Ʒ����ѧ��ѧ��
	godsId char(20) primary key,	--��Ʒ���
	godsInTime varchar(50),			--��Ʒ��¥ʱ��
	godsLevTime varchar(50),		--��Ʒ��¥ʱ��
	godsWatchId char(10),			--ֵ����
	godsRemark nvarchar(50)			--��ע
	foreign key(godsWatchId) references employee(empId)
);
insert into goodsMove values('201140420101', '2013060101', '2013-6-1 09:12:12', '2013-6-2 09:56:12', '001', '���˳����Գ�����͵�����ɣ�');
insert into goodsMove values('201140420101', '2013060202', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '���˳����Գ�����͵�����ɣ�');
insert into goodsMove values('201140420101', '2013060203', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '���˳����Գ�����͵�����ɣ�');
insert into goodsMove values('201140420101', '2013060204', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '���˳����Գ�����͵�����ɣ�');
insert into goodsMove values('201140420101', '2013060205', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '���˳����Գ�����͵�����ɣ�');

select * from goodsMove;
select godsId from goodsMove;
-- delete from goodsMove
select * from goodsMove where godsInTime like '%2013-6-1%' or godsLevTime like '%2013-6-1%';
-- drop table goodsMove