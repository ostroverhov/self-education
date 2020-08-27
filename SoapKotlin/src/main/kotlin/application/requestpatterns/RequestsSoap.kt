package application.requestpatterns

import application.models.Employee

fun baseRequest(body: String) =
    ("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
            + "xmlns:ser=\"Service\"> <soapenv:Header/> <soapenv:Body> $body </soapenv:Body> </soapenv:Envelope>")

fun addEmployeeRequest(employee: Employee?) = ("<ser:AddNewEmployee> "
        + "<!--Optional:--> <ser:newID>${employee?.id}</ser:newID> "
        + "<!--Optional:--> <ser:newPrivate_id>${employee?.privateId}</ser:newPrivate_id> "
        + "<!--Optional:--> <ser:newFirst_name>${employee?.firstName}</ser:newFirst_name> "
        + "<!--Optional:--> <ser:newLast_name>${employee?.lastName}</ser:newLast_name> "
        + "<!--Optional:--> <ser:newMiddle_name>${employee?.middleName}</ser:newMiddle_name> "
        + "<!--Optional:--> <ser:newExp>${employee?.experience}</ser:newExp> "
        + "<ser:newProfession_id>${employee?.professionId}</ser:newProfession_id> "
        + "</ser:AddNewEmployee>")

fun searchEmployeeByPiRequest(pi: String?) = ("<ser:GetEmpByPI> "
        + "<ser:pi>$pi</ser:pi> </ser:GetEmpByPI>")

fun getEmployeeSalaryRequest(
    pi: String?, workDays: String?,
    sickDays: String?, overDays: String?,
    month: String?, isPrivelegent: String?
) = ("<ser:GetEmpSalary> "
        + "<!--Optional:--> <ser:pi>$pi</ser:pi> "
        + "<!--Optional:--> <ser:workDays>$workDays</ser:workDays> "
        + "<!--Optional:--> <ser:sickDays>$sickDays</ser:sickDays> "
        + "<!--Optional:--> <ser:overDays>$overDays</ser:overDays> "
        + "<!--Optional:--> <ser:month>$month</ser:month> "
        + "<!--Optional:--> <ser:isPriv>$isPrivelegent</ser:isPriv> "
        + "</ser:GetEmpSalary>")