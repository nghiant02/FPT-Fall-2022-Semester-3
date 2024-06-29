CREATE TABLE Cars
(
	SerialNo int,
	Price decimal(12),
	Model Varchar(50),
	primary key(SerialNo),
	foreign key ,
)

CREATE TABLE Options
(	
	Price decimal(8),
	OptionName Varchar(100),
)

CREATE TABLE Salespersons
(	
	SalespersonsID int,
	Name Varchar(100),
	primary key(SalespersonsID),
)

CREATE TABLE Sales
(	
	Saledate date,
)
