package com.Geartnt.dao.impl;

import com.Geartnt.dao.ICategoryDAO;
import com.Geartnt.model.CategoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaterogyDAO implements ICategoryDAO {
    public Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jgearvnservlet";
            String user = "root";
            String password = "24012003";
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    @Override
    public List<CategoryModel> findAll(){
        List<CategoryModel> results = new ArrayList<>();
        String sql = "SELECT * FROM category;";
        //open connection
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null){
            try{
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                    CategoryModel category = new CategoryModel();
                    category.setId(resultSet.getLong("id"));
                    category.setCode(resultSet.getString("code"));
                    category.setName(resultSet.getString("name"));
                    results.add(category);
                }
                if(connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
                return results;
            }catch(SQLException e){
                return null;
            }
        }
        return null;
    }
}
