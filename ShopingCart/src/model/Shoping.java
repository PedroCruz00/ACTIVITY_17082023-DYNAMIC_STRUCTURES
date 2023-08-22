package model;

import java.util.Vector;
public class Shoping {
    Vector<Product> shoping;

    public Shoping() {
        this.shoping = new Vector<>();
    }
    public void addProduct(Product product){
        shoping.add(product);
    }
    public Double calculateTotal(){
        double total = 0;
        for (Product product : shoping ) {
            total+= product.getPrice();
        }
        return total;
    }

    public Vector<Product> getShoping() {
        return shoping;
    }
}
