package application.models

import java.io.Serializable
import java.util.*

data class Employee(
    var id: String? = null,
    var privateId: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var middleName: String? = null,
    var experience: String? = null,
    var professionId: String? = null,
    var professionName: String? = null,
    var salaryAmount: String? = null
) : Serializable {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val employee = o as Employee
        return privateId == employee.privateId &&
                firstName == employee.firstName &&
                lastName == employee.lastName &&
                middleName == employee.middleName &&
                experience == employee.experience &&
                professionId == employee.professionId &&
                professionName == employee.professionName &&
                salaryAmount == employee.salaryAmount
    }

    override fun hashCode(): Int {
        return Objects.hash(privateId, firstName, lastName, middleName, experience, professionId,  professionName, salaryAmount)
    }
}