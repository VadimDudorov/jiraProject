CREATE TABLE jira.tasks (
	task_id int8 NOT NULL,
	user_id int8 NULL,
	project_id int8 NULL,
	status int2 NULL,
	description varchar(255) NULL,
	story_point int8 NULL,
	timestamp_cr timestamp(6) NULL,
	timestamp_up timestamp(6) NULL,
	CONSTRAINT tasks_pkey PRIMARY KEY (task_id),
	CONSTRAINT tasks_status_check CHECK (((status > 0) AND (status <= '-1'::integer)))
);