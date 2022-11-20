-- CREATE TABLE IF NOT EXISTS PRODUCT
-- (id INTEGER PRIMARY KEY UNIQUE NOT null ,
-- `name` varchar(200),
-- brand varchar(300));

CREATE TABLE IF NOT EXISTS loan_requests ( id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, customer_number VARCHAR(100) NOT NULL, status VARCHAR(100) NOT NULL, `amount` INTEGER NOT NULL);
CREATE TABLE IF NOT EXISTS CUSTOMER_KYC (record_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
created_at VARCHAR NOT NULL ,
created_date VARCHAR NOT NULL ,
updated_at VARCHAR NOT NULL ,
 customer_number VARCHAR(100) NOT NULL,
 email VARCHAR(100) NOT NULL,
 first_name VARCHAR(100) NOT NULL,
 gender VARCHAR(100) NOT NULL,
 middle_name VARCHAR(100) NOT NULL,
 last_name VARCHAR(100) NOT NULL,
 mobile VARCHAR(100) NOT NULL,
 status VARCHAR(100) NOT NULL,
 id INT NOT NULL ,
 id_number INTEGER NOT NULL ,
 monthly_income FLOAT NOT NULL ,
id_type VARCHAR(100) NOT NULL




)