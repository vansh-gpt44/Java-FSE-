CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER(10,2)
);
INSERT INTO Employees VALUES (1, 'Ankit', 'IT', 50000);
INSERT INTO Employees VALUES (2, 'Sneha', 'HR', 45000);
INSERT INTO Employees VALUES (3, 'Vikas', 'IT', 60000);
INSERT INTO Employees VALUES (4, 'Pooja', 'Finance', 55000);
INSERT INTO Employees VALUES (5, 'Rohit', 'IT', 70000);

COMMIT;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus updated successfully.');
END;
/
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/