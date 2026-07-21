CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    CONSTRAINT fk_customer
        FOREIGN KEY (CustomerID)
        REFERENCES Customers(CustomerID)
);
INSERT INTO Customers VALUES (1,'Rahul',65,15000,'FALSE');
INSERT INTO Customers VALUES (2,'Amit',45,8000,'FALSE');
INSERT INTO Customers VALUES (3,'Priya',70,20000,'FALSE');
INSERT INTO Customers VALUES (4,'John',30,5000,'FALSE');

INSERT INTO Loans VALUES (101,1,8.5,SYSDATE+10);
INSERT INTO Loans VALUES (102,2,9.0,SYSDATE+50);
INSERT INTO Loans VALUES (103,3,7.5,SYSDATE+20);
INSERT INTO Loans VALUES (104,4,10.0,SYSDATE+5);

COMMIT;
SELECT * FROM Customers;
SELECT * FROM Loans;
BEGIN
    FOR cust IN (
        SELECT CustomerID, Age
        FROM Customers
    )
    LOOP
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/