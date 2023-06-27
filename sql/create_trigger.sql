USE case_study_web_game;

# Tạo game_character_detail khi tạo nhân vật mới
DELIMITER $$
CREATE TRIGGER create_character_detail
    AFTER INSERT ON game_character
    FOR EACH ROW
BEGIN
    INSERT INTO character_detail (health,magic_atk,magic_def,mana,phys_atk,phys_def,game_character_character_id)
    VALUES (
                       NEW.character_str*1+NEW.character_vit*3+NEW.character_level*2+NEW.character_mind*1,
                       NEW.character_int*3+NEW.character_mind*1,
                       NEW.character_mind*2+NEW.character_vit,
                       NEW.character_int*3+NEW.character_vit*1+NEW.character_level*1+NEW.character_mind*2,
                       NEW.character_str*2+NEW.character_vit*1,
                       NEW.character_mind+NEW.character_vit*2,
                       NEW.character_id);
END$$
DELIMITER ;

# Cập nhật game_character_detail khi có thay đổi trong character
DELIMITER $$
CREATE TRIGGER update_character_detail
    AFTER UPDATE ON game_character
    FOR EACH ROW
BEGIN
    UPDATE character_detail
    SET
        health = NEW.character_str*1+NEW.character_vit*3+NEW.character_level*2+NEW.character_mind*1,
        magic_atk = NEW.character_int*3+NEW.character_mind*1,
        magic_def = NEW.character_mind*2+NEW.character_vit,
        mana = NEW.character_int*3+NEW.character_vit*1+NEW.character_level*1+NEW.character_mind*2,
        phys_atk = NEW.character_str*2+NEW.character_vit*1,
        phys_def = NEW.character_mind+NEW.character_vit*2
    WHERE game_character_character_id = NEW.character_id ;
END$$
DELIMITER ;