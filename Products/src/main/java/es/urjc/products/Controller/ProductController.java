package es.urjc.products.Controller;

import es.urjc.products.Model.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
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
    private final List<Product> products = new ArrayList<>();
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("home_template");
    }
    
    @RequestMapping(value="/products", method=RequestMethod.POST)
    public String createProduct(@RequestParam("id") int id, @RequestParam("name") String name, 
                                @RequestParam("description") String description, @RequestParam("price") double price){
        if(id == -1){
            Product product = new Product(name, description, price);
            this.products.add(product);
            return "redirect:/";
        }else{
            changeProduct(id, name, description, price);
            return "redirect:/";
        }
    }
    
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public ModelAndView listProducts(){
        return new ModelAndView("listProducts_template").addObject("products", this.products);
    }
    
    @RequestMapping(value="/products/forms", method=RequestMethod.GET)
    public ModelAndView formProduct(){
        return new ModelAndView("formProduct_template");
    }
    
    @RequestMapping(value="/products/{id}/forms", method=RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable int id){
        Product product = extractProduct(id);
        return new ModelAndView("formProduct_template").addObject(product);
    }
    
    @RequestMapping(value="/products/{id}", method=RequestMethod.GET)
    public ModelAndView getProduct(@PathVariable int id){
        Product product = extractProduct(id);
        return new ModelAndView("product_template").addObject(product);
    }
    
    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id){
        this.products.remove(id);
        return "redirect:/products";
    }
    
    private Product extractProduct(int id){
        Product product = null;
        Iterator listIterator = this.products.iterator();
        while(listIterator.hasNext()){
            product = (Product)listIterator.next();
            if(product.getId() == id){
                return product;
            }
        }
        return product;
    }
    
    private void changeProduct(int id, String name, String description, double price){
        Iterator listIterator = this.products.iterator();
        while(listIterator.hasNext()){
            Product product = (Product)listIterator.next();
            if(product.getId() == id){
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
            }
        }
    }
    
    
}
