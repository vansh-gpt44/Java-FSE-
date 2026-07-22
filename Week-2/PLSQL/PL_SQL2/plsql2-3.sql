CREATE TABLE CustomerDetails(
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Email VARCHAR2(100)
);
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    c_id NUMBER,
    c_name VARCHAR2,
    c_email VARCHAR2
)
AS

BEGIN

    INSERT INTO CustomerDetails
    VALUES
    (
        c_id,
        c_name,
        c_email
    );


    COMMIT;


    DBMS_OUTPUT.PUT_LINE(
        'Customer Added Successfully'
    );


EXCEPTION

    WHEN DUP_VAL_ON_INDEX THEN

        DBMS_OUTPUT.PUT_LINE(
            'Error: Customer ID already exists'
        );


    WHEN OTHERS THEN

        DBMS_OUTPUT.PUT_LINE(
            'Error: ' || SQLERRM
        );

END;
/
BEGIN
    AddNewCustomer(
        101,
        'Vansh',
        'vansh@gmail.com'
    );
END;
/
SELECT * FROM CustomerDetails;
BEGIN
    AddNewCustomer(
        101,
        'Rahul',
        'rahul@gmail.com'
    );
END;
/