package produitFactory;

import java.util.Random;

/**
 * Classe abstraite products
 * @author yvrenaud
 */
public abstract class Products implements IProducts {

    protected static Random random = new Random();
    private static int idGenerator = 0;
    private int id;
    private String name;

    protected Products() {
    }
    
    protected Products(String n) {
        this.name = n;
        this.id = genid();
    }

    
    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }


    // Generates id for shapes.
    private static int genid() {
        return ++idGenerator;
    }
    
//    @Override
//    public void affiche(){
//        System.out.println("Produit " + this.getID() + " " + this.getName());
//    }

    abstract protected Products createProduct();
}
