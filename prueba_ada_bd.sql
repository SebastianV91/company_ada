CREATE DATABASE db_company;

USE db_company;

CREATE TABLE `company` (
  `id_company` int(11) NOT NULL,
  `codigo_company` varchar(50) NOT NULL,
  `name_company` varchar(100) NOT NULL,
  `description_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_company`),
  UNIQUE KEY `codigo_company` (`codigo_company`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `application` (
  `app_id` int(11) NOT NULL,
  `app_code` varchar(50) NOT NULL,
  `app_name` varchar(100) NOT NULL,
  `app_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`app_id`),
  UNIQUE KEY `app_code` (`app_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `version` (
  `version_id` int(11) NOT NULL,
  `app_id` int(11) NOT NULL,
  `version` varchar(50) NOT NULL,
  `version_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`version_id`),
  KEY `fk_version_app` (`app_id`),
  CONSTRAINT `fk_version_app` FOREIGN KEY (`app_id`) REFERENCES `application` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `version_company` (
  `version_company_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `version_id` int(11) NOT NULL,
  `version_company_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`version_company_id`),
  KEY `fk_vc_company` (`company_id`),
  KEY `fk_vc_version` (`version_id`),
  CONSTRAINT `fk_vc_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id_company`),
  CONSTRAINT `fk_vc_version` FOREIGN KEY (`version_id`) REFERENCES `version` (`version_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

    -- Definir cursor sobre TMP_LLENAR_CAMPOS
    DECLARE CTemporal CURSOR FOR
        SELECT id_company, codigo_company, name_company, description_company,
               version_id, version, version_description,
               version_company_id, company_id, version_company_description,
               app_id, app_code, app_name, app_description
        FROM TMP_LLENAR_CAMPOS;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    -- Abrir cursor
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
        WHERE NOT EXISTS (SELECT 1 FROM company WHERE id_company = v_id_company);

        -- Insertar en application si no existe
        INSERT INTO application (app_id, app_code, app_name, app_description)
        SELECT v_app_id, v_app_code, v_app_name, v_app_description
        WHERE NOT EXISTS (SELECT 1 FROM application WHERE app_id = v_app_id);

        -- Insertar en version si no existe
        INSERT INTO version (version_id, app_id, version, version_description)
        SELECT v_version_id, v_app_id, v_version, v_version_description
        WHERE NOT EXISTS (SELECT 1 FROM version WHERE version_id = v_version_id);

        -- Insertar en version_company si no existe
        INSERT INTO version_company (version_company_id, company_id, version_id, version_company_description)
        SELECT v_version_company_id, v_company_id, v_version_id, v_version_company_description
        WHERE NOT EXISTS (SELECT 1 FROM version_company WHERE version_company_id = v_version_company_id);

    END LOOP;

    CLOSE CTemporal;
END$$

DELIMITER ;

CREATE TABLE TMP_LLENAR_CAMPOS (
    -- Datos de company
    id_company              INT,
    codigo_company          VARCHAR(50),
    name_company            VARCHAR(100),
    description_company     VARCHAR(255),

    -- Datos de application
    app_id                  INT,
    app_code                VARCHAR(50),
    app_name                VARCHAR(100),
    app_description         VARCHAR(255),

    -- Datos de version
    version_id              INT,
    version                 VARCHAR(50),
    version_description     VARCHAR(255),

    -- Datos de version_company
    version_company_id      INT,
    company_id              INT,
    version_company_description VARCHAR(255)
);

INSERT INTO TMP_LLENAR_CAMPOS (
    id_company, codigo_company, name_company, description_company,
    version_id, version, version_description,
    version_company_id, company_id, version_company_description,
    app_id, app_code, app_name, app_description
)
VALUES
-- Empresa 1 con una app y versión
(1, 'C001', 'TechCorp', 'Empresa de software',
 1, 'v1.0', 'Primera versión del ERP',
 1, 1, 'TechCorp usa ERP v1.0',
 1, 'APP01', 'ERP System', 'Sistema de planificación empresarial'),

-- Empresa 2 con otra app y versión
(2, 'C002', 'InnovaSA', 'Empresa de innovación tecnológica',
 2, 'v2.0', 'Segunda versión del CRM',
 2, 2, 'InnovaSA usa CRM v2.0',
 2, 'APP02', 'CRM Tool', 'Herramienta de gestión de clientes');

CALL SP_LLENAR_TABLAS();

SELECT * FROM company;

-- Ver aplicaciones
SELECT * FROM application;

-- Ver versiones
SELECT * FROM version;

-- Ver asociaciones empresa - versión
SELECT * FROM version_company;

-- Consulta JOIN final para ver todo relacionado
SELECT 
    c.name_company AS company,
    a.app_name AS application,
    v.version AS version,
    vc.version_company_description AS detalle
FROM version_company vc
JOIN company c ON vc.company_id = c.id_company
JOIN version v ON vc.version_id = v.version_id
JOIN application a ON v.app_id = a.app_id;
