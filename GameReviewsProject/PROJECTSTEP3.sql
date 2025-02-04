 -- SQL QUERIES
 SELECT g.Title, d.Dname AS Developer
FROM games g
JOIN developers d on d.developerID =g.developerID
ORDER BY d.developerID;


CREATE VIEW GameAvgRating AS
SELECT g.Title, AVG(r.Rating) AS AvgUserRating
FROM games g
JOIN reviews r ON g.GameID = r.GameID
GROUP BY g.Title;
SELECT Title, AvgUserRating
FROM GameAvgRating
WHERE AvgUserRating>=9;

SELECT ReviewDate, Rating, Comment
FROM Reviews
WHERE  GameID = 2
ORDER BY Rating;

SELECT g.Title, d.Dname, p.Pname
FROM games g
JOIN developers d on d.developerID=g.developerID
JOIN platforms p on p.platformID=g.platformID
WHERE  Genre = 'Action-Adventure';

SELECT u.UserName, COUNT(r.ReviewID) AS ReviewCount
FROM users u
JOIN reviews r ON u.UserID = r.UserID
GROUP BY u.UserName
ORDER BY ReviewCount DESC;

SELECT g.Title, p.Pname AS Platform
FROM games g
JOIN platforms p on p.platformID=g.platformID
ORDER BY p.platformID;

SELECT g.Title, g.Genre, g.AvgRating
FROM games g
WHERE g.AvgRating = (
SELECT MAX(g2.AvgRating)
FROM games g2
WHERE g2.Genre = g.Genre);

SELECT Title, ReleaseDate
FROM games
ORDER BY ReleaseDate DESC;

SELECT Genre, COUNT(Genre) AS GameCount
FROM games
GROUP BY Genre
ORDER BY GameCount DESC;

SELECT d.Dname AS Developer, AVG(G.AvgRating) AS Rating
FROM developers d 
JOIN games g ON d.developerID =g.developerID
GROUP BY d.Dname
HAVING AVG(G.AvgRating) > 8;

CREATE VIEW HighRatedGame AS
SELECT p.Pname AS Platform, p.Manufacturer, g.Title, g.AvgRating AS HighRating
FROM platforms p
JOIN games g on p.platformID=g.platformID
WHERE g.AvgRating = ( 
SELECT MAX(AvgRating) 
FROM games 
WHERE platformID = p.platformID )
ORDER BY Platform;
SELECT Platform, Manufacturer, HighRating
FROM HighRatedGame
ORDER BY Manufacturer;


SELECT * FROM Platforms 
WHERE Manufacturer IN (SELECT DName 
FROM Developers 
WHERE FoundedYear >= 2000);

SELECT COUNT(*) 
FROM Users 
WHERE JoinDate 
BETWEEN '2021-07-01' AND '2021-07-31' 
AND UserID IN (SELECT UserID FROM Reviews);

