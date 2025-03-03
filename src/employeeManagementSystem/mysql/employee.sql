use ssgdb;
drop table employee;
create table employee
(
    eno        VARCHAR(10) PRIMARY KEY,
    name       VARCHAR(20)    NOT NULL,
    enteryear  INT            NOT NULL,
    entermonth INT            NOT NULL,
    enterday   INT            NOT NULL,
    role       VARCHAR(20)    NOT NULL,
    secno      VARCHAR(10),
    salary     DECIMAL(10, 2) NOT NULL
);

INSERT INTO Employee (eno, name, enteryear, entermonth, enterday, role, secno, salary) VALUES
('s001', 'Staff One', 2020, 1, 15, 'Staff', null, 35000.00),
('s002', 'Staff Two', 2020, 2, 20, 'Staff', null, 36000.00),
('s003', 'Staff Three', 2021, 3, 10, 'Staff', null, 37000.00),
('s004', 'Staff Four', 2021, 4, 25, 'Staff', null, 38000.00),
('s005', 'Staff Five', 2022, 5, 30, 'Staff', null, 39000.00),
('m001', 'Manager One', 2019, 6, 5, 'Manager', 'sec001', 50000.00),
('m002', 'Manager Two', 2019, 7, 15, 'Manager', 'sec002', 51000.00),
('m003', 'Manager Three', 2020, 8, 20, 'Manager', 'sec003', 52000.00),
('m004', 'Manager Four', 2020, 9, 10, 'Manager', 'sec004', 53000.00),
('m005', 'Manager Five', 2021, 10, 1, 'Manager', 'sec005', 54000.00),
('sec001', 'Secretary One', 2022, 11, 5, 'Secretary', null, 30000.00),
('sec002', 'Secretary Two', 2022, 12, 15, 'Secretary', null, 31000.00),
('sec003', 'Secretary Three', 2023, 1, 20, 'Secretary', null, 32000.00),
('sec004', 'Secretary Four', 2023, 2, 10, 'Secretary', null, 33000.00),
('sec005', 'Secretary Five', 2023, 3, 25, 'Secretary', null, 34000.00);

CREATE TABLE PayRaiseRate (
    role VARCHAR(20) PRIMARY KEY,
    rate DECIMAL(5,2) NOT NULL
);

INSERT INTO PayRaiseRate (role, rate) VALUES
('Staff', 0.03),
('Manager', 0.07),
('Secretary', 0.05);

select * from Employee;
select * from PayRaiseRate