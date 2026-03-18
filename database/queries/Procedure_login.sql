DELIMITER $$
CREATE PROCEDURE login(
	IN _email VARCHAR (100)
)
	BEGIN 
		DECLARE error_ocurred BOOLEAN DEFAULT FALSE;	
	
		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		BEGIN
			SET error_ocurred = TRUE;
		END;
		
		SELECT person._Password
		FROM person
		WHERE _email = person.Email;
		
		
		IF error_ocurred THEN
			SELECT "Error ocurrido" AS mensaje;
		ELSE
			SELECT "Todo bien" AS mensaje; 
		END IF;
	END$$
DELIMITER ;