package pe.edu.cibertec.appwebventas.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.appwebventas.model.Category;
import pe.edu.cibertec.appwebventas.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listarCategorias(){
        return categoryRepository.findAll();
    }

}
