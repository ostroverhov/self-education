package application.requestpatterns

fun getEmployeeByPiPattern(privateId: String?) = "SELECT * FROM employees WHERE private_id = '$privateId'"

fun getEmployeeByPiWithProfAndSalaryPattern(privateId: String?) = "SELECT employees.id, employees.private_id, " +
        "employees.first_name, employees.last_name, employees.middle_name, employees.exp, base_salaries.prof_name, " +
        "base_salaries.salary_amount FROM employees LEFT JOIN base_salaries ON " +
        "employees.profession_id = base_salaries.id WHERE employees.private_id = '$privateId'"