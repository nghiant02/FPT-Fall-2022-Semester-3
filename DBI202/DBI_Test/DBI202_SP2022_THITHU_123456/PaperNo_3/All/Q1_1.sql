--Q1
CREATE TABLE Roles (
	RoleID INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(100),
)

CREATE TABLE Users (
	Username VARCHAR(30) PRIMARY KEY,
	Password NVARCHAR(20), 
	Email NVARCHAR(200),
	RoleID INT IDENTITY(1,1),
	FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
)

CREATE TABLE Permissions(
	permissionID int IDENTITY(1,1) PRIMARY KEY,
	name nvarchar(50)
)

CREATE TABLE hasPermission(
	RoleID int 
	FOREIGN KEY (RoleID) REFERENCES Roles(RoleID),
	permissionID int 
	FOREIGN KEY (permissionID) REFERENCES Permissions(permissionID) 
)