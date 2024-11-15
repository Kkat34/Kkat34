--Unit 4 Assignment no.1
--Entertainment Agency Database pages 317-318
--#1
SELECT Agents.AgtFirstName, agents.AgtLastName, engagements.StartDate, Engagements.EngagementNumber
FROM Agents
INNER JOIN engagements ON agents.AgentID = engagements.AgentID
ORDER BY engagements.StartDate

--#2
SELECT Customers.CustFirstName, Customers.CustLastName, Entertainers.EntStageName, Engagements.EntertainerID
FROM Engagements
INNER JOIN Customers  ON Engagements.customerid = Customers.CustomerID
INNER JOIN Entertainers  ON Engagements.entertainerid = Entertainers.EntertainerID

--#3
SELECT Agents.AgentID, Entertainers.EntStageName, agents.AgtZipCode, Entertainers.EntZipCode
FROM agents 
INNER JOIN entertainers  ON Agents.AgtZipCode = Entertainers.EntZipCode