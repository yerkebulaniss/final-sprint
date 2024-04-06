package kz.bitlab.academy.finalsprint.categories.service;

import kz.bitlab.academy.finalsprint.categories.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    String create(String name);

    String update(Long id, String name);

    List<CategoryEntity> findAll();

    List<CategoryEntity> findAllNotContains(Long folderId);

    CategoryEntity findById(Long id);

    void delete(Long id);

}
