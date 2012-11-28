/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produitFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yvrenaud
 */
public class ProductsFactory {
    
    private static volatile ProductsFactory instance = null;
    private static Map<String, Products> registry = new HashMap<String, Products>();

    private ProductsFactory() {
        super();
    }
    
    public final static ProductsFactory getInstance() {
        ProductsFactory result = instance;
        if (result == null) { // 1er verif sans verrou
            synchronized (ProductsFactory.class) {
                result = instance;
                if (result == null) { // 2eme verif, apres acquisition du verrou
                    instance = new ProductsFactory();
                }
            }
        }
        return instance;
    }
    
    
    public static void registerProduct(String name, Products s) {
        if (!registry.containsKey(name)) {
            registry.put(name, s);
        }
    }

    public Products createProduct(String name) {
        if (registry.containsKey(name)) {
            return registry.get(name).createProduct();
        } else {
            return null;
        }
    }
    
    
}
