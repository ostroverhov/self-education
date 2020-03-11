package application.models

data class SoapResponse(
    val responseCode: String? = null,
    val responseMessage: String? = null,
    val employee: Employee? = null,
    val listOfTags: List<String>? = null,
    val salaryAmount: String? = null
)
