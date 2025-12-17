-- Last updated: 12/17/2025, 10:53:33 AM
# Write your MySQL query statement below
SELECT Person.firstName, Person.lastName, Address.city, Address.state FROM Person LEFT JOIN Address ON Person.personId = Address.personId;