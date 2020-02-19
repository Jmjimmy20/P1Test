package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) throws InterruptedException {
		            
            int maxPrim=1000;
            int CantHilos = 4;
            int range = maxPrim/CantHilos;
            int inicio = 0;
            int fin = range;

            PrimesResultSet prs=new PrimesResultSet("john");

            List<PrimeFinderThread> hilos = new ArrayList<PrimeFinderThread>();

            for(int i =0; i<CantHilos;i++){
                hilos.add(new PrimeFinderThread(inicio, fin, prs));
                hilos.get(i).start();
                inicio = fin +1;
                if(maxPrim-fin < range){
                    fin = maxPrim;
                }else{
                    fin += range;
                }
                
            }

            for(PrimeFinderThread e:hilos){
                e.join();
            }
            
            
            //PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10000"), prs);
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());
            
            


            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
                        
            
            
            
            
	}
	
}


