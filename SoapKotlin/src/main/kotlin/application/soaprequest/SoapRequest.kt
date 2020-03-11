package application.soaprequest

import application.enums.ResponseTags
import application.models.Employee
import application.models.SoapResponse
import application.requestpatterns.addEmployeeRequest
import application.requestpatterns.baseRequest
import application.requestpatterns.getEmployeeSalaryRequest
import application.requestpatterns.searchEmployeeByPiRequest
import framework.utils.*

private val url = getParameter("URL")
private val createEmployee = getParameter("CREATE_EMPLOYEE")
private val getEmployeeSalary = getParameter("GET_EMPLOYEE_SALARY")
private val getEmployeeByPi = getParameter("GET_EMPLOYEE_BY_PI")
private val updateEmployee = getParameter("UPDATE_EMPLOYEE")

fun addEmployee(employee: Employee): SoapResponse? {
    logger.info("Add employee")
    val httpURLConnection = sendSoapRequest(
        url,
        createEmployee,
        baseRequest(addEmployeeRequest(employee))
    )
    return SoapResponse(
        httpURLConnection?.responseCode.toString(),
        getTagValue(parseXmlFile(getResponseInString(httpURLConnection)), ResponseTags.ADD_NEW_EMPLOYEE_RESULT.tagName)
    )
}

fun getEmployeeSalary(
    pi: String?, workDays: String?,
    sickDays: String?, overDays: String?,
    month: String?, isPriv: String?
): SoapResponse? {
    val httpURLConnection = sendSoapRequest(
        url,
        getEmployeeSalary,
        baseRequest(getEmployeeSalaryRequest(pi, workDays, sickDays, overDays, month, isPriv))
    )
    return SoapResponse(
        salaryAmount = getTagValue(
            parseXmlFile(getResponseInString(httpURLConnection)),
            ResponseTags.GET_EMPLOYEE_SALARY_RESULT.tagName
        )
    )
}

fun getEmployeeByPi(pi: String?): SoapResponse? = with(Employee()) {
    val httpURLConnection = sendSoapRequest(
        url,
        getEmployeeByPi,
        baseRequest(searchEmployeeByPiRequest(pi))
    )
    val document = parseXmlFile(getResponseInString(httpURLConnection))
    this.id = getTagValue(document, ResponseTags.ID.tagName)?.trim()
    this.privateId = getTagValue(document, ResponseTags.PRIVATE_ID.tagName)?.trim()
    this.firstName = getTagValue(document, ResponseTags.LAST_NAME.tagName)?.trim()
    this.lastName = getTagValue(document, ResponseTags.FIRST_NAME.tagName)?.trim()
    this.middleName = getTagValue(document, ResponseTags.MIDDLE_NAME.tagName)?.trim()
    this.experience = getTagValue(document, ResponseTags.EXP.tagName)?.trim()
    this.professionName = getTagValue(document, ResponseTags.PROF_NAME.tagName)?.trim()
    this.salaryAmount = getTagValue(document, ResponseTags.SALARY_AMOUNT.tagName)?.trim()
    return SoapResponse(
        responseCode = httpURLConnection?.responseCode.toString(),
        employee = this,
        listOfTags = getListTagNames(document, ResponseTags.TABLE.tagName?.trim())
    )
}

fun updateEmployeeData(employee: Employee): SoapResponse? {
    val httpURLConnection = sendSoapRequest(
        url,
        updateEmployee,
        baseRequest(addEmployeeRequest(employee))
    )
    return SoapResponse(responseCode = httpURLConnection?.responseCode.toString())
}