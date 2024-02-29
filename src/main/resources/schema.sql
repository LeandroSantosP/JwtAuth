CREATE TABLE IF NOT EXISTS USERS (
        id VARCHAR(250) NOT NULL PRIMARY KEY,
        username VARCHAR(250) NOT NULL,
        email VARCHAR(250) NOT NULL,
        password VARCHAR(250) NOT NULL,
        age INTEGER NOT NULL
);


CREATE TABLE IF NOT EXISTS ROLES (
        id VARCHAR(250) NOT NULL PRIMARY KEY,
        name VARCHAR(250) NOT NULL
);

CREATE TABLE USER_ROLES (
    USER_ID VARCHAR(250) NOT NULL,
    ROLE_ID VARCHAR(250) NOT NULL,
    PRIMARY KEY (USER_ID, ROLE_ID),
    FOREIGN KEY (USER_ID) REFERENCES USERS (id),
    FOREIGN KEY (ROLE_ID) REFERENCES ROLES (id)
);
