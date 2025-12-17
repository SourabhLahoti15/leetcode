-- Last updated: 12/17/2025, 10:53:30 AM
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE off INT;
    SET off = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT salary
      FROM Employee 
      ORDER BY salary DESC 
      LIMIT 1 OFFSET off
  );
END