
CREATE TABLE alert (
  alertid integer NOT NULL,
  type integer NOT NULL,
  patientid integer NOT NULL,
  alertdate timestamp,
  status integer NOT NULL,
  PRIMARY KEY (alertid));

CREATE TABLE healthprofessional (
  healthprofessionalid integer NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(128) NOT NULL,
  type varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  clinic varchar(50) NOT NULL,
  PRIMARY KEY (healthprofessionalid));

CREATE TABLE observation (
  obid integer NOT NULL,
  patientid integer NOT NULL,
  observationtypeid integer NOT NULL,
  obdate date NOT NULL,
  obtime timestamp NOT NULL,
  recoredtime timestamp NOT NULL,
  PRIMARY KEY (obid));
  
CREATE TABLE observationtype (
  obtypeid integer NOT NULL,
  name varchar(50) NOT NULL,
  obtype varchar(50) NOT NULL,
  PRIMARY KEY (obtypeid));

CREATE TABLE observationfactors(
	obfactorid integer, 
	observationtypeid integer, 
	name varchar(50),
	factortype varchar(20),
	PRIMARY KEY (obfactorid));
  
CREATE TABLE observationintinfo (
  obinfoid integer NOT NULL,
  obid integer NOT NULL,
  name varchar(50) NOT NULL,
  info integer NOT NULL,
  PRIMARY KEY (obinfoid));
  
  CREATE TABLE observationstringinfo (
  obinfoid integer NOT NULL,
  obid integer NOT NULL,
  name varchar(50) NOT NULL,
  info varchar(50) NOT NULL,
  PRIMARY KEY (obinfoid));
  
 CREATE TABLE observationdoubleinfo (
  obinfoid integer NOT NULL,
  obid integer NOT NULL,
  name varchar(50) NOT NULL,
  info double precision NOT NULL,
  PRIMARY KEY (obinfoid));

CREATE TABLE patients (
  patientid integer NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(128) NOT NULL,
  dob date NOT NULL,
  name varchar(50) NOT NULL,
  address varchar(50) NOT NULL,
  sex integer NOT NULL,
  healthfriend integer NOT NULL,
  PRIMARY KEY (patientid));

CREATE TABLE patient_type (
  patientid integer NOT NULL,
  typeid integer NOT NULL);

CREATE TABLE types (
  typeid integer NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (typeid));
  
