
CREATE TABLE alert (
  id integer NOT NULL,
  type integer NOT NULL,
  patientid integer NOT NULL,
  alertdate timestamp,
  status integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE confraction (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  frequency integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE diet (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  consumed varchar(50) NOT NULL,
  amount integer,
  PRIMARY KEY (id));

CREATE TABLE exercise (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  type varchar(50) NOT NULL,
  duration integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE exercisetolerance (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  steps integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE healthprofessional (
  id integer NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(128) NOT NULL,
  type varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  clinic varchar(50) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE mood (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  type integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE observation (
  id integer NOT NULL,
  patientid integer NOT NULL,
  type integer NOT NULL,
  obdate date NOT NULL,
  obtime timestamp NOT NULL,
  recoredtime timestamp NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE ob_category (
  id integer NOT NULL,
  obid integer NOT NULL,
  type integer NOT NULL,
  cattype integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE oxygensat (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  sat integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE pain (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  scale integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE patients (
  id integer NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(128) NOT NULL,
  dob date NOT NULL,
  name varchar(50) NOT NULL,
  address varchar(50) NOT NULL,
  sex integer NOT NULL,
  healthfriend integer NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE patient_type (
  patientid integer NOT NULL,
  typeid integer NOT NULL);

CREATE TABLE temperature (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  temp DOUBLE precision NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE types (
  id integer NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE weight (
  id integer NOT NULL,
  obcatid integer NOT NULL,
  amount double precision NOT NULL,
  PRIMARY KEY (id));


ALTER TABLE confraction
  ADD CONSTRAINT confraction_ibfk_1 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE diet
  ADD CONSTRAINT diet_ibfk_2 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE exercise
  ADD CONSTRAINT exercise_ibfk_1 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE exercisetolerance
  ADD CONSTRAINT exercisetolerance_ibfk_2 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE mood
  ADD CONSTRAINT mood_ibfk_1 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE observation
  ADD CONSTRAINT observation_ibfk_1 FOREIGN KEY (patientid) REFERENCES patients (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE ob_category
  ADD CONSTRAINT ob_category_ibfk_1 FOREIGN KEY (obid) REFERENCES observation (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE oxygensat
  ADD CONSTRAINT oxygensat_ibfk_1 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE pain
  ADD CONSTRAINT pain_ibfk_1 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE patient_type
  ADD CONSTRAINT patient_type_ibfk_1 FOREIGN KEY (patientid) REFERENCES patients (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT patient_type_ibfk_2 FOREIGN KEY (typeid) REFERENCES types (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE temperature
  ADD CONSTRAINT temperature_ibfk_1 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weight
  ADD CONSTRAINT weight_ibfk_1 FOREIGN KEY (obcatid) REFERENCES ob_category (id) ON DELETE CASCADE ON UPDATE CASCADE;