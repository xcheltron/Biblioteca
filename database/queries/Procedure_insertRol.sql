DELIMITER $$
CREATE PROCEDURE insertRol(
	IN newRol VARCHAR(30)
)
BEGIN
	DECLARE error_ocurred BOOLEAN DEFAULT FALSE;
	
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error_ocurred = TRUE;
	END;
	
	INSERT INTO rol (NameRol) VALUES (newRol);
	
	IF error_ocurred THEN
		SELECT "Error ocurrido" AS mensaje;
	ELSE
		SELECT "Todo bien" AS mensaje; 
	END IF;
	
END $$

DELIMITER ;