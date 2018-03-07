# SQL Memento

### Create a table

```sql
CREATE TABLE books (
    id INTEGER PRIMARY KEY,
    name TEXT,
    rating INTEGER);

CREATE TABLE songs (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT,
    artist TEXT,
    mood TEXT,
    duration INTEGER,
    released INTEGER);
```
----
### Insert

```sql
INSERT INTO books VALUES(1, "1984", 5);
INSERT INTO songs (title, artist, mood, duration, released)
  VALUES ("Bohemian Rhapsody", "Queen", "epic", 60, 1975);
```
----
### Select

```sql
SELECT * FROM books;
SELECT name FROM books;
SELECT name FROM books WHERE rating > 4 ORDER BY rating;
SELECT * FROM diary_logs WHERE
       food LIKE "%ice cream%" AND activity LIKE "%running%";
```

##### And/Or

```sql
SELECT title FROM songs WHERE mood = 'epic' OR released > 1990;
SELECT title FROM songs
  WHERE mood = 'epic'
  AND released > 1990
  AND duration < 240;
```

##### Aggregation

```sql
SELECT MAX(rating) from books;
SELECT SUM(duration) from songs;
```

##### In

```sql
SELECT title FROM songs
  WHERE artist
  IN (SELECT name FROM artists WHERE name = "Queen");
```

##### Having

```sql
SELECT author, SUM(words) AS total_words FROM books
  GROUP BY author
  HAVING total_words > 1000000;

SELECT author, AVG(words) AS avg_words FROM books
  GROUP BY author
  HAVING avg_words > 150000;
```

##### Case

```sql
SELECT COUNT(*),
  CASE
    WHEN number_grade > 90 THEN "A"
    WHEN number_grade > 80 THEN "B"
    WHEN number_grade > 70 THEN "C"
    ELSE "F"
  END AS "letter_grade"
FROM student_grades
GROUP BY letter_grade;
```

##### Join
```sql
/* cross join */
SELECT * FROM student_grades, students;

/* implicit inner join */
SELECT * FROM student_grades, students
    WHERE student_grades.student_id = students.id;

/* explicit inner join - JOIN */
SELECT students.first_name, students.last_name, students.email,
    student_grades.test, student_grades.grade FROM students
    JOIN student_grades
    ON students.id = student_grades.student_id
    WHERE grade > 90;

SELECT persons.name, hobbies.name FROM persons
  JOIN hobbies
  ON persons.id = hobbies.person_id
  WHERE persons.name = "Bobby McBobbyFace";

/* outer join */
SELECT students.first_name, students.last_name, student_projects.title
    FROM students
    LEFT OUTER JOIN student_projects
    ON students.id = student_projects.student_id;

/* (Tip: You should always GROUP BY on the column that is most likely to be unique in a row.) */
SELECT customers.name, customers.email, SUM(orders.price) AS total_money
  FROM customers
  LEFT OUTER JOIN orders
  ON customers.id = orders.customer_id
  GROUP BY customers.id;

/* self join */
SELECT students.first_name, students.last_name, buddies.email AS buddy_email
  FROM students
  JOIN students buddies
  ON students.buddy_id = buddies.id;

SELECT movies.title, sequel.title AS sequel_title
  FROM movies
  LEFT OUTER JOIN movies sequel
  ON movies.sequel_id = sequel.id;

/* multiple joins */
SELECT a.title, b.title FROM project_pairs
  JOIN student_projects a
  ON project_pairs.project1_id = a.id
  JOIN student_projects b
  ON project_pairs.project2_id = b.id;

SELECT friends1.fullname, friends2.fullname AS buddy
    FROM friends
    JOIN persons friends1
    ON friends.person1_id = friends1.id
    JOIN persons friends2
    ON friends.person2_id = friends2.id;
```

---
### Databases

##### Update

```sql
UPDATE customers SET age = 33 WHERE id = 73;
UPDATE documents SET author = "Jackie Draper"
  WHERE author = "Jackie Paper";
UPDATE users SET deleted = true
  WHERE id = 1 LIMIT 1;
```

##### Delete

```sql
DELETE FROM customers WHERE id = 73;
DELETE FROM documents WHERE title = "Things I'm Afraid Of";
```

##### Alter table

```sql
ALTER TABLE diary_logs ADD emotion TEXT;
ALTER TABLE diary_logs ADD emotion TEXT default "unknown";
```

##### Transactions

```sql
BEGIN TRANSACTION;
UPDATE people SET husband = "Winston" WHERE user_id = 1;
UPDATE people SET wife = "Winnefer" WHERE user_id = 2;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO user_badges VALUES (1, "SQL Master");
UPDATE user SET recent_activity = "Earned SQL Master badge" WHERE id = 1;
COMMIT;
```

##### Granting

```sql
GRANT FULL ON TABLE users TO super_admin;
GRANT SELECT ON TABLE users TO analyzing_user;
```
----
### Basic Example

```sql
CREATE TABLE phones (id INTEGER PRIMARY KEY, model TEXT, brand TEXT, price INTEGER);

INSERT INTO phones VALUES(1, "iPhone 6", "Apple", 600);
INSERT INTO phones VALUES(2, "Galaxy S7", "Samsung", 650);
INSERT INTO phones VALUES(3, "Pixel", "Google", 700);
INSERT INTO phones VALUES(4, "LG G5", "LG", 450);
INSERT INTO phones VALUES(5, "iPhone 7 Plus", "Apple", 750);

SELECT brand from phones ORDER BY brand;
SELECT model from phones WHERE price > 600;
SELECT brand, MAX(price) from phones;
```

### Advanced Example

```sql
CREATE TABLE marvels (ID INTEGER PRIMARY KEY,
    name TEXT,
    popularity INTEGER,
    alignment TEXT,
    gender TEXT,
    height_m NUMERIC,
    weight_kg NUMERIC,
    hometown TEXT,
    intelligence INTEGER,
    strength INTEGER,
    speed INTEGER,
    durability INTEGER,
    energy_Projection INTEGER,
    fighting_Skills INTEGER);

INSERT INTO marvels VALUES(1, "Spider Man", 1, "Good", "Male", 1.78, 75.75, "USA", 4, 4, 3, 3, 1, 4);
INSERT INTO marvels VALUES(2, "Iron Man", 20, "Neutral", "Male", 1.98, 102.58, "USA", 6, 6, 5, 6, 6, 4);
INSERT INTO marvels VALUES(3, "Hulk", 18, "Neutral", "Male", 2.44, 635.29, "USA", 6, 7, 3, 7, 5, 4);
INSERT INTO marvels VALUES(4, "Wolverine", 3, "Good", "Male", 1.6, 88.46, "Canada", 2, 4, 2, 4, 1, 7);
INSERT INTO marvels VALUES(5, "Thor", 5, "Good", "Male", 1.98, 290.3, "Norway", 2, 7, 7, 6, 6, 4);
INSERT INTO marvels VALUES(6, "Green Goblin", 91, "Bad", "Male", 1.93, 174.63, "USA", 4, 4, 3, 4, 3, 3);
INSERT INTO marvels VALUES(7, "Magneto", 11, "Neutral", "Male", 1.88, 86.18, "Germany", 6, 3, 5, 4, 6, 4);
INSERT INTO marvels VALUES(8, "Thanos", 47, "Bad", "Male", 2.01, 446.79, "Titan", 6, 7, 7, 6, 6, 4);
INSERT INTO marvels VALUES(9, "Loki", 32, "Bad", "Male", 1.93, 238.14, "Jotunheim", 5, 5, 7, 6, 6, 3);
INSERT INTO marvels VALUES(10, "Doctor Doom", 19, "Bad", "Male", 2.01, 188.24, "Latveria", 6, 4, 5, 6, 6, 4);
INSERT INTO marvels VALUES(11, "Jean Greay", 8, "Good", "Female", 1.68, 52.16, "USA", 3, 2, 7, 7, 7, 4);
INSERT INTO marvels VALUES(12, "Rogue", 4, "Good", "Female", 1.73, 54.43, "USA", 7, 7, 7, 7, 7, 7);

SELECT name, MAX(intelligence) FROM marvels;
SELECT name, MIN(fighting_skills) FROM marvels;

SELECT name as popular_vilain FROM marvels WHERE popularity < 40 AND alignment = "Bad";

SELECT name as impressive_heroes, height_m, weight_kg, fighting_Skills
  FROM marvels
  WHERE height_m > 1.90
  OR weight_kg > 200
  OR fighting_Skills > 6;

SELECT name, popularity FROM marvels
    GROUP BY popularity
    HAVING popularity < 20;

SELECT name, speed,
    CASE
        WHEN speed > 6  THEN "Slow"
        WHEN speed > 4 AND speed <= 6 THEN "Medium"
        ELSE "Fast"
    END AS "description_speed"
FROM marvels;
```

### Database example

```sql
CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, password TEXT);

INSERT INTO users (name, email, password) VALUES ("John", "johndoe@gmail.com", "password");
INSERT INTO users (name, email, password) VALUES ("Anonymous Guy", "anonymous@anonymous.net", "IamAnonymous");
INSERT INTO users (name, email, password) VALUES ("Robert", "superrobert@hotmail.com", "2JFZH3RH3hfh38j");

UPDATE users SET email = "imstillanonymous@anonymous.net" WHERE id = 2;
UPDATE users SET password = "john1987" WHERE name = "John" AND email = "johndoe@gmail.com";
DELETE FROM users WHERE id = 3;
```
