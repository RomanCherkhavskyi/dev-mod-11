CREATE TABLE IF NOT EXISTS client(
client_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
client_name VARCHAR(200) NOT NULL CHECK(LENGTH(client_name) >=3)
);

CREATE TABLE IF NOT EXISTS planet(
planet_id VARCHAR(10) PRIMARY KEY CHECK (planet_id = UPPER(planet_id) AND planet_id ~ '[A-Z0-9]'),
planet_name VARCHAR(500) NOT NULL CHECK(LENGTH(planet_name) >=1)
);

CREATE TABLE IF NOT EXISTS ticket(
  id INT AUTO_INCREMENT PRIMARY KEY,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  client_id INT,
  from_planet_id VARCHAR(10),
  to_planet_id VARCHAR(10),
  FOREIGN KEY (client_id) REFERENCES client(client_id),
  FOREIGN KEY (from_planet_id) REFERENCES planet(planet_id),
  FOREIGN KEY (to_planet_id) REFERENCES planet(planet_id)
);