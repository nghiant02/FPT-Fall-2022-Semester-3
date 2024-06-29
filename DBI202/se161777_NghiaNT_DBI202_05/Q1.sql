CREATE TABLE Salespersons(
[SalepersonID] INT PRIMARY KEY,
[NAME] Varchar(100)
)
CREATE TABLE Cars(
[SerialNo] INT PRIMARY KEY,
[Price] DECIMAL(12),
[Model] VARCHAR(50),
SalepersonID INT FOREIGN KEY REFERENCES dbo.Salespersons(SalepersonID),
[Saledate] date
)
CREATE TABLE Options(
[OptionName] VARCHAR(100),
[Price] DECIMAL(8),
SerialNo INT FOREIGN KEY REFERENCES dbo.Cars(SerialNo),
PRIMARY KEY (OptionName,SerialNo)
)
