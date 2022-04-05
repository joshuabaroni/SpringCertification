package com.spring.professional.exam.tutorial.module01.question01.manual.dependency.injection;

import com.spring.professional.exam.tutorial.module01.question01.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.question01.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.question01.commons.report.PdfSalaryReport;
import com.spring.professional.exam.tutorial.module01.question01.commons.report.XlsSalaryReport;

public class Runner {
    public static void main(String... args) {
        // provide information to the service to use for the pdf report
        EmployeesSalariesReportService employeesSalariesReportService = new EmployeesSalariesReportService(
                new EmployeeDao(),
                new EmployeeSalaryCalculator(),
                new XlsSalaryReport()
        );
        // the instance of this ReportService used contains the data it needs, rather than the object itself
        // allows for more flexible use of classes

        employeesSalariesReportService.generateReport();
    }
}
