-- Last updated: 12/17/2025, 10:53:29 AM
# Write your MySQL query statement below
SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank' FROM Scores;