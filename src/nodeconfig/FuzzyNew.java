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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author REMO
 */
public class FuzzyNew {
    static ArrayList<String> fuzzytrate;
    static ArrayList<String>  fuzzyploss;
    static ArrayList<String> fuzzydelay;
    static ArrayList<String> suspectline;
    public static void fuzzify(List<String> ploss,List<String> bitrate,List<String> delay,List<String> reading)
    {
        int mintrate=1;
        int maxtrate=150;
        int packetssent=0;
        for(int i=0;i<ploss.size();i++)
        {
            if(packetssent<Integer.valueOf(ploss.get(i)))
            {
                packetssent=Integer.valueOf(ploss.get(i));
            }
        }
        fuzzyploss=new ArrayList<String>();
        for(int i=0;i<ploss.size();i++)
        {
            int cal=packetssent-Integer.valueOf(ploss.get(i));
            double temp=(packetssent-cal)/(double)packetssent;
            fuzzyploss.add(temp+"");
        }
         fuzzytrate=new ArrayList<String>();
       //  System.out.println(bitrate.get(0));
         
        for(int i=0;i<bitrate.size();i++)
        {
            int cal=Integer.valueOf(bitrate.get(i));
            double temp=1-((maxtrate-cal)/(double)maxtrate);
            fuzzytrate.add(temp+"");
        }
        
        
        int maxdelay=0;
        for(int i=0;i<ploss.size();i++)
        {
            if(maxdelay<Integer.valueOf(delay.get(i)))
            {
                maxdelay=Integer.valueOf(delay.get(i));
            }
        }
        
        fuzzydelay=new ArrayList<String>();
        for(int i=0;i<delay.size();i++)
        {           
            double temp=(maxdelay-Double.valueOf(delay.get(i)))/(double)maxdelay;
            fuzzydelay.add(temp+"");
        }
        
        //displaying
        System.out.println("Fuzzified Packet Loss:");        
            System.out.println(fuzzyploss);
        System.out.println("Fuzzified Transmission Rate:");        
            System.out.println(fuzzytrate);
        System.out.println("Fuzzified Delay:");
            System.out.println(fuzzydelay);
        
        try{ 
                                FinalFuzzyChart.putBar(fuzzydelay, fuzzyploss, fuzzytrate);                               
                               }catch(Exception e){System.out.println(e+"");}
     suspectline=new ArrayList<String>();
     for(int i =0;i<fuzzyploss.size();i++)
     {
       double min=Double.valueOf(fuzzyploss.get(i));
       if(Double.valueOf(fuzzytrate.get(i))<min) min=Double.valueOf(fuzzytrate.get(i));
       else min=Double.valueOf(fuzzydelay.get(i));
       
       suspectline.add(min+"");
     }
     
     try{ 
                                FinalSuspectLine.putLine(suspectline);                               
                               }catch(Exception e){System.out.println(e+"");
                             }
    }
       
    
    
}
