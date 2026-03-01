package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.CategoryEntity;
import com.Architecture_Website.Architecture_Website.Repository.CategoryRepository;
import com.Architecture_Website.Architecture_Website.Request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryEntity createCategory(CategoryRequest request) {
        CategoryEntity category = CategoryEntity.builder()
                .name(request.name())
                .parentId(request.parentId())
                .build();
        return categoryRepository.save(category);
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity getCategoryById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
}
