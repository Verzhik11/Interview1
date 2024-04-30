package com.example.interview1;

import java.io.*;

import com.example.interview1.Model.Model;
import com.example.interview1.Service.CalculationService;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class ModelServlet extends HttpServlet {
    private String message;
    private final CalculationService calculationService;


    public ModelServlet(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public void init() {
        message = "Hello War!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int salary = Integer.parseInt(request.getParameter("salary"));
        Model model = calculationService.calculateModel(year, month, salary);
        response.setContentType("text/html;charset=UTF-8");
        //response.getWriter().write(new Gson().toJson(model));



        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Model Parameters:</h1>");
        out.println("<p>Year: " + model.getYear() + "</p>");
        out.println("<p>Month: " + model.getMonth() + "</p>");
        out.println("<p>Salary: " + model.getSalary() + "</p>");
        // Другие параметры модели
        out.println("</body></html>");
        out.close();
    }

    public void destroy() {
    }
}