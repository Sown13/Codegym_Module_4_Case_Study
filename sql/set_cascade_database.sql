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
drop foreign key FK7rgg6b0rrsqnbibghpw0p3284;

alter table character_item
    add constraint FK7rgg6b0rrsqnbibghpw0p3284
        foreign key (item_item_id) references item (item_id)
            on delete cascade;

alter table character_item
drop foreign key FKfyx4yb2biu72efg9133ejrqfl;

alter table character_item
    add constraint FKfyx4yb2biu72efg9133ejrqfl
        foreign key (game_character_character_id) references game_character (character_id)
            on update cascade on delete cascade;
alter table character_item
drop foreign key FK7rgg6b0rrsqnbibghpw0p3284;

alter table character_item
    add constraint FK7rgg6b0rrsqnbibghpw0p3284
        foreign key (item_item_id) references item (item_id)
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
alter table item_equipment_slot
drop foreign key FKli98rjngh1twawcfvaut3uy9e;

alter table item_equipment_slot
    add constraint FKli98rjngh1twawcfvaut3uy9e
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on delete cascade;
alter table item_equipment_slot
drop foreign key FKli98rjngh1twawcfvaut3uy9e;

alter table item_equipment_slot
    add constraint FKli98rjngh1twawcfvaut3uy9e
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on update cascade on delete cascade;
alter table item_equipment_slot
drop foreign key FKbaoixndgp4ivk11dv738sf274;

alter table item_equipment_slot
    add constraint FKbaoixndgp4ivk11dv738sf274
        foreign key (item_item_id) references item (item_id)
            on delete cascade;

alter table item_equipment_slot
drop foreign key FKli98rjngh1twawcfvaut3uy9e;

alter table item_equipment_slot
    add constraint FKli98rjngh1twawcfvaut3uy9e
        foreign key (equipment_slot_equipment_slot_id) references equipment_slot (equipment_slot_id)
            on update cascade on delete cascade;

alter table item_equipment_slot
drop foreign key FKbaoixndgp4ivk11dv738sf274;

alter table item_equipment_slot
    add constraint FKbaoixndgp4ivk11dv738sf274
        foreign key (item_item_id) references item (item_id)
            on update cascade on delete cascade;

alter table item_equipment_slot
drop foreign key FKli98rjngh1twawcfvaut3uy9e;

alter table item_equipment_slot
    add constraint FKli98rjngh1twawcfvaut3uy9e
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
drop foreign key FKbxsjom23hiq3is3ludy092ydq;

alter table inventory
    add constraint FKbxsjom23hiq3is3ludy092ydq
        foreign key (item_item_id) references item (item_id)
            on delete set null;

alter table inventory
drop foreign key FKllb82toqsyxo0kqgx9o1cfe4r;

alter table inventory
    add constraint FKllb82toqsyxo0kqgx9o1cfe4r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on update cascade on delete cascade;

alter table inventory
drop foreign key FKbxsjom23hiq3is3ludy092ydq;

alter table inventory
    add constraint FKbxsjom23hiq3is3ludy092ydq
        foreign key (item_item_id) references item (item_id)
            on update cascade on delete set null;

alter table inventory
drop foreign key FKllb82toqsyxo0kqgx9o1cfe4r;

alter table inventory
    add constraint FKllb82toqsyxo0kqgx9o1cfe4r
        foreign key (game_session_game_session_id) references game_session (game_session_id)
            on update cascade on delete cascade;



