/*创建用户表(user)*/
create table LoginIn (
	userName nvarchar(50) primary key,	--用户姓名
	userPwd varchar(50),				--用户密码
	userPower int						--用户权限
);

insert into LoginIn values('宿管', '123456', 0);
insert into LoginIn values('小李', '123456', 1);

select * from LoginIn;

/*创建楼房表(hou)*/
create table hou (
	houId int primary key,				--楼房编号
	houNum int,							--房间数量
	houFlr int,							--楼层数量
	houPeo int							--应住人数
);

select * from hou;
insert into hou values(9, 155, 7, 1080);
insert into hou values(10, 134, 7, 990);
select houId from hou;
select * from hou where houId = 1;
select MAX(houId) from hou;

/*创建寝室表(dormitory)*/
create table dormitory (
	dormId char(10) primary key,		--寝室号
	dormSex char(2) not null,			--寝室性别
	dormHouId int not null,				--所属楼栋
	dormNum int not null,				--应住人数
	dormFact int,						--实住人数
	dormPrice money,					--住宿费用
	dormTel varchar(30),				--电话号码
	dormRemark nvarchar(100)			--备注
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
 values ('5422', '男', 5, 4, 1200.00, '0714-2567', '原寝室为5712');


/*创建学生表(student)*/
create table student(
	stuId char(30) primary key,			--学号
	stuName nvarchar(50) not null,		--姓名
	stuDormId char(10),					--寝室号
	stuSex char(2) not null,			--性别
	stuInDate Date not null,			--入学日期
	stuBirDate Date not null,			--出生日期
	stuCollege nvarchar(50) not null,	--所属学院
	stuClass nvarchar(50) not null,		--所属班级
	stuPolit nvarchar(20),				--政治面貌
	stuTel varchar(30),					--联系电话
	stuAddress nvarchar(50),			--家庭住址
	stuRemark nvarchar(100),			--备注
	foreign key(stuDormID) references dormitory(dormId)
);
insert into student values('201150600101', '小庄', '5422', '男', '2013-6-1', '1993-9-12', '计算机学院', '11级计算机应用', '共青团员', '13456732134', '河北省保定市涞水市', '无');
insert into student values('201150600105', '小明', '5420', '男', '2013-6-1', '1992-8-22', '计算机学院', '11级计算机应用', '共青团员', '13456732134', '河北省保定市定州市', '无');

select * from student;
select COUNT(*) from student where stuDormId = '5422';
select * from student where stuId = '201150600101';
select * from student where stuDormId = '5422';
update student set stuId = '201150600101', 
stuName = 'xiaoli', stuDormId = '5422',
stuSex = '男', stuInDate = '2013-6-1', stuBirDate = '1993-9-12',
stuCollege = '计算机学院', stuClass = '11级计算机应用',
stuPolit = '共青团员', stuTel = '13456732134', stuAddress = '河北省定州市',
stuRemark = 'HelloWorld!'
where stuId = '201150600101';
-- drop table student

select COUNT(*) from student where stuDormId in (select dormId from Dormitory where dormHouId = 5); --查询5栋一共住了多少学生

select COUNT(*) from student where stuDormId in (select dormId from dormitory);

select dormId, COUNT(stuId) from dormitory, student group by dormId;


/* 创建员工表(employee)*/
create table employee (
	empId char(10) primary key,			--雇员编号
	empName nvarchar(50) not null,		--雇员姓名
	empAge int not null,				--雇员年龄
	empSex char(2) not null,			--雇员性别
	empHouId int not null,				--雇员所属楼栋
	empJob nvarchar(20),				--雇员职位
	empAddress nvarchar(50),			--家庭住址
	empTel varchar(30),					--联系电话
	empRemark nvarchar(100)				--备注
	foreign key(empHouId) references hou(houId)
);

insert into employee values('005', '王大妈', 35, '女', 5, '管理员', '湖北省黄石市下陆区佟家塆', '15639857458', '无');
insert into employee values('006', '王大妈', 35, '女', 5, '管理员', '湖北省黄石市下陆区佟家塆', '15639857458', '无');
insert into employee values('007', '王大妈', 35, '女', 5, '管理员', '湖北省黄石市下陆区佟家塆', '15639857458', '无');
insert into employee values('008', '王大妈', 35, '女', 5, '管理员', '湖北省黄石市下陆区佟家塆', '15639857458', '无');
insert into employee values('009', '王大妈', 35, '女', 5, '管理员', '湖北省黄石市下陆区佟家塆', '15639857458', '无');
insert into employee values('010', '王大妈', 35, '女', 5, '管理员', '湖北省黄石市下陆区佟家塆', '15639857458', '无');
select * from employee;
select * from employee where empId = '001';



/*创建人员来访表(visit)*/
create table visit (
	autoId int primary key,
	visName nvarchar(50) not null,		--来访人员姓名
	visHost nvarchar(50),				--被访人员姓名
	visDormId char(10),					--访问寝室
	visInTime varchar(50),				--来访时间,应该为Datetime类型，后面有改正
	visLevTime varchar(50),				--离开时间,应该为Datetime类型，后面有改正
	visWatchId char(10),				--值班人
	visCred varchar(50),				--身份证号
	visRemark nvarchar(50),				--备注
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

/*创建物品出入楼表(goodsMove)*/
create table goodsMove (
	godsStuId char(30) not null,	--物品所属学生学号
	godsId char(20) primary key,	--物品编号
	godsInTime varchar(50),			--物品进楼时间
	godsLevTime varchar(50),		--物品出楼时间
	godsWatchId char(10),			--值班人
	godsRemark nvarchar(50)			--备注
	foreign key(godsWatchId) references employee(empId)
);
insert into goodsMove values('201150600101', '2013060101', '2013-6-1 09:12:12', '2013-6-2 09:56:12', '001', '此人长得略抽象，有偷盗嫌疑！');
insert into goodsMove values('201150600101', '2013060202', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '此人长得略抽象，有偷盗嫌疑！');
insert into goodsMove values('201150600101', '2013060203', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '此人长得略抽象，有偷盗嫌疑！');
insert into goodsMove values('201150600101', '2013060204', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '此人长得略抽象，有偷盗嫌疑！');
insert into goodsMove values('201150600101', '2013060205', '2013-6-2 09:12:12', '2013-6-2 09:56:12', '001', '此人长得略抽象，有偷盗嫌疑！');

select * from goodsMove;
select godsId from goodsMove;
-- delete from goodsMove
select * from goodsMove where godsInTime like '%2013-6-1%' or godsLevTime like '%2013-6-1%';
-- drop table goodsMove
