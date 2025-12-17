-- Last updated: 12/17/2025, 10:52:15 AM
# Write your MySQL query statement below
SELECT class FROM Courses
GROUP BY class
HAVING COUNT(*) >= 5;