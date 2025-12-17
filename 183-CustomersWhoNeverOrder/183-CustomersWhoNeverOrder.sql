-- Last updated: 12/17/2025, 10:53:25 AM
# Write your MySQL query statement below
SELECT c.name AS Customers FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE o.customerId IS NULL;