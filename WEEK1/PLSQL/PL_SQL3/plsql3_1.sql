CREATE TABLE Account (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    AccountType VARCHAR2(20),
    Balance NUMBER(10,2)
);
INSERT INTO Account VALUES (101, 'Rahul', 'Savings', 50000);
INSERT INTO Account VALUES (102, 'Priya', 'Savings', 30000);
INSERT INTO Account VALUES (103, 'Amit', 'Current', 80000);
INSERT INTO Account VALUES (104, 'Neha', 'Savings', 45000);
INSERT INTO Account VALUES (105, 'Rohan', 'Current', 25000);

COMMIT;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Account
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/