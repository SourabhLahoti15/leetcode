-- Last updated: 12/17/2025, 10:52:19 AM
# Write your MySQL query statement below
SELECT name FROM Customer
WHERE referee_id IS NULL OR referee_id != 2;