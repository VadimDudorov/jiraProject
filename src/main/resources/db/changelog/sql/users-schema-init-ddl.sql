CREATE TABLE jira.users (
	user_id int8 NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	birth_date timestamp(6) NULL,
	"role" varchar(255) NULL,
	timestamp_cr timestamp(6) NULL,
	timestamp_up timestamp(6) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (user_id)
);