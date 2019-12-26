docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
docker run --name=mysql01 -d mysql/mysql-server:latest
=============================================================================================
docker run -p 3306:3306 --name=mysql01 -e MYSQL_ROOT_PASSWORD=1111 -d mysql/mysql-server:5.7

docker run -d -e MYSQL_ROOT_PASSWORD=root --name mysql1 --network=network mysql:5.7

docker run -p 3306:3306 --name mysql01 -e MYSQL_ROOT_PASSWORD=1111 -d mysql:5.7
=============================================================================================

docker pull mysql/mysql-server:5.7

CREATE USER 'newuser'@'localhost' IDENTIFIED BY '1111';

CREATE DATABASE aquila;

GRANT ALL PRIVILEGES ON aquila.* TO 'newuser'@'localhost';

update mysql.user set host='%' where user='newuser';
=============================================================================================
SELECT host, user FROM mysql.user;

mysqld --verbose --help | grep bind-address

update mysql.user set host='%' where user='newuser';
=============================================================================================
SHOW GRANTS FOR 'root'@'localhost';

mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4




