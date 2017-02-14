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


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.*;
/**
 *
 * @author REMO
 */

public class FinalFuzzyChart extends ApplicationFrame
{
   public FinalFuzzyChart( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Nodes",            
         "Fuzzy",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {    
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );      
      for(int i=0;i<fuzzyploss.size();i++){
       //   System.out.println("Check: "+Double.valueOf(fuzzydelay.get(i))+"");
      dataset.addValue( Double.valueOf(fuzzydelay.get(i)) , "Fuzzy(Delay)" , "Node " +(i+1) );        
      dataset.addValue( Double.valueOf(fuzzyploss.get(i)) , "Fuzzy(Loss)" , "Node " +(i+1) ); 
      dataset.addValue( Double.valueOf(fuzzytrate.get(i)) , "Fuzzy(Rate)" , "Node " +(i+1) );           
      }      
      return dataset; 
   }
  static ArrayList<String> fuzzyploss, fuzzytrate, fuzzydelay;
   public static void putBar(ArrayList<String> fuzzydelay1, ArrayList<String> fuzzyploss1, ArrayList<String> fuzzytrate1 )
   {
      fuzzyploss=fuzzyploss1;
      fuzzytrate=fuzzytrate1;
      fuzzydelay=fuzzydelay1;
     // System.out.println("Check: "+fuzzyploss+fuzzydelay+fuzzytrate);
      FinalFuzzyChart chart = new FinalFuzzyChart("Fuzzification", "Fuzzy Values");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}