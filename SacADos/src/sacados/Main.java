/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sacados;

/**
 *
 * @author claire hanen Cette classe principale permet d'appeler le générateur
 * d'instances (classe generator) en en donnant les paramètres nombre
 * d'instances, nombre d'objets, ordre de grandeur pour les tailles et les
 * utilités (poids), et ensuite pour chaque instance, elle appelle la méthode
 * arborescente de résolution et affiche le nombre de noeuds de l'arbre générés
 * et le temps en millisecondes.
 */
public class Main
{
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        Arbre a;
        Generator xtest = new Generator(5, 750, 50, 50, 100);
        
//        for (int j= 1; j<=3; j++)
//        {
//            System.out.println("########################");
//            System.out.println("     Heuristique "+j);
//            System.out.println("########################");
//            
//            Objet.Heuristique = j;
//            
//            for (int i = 0; i < xtest.nbinst; i++)
//            {
//                System.out.println("\nInstance "+(i+1));
//                long s, t = System.currentTimeMillis();
//                a = new Arbre(xtest.instances.get(i));
//                s = System.currentTimeMillis() - t;
//                System.out.println("temps : " + s + " millisec");
//                a.affiche();
//            }
//        }
        execHeuristique(1, xtest);
    }
    
    public static Integer execHeuristique(Integer h, Generator xtest) throws InterruptedException
    {
        if(h<=2)
        {
            System.out.println("########################");
            System.out.println("     Heuristique "+h);
            System.out.println("########################");
            
            Objet.Heuristique = h;
            
            execInstance(0, xtest);
            
            Thread.currentThread().sleep(1000);

            return execHeuristique(h+1, xtest);
        }
        else
        {
            return 0;
        }
        
    }
    
    public static Integer execInstance(Integer i, Generator xtest) throws InterruptedException
    {
        if (i!=xtest.nbinst)
        {
            System.out.println("\nInstance "+(i+1));
            long s, t = System.currentTimeMillis();
            Arbre a = new Arbre(xtest.instances.get(i));
            a.affiche();
            s = System.currentTimeMillis() - t;
            System.out.println("temps : " + s + " millisec");
            
            Thread.currentThread().sleep(1000);
            
            return execInstance(i+1, xtest);
        }
        else
        {
            return 0;
        }
    }
}
