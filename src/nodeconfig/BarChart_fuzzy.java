/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodeconfig;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author REMO
 */

public class BarChart_fuzzy extends ApplicationFrame
{
   public BarChart_fuzzy( String applicationTitle , String chartTitle )
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
      for(int i=0;i<StoringNodes.SetOfAllNodes.size();i++){
          Node cur=StoringNodes.SetOfAllNodes.get(i);
      dataset.addValue( cur.frss , "Fuzzy(RSS)" ,"Node " +cur.Name );        
      dataset.addValue( cur.ftime , "Fuzzy(Time)" , "Node " +cur.Name );        
      dataset.addValue( cur.fploss , "Fuzzy(Loss)" , "Node " +cur.Name ); 
      dataset.addValue( cur.ftrate , "Fuzzy(Rate)" , "Node " +cur.Name );           
      }      
      return dataset; 
   }
   public static void putBar( )
   {
      BarChart_fuzzy chart = new BarChart_fuzzy("Fuzzification", "Fuzzy Values");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}