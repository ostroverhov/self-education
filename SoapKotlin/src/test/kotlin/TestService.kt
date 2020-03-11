import application.dbqueries.getEmployeeByPiFromDb
import application.dbqueries.getEmployeeByPiWithSalaryAndProfessionFromDb
import application.enums.BodyTag
import application.models.Employee
import application.models.SoapResponse
import application.soaprequest.addEmployee
import application.soaprequest.getEmployeeByPi
import application.soaprequest.getEmployeeSalary
import application.soaprequest.updateEmployeeData
import framework.utils.deserializationObject
import framework.utils.getParameter
import framework.utils.logger
import framework.utils.serializationObject
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test

class TestService {

    @Parameters(value = ["id", "privateId", "firstName", "lastName", "middleName", "exp", "professionId", "responseCode200", "responseMessage"])
    @Test
    fun addNewEmployeeTest(
        id: String?, privateId: String?,
        firstName: String?, lastName: String?,
        middleName: String?, exp: String?,
        professionId: String?, responseCode200: String?,
        responseMessage: String?
    ) = with(Employee()){
        logger.step("Add new employee")
        this.id = id
        this.privateId = privateId
        this.firstName = firstName
        this.lastName = lastName
        this.middleName = middleName
        this.experience = exp
        this.professionId = professionId
        val addEmployeeResponse = addEmployee(this)
        val employeeInDb = getEmployeeByPiFromDb(this.privateId)
        Assert.assertEquals(addEmployeeResponse?.responseCode, responseCode200, "Check response code equals 200")
        Assert.assertEquals(addEmployeeResponse?.responseMessage, responseMessage, "Check response message")
        Assert.assertTrue(this == employeeInDb, "Check employee by soap and from database")
        serializationObject(this, getParameter("PATH_TO_FILE"))
    }

    @Parameters(value = ["updatedMiddleName", "responseCode200"])
    @Test
    fun updateCreatedEmployeeTest(
        updatedMiddleName: String?,
        responseCode200: String?
    ) {
        logger.step("Update data of exist employee")
        val employeeDeserialized: Employee =
            deserializationObject(getParameter("PATH_TO_FILE")) as Employee
        employeeDeserialized.middleName = updatedMiddleName
        val updateEmployeeDataResponse: SoapResponse? = updateEmployeeData(employeeDeserialized)
        val updatedEmployeeInDb: Employee? = getEmployeeByPiFromDb(employeeDeserialized.privateId)
        println(updatedEmployeeInDb.toString())
        Assert.assertEquals(updateEmployeeDataResponse?.responseCode, responseCode200, "Check response code equals 200")
        Assert.assertTrue(employeeDeserialized == updatedEmployeeInDb, "Check employee by soap and from database")
        serializationObject(employeeDeserialized, getParameter("PATH_TO_FILE"))
    }

    @Parameters(value = ["id", "privateId", "firstName", "lastName", "middleName", "exp", "professionId", "responseCode200", "responseMessage"])
    @Test
    fun addEmployeeWithEmptyParameterTest(
        id: String?, privateId: String?,
        firstName: String?, lastName: String?,
        middleName: String?, exp: String?,
        professionId: String?, responseCode200: String?,
        responseMessage: String?
    ) = with(Employee()) {
        logger.step("Add employee with empty parameter")
        this.id = id
        this.privateId = privateId
        this.firstName = firstName
        this.lastName = lastName
        this.middleName = middleName
        this.experience = exp
        this.professionId = professionId
        val soapWithEmptyParameterResponse: SoapResponse? = addEmployee(this)
        Assert.assertEquals(
            soapWithEmptyParameterResponse?.responseCode,
            responseCode200,
            "Check response code equals 200"
        )
        Assert.assertEquals(
            soapWithEmptyParameterResponse?.responseMessage,
            responseMessage,
            "Check response message"
        )
        Assert.assertNull(getEmployeeByPiFromDb(this.privateId), "Employee don't create")
    }

    @Parameters(value = ["responseCode200"])
    @Test
    fun searchEmployeeByPrivateIDTest(responseCode200: String?) {
        logger.step("Search employee by PrivateID")
        val employeeUpdatedDeserialized: Employee? =
            deserializationObject(getParameter("PATH_TO_FILE")) as Employee
        val employeeByPiResponse: SoapResponse? =
            getEmployeeByPi(employeeUpdatedDeserialized?.privateId)
        Assert.assertEquals(employeeByPiResponse?.responseCode, responseCode200, "Check response code equals 200")
        val employeeWithSalaryAndProfessionInDb: Employee? =
            getEmployeeByPiWithSalaryAndProfessionFromDb(employeeUpdatedDeserialized?.privateId)
        Assert.assertTrue(
            employeeWithSalaryAndProfessionInDb?.equals(employeeByPiResponse?.employee)!!,
            "Check employee by soap and from database"
        )
        val exp: List<String> = BodyTag.values().map { tag -> tag.tagName!! }
        val act: List<String>? = employeeByPiResponse?.listOfTags
        for (i in 0 until act?.size!! - 1) {
            Assert.assertEquals(act[i], exp[i], "Actual tag name ${act[i]}, expected ${exp[i]}")
        }
    }

    @Parameters(value = ["expectedSalary", "workdays", "sickDays", "overDays", "month", "isPriv"])
    @Test
    fun getSalaryEmployeeTest(
        expectedSalary: String?, workdays: String?,
        sickDays: String?, overDays: String?,
        month: String?, isPriv: String?
    ) {
        logger.step("Get salary of employee")
        val employeeUpdatedDeserialized: Employee? =
            deserializationObject(getParameter("PATH_TO_FILE")) as Employee
        val getEmployeeSalaryResponse: SoapResponse? = getEmployeeSalary(
            employeeUpdatedDeserialized?.privateId, workdays, sickDays, overDays, month, isPriv
        )
        Assert.assertEquals(expectedSalary, getEmployeeSalaryResponse?.salaryAmount, "Salary not equal")
    }
}