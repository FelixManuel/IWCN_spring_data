package es.urjc.products.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Felix Manuel Mellado
 */
@Entity
public class Product {
    //Attributes
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String name;
    private String description;
    private double price;
    
    //Constructor
    public Product(){}
    
    public Product(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public Product(long id, String name, String description, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    //Getter method
    public long getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    //Setter method    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
}
