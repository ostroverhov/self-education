select project.name as 'PROJECT', test.name as 'TEST', test.start_time as 'DATE' from test
inner join project on test.project_id=project.id where test.start_time >='2015-11-07'
order by project.name, test.name