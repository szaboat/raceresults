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
