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

@WebServlet(name = "deletePerson", urlPatterns = "/deletePerson")
public class DeletePerson extends HttpServlet {

  Dao<Person> personDao = new PersonDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        personDao.delete(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("personList",personDao.findAll());
        req.getRequestDispatcher("personList.jsp").forward(req,resp);


    }
}
