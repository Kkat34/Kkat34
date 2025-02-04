-- DEVELOPERS TABLE: 
CREATE TABLE Developers ( 
DeveloperID INT PRIMARY KEY, 
DName VARCHAR(50) NOT NULL, 
Country VARCHAR(50), 
FoundedYear INT 
); 
 
-- PLATFORMS TABLE: 
CREATE TABLE Platforms ( 
PlatformID INT PRIMARY KEY, 
PName VARCHAR(200) NOT NULL, 
Manufacturer VARCHAR(100), 
ReleaseYear INT 
); 
 
-- USERS TABLE: 
CREATE TABLE Users ( 
UserID INT PRIMARY KEY, 
UserName VARCHAR(100) NOT NULL, 
Email VARCHAR(100) UNIQUE NOT NULL, 
JoinDate DATE 
); 
 
-- GAMES TABLE: 
CREATE TABLE Games ( 
GameID INT PRIMARY KEY, 
Title VARCHAR(100) NOT NULL, 
Genre VARCHAR(50), 
ReleaseDate DATE, 
DeveloperID INT, 
PlatformID INT, 
AvgRating DECIMAL(2, 1) NULL, 
FOREIGN KEY (DeveloperID) REFERENCES Developers(DeveloperID), 
FOREIGN KEY (PlatformID) REFERENCES Platforms(PlatformID) 
); 
 
-- REVIEWS TABLE: 
CREATE TABLE Reviews ( 
ReviewID INT PRIMARY KEY, 
GameID INT, 
UserID INT, 
Rating INT CHECK (Rating >= 1 AND Rating <= 10), 
Comment TEXT, 
ReviewDate DATE, 
FOREIGN KEY (GameID) REFERENCES Games(GameID), 
FOREIGN KEY (UserID) REFERENCES Users(UserID), 
UNIQUE (UserID, GameID) -- a user can only review a game once 
);

-- INSERTION ORDER: PLATFORMS-->DEVELOPERS-->GAMES-->USERS-->REVIEWS
-- NOTES: WE NEED AT LEAST 10 ROWS PER TABLE

-- PLATFORMS INSERTION: 
INSERT INTO Platforms (PlatformID, PName, Manufacturer, ReleaseYear) VALUES 
(1, 'PC', 'Various', 1981),
(2, 'PlayStation 5', 'Sony', 2020),
(3, 'PlayStation 4', 'Sony', 2013),
(4, 'PlayStation 3', 'Sony', 2006),
(5, 'Xbox Series X', 'Microsoft', 2020),
(6, 'Xbox One', 'Microsoft', 2013),
(7, 'Xbox 360', 'Microsoft', 2005),
(8, 'Nintendo Switch', 'Nintendo', 2017),
(9, 'Wii U', 'Nintendo', 2012),
(10, 'Wii', 'Nintendo', 2006);
 
-- DEVELOPERS INSERTION: 
INSERT INTO Developers (DeveloperID, DName, Country, FoundedYear) VALUES 
(1, 'Nintendo', 'Japan', 1889),
(2, 'Sony Interactive Entertainment', 'Japan', 1993),
(3, 'Microsoft Studios', 'USA', 2000),
(4, 'Valve Corporation', 'USA', 1996),
(5, 'Electronic Arts', 'USA', 1982),
(6, 'Ubisoft', 'France', 1986),
(7, 'Rockstar Games', 'USA', 1998),
(8, 'Square Enix', 'Japan', 1986),
(9, 'Bungie', 'USA', 1991),
(10, 'CD Projekt', 'Poland', 2002);
 
-- GAMES INSERTION: 
INSERT INTO Games(GameID, Title, Genre, ReleaseDate, DeveloperID, PlatformID, AvgRating ) VALUES 
(1, 'The Legend of Zelda: Breath of the Wild', 'Action-Adventure', '2017-03-03', 1, 8, NULL),
(2, 'God of War', 'Action-Adventure', '2018-04-20', 2, 3, NULL),
(3, 'Halo Infinite', 'First-Person Shooter', '2021-12-08', 3, 5, NULL),
(4, 'Half-Life: Alyx', 'First-Person Shooter', '2020-03-23', 4, 1, NULL),
(5, 'FIFA 22', 'Sports', '2021-10-01', 5, 1, NULL),
(6, 'Assassin’s Creed Valhalla', 'Action-RPG', '2020-11-10', 6, 2, NULL),
(7, 'Grand Theft Auto V', 'Action-Adventure', '2013-09-17', 7, 4, NULL),
(8, 'Final Fantasy VII Remake', 'RPG', '2020-04-10', 8, 2, NULL),
(9, 'Destiny 2', 'First-Person Shooter', '2017-09-06', 9, 6, NULL),
(10, 'The Witcher 3: Wild Hunt', 'RPG', '2015-05-19', 10, 3, NULL);
 
-- USERS INSERTION: 
INSERT INTO Users (UserID, UserName, Email, JoinDate) VALUES 
(1, 'GamerJay', 'gamerjay@example.com', '2021-05-01'),
(2, 'LunarMoon', 'lunarmoon@example.com', '2021-06-15'),
(3, 'LameNinja', 'lameninja@example.com', '2021-07-20'),
(4, 'PixelPrince', 'pixelprince@example.com', '2021-08-30'),
(5, 'DragonMaid', 'dragonmaid@example.com', '2021-09-10'),
(6, 'QuestGiver', 'questgiver@example.com', '2021-10-05'),
(7, 'LightHunter', 'lighthunter@example.com', '2021-11-12'),
(8, 'SwordWanderer', 'swordwanderer@example.com', '2021-12-25'),
(9, 'SunGazer', 'sungazer@example.com', '2021-01-18'),
(10, 'TheMyth', 'themyth@example.com', '2021-02-22'),
(11, 'WarriorKing', 'warriorking@example.com', '2021-03-14'),
(12, 'CodeCrusher', 'codecrusher@example.com', '2021-04-29'),
(13, 'MysticBeserker', 'mysticbeserker@example.com', '2021-05-21'),
(14, 'KnightWalker', 'knightwalker@example.com', '2021-06-15'),
(15, 'FutureWorker', 'futureworker@example.com', '2021-07-30'),
(16, 'LoneCat', 'lonecat@example.com', '2021-08-10'),
(17, 'NerdyKitten', 'nerdykitten@example.com', '2021-09-20'),
(18, 'StealthMage', 'stealthmage@example.com', '2021-10-12'),
(19, 'HeroicLegend', 'heroiclegend@example.com', '2021-11-02'),
(20, 'RetroLamp', 'retrolamp@example.com', '2021-12-31');
 
-- REVIEWS INSERTION: 
INSERT INTO Reviews (ReviewID, GameID, UserID, Rating, Comment, ReviewDate) VALUES 
(1, 1, 1, 10, 'An absolute masterpiece!', '2024-10-01'),
(2, 1, 2, 9, 'Stunning graphics and gameplay.', '2024-10-02'),
(3, 2, 3, 10, 'A fantastic reboot of the series!', '2024-10-03'),
(4, 3, 4, 8, 'Great campaign, but needs more content.', '2024-10-04'),
(5, 4, 5, 9, 'Innovative VR experience.', '2024-10-05'),
(6, 5, 6, 7, 'Good, but lacks innovation.', '2024-10-06'),
(7, 6, 7, 8, 'Engaging story and fun gameplay.', '2024-10-07'),
(8, 7, 8, 10, 'Best game in the series!', '2024-10-08'),
(9, 8, 9, 9, 'Beautiful and emotional experience.', '2024-10-09'),
(10, 9, 10, 8, 'Fun, but repetitive.', '2024-10-10'),
(11, 10, 11, 10, 'A breathtaking journey.', '2024-10-11'),
(12, 2, 12, 9, 'Great graphics, but a bit linear.', '2024-10-12'),
(13, 3, 13, 8, 'Enjoyable, but had some issues.', '2024-10-13'),
(14, 4, 14, 7, 'A unique take on the franchise.', '2024-10-14'),
(15, 5, 15, 9, 'Fantastic characters and world.', '2024-10-15'),
(16, 6, 16, 6, 'Same old, same old.', '2024-10-16'),
(17, 7, 17, 8, 'Great improvements over the original.', '2024-10-17'),
(18, 8, 18, 10, 'An epic adventure!', '2024-10-18'),
(19, 9, 19, 9, 'Good mechanics, but could be better.', '2024-10-19'),
(20, 10, 20, 7, 'Highly recommend!', '2024-10-20');
 
-- AVGRATING STATEMENT: 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 1; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 2; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 3; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 4; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 5; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 6; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 7; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 8; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 9; 
SELECT AVG(Rating) FROM Reviews WHERE GameID = 10;
