/*
 * db.sql
 * authors : Thomas Lombart - Martin Vasilev
 *
 * SQL script that creates the database used for Rezozio
 */

CREATE TABLE users (
  login VARCHAR(20) PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(2048) DEFAULT '',
  password VARCHAR
);

CREATE TABLE messages (
  id SERIAL PRIMARY KEY,
  content VARCHAR(140),
  author VARCHAR(20) REFERENCES users,
  date TIMESTAMP DEFAULT now()
);

CREATE TABLE mentions (
  message_id SERIAL REFERENCES messages,
  users_id VARCHAR(20) REFERENCES users
);

CREATE TABLE followers (
  user_followed VARCHAR(20) REFERENCES users,
  user_following VARCHAR(20) REFERENCES users
);

CREATE TABLE avatars (
  login VARCHAR(20) PRIMARY KEY REFERENCES users,
  image BYTEA,
  type VARCHAR
);
