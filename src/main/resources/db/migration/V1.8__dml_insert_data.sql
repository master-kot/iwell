INSERT INTO users
(user_name, password, enabled, birthday_date, first_name, last_name, address, phone, gender, photo_link)
VALUES
('admin', '$2a$10$ArsakpPHT5jPbPEAeVc/lup1V4tJS9hqaa1PfRNIUy459JkPjK5xS', true, '2001-02-03', 'Иван', 'Иванов', 'Москва', '80123456789', 2, 'myfoto.png'),
('user', '$2a$10$7v8.w1xVYIu6TKY3a58CX.xcmSXPpW6mVLTqB11kAn10jezppGdE2', true, '2003-04-05', 'Катя', 'Петрова', 'Казань', '89876543210', 1, 'katya.png');

INSERT INTO authorities
(authority)
VALUES
('ROLE_ADMIN'),
('ROLE_USER'),
('ROLE_COUCH');

INSERT INTO users_authorities
(user_id, authority_id)
VALUES
(1, 1),
(2, 2);