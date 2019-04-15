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

@WebServlet(name = "updatePerson", urlPatterns = "/updatePerson")
public class updatePerson extends HttpServlet {
    Dao<Person>  personDao = new PersonDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = personDao.findById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("person",person);
        req.getRequestDispatcher("updatePerson.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person();
        person.setId(Integer.parseInt(req.getParameter("id")));
        person.setFirstname(req.getParameter("firstname"));
        person.setLastname(req.getParameter("lastname"));
        person.setAge(Integer.parseInt(req.getParameter("age")));
        personDao.update(person);
        req.setAttribute("personList",personDao.findAll());
        req.getRequestDispatcher("personList.jsp").forward(req,resp);
    }
}
