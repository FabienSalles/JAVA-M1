package produitFactory;

/**
 *
 * @author yvrenaud
 */
public class ProductA extends Products {

    static {
        ProductsFactory.registerProduct("ProdA", new ProductA());
    }

    public void doYourStuff() {
        System.out.println(" I ’m a ProductA , doing my stuff");
    }

    private ProductA() {
        super("ProdA");
    }

    @Override
    protected Products createProduct() {
        return new ProductA();
    }

    @Override
    public void affiche() {
        System.out.println("Produit A : " + this.getName());
    }
}
