CREATE TABLE jira.projects (
	project_id BIGSERIAL PRIMARY KEY,
	name_project VARCHAR(255) NOT NULL,
	timestamp_cr TIMESTAMP(6) NULL,
	timestamp_up TIMESTAMP(6) NULL
);