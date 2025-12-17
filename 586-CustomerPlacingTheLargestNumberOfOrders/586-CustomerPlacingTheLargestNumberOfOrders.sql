-- Last updated: 12/17/2025, 10:52:18 AM
# Write your MySQL query statement below
SELECT customer_number FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;