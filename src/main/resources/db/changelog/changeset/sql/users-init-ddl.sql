CREATE TABLE jira.users (
	user_id BIGSERIAL PRIMARY KEY,
	first_name VARCHAR(255) NULL,
	last_name VARCHAR(255) NULL,
	birth_date TIMESTAMP(6) NULL,
	"role" VARCHAR(255) NULL,
	timestamp_cr TIMESTAMP(6) NULL,
	timestamp_up TIMESTAMP(6) NULL
);