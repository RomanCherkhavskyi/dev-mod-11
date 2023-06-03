INSERT INTO client
(client_name)
VALUES
('Roman'),
('Ruslana'),
('Pavlo'),
('Anastasia'),
('Anna'),
('Mykhailo'),
('Dmytro'),
('Yulia'),
('Igor'),
('Victoria');

INSERT INTO planet
(planet_id, planet_name)
VALUES
('E30', 'Earth'),
('M16', 'Mars'),
('J285', 'Jupiter'),
('V21', 'Venera'),
('S4', 'Saturn');

insert into ticket
(created_at, client_id, from_planet_id, to_planet_id)
values
('2023-01-01 15:20', 1, 'E30', 'M16'),
('2023-02-07 16:30', 4, 'J285', 'S4'),
('2023-02-18 10:00', 8, 'V21', 'E30'),
('2022-12-12 19:40', 10, 'M16', 'V21'),
('2022-02-14 08:20', 9, 'S4', 'J285'),
('2022-02-14 18:00', 2, 'J285', 'S4'),
('2022-08-24 10:00', 3, 'V21', 'M16'),
('2021-04-19 07:30', 5, 'S4', 'E30'),
('2023-07-02 12:50', 7, 'E30', 'V21'),
('2021-10-11 16:10', 6, 'M16', 'J285');
