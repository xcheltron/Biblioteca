/*CREATE DATABASE library*/

USE library;

CREATE TABLE Person(
	IdPerson INT AUTO_INCREMENT PRIMARY KEY,
	idRol INT,
	_Name VARCHAR(50),
	Phone_number VARCHAR(10),
	Email VARCHAR(100) UNIQUE,
	_Password VARCHAR(100), 
	FOREIGN KEY (idRol) REFERENCES Rol(IdRol)		
);

CREATE TABLE Rol(
	IdRol INT AUTO_INCREMENT PRIMARY	KEY,
	NameRol VARCHAR(30)
);

CREATE TABLE Book(
	IdBook INT AUTO_INCREMENT PRIMARY KEY,
	Author VARCHAR (50) NOT NULL,
	Name_Book VARCHAR(100) UNIQUE NOT NULL,
	Sub_Title VARCHAR(70) DEFAULT "not sub_title",
	publication_date INT NOT NULL,
	quantity INT NOT NULL DEFAULT 1	
);

CREATE TABLE Loan(
	IdLoan INT AUTO_INCREMENT PRIMARY KEY,
	idPerson INT,
	loan_date DATE,
	max_date_return DATE,
	return_date DATE, 
	FOREIGN KEY (idPerson) REFERENCES Person(IdPerson)		
);


CREATE TABLE Loan_Detail(
	IdLoan_Detail INT AUTO_INCREMENT PRIMARY	KEY,
	IdLoan INT,
	FOREIGN KEY (IdLoan) REFERENCES loan(IdLoan)
);

CREATE TABLE Fines(
	IdFine INT AUTO_INCREMENT PRIMARY KEY,
	idLoan INT,
	Price DOUBLE,
	Liquidated BOOLEAN,
	Liquidated_date DATE, 
	FOREIGN KEY (idLoan) REFERENCES Loan(idLoan)		
);
