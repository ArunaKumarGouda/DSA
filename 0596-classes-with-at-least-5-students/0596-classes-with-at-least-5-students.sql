# Write your MySQL query statem
SELECT class 
FROM Courses 
GROUP BY class
HAVING COUNT(student) >= 5;