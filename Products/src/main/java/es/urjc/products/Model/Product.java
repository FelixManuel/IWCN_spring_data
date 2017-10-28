package es.urjc.products.Model;

/**
 * @author Felix Manuel Mellado
 */
public class Product {
    //Attributes
    private int id;
    private String name;
    private String description;
    private double price;
    
    //Temporal Attribute
    private static int count = 0;
    
    //Constructor
    public Product(String name, String description, double price){
        this.id = count++;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    //Getter method
    public int getId(){
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
    public void setId(int id){
        this.id = id;
    }
    
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
