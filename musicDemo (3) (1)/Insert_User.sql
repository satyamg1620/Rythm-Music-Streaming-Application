USE `Rythm`;

INSERT INTO `Rythm`.users (username, full_name, email, password, mobile_no, is_premium)
VALUES
	('satyamg16', 'Satyam Gupta', 'satyam.g16@gmail.com', 'test123', '9876543210', true),
	('shubham30', 'Shubham Gupta', 'shub30mayjugal@gmail.com', 'test123', '8765432109', true),
	('rup4jan', 'Rupali Gupta', 'rup4jan@gmail.com', 'test123', '7654321098', true);
    

INSERT INTO `Rythm`.artist (full_name, genre)
VALUES
	-- ('A. R. Rahman', 'Pop'),
-- 	('Sonu Nigam', 'Pop'),
-- 	('Lata Mangeshkar', 'Folk')
    ('Dua Lipa', 'Pop'),
    ('Charlie Puth', 'Pop'),
    ('Justin Beiber', 'Pop'),
    ('Selena Gomez', 'Pop'),
    ('Rema', 'Pop'),
    ('Coldplay', 'Pop');
    
INSERT INTO `Rythm`.follower (username, artist_id)
VALUES
	('satyamg16', '1'),
-- 	('Sonu Nigam', 'Pop'),
	('rup4jan', '3');
    
    
INSERT INTO `Rythm`.album (artist_id, album_name, release_date)
VALUES
	-- (1, 'The Flying Lotus', '2017-10-06'),
-- 	(1, 'Raunaq', '2017-02-27'),
-- 	(3, 'Chala Vaahi Des', '1970-10-10'),
--     (2, 'Rafi Ki Yaadein', '1992-10-10')
(4, 'Levitating', '2017-10-06'),
(5, 'Attention', '2017-10-06'),
(6, 'Stay', '2017-10-06'),
(7, 'Calm Down', '2017-10-06'),
(5, 'We Dont Talk Anymore', '2017-10-06'),
(9, 'Hymn', '2017-10-06'),
(9, 'A Sky Full of Stars', '2017-10-06')
    ;
    
INSERT INTO `Rythm`.track (album_id, track_name, duration, track_path)
VALUES
	-- (1, 'Kunfaya', 240, '/Rockstar/Kunfaya'),
-- 	(2, 'Nadan Parindey', 250, '/Rockstar/Nadan Parindey'),
-- 	(3, 'Tum Yahan Hum Yahan',260, '/Veer Zara/Tum Yahan Hum Yahan'),
--     (4, 'Abhi Mujhme', 300, '/Agneepath/Abhi Mujhme Kahin');
(5, 'Levitating',260, 'DuaLipa__Levitating'),
(6, 'Attention',260, 'CharliePuth__Attention'),
(7, 'Stay',260, 'TheKidLAROI_JustinBieber__STAY'),
(8, 'Calm Down',260, 'Rema_SelenaGomez__CalmDown'),
(9, 'We Dont Talk Anymore',260, 'CharliePuth_SelenaGomez__We_Dont_Talk_Anymore'),
(10, 'Hymn',260, 'Coldplay__A_Sky_Full_Of_Stars'),
(11, 'A Sky Full of Stars',260, 'Coldplay__Hymn')
;
    
    INSERT INTO `Rythm`.playlist (username, playlist_name)
	VALUES
	('satyamg16', 'Fav'),
	('shubham30', 'Work'),
	('rup4jan', 'Fun');
    
    INSERT INTO `Rythm`.playlist_track (playlist_id, track_id)
	VALUES
	(10, 1),
	(10, 2),
	(11, 2),
    (11, 3),
    (12, 3),
    (12, 1);
    
    INSERT INTO `Rythm`.likes (username, track_id)
	VALUES
	('satyamg16', 1),
    ('satyamg16', 2),
	('shubham30', 3),
	('rup4jan', 4);
    
     INSERT INTO `Rythm`.members (username, password, active)
	VALUES
	('satyamg16','{noop}test123' , 1),
	('shubham30','{noop}test123' ,1),
	('rup4jan','{noop}test123' ,1);
    
      INSERT INTO `Rythm`.roles (username, role)
	VALUES
	('satyamg16','ROLE_ADMIN'),
    ('satyamg16','ROLE_USER'),
	('shubham30','ROLE_USER'),
	('rup4jan','ROLE_USER');
    
