package produitFactory;


public class ProductC extends Products {

    public void perform() {
        System.out.println(" I ’m a ProductC , performing");
    }

    static {
        ProductsFactory.registerProduct("ProdC", new ProductC());
    }

    private ProductC() {
        super("ProdC");
    }

    @Override
    protected Products createProduct() {
        return new ProductC();
    }

    @Override
    public void affiche() {
        System.out.println("Produit C : " + this.getName());
    }
}
