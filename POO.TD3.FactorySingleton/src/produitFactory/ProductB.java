package produitFactory;


public final class ProductB extends Products {

    
    static {
        ProductsFactory.registerProduct("ProdB", new ProductB());
    }
    
    public void doIt() {
        System.out.println(" I ’m a ProductB , doing it");
    }
    
    private ProductB() {
        super("ProdB");
    }

    @Override
    protected Products createProduct() {
        return new ProductB();
    }
    
    
    @Override
    public void affiche() {
        System.out.println("Produit B : " + this.getName());
    }

}
