# Projeto-DAO-JDBC
 Projeto DAO com MySql


# Codigo usando para criar as Tabelas do db
<p>CREATE TABLE department (</p>
<p>  Id int(11) NOT NULL AUTO_INCREMENT,</p>
<p>  Name varchar(60) DEFAULT NULL,</p>
<p>  PRIMARY KEY (Id)</p>
<p>);</p>

<p>CREATE TABLE seller (</p>
<p>  Id int(11) NOT NULL AUTO_INCREMENT,</p>
<p>  Name varchar(60) NOT NULL,</p>
<p>  Email varchar(100) NOT NULL,</p>
<p>  BirthDate datetime(6) NOT NULL,</p>
<p>  BaseSalary double NOT NULL,</p>
<p>  DepartmentId int(11) NOT NULL,</p>
<p>  PRIMARY KEY (Id),</p>
<p>  FOREIGN KEY (DepartmentId) REFERENCES department (id)</p>
<p>);</p>
