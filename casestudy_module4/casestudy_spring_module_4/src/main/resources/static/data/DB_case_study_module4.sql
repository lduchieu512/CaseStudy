-- drop database case_study_module4;
-- create database if not exists case_study_module4;
-- use case_study_module4;

-- Add data for position
insert into `position` (position_name)
values ('Lễ tân'), ('Phục vụ'), ('Chuyên viên'), ('Giám sát'), ('Quản lý'), ('Giám đốc');
select * from `position`;

-- Add data for education degree
insert into education_degree (education_degree_name) 
values ("Trung cấp"), ("Cao đẳng"), ("Đại học"), ("Sau đại học");
select * from education_degree;

-- Add data for division
insert into division (division_name) 
values ("Sale–Marketing"), ("Hành chính"), ("Phục vụ"), ("Quản lý");
select * from division;

-- Add data for role
insert into `role` (role_name)
values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');
select * from `role`;

-- Add data for user
insert into `user` (username, `password`)
values ('admin1', '123'), ('admin2', '123'), ('admin3', '123'), ('admin4', '123'), ('admin5', '123');
select * from `user`;

-- Add data for user_role
insert into  `user_role`(role_id, username)
values (1, 'admin1'), (2, 'admin2'), (3, 'admin3'), (4, 'admin4'), (5, 'admin5');
select * from `user_role`;

-- Add data for employee
insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, 
					  position_id, education_degree_id, division_id, username)
values ('Nguyễn Văn An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng',	1, 3, 1, 'admin1'),
       ('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2, 'admin2'),
       ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2, 'admin3'),
       ('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4, 'admin4'),
       ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1, 'admin5'),
       ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3, 'admin1'),
       ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2, 'admin2'),
       ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4, 'admin3'),
       ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4, 'admin4'),
       ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2, 'admin5');
select * from employee;
select * from employee where employee_name like "Nguyễn Văn An" and employee_email like "annguyen@gmail.com" and division_id like "1";

-- Add data for customer_type
insert into customer_type (customer_type_name) 
values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');
select * from customer_type;

-- Add data for customer
insert into customer(customer_id ,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
values  ("1",5,"Nguyễn Thị Hào",'1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng'),
		("2",3,'Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị'),
		("3",1,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh'),
		("4",1,'Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng'),
		("5",4,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai'),
		("6",4,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng'),
		("7",1,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh'),
		("8",3,'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum'),
		("9",1,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi'),
		("10",2,'Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng');
select * from customer;
select * from customer where customer_name like "Nguyễn Thị Hào" and customer_email like "thihao07@gmail.com" and customer_type_id like 5;

-- Add data for rent_type
insert into rent_type (rent_type_name, rent_type_cost) 
values ('Year', 250000000),('Month', 25000000),('Day', 2500000),('Hour', 250000);
select * from rent_type;

-- Add data for service_type
insert into service_type (service_type_name) 
values ('Villa'), ('House'), ('Room');
select * from service_type;

-- Add data for service
insert into service (service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, 
					 standard_room, description_other_convenience, pool_area,number_of_floors)
values  ("1",'Villa Beach Front',25000,10000000,10,3,1,'vip','Có hồ bơi',500,4),
		("2",'House Princess 01',14000,5000000,7,2,2,'vip','Có thêm bếp nướng',1,3),
		("3",'Room Twin 01',5000,1000000,2,4,3,'normal','Có tivi',1,2),
		("4",'Villa No Beach Front',22000,9000000,8,3,1,'normal','Có hồ bơi',300,3),
		("5",'House Princess 02',10000,4000000,5,3,2,'normal','Có thêm bếp nướng',1,2),
		("6",'Room Twin 02',3000,900000,2,4,3,'normal','Có tivi',1,2);
select * from service;

-- Add data for contract
insert into contract (contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id)
values ("2020-12-08","2020-12-08",0,500000,3,1,3),
	   ("2020-07-14","2020-07-21",200000,1000000,7,3,1),
	   ("2021-03-15","2021-03-17",50000,700000,3,4,2),
       ("2021-01-14","2021-01-18",100000,5000000,7,5,5),
	   ("2021-07-14","2021-07-15",0,500000,7,2,6),
	   ("2021-06-01","2021-06-03",0,500000,7,7,6),
	   ("2021-09-02","2021-09-05",100000,2000000,7,4,4),
	   ("2021-06-17","2021-06-18",150000,10000000,3,4,1),
	   ("2020-11-19","2020-11-19",0,500000,3,4,3),
	   ("2021-04-12","2021-04-14",0,500000,10,3,5),
	   ("2021-04-25","2021-04-25",0,500000,2,2,1),
	   ("2021-05-25","2021-05-27",0,600000,7,10,1);
select * from contract;

-- Add data for attach_service
insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values ('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
       ('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
       ('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
       ('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
select * from attach_service;
       
-- Add data for contract_detail
insert into contract_detail (contract_id, attach_service_id, quantity)
values (2, 4, 5), (2, 5, 8), (2, 6, 15), (3, 1, 1), (3, 2, 11), (1, 3, 1), (1, 2, 2), (12, 2, 2);
select * from contract_detail;

