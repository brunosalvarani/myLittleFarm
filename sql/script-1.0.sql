set search_path to public;
CREATE TABLE ANIMAL (
    ANIMAL_ID SERIAL NOT NULL,
	TAG VARCHAR(9) NOT NULL,
	PARENTTAG VARCHAR(9),
	BIRTHDATE DATE,
	GENDER VARCHAR(1),
	RACE VARCHAR(20),
	ISNATIVE VARCHAR(1) NOT NULL,
	CONSTRAINT PK_ANIMAL PRIMARY KEY (ANIMAL_ID)
);

CREATE TABLE MY_USER (
    USER_ID SERIAL NOT NULL,
    USERNAME VARCHAR(20) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (USER_ID),
    CONSTRAINT UK_USERNAME UNIQUE (USERNAME)
);