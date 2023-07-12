package com.example.productdiscountcalculator;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/DiscountCalculator")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = req.getParameter("description");
        float price = Float.parseFloat(req.getParameter("price"));
        float percent = Float.parseFloat(req.getParameter("percent"));

        float discount = (float) (price * percent * 0.01);
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<h1>Description: " + view + "</h1>");
        writer.println("<h1>Price: " + price + "</h1>");
        writer.println("<h1>Percent: " + percent + "</h1>");
        writer.println("<h1>Discount: " + discount + "</h1>");
        writer.println("</html>");

    }
}