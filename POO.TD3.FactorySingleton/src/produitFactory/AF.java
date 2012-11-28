package produitFactory;


public class AF {

    static {
        try {
            Class.forName("produitFactory.ProductsLoader");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client myClient = new Client();
        ProductsFactory instance = ProductsFactory.getInstance();
        
        myClient.add(instance.createProduct("ProdB"));
        myClient.add(instance.createProduct("ProdA"));
        myClient.add(instance.createProduct("ProdC"));
   
        myClient.afficheAll();
    }
}
