/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodeconfig;

/**
 *
 * @author REMO
 */
public class Fuzzification {
    
    public static void fuzzify()
    {
        int minrss=30;
        int maxrss=90;
        int optimalrss=30;
        int mintrate=20;
        int maxtrate=250;
        int minploss=0,maxploss=100;
        
        System.out.println("\n\nFUZZIFIED PARAMETERS");
        for(int i=0;i<StoringNodes.SetOfAllNodes.size();i++)
        {
            Node cur=StoringNodes.SetOfAllNodes.get(i);
            int currss=Integer.parseInt(cur.power);
                currss*=-1;
                    //Fuzzifying Rss                      
                cur.frss=1.0-(currss-minrss)/(double)(maxrss-minrss);                
            
            
                    //Fuzzifying Time
            int mintime=0;
            int maxtime=StoringNodes.SetOfAllNodes.size();
            
            cur.ftime=1-((Integer.parseInt(cur.Name)-mintime)/(double)(maxtime));
            
                    //Fuzzifying Trate
            int optimaltrate=130;
            int curtrate=Integer.parseInt(cur.SLevel);           
                cur.ftrate=(curtrate-mintrate)/(double)(maxtrate-mintrate);
            
            
                    //Fuzzifying Packet Loss
            cur.fploss=1-(Integer.parseInt(cur.SPloss)-minploss)/(double)(maxploss);
         
            
                    //Fuzzy Decision Making
            if(cur.frss<=cur.fploss && cur.frss<=cur.ftrate && cur.frss<=cur.ftime)
                cur.degreeofsuspect=cur.frss;
            else if(cur.fploss<=cur.frss && cur.fploss<=cur.ftrate && cur.fploss<=cur.ftime)
                cur.degreeofsuspect=cur.fploss;
            else if(cur.ftrate<=cur.frss && cur.ftrate<=cur.fploss && cur.ftrate<=cur.ftime)
                cur.degreeofsuspect=cur.ftrate;
            else
                cur.degreeofsuspect=cur.ftime;
        
            System.out.println(cur.degreeofsuspect+"");
            cur.degreeofsuspect=1-cur.degreeofsuspect;
            cur.degreeofsuspect*=100;
            
            System.out.println("\nNode:"+cur.Name+", Rss:"+cur.frss+", Ploss:"+cur.fploss+", Trate:"+cur.ftrate+", Time:"+cur.ftime+" Degree:"+cur.degreeofsuspect+"%");
        }
    }
        
    
    
}
