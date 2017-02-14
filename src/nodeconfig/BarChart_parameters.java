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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_parameters extends ApplicationFrame
{
   public BarChart_parameters( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Nodes",            
         "Values",            
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
      dataset.addValue( Double.valueOf(cur.power)*-1 , "RSS" ,"Node " +cur.Name );        
      dataset.addValue( Double.valueOf(cur.Name) , "Time" , "Node " +cur.Name );        
      dataset.addValue( Double.valueOf(cur.SPloss) , "Loss" , "Node " +cur.Name ); 
      dataset.addValue( Double.valueOf(cur.SLevel) , "Rate" , "Node " +cur.Name );           
      }      
      return dataset; 
   }
   public static void putBar( )
   {
      BarChart_parameters chart = new BarChart_parameters("Node Statistics", "Parameters");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}