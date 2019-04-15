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


@WebServlet(name = "addperson", urlPatterns = "/addPerson")
public class AddPerson extends HttpServlet {

Dao<Person> personDao = new PersonDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String firstname = req.getParameter("firstname");
    String lastname = req.getParameter("lastname");
    int age = Integer.parseInt(req.getParameter("age"));
    boolean isSaved = personDao.add(new Person(firstname, lastname, age));
        if(isSaved){
            req.setAttribute("isSaved",true);
        }
        List<Person> personList = new ArrayList<>();
        personList = personDao.findAll();
        req.setAttribute("personList", personList);
        req.getRequestDispatcher("personList.jsp").forward(req,resp);

    }
}
