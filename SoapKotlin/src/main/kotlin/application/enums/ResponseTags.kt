package application.enums

enum class ResponseTags(nameResponseTag: String) {

    ADD_NEW_EMPLOYEE_RESULT("AddNewEmployeeResult"),
    ID("id"),
    PRIVATE_ID("private_id"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    MIDDLE_NAME("middle_name"),
    EXP("exp"),
    PROF_NAME("prof_name"),
    SALARY_AMOUNT("salary_amount"),
    TABLE("Table"),
    GET_EMPLOYEE_SALARY_RESULT("GetEmpSalaryResult");

    val tagName: String? = nameResponseTag
}