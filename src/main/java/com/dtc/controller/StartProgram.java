package com.dtc.controller;

import com.dtc.dao.Dao;
import com.dtc.daoimpl.PersonDaoImpl;
import com.dtc.modal.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "startProgram", urlPatterns = "/")
public class StartProgram extends HttpServlet {

    Dao<Person> personDao = new PersonDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> personList = new ArrayList<>();

        personList = personDao.findAll();
        System.out.println("Called ..");
        System.out.println(personList);
        req.setAttribute("personList", personList);
        req.getRequestDispatcher("personList.jsp").forward(req,resp);
    }
}
