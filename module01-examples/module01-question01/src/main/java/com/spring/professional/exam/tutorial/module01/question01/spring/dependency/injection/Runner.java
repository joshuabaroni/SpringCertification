package com.spring.professional.exam.tutorial.module01.question01.spring.dependency.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String... args) {
        // with spring profiles added, we dont even need to change the main runner class. we just declare the context of the application using the profiles of the available beans
        AnnotationConfigApplicationContext context = getSpringContext("xls-reports");

        // spring profiles allow for maximum reusability depending on your spring context
        EmployeesSalariesReportService employeesSalariesReportService = context.getBean(EmployeesSalariesReportService.class);
        employeesSalariesReportService.generateReport();

        context.close();
    }

    // profile is a way to easily change the behavior of the system without changing the code
    private static AnnotationConfigApplicationContext getSpringContext(String profile) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profile);
        context.register(Configuration.class);
        context.refresh();
        return context;
    }
}
