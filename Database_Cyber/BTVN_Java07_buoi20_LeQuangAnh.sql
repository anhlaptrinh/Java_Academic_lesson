CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255),
    salary DECIMAL(10, 2),
    start_date DATE,
    department_id INT
);

CREATE TABLE access_rights (
    access_id INT PRIMARY KEY,
    employee_id INT,
    access_level VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(255)
);

INSERT INTO employees (employee_id, employee_name, salary, start_date, department_id)
VALUES
    (1, 'John Doe', 60000, '2021-01-15', 1),
    (2, 'Jane Smith', 70000, '2020-05-20', 2),
    (3, 'Bob Johnson', 55000, '2022-03-10', 1),
    (4, 'Alice Williams', 80000, '2021-08-05', 3),
    (5, 'Charlie Brown', 65000, '2020-12-01', 2);

INSERT INTO departments (department_id, department_name)
VALUES
    (1, 'IT'),
    (2, 'Sales'),
    (3, 'HR');

INSERT INTO access_rights (access_id, employee_id, access_level)
VALUES
    (1, 1, 'Admin'),
    (2, 2, 'User'),
    (3, 3, 'User'),
    (4, 4, 'Admin'),
    (5, 5, 'User');



-- 1)	Hiển thị tất cả thông tin của bảng "employees"
SELECT * FROM employees e 

-- 2)	Hiển thị tên và lương của tất cả nhân viên
SELECT e.employee_name, e.salary From employees e 

-- 3)	Hiển thị thông tin của những nhân viên có lương lớn hơn 50000
SELECT * FROM employees e WHERE e.salary > 50000

-- 4)	Hiển thị số lượng nhân viên trong mỗi phòng ban
SELECT d.department_name, COUNT(e.employee_id) as number_employee 
FROM employees e
JOIN departments d ON e.department_id = d.department_id 
GROUP BY d.department_name 

-- 5)	Sắp xếp danh sách nhân viên theo tên từ A-Z
SELECT * 
FROM employees e
ORDER BY e.employee_name ASC

-- 6)	Hiển thị tên, lương và phòng ban của những nhân viên có lương từ 40000 đến 60000, sắp xếp theo lương giảm dần
SELECT e.employee_name,e.salary,d.department_name 
FROM employees e 
JOIN departments d ON e.employee_id = d.department_id 
WHERE e.salary BETWEEN 40000 AND 60000
ORDER BY e.salary DESC

-- 7)	Tính tổng lương của tất cả nhân viên
SELECT SUM(e.salary) as employee_totalSalary 
FROM employees e 

-- 8)	Hiển thị tên của nhân viên và tên phòng ban của họ
SELECT e.employee_name,d.department_name 
FROM employees e 
JOIN departments d ON e.department_id = d.department_id 

-- 9)	Tìm những phòng ban có ít nhất 3 nhân viên
SELECT d.department_name, COUNT(e.employee_id) as number_employee 
FROM employees e
JOIN departments d ON e.department_id = d.department_id 
GROUP BY department_name
HAVING COUNT(e.employee_id)>=3

-- 10)	Hiển thị tên nhân viên và lương của những nhân viên ở phòng ban "IT" hoặc "Sales"
SELECT e.employee_name , e.salary 
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE d.department_name IN ('IT', 'Sales');

-- 11)	Hiển thị tên và ngày bắt đầu làm việc của những nhân viên được tuyển dụng sau năm 2020
SELECT e.employee_name, e.start_date 
FROM employees e 
WHERE YEAR(e.start_date)>2020

-- 12)	Tính trung bình lương của nhân viên
SELECT AVG(e.salary) 
FROM employees e 

-- 13)	Hiển thị danh sách các phòng ban và số lượng nhân viên trong mỗi phòng ban, kể cả những phòng ban không có nhân viên
SELECT d.department_name, COUNT(e.employee_id) AS employee_count
FROM departments d
LEFT JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_id;

-- 14)	Hiển thị 5 nhân viên có lương cao nhất
SELECT e.employee_name,e.salary FROM employees e
ORDER BY salary DESC
LIMIT 5;

-- 15)	Tìm những nhân viên có tên bắt đầu bằng chữ "A"
SELECT e.employee_name
FROM employees e
WHERE e.employee_name LIKE 'A%'

-- 16)	Hiển thị tên nhân viên và tên quyền truy cập của những người có quyền là "Admin"
SELECT e.employee_name, ar.access_level 
FROM employees e
JOIN access_rights ar ON e.employee_id = ar.employee_id 
WHERE ar.access_level = 'Admin'

-- 17)	Tính tổng lương cho mỗi phòng ban và sắp xếp theo tổng lương giảm dần
SELECT d.department_name ,  SUM(e.salary) as Total
FROM employees e
JOIN departments d ON e.department_id = d.department_id 
GROUP BY department_name
ORDER BY SUM(e.salary)  DESC

-- 18)	Hiển thị danh sách nhân viên và ngày bắt đầu làm việc, sắp xếp theo ngày bắt đầu làm việc tăng dần
SELECT e.employee_name , e.start_date 
FROM employees e 
ORDER BY DATE(e.start_date) ASC

-- 19)	Tìm những nhân viên có lương cao nhất trong từng phòng ban
SELECT employee_name, salary, department_id
FROM employees e1
WHERE salary = (SELECT MAX(salary) FROM employees e2 WHERE e2.department_id = e1.department_id);

-- 20)	Hiển thị danh sách nhân viên và tên quyền truy cập của họ, bao gồm những nhân viên không có quyền truy cập
SELECT e.employee_name, ar.access_level 
FROM employees e
LEFT JOIN access_rights ar ON e.employee_id = ar.employee_id 

