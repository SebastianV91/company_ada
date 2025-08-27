DELIMITER $$

CREATE PROCEDURE SP_LLENAR_TABLAS()
BEGIN
    DECLARE done INT DEFAULT 0;

    -- Variables para el cursor
    DECLARE v_id_company INT;
    DECLARE v_codigo_company VARCHAR(50);
    DECLARE v_name_company VARCHAR(100);
    DECLARE v_description_company VARCHAR(255);

    DECLARE v_version_id INT;
    DECLARE v_version VARCHAR(50);
    DECLARE v_version_description VARCHAR(255);

    DECLARE v_version_company_id INT;
    DECLARE v_company_id INT;
    DECLARE v_version_company_description VARCHAR(255);

    DECLARE v_app_id INT;
    DECLARE v_app_code VARCHAR(50);
    DECLARE v_app_name VARCHAR(100);
    DECLARE v_app_description VARCHAR(255);

    -- Definir cursor sobre TMP_LLENAR_CAMPOS eliminando duplicados
    DECLARE CTemporal CURSOR FOR
        SELECT DISTINCT id_company, codigo_company, name_company, description_company,
               version_id, version, version_description,
               version_company_id, company_id, version_company_description,
               app_id, app_code, app_name, app_description
        FROM TMP_LLENAR_CAMPOS;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN CTemporal;

    read_loop: LOOP
        FETCH CTemporal INTO v_id_company, v_codigo_company, v_name_company, v_description_company,
                           v_version_id, v_version, v_version_description,
                           v_version_company_id, v_company_id, v_version_company_description,
                           v_app_id, v_app_code, v_app_name, v_app_description;

        IF done = 1 THEN
            LEAVE read_loop;
        END IF;

        -- Insertar en company si no existe
        INSERT INTO company (id_company, codigo_company, name_company, description_company)
        SELECT v_id_company, v_codigo_company, v_name_company, v_description_company
        WHERE NOT EXISTS (
            SELECT 1 FROM company WHERE id_company = v_id_company
        );

        -- Insertar en application si no existe
        INSERT INTO application (app_id, app_code, app_name, app_description)
        SELECT v_app_id, v_app_code, v_app_name, v_app_description
        WHERE NOT EXISTS (
            SELECT 1 FROM application WHERE app_id = v_app_id
        );

        -- Insertar en version si no existe
        INSERT INTO version (version_id, app_id, version, version_description)
        SELECT v_version_id, v_app_id, v_version, v_version_description
        WHERE NOT EXISTS (
            SELECT 1 FROM version WHERE version_id = v_version_id
        );

        -- Insertar en version_company si no existe
        INSERT INTO version_company (version_company_id, company_id, version_id, version_company_description)
        SELECT v_version_company_id, v_company_id, v_version_id, v_version_company_description
        WHERE NOT EXISTS (
            SELECT 1 FROM version_company WHERE version_company_id = v_version_company_id
        );

    END LOOP;

    CLOSE CTemporal;
END$$

DELIMITER ;