CREATE TABLE Employees(
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Salary NUMBER
);
INSERT INTO Employees VALUES
(1,'John',50000);
INSERT INTO Employees VALUES
(2,'David',60000);
COMMIT;
CREATE OR REPLACE PROCEDURE UpdateSalary(
    emp_id NUMBER,
    percentage NUMBER
)
AS
    emp_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO emp_count
    FROM Employees
    WHERE EmployeeID = emp_id;
    IF emp_count = 0 THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            'Employee ID does not exist'
        );

    END IF;
    UPDATE Employees
    SET Salary = Salary + 
        (Salary * percentage / 100)
    WHERE EmployeeID = emp_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Salary Updated Successfully'
    );
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(
            'Error: ' || SQLERRM
        );
END;
/
BEGIN
    UpdateSalary(1,10);
END;
/

SELECT * FROM Employees;
BEGIN
    UpdateSalary(99,10);
END;
/