-- Role data insertion
INSERT INTO rol (id, name) VALUES
                               (1, 'Admin'),
                               (2, 'Moderator'),
                               (3, 'User'),
                               (4, 'Guest'),
                               (5, 'Editor');

-- User insertion
INSERT INTO "user" (id, username, "password", email, created_at) VALUES
                                                                     (1, 'john_doe', 'password123', 'john.doe@example.com', NOW()),
                                                                     (2, 'jane_smith', 'pass456', 'jane.smith@example.com', NOW()),
                                                                     (3, 'bob_johnson', 'securepass', 'bob.johnson@example.com', NOW()),
                                                                     (4, 'alice_williams', 'myp@ssword', 'alice.williams@example.com', NOW()),
                                                                     (5, 'charlie_brown', 'brownie', 'charlie.brown@example.com', NOW()),
                                                                     (6, 'eva_jones', 'evapass', 'eva.jones@example.com', NOW()),
                                                                     (7, 'michael_clark', 'michaelpass', 'michael.clark@example.com', NOW()),
                                                                     (8, 'sophie_anderson', 'sophiepass', 'sophie.anderson@example.com', NOW()),
                                                                     (9, 'david_wilson', 'davidpass', 'david.wilson@example.com', NOW()),
                                                                     (10, 'olivia_moore', 'moorepass', 'olivia.moore@example.com', NOW());

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
                                                                   (10, true, NOW(), 10, 5);

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
                                                                                 (10, 'Olivia', 'Moore', 27, '1996-06-14', 10);
