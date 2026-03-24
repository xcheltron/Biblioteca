DELIMITER $$
	CREATE PROCEDURE insertBook(
		in _author VARCHAR(50),
		in _Name_book VARCHAR(100),
		in _sub_title VARCHAR(70),
		in _publication_date int,
		in _quantity int
	)
	BEGIN
	
	DECLARE error_ocurred BOOLEAN DEFAULT FALSE;
	
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error_ocurred = TRUE;
	END;
	
	INSERT INTO book(
		author,
		Name_Book,
		Sub_Title,
		publication_date,
		quantity
	)
	VALUES(
		_author,
		_Name_book,
		_sub_title,
		_publication_date,
		_quantity
	);
	
	IF error_ocurred THEN
		SELECT "Error ocurrido" AS mensaje;
	ELSE
		SELECT "Todo bien" AS mensaje; 
	END IF;
	END $$
DELIMITER ;