package edu.eci.arsw.primefinder;

import java.math.BigInteger;

/**
 * PrimeFinderThread
 */
public class PrimeFinderThread extends Thread{

    BigInteger a,b;
    PrimesResultSet prs;

    public PrimeFinderThread(int a, int b, PrimesResultSet prs){
        this.a = new BigInteger(Integer.toString(a));
        this.b = new BigInteger(Integer.toString(b)); 
        this.prs = prs;
    }

    @Override
    public void run(){
        PrimeFinder.findPrimes(a, b, prs);
        //System.out.println("a " +  a);
        //System.out.println("b " +  b);
    }
    
}
