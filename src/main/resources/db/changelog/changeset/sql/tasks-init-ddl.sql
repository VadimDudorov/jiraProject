CREATE TABLE jira.tasks (
	task_id BIGSERIAL PRIMARY KEY,
	user_id BIGINT NULL REFERENCES jira.users(user_id),
	project_id BIGINT NULL REFERENCES jira.projects(project_id),
	status VARCHAR NULL,
	description VARCHAR(255) NULL,
	story_point BIGINT NULL,
	timestamp_cr TIMESTAMP(6) NULL,
	timestamp_up TIMESTAMP(6) NULL
);