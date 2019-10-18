select project.name as 'PROJECT', count(distinct test.name) as 'TEST_COUNT' from test
inner join project on test.project_id=project.id group by project.name