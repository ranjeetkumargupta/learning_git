
--Here, the script populates the countries table in our schema with some sample data.

--Spring Boot will automatically pick up this file and run it against an embedded in-memory database, 
--such as our configured H2 instance. This is a good way to seed the database for testing or initialization purposes.

--We can disable this default behavior by setting the spring.sql.init.mode property to never. Additionally, 
--multiple SQL files can also be configured to load the initial data.

INSERT INTO countries (id,name) VALUES (null,'Australia');
INSERT INTO countries (id,name) VALUES (null,France');
INSERT INTO countries (id,name) VALUES (null,'Brazil');
INSERT INTO countries (id,name) VALUES (null,'Italy');
INSERT INTO countries (id,name) VALUES (null,'Canada');