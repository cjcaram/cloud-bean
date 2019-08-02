DELIMITER $$

DROP TRIGGER IF EXISTS `mercaderia_stock_AFTER_INSERT`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mercaderia_stock_AFTER_INSERT` AFTER INSERT ON `mercaderia_stock` FOR EACH ROW
BEGIN
INSERT INTO mercaderia_stock_audit (
        mercaderia_stock_id, 
        accion, 
        fecha_modificacion, 
        propietario, 
        tipo_calidad_id, 
        tipo_bolsa_id, 
        cantidad_bulto, 
        cantidad_kg, 
        ubicacion, 
        cosecha, 
        gramaje, 
        grano_especie_id, 
        obs, 
        proceso_id, 
        entrada_id, 
        salida_id)
  VALUES (
        NEW.id, 
        0, 
        NOW(), 
        NEW.propietario, 
        NEW.tipo_calidad_id, 
        NEW.tipo_bolsa_id, 
        NEW.cantidad_bulto,
        NEW.cantidad_kg, 
        NEW.ubicacion, 
        NEW.cosecha, 
        NEW.gramaje, 
        NEW.grano_especie_id,
        NEW.obs, 
        NEW.proceso_id,
        NEW.entrada_id, 
        NEW.salida_id);
END$$
DELIMITER ;


DELIMITER $$

DROP TRIGGER IF EXISTS `mercaderia_stock_AFTER_UPDATE`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mercaderia_stock_AFTER_UPDATE` AFTER UPDATE ON `mercaderia_stock` FOR EACH ROW
BEGIN
INSERT INTO mercaderia_stock_audit (
        mercaderia_stock_id, 
        accion, 
        fecha_modificacion, 
        propietario, 
        tipo_calidad_id, 
        tipo_bolsa_id, 
        cantidad_bulto, 
        cantidad_kg, 
        ubicacion, 
        cosecha, 
        gramaje, 
        grano_especie_id, 
        obs, 
        proceso_id, 
        entrada_id, 
        salida_id)
  VALUES (
        NEW.id, 
        1, 
        NOW(), 
        NEW.propietario, 
        NEW.tipo_calidad_id, 
        NEW.tipo_bolsa_id, 
        NEW.cantidad_bulto,
        NEW.cantidad_kg, 
        NEW.ubicacion, 
        NEW.cosecha, 
        NEW.gramaje, 
        NEW.grano_especie_id,
        NEW.obs, 
        NEW.proceso_id,
        NEW.entrada_id, 
        NEW.salida_id);
END$$
DELIMITER ;


DELIMITER $$

DROP TRIGGER IF EXISTS `mercaderia_stock_AFTER_DELETE`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mercaderia_stock_AFTER_DELETE` AFTER DELETE ON `mercaderia_stock` FOR EACH ROW
BEGIN
  INSERT INTO mercaderia_stock_audit (
        mercaderia_stock_id, 
        accion, 
        fecha_modificacion, 
        propietario, 
        tipo_calidad_id, 
        tipo_bolsa_id, 
        cantidad_bulto, 
        cantidad_kg, 
        ubicacion, 
        cosecha, 
        gramaje, 
        grano_especie_id, 
        obs, 
        proceso_id, 
        entrada_id, 
        salida_id)
  VALUES (
        OLD.id, 
        2, 
        NOW(), 
        OLD.propietario, 
        OLD.tipo_calidad_id, 
        OLD.tipo_bolsa_id, 
        OLD.cantidad_bulto,
        OLD.cantidad_kg, 
        OLD.ubicacion, 
        OLD.cosecha, 
        OLD.gramaje, 
        OLD.grano_especie_id,
        OLD.obs, 
        OLD.proceso_id,
        OLD.entrada_id, 
        OLD.salida_id);
END$$
DELIMITER ;