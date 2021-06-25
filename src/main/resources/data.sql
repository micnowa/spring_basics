INSERT INTO users (username, password, enabled)
values ('user','pass',1);

INSERT INTO authorities (username, authority)
values ('user', 'ROLE_USER');


INSERT INTO users (username, password, enabled)
values ('admin','pass',1);

INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_ADMIN');