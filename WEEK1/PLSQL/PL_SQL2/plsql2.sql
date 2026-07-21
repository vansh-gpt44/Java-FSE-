CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Balance NUMBER
);
INSERT INTO Accounts VALUES (101,'Rahul',5000);
INSERT INTO Accounts VALUES (102,'Amit',3000);

COMMIT;
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    from_account NUMBER,
    to_account NUMBER,
    amount NUMBER
)
AS
    sender_balance NUMBER;
BEGIN

    SELECT Balance
    INTO sender_balance
    FROM Accounts
    WHERE AccountID = from_account;


    IF sender_balance < amount THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'Insufficient funds'
        );
    END IF;


    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account;


    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account;


    COMMIT;


    DBMS_OUTPUT.PUT_LINE(
        'Transfer Successful'
    );


EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Failed: ' || SQLERRM
        );

END;
/
BEGIN
    SafeTransferFunds(101,102,1000);
END;
/
SELECT * FROM Accounts;