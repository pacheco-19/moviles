DROP TABLE IF EXISTS movil;

CREATE TABLE movil (
                       id                BIGINT AUTO_INCREMENT PRIMARY KEY,
                       marca             VARCHAR(50)    NOT NULL,
                       modelo            VARCHAR(80)    NOT NULL,
                       sistema_operativo VARCHAR(20)    NOT NULL,
                       pantalla          VARCHAR(20)    NOT NULL,
                       ram_gb            INT            NOT NULL,
                       almacenamiento_gb INT            NOT NULL,
                       precio            DECIMAL(10, 2) NOT NULL,
                       anio_lanzamiento  INT            NOT NULL
);