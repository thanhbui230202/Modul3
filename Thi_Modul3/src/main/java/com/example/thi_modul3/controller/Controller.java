package com.example.thi_modul3.controller;

import com.example.thi_modul3.model.BenhNhan;
import com.example.thi_modul3.service.BenhNhanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "book", urlPatterns = "/book")
public class Controller extends HttpServlet {
    private BenhNhanServiceImpl benhNhanService = new BenhNhanServiceImpl();
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list_benh":
                viewListBook(req, resp);
                break;
            case "delete_benh":
                doDelete1(req,resp);
            case "update":
                viewUpdate(req,resp);
                break;
            default:
                viewListBook(req,resp);
                break;
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("");
        req.getRequestDispatcher("view/Create.jsp").forward(req,resp);
    }

    private void doDelete1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String id =req.getParameter("id");
          benhNhanService.finByID(id);
          benhNhanService.delete(benhNhanService.finByID(id));
          viewListBook(req,resp);
    }

    private void viewListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BenhNhan> benhNhans = benhNhanService.finAll();
        req.setAttribute("bang",benhNhans);
        req.getRequestDispatcher("/view/ViewList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update_benh":
                doUpdate(req, resp);
                break;
    }
}

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        String id1 = req.getParameter("id1");
        String name = req.getParameter("name");
        LocalDate date1 = LocalDate.parse(req.getParameter("date1"));
        LocalDate date2 = LocalDate.parse(req.getParameter("date2"));
        String lydo = req.getParameter("lydo");
        BenhNhan benhNhan = new BenhNhan(id,id1,name,date1,date2,lydo);
        benhNhanService.update(benhNhan);
        viewListBook(req,resp);
    }
    }
