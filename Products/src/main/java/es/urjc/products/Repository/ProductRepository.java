package es.urjc.products.Repository;

import es.urjc.products.Model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Félix Manuel Mellado
 */
public interface ProductRepository extends CrudRepository<Product,Long>{
    
    @Query(value="SELECT * FROM PRODUCT", nativeQuery=true)
    List<Product> selectAll();
    
}
