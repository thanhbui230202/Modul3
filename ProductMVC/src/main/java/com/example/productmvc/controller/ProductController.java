package com.example.productmvc.controller;

import com.example.productmvc.model.Product;
import com.example.productmvc.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "product", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if (action == null){
            action = "list";
        }
        switch (action){
            case "list":
                viewList(req,resp);
                break;
            case "create":
                viewCreate(req,resp);
                break;
            case "view":
                viewDetail(req,resp);
                break;
            case "update":
                viewUpdate(req,resp);
                break;
            case "delete":
                doDelete(req,resp);
                break;
            default:
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));
        Product  product= productService.findById(id);
        req.setAttribute("product", productService.findById(id));
        req.getRequestDispatcher("/WEB-INF/view/product/update.jsp").forward(req,resp);
    }

    private void viewDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product", product);
//        resp.sendRedirect("/product?action=view");
        req.getRequestDispatcher("/WEB-INF/view/product/view.jsp").forward(req,resp);
    }

    private void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        req.getRequestDispatcher("/WEB-INF/view/product/create.jsp").forward(req,resp);
    }

    private void viewList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/WEB-INF/view/product/list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            resp.sendRedirect("/product?action=list");
        }
        switch (action){
            case "create":
                doCreate(req,resp);
                break;
            case "update":
                doUpdate(req,resp);
                break;
            default:
        }
    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        LocalDate date = LocalDate.parse(req.getParameter("dateRelease"));
//        String date = req.getParameter("dateRelease");
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateRelease = null;
//        try {
//            dateRelease = format.parse(date);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        int id = Integer.parseInt(req.getParameter("id"));
        Product product= new Product(id,name,quantity,price,date,description,category);
        productService.update(product);
        resp.sendRedirect("/product?action=list");
        //        productService.findById(id);
//
//        productService.findById(id).setName(req.getParameter("name"));
//        productService.findById(id).setQuantity( Integer.parseInt(req.getParameter("quantity")));
//        productService.findById(id).setPrice(Integer.parseInt(req.getParameter("price")));
//        productService.findById(id).setDateRelease(LocalDate.parse(req.getParameter("dateRelease")));
//        productService.findById(id).setDescription(req.getParameter("description"));
//        productService.findById(id).setCategory(req.getParameter("category"));

    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        LocalDate date = LocalDate.parse(req.getParameter("dateRelease"));
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        Product product= new Product(id,name,quantity,price,date,description,category);
        productService.add(product);
        resp.sendRedirect("/product?action=list");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.findById(id);
        productService.delete(productService.findById(id));
        resp.sendRedirect("/product?action=list");
    }

}

