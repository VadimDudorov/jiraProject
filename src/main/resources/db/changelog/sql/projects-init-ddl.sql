CREATE TABLE jira.projects (
	project_id int8 NOT NULL,
	name_project varchar(255) NULL,
	timestamp_cr timestamp(6) NULL,
	timestamp_up timestamp(6) NULL,
	CONSTRAINT projects_pkey PRIMARY KEY (project_id)
);