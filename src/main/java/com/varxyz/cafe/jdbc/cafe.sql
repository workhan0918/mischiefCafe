CREATE TABLE Category(
	cateName	VARCHAR(20)		PRIMARY KEY
);

DROP TABLE Category;
DROP TABLE Menu;

CREATE TABLE Menu(
	name 		VARCHAR(20)		PRIMARY KEY,
	price 		INT UNSIGNED	NOT NULL 	DEFAULT 0,
	category	VARCHAR(20)		NOT NULL,
	stock		INT	UNSIGNED	NOT NULL	DEFAULT 0,
	imgUrl		VARCHAR(100)	NOT NULL	DEFAULT	'default_img',
	CONSTRAINT Category_Name_FK
	FOREIGN KEY(category) REFERENCES Category(cateName)
);

SELECT * FROM Category;
SELECT * FROM Menu;

DELETE FROM Category cateName WHERE cateName = '커피';

SELECT name, price, category, stock FROM Menu WHERE category = '커피';