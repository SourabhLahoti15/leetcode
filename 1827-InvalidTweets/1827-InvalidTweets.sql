-- Last updated: 12/17/2025, 10:51:21 AM
# Write your MySQL query statement below
SELECT tweet_id FROM Tweets
WHERE CHAR_LENGTH(content) > 15;