USE case_study_web_game;
alter table character_equipment_slot
drop foreign key FKfc31q0svfh33s7ujl0g39db7g;

alter table character_equipment_slot
    add constraint FKfc31q0svfh33s7ujl0g39db7g
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on delete cascade;

alter table character_equipment_slot
drop foreign key FKfc31q0svfh33s7ujl0g39db7g;

alter table character_equipment_slot
    add constraint FKfc31q0svfh33s7ujl0g39db7g
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on update cascade on delete cascade;

alter table character_equipment_slot
drop foreign key FK8sbedmw8v1wipd69lm7yx2cmd;

alter table character_equipment_slot
    add constraint FK8sbedmw8v1wipd69lm7yx2cmd
        foreign key (game_character_character_id) references game_character (character_id)
            on delete cascade;
alter table character_equipment_slot
drop foreign key FK8sbedmw8v1wipd69lm7yx2cmd;

alter table character_equipment_slot
    add constraint FK8sbedmw8v1wipd69lm7yx2cmd
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;

alter table character_item
drop foreign key FKfyx4yb2biu72efg9133ejrqfl;

alter table character_item
    add constraint FKfyx4yb2biu72efg9133ejrqfl
        foreign key (game_character_character_id) references game_character (character_id)
            on delete cascade;
alter table character_item
drop foreign key FKfyx4yb2biu72efg9133ejrqfl;

alter table character_item
    add constraint FKfyx4yb2biu72efg9133ejrqfl
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table character_item
drop foreign key FK12g405kc1q9vtctoj5gy34mwa;

alter table character_item
    add constraint FK12g405kc1q9vtctoj5gy34mwa
        foreign key (game_item_item_id) references game_item (item_id)
            on delete cascade;

alter table character_item
drop foreign key FKfyx4yb2biu72efg9133ejrqfl;

alter table character_item
    add constraint FKfyx4yb2biu72efg9133ejrqfl
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table character_item
drop foreign key FK12g405kc1q9vtctoj5gy34mwa;

alter table character_item
    add constraint FK12g405kc1q9vtctoj5gy34mwa
        foreign key (game_item_item_id) references game_item (item_id)
            on update cascade on delete cascade;

alter table character_item
drop foreign key FKfyx4yb2biu72efg9133ejrqfl;

alter table character_item
    add constraint FKfyx4yb2biu72efg9133ejrqfl
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table character_skill
drop foreign key FKb5q3txdqj906cnfqi4hh52oun;

alter table character_skill
    add constraint FKb5q3txdqj906cnfqi4hh52oun
        foreign key (game_character_character_id) references game_character (character_id)
            on delete cascade;
alter table character_skill
drop foreign key FKb5q3txdqj906cnfqi4hh52oun;

alter table character_skill
    add constraint FKb5q3txdqj906cnfqi4hh52oun
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table character_skill
drop foreign key FKb5q3txdqj906cnfqi4hh52oun;

alter table character_skill
    add constraint FKb5q3txdqj906cnfqi4hh52oun
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;

alter table character_skill
drop foreign key FKomr6e7vp5xqpv19tg7csmu9d3;

alter table character_skill
    add constraint FKomr6e7vp5xqpv19tg7csmu9d3
        foreign key (skill_skill_id) references skill (skill_id)
            on delete cascade;

alter table character_skill
drop foreign key FKb5q3txdqj906cnfqi4hh52oun;

alter table character_skill
    add constraint FKb5q3txdqj906cnfqi4hh52oun
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;

alter table character_skill
drop foreign key FKomr6e7vp5xqpv19tg7csmu9d3;

alter table character_skill
    add constraint FKomr6e7vp5xqpv19tg7csmu9d3
        foreign key (skill_skill_id) references skill (skill_id)
            on update cascade on delete cascade;
alter table game_item_equipment_slot
drop foreign key FKgnixg5bn5326oajlai20jao6r;

alter table game_item_equipment_slot
    add constraint FKgnixg5bn5326oajlai20jao6r
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on delete cascade;
alter table game_item_equipment_slot
drop foreign key FKgnixg5bn5326oajlai20jao6r;

alter table game_item_equipment_slot
    add constraint FKgnixg5bn5326oajlai20jao6r
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on update cascade on delete cascade;
alter table game_item_equipment_slot
drop foreign key FKfdtxavh4taecvddu25u79ebje;

alter table game_item_equipment_slot
    add constraint FKfdtxavh4taecvddu25u79ebje
        foreign key (game_item_item_id) references game_item (item_id)
            on delete cascade;

alter table game_item_equipment_slot
drop foreign key FKgnixg5bn5326oajlai20jao6r;

alter table game_item_equipment_slot
    add constraint FKgnixg5bn5326oajlai20jao6r
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on update cascade on delete cascade;

alter table game_item_equipment_slot
drop foreign key FKfdtxavh4taecvddu25u79ebje;

alter table game_item_equipment_slot
    add constraint FKfdtxavh4taecvddu25u79ebje
        foreign key (game_item_item_id) references game_item (item_id)
            on update cascade on delete cascade;

alter table game_item_equipment_slot
drop foreign key FKgnixg5bn5326oajlai20jao6r;

alter table game_item_equipment_slot
    add constraint FKgnixg5bn5326oajlai20jao6r
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on update cascade on delete cascade;
alter table session_character
drop foreign key FKcpmiiaggrj74pdscu8ydfel1n;

alter table session_character
    add constraint FKcpmiiaggrj74pdscu8ydfel1n
        foreign key (game_character_character_id) references game_character (character_id)
            on delete cascade;
alter table session_character
drop foreign key FKcpmiiaggrj74pdscu8ydfel1n;

alter table session_character
    add constraint FKcpmiiaggrj74pdscu8ydfel1n
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table session_character
drop foreign key FK64j7k66ib4nvr9yk133gwgs6r;

alter table session_character
    add constraint FK64j7k66ib4nvr9yk133gwgs6r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on delete cascade;

alter table session_character
drop foreign key FKcpmiiaggrj74pdscu8ydfel1n;

alter table session_character
    add constraint FKcpmiiaggrj74pdscu8ydfel1n
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table session_character
drop foreign key FK64j7k66ib4nvr9yk133gwgs6r;

alter table session_character
    add constraint FK64j7k66ib4nvr9yk133gwgs6r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on update cascade on delete cascade;

alter table session_character
drop foreign key FKcpmiiaggrj74pdscu8ydfel1n;

alter table session_character
    add constraint FKcpmiiaggrj74pdscu8ydfel1n
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table inventory
drop foreign key FKllb82toqsyxo0kqgx9o1cfe4r;

alter table inventory
    add constraint FKllb82toqsyxo0kqgx9o1cfe4r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on delete cascade;
alter table inventory
drop foreign key FKllb82toqsyxo0kqgx9o1cfe4r;

alter table inventory
    add constraint FKllb82toqsyxo0kqgx9o1cfe4r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on update cascade on delete cascade;
alter table inventory
drop foreign key FKmqj87t4om0fr9d9vuy3626wdt;

alter table inventory
    add constraint FKmqj87t4om0fr9d9vuy3626wdt
        foreign key (game_item_item_id) references game_item (item_id)
            on delete set null;

alter table inventory
drop foreign key FKllb82toqsyxo0kqgx9o1cfe4r;

alter table inventory
    add constraint FKllb82toqsyxo0kqgx9o1cfe4r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on update cascade on delete cascade;

alter table inventory
drop foreign key FKmqj87t4om0fr9d9vuy3626wdt;

alter table inventory
    add constraint FKmqj87t4om0fr9d9vuy3626wdt
        foreign key (game_item_item_id) references game_item (item_id)
            on update cascade on delete set null;

alter table inventory
drop foreign key FKllb82toqsyxo0kqgx9o1cfe4r;

alter table inventory
    add constraint FKllb82toqsyxo0kqgx9o1cfe4r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on update cascade on delete cascade;



