INSERT INTO users (username, password, enabled)
values ('user','pass',1);

INSERT INTO authorities (username, roles)
values ('user', 'ROLE_USER');


INSERT INTO users (username, password, enabled)
values ('admin','pass',1);

INSERT INTO authorities (username, roles)
values ('admin', 'ROLE_ADMIN');