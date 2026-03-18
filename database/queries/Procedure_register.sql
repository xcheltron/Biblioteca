DELIMITER $$
CREATE PROCEDURE register(
	IN	_Namerol VARCHAR(30), 
	IN _Name_ VARCHAR (50),
	IN _Phone_number VARCHAR(10),
	IN _email VARCHAR (100),
	IN _password_hashed VARCHAR(100)
)
	BEGIN 
		DECLARE error_ocurred BOOLEAN DEFAULT FALSE;	
		DECLARE idrol INT;
		
		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		BEGIN
			SET error_ocurred = TRUE;
		END;
		
		SELECT rol.IdRol INTO idrol
		FROM	rol
		WHERE	rol.NameRol = _Namerol
		LIMIT 1;
		
		INSERT INTO person (idRol, _Name, Phone_number, email, _Password) VALUES
		(idrol, _Namerol, _Name_, _Phone_number, _email, _password_hashed);
		
		IF error_ocurred THEN
			SELECT "Error ocurrido" AS mensaje;
		ELSE
			SELECT "Todo bien" AS mensaje; 
		END IF;
	END$$
DELIMITER ;