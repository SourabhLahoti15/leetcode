-- Last updated: 12/17/2025, 10:53:24 AM
# Write your MySQL query statement below
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary FROM Employee e
JOIN
(SELECT departmentId, max(salary) AS salary
FROM Employee
GROUP BY departmentId) m
ON e.departmentId = m.departmentId AND e.salary = m.salary
JOIN Department d
ON e.departmentId = d.id;