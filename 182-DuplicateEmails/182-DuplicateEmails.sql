-- Last updated: 12/17/2025, 10:53:26 AM
# Write your MySQL query statement below
SELECT email FROM Person
GROUP BY email
HAVING COUNT(email)>1;