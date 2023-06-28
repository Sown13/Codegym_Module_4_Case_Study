use case_study_web_game;

SELECT * FROM game_character gc
JOIN session_character sc ON gc.character_id = sc.game_character_character_id
JOIN game_session gs ON sc.game_session_game_session_id = gs.game_session_id
WHERE gc.is_alive = true AND  gc.is_enemy = false AND gs.game_session_id = 9;

SELECT * FROM character_detail cs JOIN game_character gc on gc.character_id = cs.game_character_character_id
                  JOIN session_character sc ON gc.character_id = sc.game_character_character_id
                  JOIN game_session gs ON sc.game_session_game_session_id = gs.game_session_id
WHERE gc.is_alive = true AND  gc.is_enemy = false AND gs.game_session_id = 9;