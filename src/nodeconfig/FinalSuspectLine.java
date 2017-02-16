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
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.*;

public class FinalSuspectLine extends ApplicationFrame
{
   public FinalSuspectLine( String applicationTitle , String chartTitle )
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Nodes","Degree Of Suspect",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( )
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      for(int i=0;i<suspectline.size();i++){
      dataset.addValue( Double.valueOf(suspectline.get(i)) , "Degree Of Suspect" , "Node "+i+"" );
      }
      return dataset;
   }
   static ArrayList<String> suspectline;
   public static void putLine(ArrayList<String> suspect) 
   {
       suspectline=suspect;
      FinalSuspectLine chart = new FinalSuspectLine(
      "Fuzzy Decision Making" ,
      "Degree Of Suspect");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}
