package com.spring.professional.exam.tutorial.module01.question01.no.dependency.injection;

import com.spring.professional.exam.tutorial.module01.question01.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.question01.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.Employee;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.question01.commons.report.PdfSalaryReport;
import com.spring.professional.exam.tutorial.module01.question01.commons.report.XlsSalaryReport;

import java.util.List;

class EmployeesSalariesReportService {
    void generateReport() {
        // get all employees
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();

        // calculate salaries for each employee
        EmployeeSalaryCalculator employeeSalaryCalculator = new EmployeeSalaryCalculator();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

        // generate salary report based on calculations
        PdfSalaryReport pdfSalaryReport = new PdfSalaryReport();
        pdfSalaryReport.writeReport(employeeSalaries);

        // we can't modify the behavior of this class without changing the details of implementation (code in this class)
//        XlsSalaryReport xlsSalaryReport = new XlsSalaryReport();
//        xlsSalaryReport.writeReport(employeeSalaries);
    }
}
