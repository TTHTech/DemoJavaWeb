package com.Geartnt.dao;

import com.Geartnt.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();
}
