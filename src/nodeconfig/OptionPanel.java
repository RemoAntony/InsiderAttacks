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

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class OptionPanel extends JPanel {

	/**
	 * 
	 */
	// TODO Declaration
	private static final long serialVersionUID = 1L;
	NodeConfig f;
	JToggleButton NB;
	JComboBox<String> s,e;
	JButton b;
	int start;
	int end;
	
	public OptionPanel(NodeConfig x) {
		// TODO Auto-generated constructor stub
		
		f = x;
		this.setBounds(0, 0, 1000, 50);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		init();
		
	}
	
	void init(){
		// TODO init function
		NB = new JToggleButton("Node");
		NB.setBounds(5, 5, 80, 35);
		this.add(NB);
		/*
		s = new JComboBox<String>();
		s.setBounds(60, 5, 45, 35);
		this.add(s);
		
		e = new JComboBox<String>();
		e.setBounds(110, 5, 45, 35);
		this.add(e);
		*/
		b = new JButton("Run");
		b.setBounds(160,5,70,35);
		this.add(b);
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent eve){
//				start = Integer.parseInt((String)s.getSelectedItem());
//				end = Integer.parseInt((String)e.getSelectedItem());
				//System.out.println("Start ="+start+" End = "+end);
				/*f.dp.arrowc = 0;
				f.dp.aow = 0;
				f.dp.dijkstra(f.dp.Graph,start,end);*/
				//send(start,end);
                                /*for(int i=0;i<StoringNodes.SetOfAllNodes.size();i++)
                                {
                                    new Thread()
                                        {
                                            public void run() {
                                            System.out.println("blah");
                                        }
                                    }.start();
                                }
                            */
                                Fuzzification.fuzzify();
                               
                               try{ 
                                BarChart_parameters.putBar();
                                BarChart_fuzzy.putBar();
                                SuspectLine.putLine();
                               }catch(Exception e){System.out.println(e+"");}
                                
			}
		});
		
	}
	
	void send(int start,int end){
		f.td.txt.append("\n >>> /******* Syn request ***********/");
		f.td.txt.append("\n");
		f.td.txt.append("\n Datagram image of Syn request");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n| D\tDi\tG\tR\t|");
		f.td.txt.append("\n| 1\t0 \t0\t0\t|");
		f.td.txt.append("\n| S\tA\tRq\tRp\t|");
		f.td.txt.append("\n| 1\t0\t0 \t0 \t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t From : Node"+start+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t To : Node"+end+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tNo Data\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n");
	}

}
