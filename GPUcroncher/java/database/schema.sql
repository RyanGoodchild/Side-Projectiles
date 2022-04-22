BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS farms;
DROP TABLE IF EXISTS rigs;
DROP TABLE IF EXISTS cards;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_farm_id;
DROP SEQUENCE IF EXISTS seq_rig_id;
DROP SEQUENCE IF EXISTS seq_card_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');



CREATE SEQUENCE seq_farm_id
        INCREMENT BY 1
        NO MAXVALUE
        NOMINVALUE
        CACHE 1;
        
CREATE TABLE farms (
        farm_id int DEFAULT nextval('seq_farm_id'::regclass) NOT NULL,
        user_id int NOT NULL REFERENCES users (user_id),
        rig_id int REFERENCES rigs (rig_id),
        bank_total numeric,
        eth_total int,
        CONSTRAINT PK_farm PRIMARY KEY (farm_id)
);



CREATE SEQUENCE seq_rig_id
        INCREMENT BY 1
        NO MAXVALUE
        NOMINVALUE
        CACHE 1;

CREATE TABLE rigs (
        rig_id int DEFAULT nextval('seq_rig_id'::regclass) NOT NULL,
        gpu_type int NOT NULL REFERENCES cards (card_id),
        gpu_count int NOT NULL,
        power_use int,
        hardware_cost numeric NOT NULL,
        daily_income numeric,
        mining_speed numeric,
        CONSTRAINT PK_rig PRIMARY KEY (rig_id)     
);

CREATE SEQUENCE seq_card_id
        INCREMENT BY 1
        NO MAXVALUE
        NOMINVALUE
        CACHE 1;

CREATE TABLE cards (
        card_id int DEFAULT nextval('seq_card_id'::regclass) NOT NULL,
        card_brand varchar(15),
        card_model varchar (30),
        power_use int,
        cost_new numeric NOT NULL,
        daily_income numeric,
        mining_speed numeric,
        CONSTRAINT PK_card PRIMARY KEY (card_id)     
);




COMMIT TRANSACTION;
