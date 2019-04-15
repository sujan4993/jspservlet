package com.dtc.daoimpl;

import com.dtc.dao.Dao;
import com.dtc.dbconnection.DBConnection;
import com.dtc.modal.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements Dao<Person> {

    DBConnection dbConnection = new DBConnection();
    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();

        String query = "select * from person";
        dbConnection.dbOpen();
        PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Person person = new Person(resultSet.getInt("id"),resultSet.getString("firstname"),resultSet.getString("lastname"),resultSet.getInt("age"));
                personList.add(person);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnection.dbClose();
        }


        return personList;
    }

    @Override
    public Person findById(int id) {
        String query = "select * from person where id =?";
        Person person = new Person();
        dbConnection.dbOpen();
        PreparedStatement preparedStatement= dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                person.setId(resultSet.getInt("id"));
                person.setFirstname(resultSet.getString("firstname"));
                person.setLastname(resultSet.getString("lastname"));
                person.setAge(resultSet.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbConnection.dbClose();
        }

        return person;
    }

    @Override
    public boolean add(Person person) {

        String query = "insert into person(firstname,lastname,age) values(?,?,?)";

        dbConnection.dbOpen();
        PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);

        try {
            preparedStatement.setString(1,person.getFirstname());
            preparedStatement.setString(2,person.getLastname());
            preparedStatement.setInt(3,person.getAge());
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbConnection.dbClose();
        }


        return false;
    }

    @Override
    public boolean update(Person person) {
        String query = "update person set firstname=?,lastname=?,age=? where id=?";
        dbConnection.dbOpen();
        PreparedStatement preparedStatement =dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setString(1,person.getFirstname());
            preparedStatement.setString(2,person.getLastname());
            preparedStatement.setInt(3,person.getAge());
            preparedStatement.setInt(4,person.getId());
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnection.dbClose();
        }


        return false;
    }

    @Override
    public boolean delete(int id) {
        String query ="delete from person where id =?";
        dbConnection.dbOpen();
        PreparedStatement preparedStatement =dbConnection.getPreparedStatement(query);
        try {
            preparedStatement.setInt(1,id);
            int i= preparedStatement.executeUpdate();
            if(i > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}