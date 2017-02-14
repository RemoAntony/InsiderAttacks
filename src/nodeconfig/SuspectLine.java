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

public class SuspectLine extends ApplicationFrame
{
   public SuspectLine( String applicationTitle , String chartTitle )
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
      for(int i=0;i<StoringNodes.SetOfAllNodes.size();i++){
          Node cur=StoringNodes.SetOfAllNodes.get(i);   
      dataset.addValue( cur.degreeofsuspect , "Degree Of Suspect" , cur.Name );
      }
      return dataset;
   }
   public static void putLine() 
   {
      SuspectLine chart = new SuspectLine(
      "Fuzzy Decision Making" ,
      "Degree Of Suspect");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}