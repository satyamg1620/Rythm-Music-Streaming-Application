DROP SCHEMA IF EXISTS `Rythm`;
CREATE SCHEMA `Rythm`;
USE `Rythm`;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `artist`;
DROP TABLE IF EXISTS `album`;
DROP TABLE IF EXISTS `track`;
DROP TABLE IF EXISTS `playlist`;
DROP TABLE IF EXISTS `follower`;
DROP TABLE IF EXISTS `likes`;

CREATE TABLE users (
  username VARCHAR(50) PRIMARY KEY,
  full_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  mobile_no VARCHAR(10),
  is_premium BOOLEAN NOT NULL,
  profile_image Blob
);

CREATE TABLE artist (
  id INT AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(50) NOT NULL,
  genre VARCHAR(50),
  image Blob
);


CREATE TABLE album (
  id INT AUTO_INCREMENT PRIMARY KEY,
  artist_id INT,
  album_name VARCHAR(50) NOT NULL,
  release_date DATE,
  photo Blob,
  FOREIGN KEY (artist_id) REFERENCES artist(id)
);


CREATE TABLE track (
  id INT AUTO_INCREMENT PRIMARY KEY,
  album_id INT,
  track_name VARCHAR(50) NOT NULL,
  duration INT NOT NULL,
  track_path VARCHAR(255),
  FOREIGN KEY (album_id) REFERENCES album(id)
);


CREATE TABLE playlist (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100),
  playlist_name VARCHAR(50) NOT NULL,
  image Blob,
  FOREIGN KEY (username) REFERENCES users(username)
);

DROP TABLE IF EXISTS `playlist_track`;
CREATE TABLE playlist_track (
  playlist_id INT,
  track_id INT,
  -- `Order` INT,
  PRIMARY KEY (playlist_id, track_id),
  FOREIGN KEY (playlist_id) REFERENCES playlist(id),
  FOREIGN KEY (track_id) REFERENCES track(id)
);


CREATE TABLE follower (
  username VARCHAR(100),
  artist_id INT,
  PRIMARY KEY (username, artist_id),
  FOREIGN KEY (username) REFERENCES users(username),
  FOREIGN KEY (artist_id) REFERENCES artist(id)
);


CREATE TABLE likes (
  username VARCHAR(100),
  track_id INT,
  like_Date_Time DATETIME,
  PRIMARY KEY (username, track_id),
  FOREIGN KEY (username) REFERENCES users(username),
  FOREIGN KEY (track_id) REFERENCES track(id)
);

CREATE TABLE members (
  username VARCHAR(100),
  password VARCHAR(100) NOT NULL,
  active TINYINT(1),
  PRIMARY KEY (username),
  FOREIGN KEY (username) REFERENCES users(username)
);
CREATE TABLE roles (
  username VARCHAR(100),
  role VARCHAR(50) NOT NULL,
  PRIMARY KEY (username, role),
  FOREIGN KEY (username) REFERENCES members(username)
);

