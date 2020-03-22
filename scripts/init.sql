CREATE USER tech_lead WITH PASSWORD 'tech_lead';

DROP DATABASE IF EXISTS order_database;

CREATE DATABASE order_database;

GRANT ALL PRIVILEGES ON DATABASE order_database TO tech_lead;

DROP DATABASE IF EXISTS inventory_database;

CREATE DATABASE inventory_database;

GRANT ALL PRIVILEGES ON DATABASE inventory_database TO tech_lead;


DROP DATABASE IF EXISTS payment_database;

CREATE DATABASE payment_database;

GRANT ALL PRIVILEGES ON DATABASE payment_database TO tech_lead;