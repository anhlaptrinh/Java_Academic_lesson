-- 1)	Liệt kê tên nhân viên và tên phòng ban của họ
SELECT e.name , d.department_name 
FROM employees e 
JOIN departments d ON e.department_id =d.department_id 

-- 2)	Liệt kê tên nhân viên và tên dự án mà họ tham gia
SELECT e.name AS employee_name, GROUP_CONCAT(DISTINCT p.project_name SEPARATOR ', ') AS projects
FROM employees e
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id
GROUP BY e.name;

-- 3)	Liệt kê tên phòng ban, tên dự án và tên nhân viên tham gia dự án đó.
SELECT d.department_name , GROUP_CONCAT(DISTINCT p.project_name SEPARATOR ', ') AS projects , GROUP_CONCAT(DISTINCT e.name SEPARATOR ', ') AS employees 
FROM departments d 
JOIN projects p ON d.department_id =p.project_id 
JOIN employee_projects ep ON ep.project_id = p.project_id 
JOIN employees e ON e.employee_id =ep.employee_id 
GROUP BY d.department_name;

-- 4)	Tính tổng lương của nhân viên tham gia từng dự án
SELECT p.project_name, SUM(e.salary) AS employee_totalSalary 
FROM projects p 
JOIN employee_projects ep ON ep.project_id=p.project_id
JOIN employees e ON e.employee_id =ep.employee_id 
GROUP BY p.project_name 

-- 5)	Liệt kê tên nhân viên, tên quản lý của họ và tên dự án họ tham gia
SELECT e.name AS employee_name, 
       m.name AS manager_name, 
       GROUP_CONCAT(DISTINCT p.project_name SEPARATOR ', ') AS projects
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.employee_id
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id
GROUP BY e.name, m.name;

-- 6)	Liệt kê tên phòng ban và số lượng nhân viên tham gia dự án của từng phòng ban
SELECT d.department_name , COUNT(DISTINCT e.employee_id) as number_employees 
FROM departments d 
JOIN employees e ON e.department_id =d.department_id 
GROUP BY d.department_name

-- 7)	Tìm tên nhân viên có lương cao nhất tham gia trong mỗi dự án
SELECT p.project_name, e.name AS employee_name, e.salary
FROM projects p
JOIN employee_projects ep ON p.project_id = ep.project_id
JOIN employees e ON ep.employee_id = e.employee_id
WHERE e.salary = (SELECT MAX(salary) 
                  FROM employees e2 
                  JOIN employee_projects ep2 ON e2.employee_id = ep2.employee_id 
                  WHERE ep2.project_id = p.project_id);
             
-- 8)	Liệt kê tên dự án và tổng số nhân viên tham gia, sắp xếp theo tổng số nhân viên giảm dần
SELECT p.project_name, COUNT(DISTINCT e.employee_id) AS sum_employee 
FROM projects p 
JOIN employee_projects ep ON ep.project_id =p.project_id 
JOIN employees e ON e.employee_id =ep.employee_id 
GROUP BY p.project_name
ORDER BY COUNT(DISTINCT e.employee_id) DESC

-- 9)	Tính lương trung bình của nhân viên trong từng phòng ban tham gia dự án
SELECT d.department_name , AVG(e.salary) AS average_salary 
FROM employees e 
JOIN departments d ON d.department_id =e.department_id 
GROUP BY d.department_name 

-- 10)	Tìm tên nhân viên và dự án mà họ tham gia ít nhất một lần trong mỗi phòng ban
SELECT e.name, GROUP_CONCAT(DISTINCT p.project_name SEPARATOR ', ') AS projects  
FROM employees e 
JOIN employee_projects ep ON ep.employee_id=e.employee_id 
JOIN projects p ON p.project_id =ep.project_id 
JOIN departments d ON d.department_id =p.department_id 
GROUP BY e.name 

-- 11)	Tìm tên nhân viên và số lượng dự án mà họ tham gia nhiều nhất
SELECT e.name AS employee_name, COUNT(ep.project_id) AS project_count
FROM employees e
JOIN employee_projects ep ON e.employee_id = ep.employee_id
GROUP BY e.name
HAVING COUNT(ep.project_id) = (
    SELECT MAX(project_count)
    FROM (
        SELECT COUNT(ep2.project_id) AS project_count
        FROM employees e2
        JOIN employee_projects ep2 ON e2.employee_id = ep2.employee_id
        GROUP BY e2.name
    ) AS project_counts
);

-- 12)	Tìm tên phòng ban và số lượng dự án mà phòng ban đó quản lý nhiều nhất
SELECT d.department_name, COUNT(p.project_id) AS number_projects
FROM departments d
JOIN projects p ON d.department_id = p.department_id
GROUP BY d.department_name
HAVING COUNT(p.project_id) = (
    SELECT MAX(project_count)
    FROM (
        SELECT COUNT(p2.project_id) AS project_count
        FROM departments d2
        JOIN projects p2 ON d2.department_id = p2.department_id
        GROUP BY d2.department_name
    ) AS project_counts
);

-- 13)	Tìm tên nhân viên có lương thấp nhất trong từng dự án
SELECT p.project_name, e.name AS employee_name, e.salary
FROM projects p
JOIN employee_projects ep ON p.project_id = ep.project_id
JOIN employees e ON ep.employee_id = e.employee_id
WHERE e.salary = (SELECT MIN(salary) 
                  FROM employees e2 
                  JOIN employee_projects ep2 ON e2.employee_id = ep2.employee_id 
                  WHERE ep2.project_id = p.project_id);

-- 14)	Liệt kê tên tất cả các dự án không có nhân viên tham gia
SELECT p.project_name
FROM projects p
LEFT JOIN employee_projects ep ON p.project_id = ep.project_id
WHERE ep.employee_id IS NULL;

-- 15)	Tìm tên nhân viên có lương cao nhất và thấp nhất trong mỗi phòng ban
SELECT d.department_name, e.name AS employee_name, e.salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.salary = (SELECT MAX(salary) FROM employees e2 WHERE e2.department_id = d.department_id)
   OR e.salary = (SELECT MIN(salary) FROM employees e2 WHERE e2.department_id = d.department_id);
  
-- 16)	Tính tổng lương và số lượng nhân viên cho từng dự án trong mỗi phòng ban
SELECT d.department_name, p.project_name, SUM(e.salary) AS total_salary, COUNT(e.employee_id) AS employee_count
FROM departments d
JOIN projects p ON d.department_id = p.department_id
JOIN employee_projects ep ON p.project_id = ep.project_id
JOIN employees e ON ep.employee_id = e.employee_id
GROUP BY d.department_name, p.project_name;

-- 17)	Tìm tên các nhân viên không tham gia bất kỳ dự án nào
SELECT e.name
FROM employees e
LEFT JOIN employee_projects ep ON e.employee_id = ep.employee_id
WHERE ep.project_id IS NULL;

-- 18)	Tính tổng số dự án mà mỗi phòng ban đang quản lý
SELECT d.department_name, COUNT(p.project_id) AS project_count
FROM departments d
JOIN projects p ON d.department_id = p.department_id
GROUP BY d.department_name;

-- 19)	Tìm tên nhân viên và tên dự án mà nhân viên có lương cao nhất tham gia trong từng phòng ban
SELECT d.department_name, e.name AS employee_name, p.project_name
FROM departments d
JOIN employees e ON d.department_id = e.department_id
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id
WHERE e.salary = (SELECT MAX(salary) FROM employees e2 WHERE e2.department_id = d.department_id);

-- 20)	Tính tổng lương của nhân viên trong mỗi phòng ban theo từng dự án mà không có nhân viên tham gia dự án

SELECT d.department_name, p.project_name, SUM(e.salary) AS total_salary
FROM departments d
JOIN projects p ON d.department_id = p.department_id
LEFT JOIN employee_projects ep ON p.project_id = ep.project_id
LEFT JOIN employees e ON ep.employee_id = e.employee_id
GROUP BY d.department_name, p.project_name
HAVING total_salary IS NOT NULL;


SELECT * FROM employees e;
 



 
CREATE DATABASE qlnhanvien;
USE qlnhanvien;
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







 
 