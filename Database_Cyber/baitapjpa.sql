
CREATE DATABASE baitapjpa
USE baitapjpa

CREATE TABLE courses(
	id int Not Null  AUTO_INCREMENT,
	title varchar(255) ,
	duration int Not null,
	Primary key(id)
	
);

CREATE TABLE students (
	id int Not NUll AUTO_INCREMENT,
	email varchar(255),
	name varchar(255),
	age int ,
	PRIMARY KEY(id)
);

CREATE TABLE registration(
	registration_id int NOT NULL AUTO_INCREMENT,
	student_id int NOT NULL,
	course_id int NOT NULL,
	registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (registration_id)
);

ALTER TABLE registration ADD FOREIGN KEY (student_id) REFERENCES students(id);
ALTER TABLE registration ADD FOREIGN KEY (course_id) REFERENCES courses(id);



SELECT s.name, s.email, c.title, c.duration, r.registration_date FROM students s 
JOIN registration r ON s.id = r.student_id 
JOIN courses c ON c.id = r.course_id 

INSERT INTO students (email, name, age) VALUES
('student1@example.com', 'Student 1', 18),
('student2@example.com', 'Student 2', 19),
('student3@example.com', 'Student 3', 20),
('student4@example.com', 'Student 4', 21),
('student5@example.com', 'Student 5', 22),
('student6@example.com', 'Student 6', 23),
('student7@example.com', 'Student 7', 24),
('student8@example.com', 'Student 8', 25),
('student9@example.com', 'Student 9', 26),
('student10@example.com', 'Student 10', 27),
('student11@example.com', 'Student 11', 18),
('student12@example.com', 'Student 12', 19),
('student13@example.com', 'Student 13', 20),
('student14@example.com', 'Student 14', 21),
('student15@example.com', 'Student 15', 22),
('student16@example.com', 'Student 16', 23),
('student17@example.com', 'Student 17', 24),
('student18@example.com', 'Student 18', 25),
('student19@example.com', 'Student 19', 26),
('student20@example.com', 'Student 20', 27),
('student21@example.com', 'Student 21', 18),
('student22@example.com', 'Student 22', 19),
('student23@example.com', 'Student 23', 20),
('student24@example.com', 'Student 24', 21),
('student25@example.com', 'Student 25', 22),
('student26@example.com', 'Student 26', 23),
('student27@example.com', 'Student 27', 24),
('student28@example.com', 'Student 28', 25),
('student29@example.com', 'Student 29', 26),
('student30@example.com', 'Student 30', 27),
('student31@example.com', 'Student 31', 18),
('student32@example.com', 'Student 32', 19),
('student33@example.com', 'Student 33', 20),
('student34@example.com', 'Student 34', 21),
('student35@example.com', 'Student 35', 22),
('student36@example.com', 'Student 36', 23),
('student37@example.com', 'Student 37', 24),
('student38@example.com', 'Student 38', 25),
('student39@example.com', 'Student 39', 26),
('student40@example.com', 'Student 40', 27),
('student41@example.com', 'Student 41', 18),
('student42@example.com', 'Student 42', 19),
('student43@example.com', 'Student 43', 20),
('student44@example.com', 'Student 44', 21),
('student45@example.com', 'Student 45', 22),
('student46@example.com', 'Student 46', 23),
('student47@example.com', 'Student 47', 24),
('student48@example.com', 'Student 48', 25),
('student49@example.com', 'Student 49', 26),
('student50@example.com', 'Student 50', 27);

