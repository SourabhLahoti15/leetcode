-- Last updated: 12/17/2025, 10:53:32 AM
# Write your MySQL query statement below
SELECT 
  MAX(salary) AS secondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);
