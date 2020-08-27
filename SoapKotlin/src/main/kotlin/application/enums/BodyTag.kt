package application.enums

enum class BodyTag(bodyTag: String) {

    PRIVATE_ID("private_id"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    MIDDLE_NAME("middle_name"),
    EXP("exp"),
    PROF_NAME("prof_name");

    val tagName: String? = bodyTag
}