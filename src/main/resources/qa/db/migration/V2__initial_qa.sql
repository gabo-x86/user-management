-- Role data insertion
INSERT INTO rol (id, name) VALUES
(1, 'Admin'),
(2, 'Moderator'),
(3, 'User'),
(4, 'Guest'),
(5, 'Editor');

-- User insertion
INSERT INTO "user" (id, username, "password", email, created_at) VALUES
(1, 'user1', 'password1', 'user1@example.com', NOW()),
(2, 'user2', 'password2', 'user2@example.com', NOW()),
(3, 'user3', 'password3', 'user3@example.com', NOW()),
(4, 'user4', 'password4', 'user4@example.com', NOW()),
(5, 'user5', 'password5', 'user5@example.com', NOW()),
(6, 'user6', 'password6', 'user6@example.com', NOW()),
(7, 'user7', 'password7', 'user7@example.com', NOW()),
(8, 'user8', 'password8', 'user8@example.com', NOW()),
(9, 'user9', 'password9', 'user9@example.com', NOW()),
(10, 'user10', 'password10', 'user10@example.com', NOW()),
(11, 'user11', 'password11', 'user11@example.com', NOW()),
(12, 'user12', 'password12', 'user12@example.com', NOW()),
(13, 'user13', 'password13', 'user13@example.com', NOW()),
(14, 'user14', 'password14', 'user14@example.com', NOW()),
(15, 'user15', 'password15', 'user15@example.com', NOW()),
(16, 'user16', 'password16', 'user16@example.com', NOW()),
(17, 'user17', 'password17', 'user17@example.com', NOW()),
(18, 'user18', 'password18', 'user18@example.com', NOW()),
(19, 'user19', 'password19', 'user19@example.com', NOW()),
(20, 'user20', 'password20', 'user20@example.com', NOW());

-- Asign user and rol
INSERT INTO user_rol (id, active, created_at, user_id, rol_id) VALUES
(1, true, NOW(), 1, 1),
(2, true, NOW(), 2, 2),
(3, true, NOW(), 3, 3),
(4, true, NOW(), 4, 4),
(5, true, NOW(), 5, 5),
(6, true, NOW(), 6, 1),
(7, true, NOW(), 7, 2),
(8, true, NOW(), 8, 3),
(9, true, NOW(), 9, 4),
(10, true, NOW(), 10, 5),
(11, true, NOW(), 11, 1),
(12, true, NOW(), 12, 2),
(13, true, NOW(), 13, 3),
(14, true, NOW(), 14, 4),
(15, true, NOW(), 15, 5),
(16, true, NOW(), 16, 1),
(17, true, NOW(), 17, 2),
(18, true, NOW(), 18, 3),
(19, true, NOW(), 19, 4),
(20, true, NOW(), 20, 5);



-- User detail
INSERT INTO user_detail (id, first_name, last_name, age, birth_day, user_id) VALUES
(1, 'John', 'Doe', 25, '1998-01-15', 1),
(2, 'Jane', 'Smith', 30, '1993-05-22', 2),
(3, 'Bob', 'Johnson', 28, '1995-11-10', 3),
(4, 'Alice', 'Williams', 22, '2000-03-08', 4),
(5, 'Charlie', 'Brown', 35, '1987-09-17', 5),
(6, 'Eva', 'Jones', 29, '1994-07-30', 6),
(7, 'Michael', 'Clark', 31, '1991-12-03', 7),
(8, 'Sophie', 'Anderson', 26, '1997-08-20', 8),
(9, 'David', 'Wilson', 33, '1990-04-25', 9),
(10, 'Olivia', 'Moore', 27, '1996-06-14', 10),
(11, 'Sam', 'Taylor', 34, '1989-02-18', 11),
(12, 'Emily', 'Miller', 23, '1999-09-05', 12),
(13, 'Ryan', 'Hill', 32, '1992-04-30', 13),
(14, 'Sophia', 'Turner', 28, '1995-07-12', 14),
(15, 'Daniel', 'Baker', 26, '1997-08-25', 15),
(16, 'Ava', 'Harris', 30, '1993-03-28', 16),
(17, 'Max', 'Smith', 29, '1994-06-08', 17),
(18, 'Grace', 'Cooper', 27, '1996-05-19', 18),
(19, 'Logan', 'Ward', 31, '1991-11-10', 19),
(20, 'Lily', 'Fisher', 25, '1998-01-05', 20);
