package pe.edu.cibertec.appwebventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.appwebventas.model.Category;
import pe.edu.cibertec.appwebventas.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,
        Integer> {
}
