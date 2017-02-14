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

public class Node extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NodeConfig f;
	String Name;
	Node my;
	int X,Y;
	String SLevel = "20";
	String power = "-30";
        String SPloss="0";
        double frss,fploss,ftrate,ftime;
        double degreeofsuspect;
	
	public Node(NodeConfig f,int x,int y,int name) {
		// TODO Auto-generated constructor stub
		
		this.f = f;
		Name = ""+name;
		X = x;
		Y = y;
		my = this;
		
		this.setBounds(x-5,y-10,20,20);
		//this.setBackground(Color.RED);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				
				f.td.txt.append("\n /--------------- Node "+Name+" Configuration ---------------/");
                                f.td.txt.append("\n Node Details: \n Rate: "+SLevel+"\n RSS: "+power+"\n Loss : "+SPloss);
				f.pp.setProperties(X, Y, SLevel, power,SPloss, Name, my);
//				f.dp.dijkstra(f.dp.Graph,Integer.parseInt(Name));
				
			}
		});
		
		//Discovery();
		//Graph();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		 int fontSize = 12;
		 g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		 g.setColor(Color.BLUE);
		 g.drawString(Name,3,13);
	}
/*	
	void Discovery(){
		f.td.txt.append("\n >>> /******* Node"+Name+" ***********");
		f.td.txt.append("\n");
		f.td.txt.append("\n Datagram image of discovery request");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n| D\tDi\tG\tR\t|");
		f.td.txt.append("\n| 0\t1 \t0\t0\t|");
		f.td.txt.append("\n| S\tA\tRq\tRp\t|");
		f.td.txt.append("\n| 0\t0\t0 \t0 \t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tFrom : Node"+Name+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tBroadcast message\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tNo Data\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n");
	}
	
	void Graph(){
		f.td.txt.append("\n >>> /******* Node"+Name+" ***********");
		f.td.txt.append("\n");
		f.td.txt.append("\n Datagram image of Graph request");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n| D\tDi\tG\tR\t|");
		f.td.txt.append("\n| 0\t0 \t1\t0\t|");
		f.td.txt.append("\n| S\tA\tRq\tRp\t|");
		f.td.txt.append("\n| 0\t0\t1 \t0 \t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tFrom : Node"+Name+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tBroadcast message\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tNo Data\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n");
	}
*/
}
