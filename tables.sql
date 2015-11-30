CREATE TYPE race_type AS ENUM ('XCO', 'CX', 'XCM', 'ROAD', 'XCU');

create TABLE race (
  id serial not null,
  name varchar(255) not null,
  description text(2147483647) not null,
  "date" date not null,
  type race_type,
  url varchar(255) not null,
  location varchar(255),
  short_name varchar(255)
);

create type result_status as enum ('FINISHED', 'DNF', 'DSQ', 'DNS');

create table result (
  athleteId int not null,
  raceId int not null,
  status result_status not null,
  totalTime int not null,
  position int not null,
  raceNumber VARCHAR(10) not null,
  importedAt TIMESTAMP
);

create table club (
  id serial not null,
  name varchar(255) not null
)

create table athlete (
  id serial not null,
  name varchar(255) not null,
  yearOfBirth int not null
)
