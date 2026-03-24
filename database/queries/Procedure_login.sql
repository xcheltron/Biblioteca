DELIMITER $$

CREATE PROCEDURE login(
	IN _email VARCHAR(100)
)
BEGIN 
	DECLARE error_ocurred BOOLEAN DEFAULT FALSE;	
	
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error_ocurred = TRUE;
	END;
	
	SELECT p._Password, p._Name, p.Phone_number, r.NameRol 
	FROM person AS p
	INNER JOIN rol AS r
		ON p.idRol = r.IdRol
	WHERE _email = p.Email;
	
	IF error_ocurred THEN
		SELECT "Error ocurrido" AS mensaje;
	ELSE
		SELECT "Todo bien" AS mensaje; 
	END IF;

END$$

DELIMITER ;