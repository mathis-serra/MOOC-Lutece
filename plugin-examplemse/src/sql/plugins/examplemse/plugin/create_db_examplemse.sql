
--
-- Structure for table examplemse_project
--

DROP TABLE IF EXISTS examplemse_project;
CREATE TABLE examplemse_project (
id_project int AUTO_INCREMENT,
name varchar(50) default '' NOT NULL,
description varchar(255) default '' NOT NULL,
imageurl varchar(255) default '' NOT NULL,
cost int(6) default 0 NOT NULL,
PRIMARY KEY (id_project)
);
