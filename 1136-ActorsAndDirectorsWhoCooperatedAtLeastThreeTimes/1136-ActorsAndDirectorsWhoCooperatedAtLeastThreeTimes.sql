-- Last updated: 12/17/2025, 10:51:43 AM
# Write your MySQL query statement below
SELECT actor_id, director_id 
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >= 3;