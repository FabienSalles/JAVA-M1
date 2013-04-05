/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package op.sac3d;

/**
 *
 * @author fasalles
 */
public class OPSAC3D {
    static final int P = 10;
    static final int Q = 7;
    static final int N = 10;
    static final int[] p = {3,1,4,6,2,3,1,2,5,4};
    static final int[] w = {30,12,10,18,4,7,12,8,16,15};
    static int[][][] result;
    static int i,j,k,x; 
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        result = new int [N+1][P+1][Q+1];
        
        for(i=0;i<=P;i++)
        {
            for(j=0;j<=Q;j++)
            {
                if(p[N-1] > Math.max(i,j))
                {
                    result[N-1][i][j]=0;
                }
                else
                {
                    result[N-1][i][j]= w[N-1];
                }
            }
        }
            
        for(i=N-1; i+1>0;i--)
        {
            for(j=0; j<=P; j++)
            {
                for(k=0; k<=Q; k++)
                {
                    x = result[i+1][j][k];
                    if(p[i]<=j && result[i+1][j-p[i]][k]+w[i]>x) 
                    {
                        x=result[i+1][j-p[i]][k]+w[i];
                    }
                    if(p[i]<=k && result[i+1][j][k-p[i]]+w[i]>x)
                    {
                        x=result[i+1][j][k-p[i]]+w[i];
                    }
                    result[i][j][k]=x;
                }
            }
        }
        
        for(j=P,k=Q,i=0;i<N;i++)
        {
            if(result[i][j][k]==result[i+1][j][k])
            {
                System.out.println("objet "+i+" non pris");
            }
            else if(p[i]<=j && result[i][j][k]==result[i+1][j-p[i]][k]+w[i])
            {
                System.out.println("objet "+i+" dans le sac 1."); 
                j-=p[i]; 
            }
            else
            {
                System.out.println("objet "+i+" dans le sac 2."); 
                k-=p[i]; 
            }
        }
        
        System.out.println("Le sac 1 pèse "+(P-j));
        System.out.println("Le sac 2 pèse "+(Q-k));
        System.out.println("L'utilité totale est "+result[0][P][Q]);

    }
    

}
