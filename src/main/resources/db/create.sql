CREATE DATABASE wildlifetracker;
\c wildlifetracker;
CREATE TABLE rangers (id SERIAL PRIMARY KEY, contactInfo VARCHAR, badgeNumber INTEGER);
CREATE TABLE sightings (id SERIAL PRIMARY KEY, rangersId INTEGER, animalId INTEGER, locationId INTEGER, lastSighting TIMESTAMP);
CREATE TABLE locations (id SERIAL PRIMARY KEY, name VARCHAR);
CREATE TABLE animal (id SERIAL PRIMARY KEY, name VARCHAR, age VARCHAR, health VARCHAR, type VARCHAR);
CREATE DATABASE wildlifetracker_test WITH TEMPLATE wildlifetracker;