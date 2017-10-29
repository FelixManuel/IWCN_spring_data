package es.urjc.products.Controller;

import es.urjc.products.Model.Product;
import es.urjc.products.Repository.ProductRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Félix Manuel Mellado
 */
@Controller
public class ProductController {
    //Atributter
    @Autowired
    private ProductRepository productRepository;
    
    private final List<Product> products = new ArrayList<>();
    
    //PathMethods
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("home_template");
    }
    
    @RequestMapping(value="/products", method=RequestMethod.POST)
    public String createProduct(@RequestParam(value="id", required=false) Long id, @RequestParam("name") String name, 
                                @RequestParam("description") String description, @RequestParam("price") double price){
        if(id == null){
            this.productRepository.save(new Product(name,description,price));
            return "redirect:/";
        }else{
            this.productRepository.save(new Product(id,name,description,price));
            return "redirect:/";
        }
    }
    
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public ModelAndView listProducts(){
        List<Product> products = this.productRepository.selectAll();
        return new ModelAndView("listProducts_template").addObject("products", products);
    }
    
    @RequestMapping(value="/products/forms", method=RequestMethod.GET)
    public ModelAndView formProduct(){
        return new ModelAndView("formProduct_template");
    }
    
    @RequestMapping(value="/products/{id}/forms", method=RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable long id){
        Product product = this.productRepository.findOne(id);
        return new ModelAndView("formProduct_template").addObject(product);
    }
    
    @RequestMapping(value="/products/{id}", method=RequestMethod.GET)
    public ModelAndView getProduct(@PathVariable long id){
        Product product = this.productRepository.findOne(id);
        return new ModelAndView("product_template").addObject(product);
    }
    
    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public String deleteProduct(@PathVariable long id){
        this.productRepository.delete(id);
        return "redirect:/products";
    }
        
    //Init
    @PostConstruct
    private void initDataBase(){
        productRepository.save(new Product("a","a",1));
        productRepository.save(new Product("b","b",2));
        productRepository.save(new Product("c","c",3));
    }
    
    
}
