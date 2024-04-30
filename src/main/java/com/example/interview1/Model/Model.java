package com.example.interview1.Model;

import java.util.Objects;

public class Model {
    private int year;
    private String month;
    private int salary;
    private double hourIncome;
    private int workdaysMonth;

    public Model(int year, String month, int salary, double hourIncome, int workdaysMonth) {
        this.year = year;
        this.month = month;
        this.salary = salary;
        this.hourIncome = hourIncome;
        this.workdaysMonth = workdaysMonth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getHourIncome() {
        return hourIncome;
    }

    public void setHourIncome(double hourIncome) {
        this.hourIncome = hourIncome;
    }

    public int getWorkdaysMonth() {
        return workdaysMonth;
    }

    public void setWorkdaysMonth(int workdaysMonth) {
        this.workdaysMonth = workdaysMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return year == model.year && salary == model.salary && Double.compare(model.hourIncome, hourIncome) == 0 && workdaysMonth == model.workdaysMonth && month.equals(model.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, salary, hourIncome, workdaysMonth);
    }

    @Override
    public String toString() {
        return "Model{" +
                "year=" + year +
                ", month='" + month + '\'' +
                ", salary=" + salary +
                ", hourIncome=" + hourIncome +
                ", workdaysMonth=" + workdaysMonth +
                '}';
    }
}
