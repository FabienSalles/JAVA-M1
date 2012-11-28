package produitFactory;

public class ProductsLoader {

    static {
        try {
            Class.forName("produitFactory.ProductA");
            Class.forName("produitFactory.ProductB");
            Class.forName("produitFactory.ProductC");
        } catch (ClassNotFoundException any) {
            any.printStackTrace();
        }
    }
}
