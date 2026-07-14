-- =====================================================================
-- Base de datos: Sistema de Gestión de Ventas - Fravadent E.I.R.L.
-- =====================================================================

DROP DATABASE IF EXISTS fravadent_db;
CREATE DATABASE fravadent_db CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE fravadent_db;

-- =====================================================================
-- 1. TABLAS MAESTRAS
-- =====================================================================

CREATE TABLE sexo (
    id_sexo     INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(20)  NOT NULL,
    estado      CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE tipo_documento (
    id_tipo_documento  INT AUTO_INCREMENT PRIMARY KEY,
    nombre             VARCHAR(50)  NOT NULL,
    abreviatura        VARCHAR(10)  NOT NULL,
    estado             CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE rol (
    id_rol      INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(50)  NOT NULL,
    estado      CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE departamento (
    id_departamento  INT AUTO_INCREMENT PRIMARY KEY,
    nombre           VARCHAR(80)  NOT NULL,
    estado           CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE provincia (
    id_provincia     INT AUTO_INCREMENT PRIMARY KEY,
    nombre           VARCHAR(80)  NOT NULL,
    id_departamento  INT          NOT NULL,
    estado           CHAR(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT fk_provincia_departamento
        FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento)
);

CREATE TABLE distrito (
    id_distrito   INT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(80)  NOT NULL,
    id_provincia  INT          NOT NULL,
    estado        CHAR(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT fk_distrito_provincia
        FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia)
);

CREATE TABLE tipo_comprobante (
    id_tipo_comprobante  INT AUTO_INCREMENT PRIMARY KEY,
    nombre               VARCHAR(30)  NOT NULL,
    estado               CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE metodo_pago (
    id_metodo_pago  INT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(30)  NOT NULL,
    estado          CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE estado_venta (
    id_estado_venta  INT AUTO_INCREMENT PRIMARY KEY,
    nombre           VARCHAR(30)  NOT NULL,
    estado           CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE categoria_producto (
    id_categoria  INT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(80)  NOT NULL,
    estado        CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE marca (
    id_marca  INT AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(80)  NOT NULL,
    estado    CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE unidad_medida (
    id_unidad_medida  INT AUTO_INCREMENT PRIMARY KEY,
    nombre            VARCHAR(40)  NOT NULL,
    abreviatura       VARCHAR(10)  NOT NULL,
    estado            CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE tipo_movimiento (
    id_tipo_movimiento  INT AUTO_INCREMENT PRIMARY KEY,
    nombre              VARCHAR(30)  NOT NULL,
    estado              CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE tipo_despacho (
    id_tipo_despacho  INT AUTO_INCREMENT PRIMARY KEY,
    nombre            VARCHAR(30)  NOT NULL,
    estado            CHAR(1)      NOT NULL DEFAULT 'A'
);

CREATE TABLE estado_despacho (
    id_estado_despacho  INT AUTO_INCREMENT PRIMARY KEY,
    nombre              VARCHAR(30)  NOT NULL,
    estado              CHAR(1)      NOT NULL DEFAULT 'A'
);

-- =====================================================================
-- 2. TABLAS PRINCIPALES
-- =====================================================================

CREATE TABLE usuario (
    id_usuario         INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_documento  INT          NOT NULL,
    numero_documento   VARCHAR(20)  NOT NULL,
    nombres            VARCHAR(80)  NOT NULL,
    apellido_paterno   VARCHAR(50)  NOT NULL,
    apellido_materno   VARCHAR(50)  NOT NULL,
    id_sexo            INT          NOT NULL,
    username           VARCHAR(50)  NOT NULL UNIQUE,
    password_hash      VARCHAR(255) NOT NULL,
    id_rol             INT          NOT NULL,
    telefono           VARCHAR(20),
    email              VARCHAR(100),
    direccion          VARCHAR(150),
    id_distrito        INT          NOT NULL,
    estado             CHAR(1)      NOT NULL DEFAULT 'A',
    fecha_registro     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_usuario_tipo_documento FOREIGN KEY (id_tipo_documento) REFERENCES tipo_documento(id_tipo_documento),
    CONSTRAINT fk_usuario_sexo          FOREIGN KEY (id_sexo)           REFERENCES sexo(id_sexo),
    CONSTRAINT fk_usuario_rol           FOREIGN KEY (id_rol)            REFERENCES rol(id_rol),
    CONSTRAINT fk_usuario_distrito      FOREIGN KEY (id_distrito)       REFERENCES distrito(id_distrito)
);

CREATE TABLE cliente (
    id_cliente         INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_documento  INT          NOT NULL,
    numero_documento   VARCHAR(20)  NOT NULL,
    nombres            VARCHAR(80),
    apellido_paterno   VARCHAR(50),
    apellido_materno   VARCHAR(50),
    razon_social       VARCHAR(150),
    telefono           VARCHAR(20),
    email              VARCHAR(100),
    direccion          VARCHAR(150),
    id_distrito        INT          NOT NULL,
    estado             CHAR(1)      NOT NULL DEFAULT 'A',
    fecha_registro     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_cliente_tipo_documento FOREIGN KEY (id_tipo_documento) REFERENCES tipo_documento(id_tipo_documento),
    CONSTRAINT fk_cliente_distrito       FOREIGN KEY (id_distrito)       REFERENCES distrito(id_distrito)
);

CREATE TABLE proveedor (
    id_proveedor    INT AUTO_INCREMENT PRIMARY KEY,
    razon_social    VARCHAR(150) NOT NULL,
    ruc             VARCHAR(20)  NOT NULL,
    telefono        VARCHAR(20),
    email           VARCHAR(100),
    direccion       VARCHAR(150),
    id_distrito     INT          NOT NULL,
    estado          CHAR(1)      NOT NULL DEFAULT 'A',
    fecha_registro  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_proveedor_distrito FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito)
);

CREATE TABLE producto (
    id_producto          INT AUTO_INCREMENT PRIMARY KEY,
    codigo_sku           VARCHAR(30)   NOT NULL UNIQUE,
    nombre_descripcion   VARCHAR(200)  NOT NULL,
    id_categoria         INT           NOT NULL,
    id_marca             INT           NOT NULL,
    id_unidad_medida     INT           NOT NULL,
    precio_compra        DECIMAL(10,2) NOT NULL,
    precio_venta         DECIMAL(10,2) NOT NULL,
    stock_actual         INT           NOT NULL DEFAULT 0,
    stock_minimo         INT           NOT NULL DEFAULT 0,
    estado               CHAR(1)       NOT NULL DEFAULT 'A',
    CONSTRAINT fk_producto_categoria     FOREIGN KEY (id_categoria)     REFERENCES categoria_producto(id_categoria),
    CONSTRAINT fk_producto_marca         FOREIGN KEY (id_marca)         REFERENCES marca(id_marca),
    CONSTRAINT fk_producto_unidad_medida FOREIGN KEY (id_unidad_medida) REFERENCES unidad_medida(id_unidad_medida)
);

-- =====================================================================
-- 3. VENTAS Y DESPACHO
-- =====================================================================

CREATE TABLE venta (
    id_venta            INT AUTO_INCREMENT PRIMARY KEY,
    nro_comprobante     VARCHAR(20)   NOT NULL,
    id_tipo_comprobante INT           NOT NULL,
    fecha_hora          DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_cliente          INT           NOT NULL,
    id_usuario          INT           NOT NULL,
    id_metodo_pago      INT           NOT NULL,
    id_estado_venta     INT           NOT NULL,
    monto_total         DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_venta_tipo_comprobante FOREIGN KEY (id_tipo_comprobante) REFERENCES tipo_comprobante(id_tipo_comprobante),
    CONSTRAINT fk_venta_cliente          FOREIGN KEY (id_cliente)          REFERENCES cliente(id_cliente),
    CONSTRAINT fk_venta_usuario          FOREIGN KEY (id_usuario)          REFERENCES usuario(id_usuario),
    CONSTRAINT fk_venta_metodo_pago      FOREIGN KEY (id_metodo_pago)      REFERENCES metodo_pago(id_metodo_pago),
    CONSTRAINT fk_venta_estado_venta     FOREIGN KEY (id_estado_venta)     REFERENCES estado_venta(id_estado_venta)
);

CREATE TABLE detalle_venta (
    id_detalle       INT AUTO_INCREMENT PRIMARY KEY,
    id_venta         INT           NOT NULL,
    id_producto      INT           NOT NULL,
    cantidad         INT           NOT NULL,
    precio_unitario  DECIMAL(10,2) NOT NULL,
    subtotal         DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_detalle_venta_venta    FOREIGN KEY (id_venta)    REFERENCES venta(id_venta),
    CONSTRAINT fk_detalle_venta_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE despacho (
    id_despacho          INT AUTO_INCREMENT PRIMARY KEY,
    id_venta             INT       NOT NULL UNIQUE,
    id_usuario           INT       NOT NULL,
    id_tipo_despacho     INT       NOT NULL,
    id_estado_despacho   INT       NOT NULL,
    direccion_entrega    VARCHAR(150),
    id_distrito          INT       NOT NULL,
    fecha_programada     DATETIME,
    fecha_entrega_real   DATETIME,
    observaciones        VARCHAR(255),
    CONSTRAINT fk_despacho_venta           FOREIGN KEY (id_venta)           REFERENCES venta(id_venta),
    CONSTRAINT fk_despacho_usuario         FOREIGN KEY (id_usuario)         REFERENCES usuario(id_usuario),
    CONSTRAINT fk_despacho_tipo_despacho   FOREIGN KEY (id_tipo_despacho)   REFERENCES tipo_despacho(id_tipo_despacho),
    CONSTRAINT fk_despacho_estado_despacho FOREIGN KEY (id_estado_despacho) REFERENCES estado_despacho(id_estado_despacho),
    CONSTRAINT fk_despacho_distrito        FOREIGN KEY (id_distrito)        REFERENCES distrito(id_distrito)
);

-- =====================================================================
-- 4. COMPRAS Y CONTROL DE INVENTARIO
-- =====================================================================

CREATE TABLE compra (
    id_compra      INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor   INT           NOT NULL,
    id_usuario     INT           NOT NULL,
    fecha_hora     DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    monto_total    DECIMAL(10,2) NOT NULL,
    estado         CHAR(1)       NOT NULL DEFAULT 'A',
    CONSTRAINT fk_compra_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor),
    CONSTRAINT fk_compra_usuario   FOREIGN KEY (id_usuario)   REFERENCES usuario(id_usuario)
);

CREATE TABLE detalle_compra (
    id_detalle_compra  INT AUTO_INCREMENT PRIMARY KEY,
    id_compra          INT           NOT NULL,
    id_producto        INT           NOT NULL,
    cantidad           INT           NOT NULL,
    precio_unitario    DECIMAL(10,2) NOT NULL,
    subtotal           DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_detalle_compra_compra   FOREIGN KEY (id_compra)   REFERENCES compra(id_compra),
    CONSTRAINT fk_detalle_compra_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE movimiento_inventario (
    id_movimiento      INT AUTO_INCREMENT PRIMARY KEY,
    id_producto        INT       NOT NULL,
    id_tipo_movimiento INT       NOT NULL,
    cantidad           INT       NOT NULL,
    fecha_hora         DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    referencia_tipo    VARCHAR(20),
    referencia_id      INT,
    id_usuario         INT       NOT NULL,
    observacion        VARCHAR(255),
    CONSTRAINT fk_movimiento_producto        FOREIGN KEY (id_producto)        REFERENCES producto(id_producto),
    CONSTRAINT fk_movimiento_tipo_movimiento FOREIGN KEY (id_tipo_movimiento) REFERENCES tipo_movimiento(id_tipo_movimiento),
    CONSTRAINT fk_movimiento_usuario         FOREIGN KEY (id_usuario)         REFERENCES usuario(id_usuario)
);
</USER_REQUEST>
<ADDITIONAL_METADATA>
The current local time is: 2026-07-14T11:41:59-05:00.
</ADDITIONAL_METADATA>
<USER_SETTINGS_CHANGE>
The user changed setting `Model Selection` from Gemini 3.5 Flash (Medium) to Gemini 3.1 Pro (High). No need to comment on this change if the user doesn't ask about it. If reporting what model you are, please use a human readable name instead of the exact string.
</USER_SETTINGS_CHANGE>