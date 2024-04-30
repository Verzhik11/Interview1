package com.example.interview1.Service;

import com.example.interview1.Model.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalculationService {
    private final Model model;

    public CalculationService(Model model) {
        this.model = model;
    }

    public Model calculateModel(int year, int month, int salary) {
        String modelMonth = getNameOfMonth(month);
        double hourIncome = calculateHourIncome(year, month, salary);
        int workingDays = countWorkingDays(year, month);
        model.setYear(year);
        model.setMonth(modelMonth);
        model.setSalary(salary);
        model.setHourIncome(hourIncome);
        model.setWorkdaysMonth(workingDays);
        return model;

    }

    public double calculateHourIncome(int year, int month, int salary) {
        int workingDays = countWorkingDays(year, month);
        double hourIncome = salary / workingDays;
        double scale = Math.pow(10, 2);
        return Math.ceil(hourIncome * scale) / scale;

    }

    public int countWorkingDays(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        int workingDays = 0;
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDays++;
            }
            date = date.plusDays(1);
        }
        return workingDays;

    }

    public String getNameOfMonth(int numberOfMonth) {
        return Month.of(numberOfMonth).getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
    }
}
