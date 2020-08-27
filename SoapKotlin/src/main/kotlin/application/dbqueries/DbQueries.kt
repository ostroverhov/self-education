package application.dbqueries

import application.models.Employee
import application.requestpatterns.getEmployeeByPiPattern
import application.requestpatterns.getEmployeeByPiWithProfAndSalaryPattern
import framework.utils.getParameter
import framework.utils.logger
import framework.utils.select

private val URL = getParameter("URLDATABASE")
private val USER_NAME = getParameter("USER_NAME")
private val USER_PASSWORD = getParameter("USER_PASSWORD")

fun getEmployeeByPiFromDb(pi: String?): Employee? = with(Employee()) {
    logger.info("Get employee with $pi from database")
    val result = select(URL, USER_NAME, USER_PASSWORD, getEmployeeByPiPattern(pi))
    if (result?.size!! > 0) {
        id = result[0]["id"]!!.trim()
        privateId = result[0]["private_id"]!!.trim()
        firstName = result[0]["last_name"]!!.trim()
        lastName = result[0]["first_name"]!!.trim()
        middleName = result[0]["middle_name"]!!.trim()
        experience = result[0]["exp"]!!.trim()
        professionId = result[0]["profession_id"]!!.trim()
    } else {
        return null
    }
    return this
}

fun getEmployeeByPiWithSalaryAndProfessionFromDb(pi: String?): Employee? = with(Employee()) {
    logger.info("Get employee with salary and profession with $pi from database")
    val result = select(URL, USER_NAME, USER_PASSWORD, getEmployeeByPiWithProfAndSalaryPattern(pi))
    if (result?.size!! > 0) {
        this.id = result[0]["id"]!!.trim()
        this.privateId = result[0]["private_id"]!!.trim()
        this.firstName = result[0]["last_name"]!!.trim()
        this.lastName = result[0]["first_name"]!!.trim()
        this.middleName = result[0]["middle_name"]!!.trim()
        this.experience = result[0]["exp"]!!.trim()
        this.professionName = result[0]["prof_name"]!!.trim()
        this.salaryAmount = result[0]["salary_amount"]!!.trim()
    } else {
        return null
    }
    return this
}