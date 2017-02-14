/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodeconfig;

/**
 *
 * @author REMO
 */import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class PropertyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        public ArrayList<Node> node =new ArrayList<Node>();
        NodeConfig f;
	Node N;
	JLabel X;
	JLabel Y;
	JLabel Power;
	JLabel Slevel;
	JLabel Name,Ploss;
	JComboBox<String> CPower;
	JComboBox<String> CSlevel;
        JComboBox<String> CPloss;
	String level[] = {"20","40","100","200","250"};
	String power[] = {"-30","-40","-50","-60","-70","-80","-90"};
        String ploss[]={"0","25","50","75","100"};
	int Nodei;
	
	public PropertyPanel(NodeConfig x) {
		
		f = x;
		this.setBounds(550, 50, 450, 200);
		this.setLayout(null);
		//this.setBackground(Color.RED);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		init();
	}
	
	void init(){
		Name = new JLabel("Name : ");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setBounds(170,5,110,40);
		Name.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		this.add(Name);
				
		X = new JLabel("X : ");
		X.setHorizontalAlignment(SwingConstants.CENTER);
		X.setBounds(20,55,110,40);
		X.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		this.add(X);
		
		Y = new JLabel("Y : ");
		Y.setHorizontalAlignment(SwingConstants.CENTER);
		Y.setBounds(20,105,110,40);
		Y.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		this.add(Y);
		
		Slevel = new JLabel(" Rate (kbps) :");
		Slevel.setHorizontalAlignment(SwingConstants.CENTER);
		Slevel.setBounds(200,55,110,40);
		Slevel.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		this.add(Slevel);
		
		CSlevel = new JComboBox<String>(level);
		CSlevel.setBounds(320,55,110,40);
		CSlevel.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		CSlevel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				level(e);
			}
		});
		this.add(CSlevel);
		
		Power = new JLabel("RSS (dBm) : ");
		Power.setHorizontalAlignment(SwingConstants.CENTER);
		Power.setBounds(200,105,110,40);
		Power.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		this.add(Power);
		
		CPower = new JComboBox<String>(power);
		CPower.setBounds(320,105,110,40);
		CPower.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		CPower.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				power(e);
			}
		});
		this.add(CPower);
		
                Ploss = new JLabel(" Loss (%) : ");
		Ploss.setHorizontalAlignment(SwingConstants.CENTER);
		Ploss.setBounds(200,155,110,40);
		Ploss.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		this.add(Ploss);
		
		CPloss = new JComboBox<String>(ploss);
		CPloss.setBounds(320,155,110,40);
		CPloss.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		CPloss.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ploss(e);
			}
		});
		this.add(CPloss);
	}
	
	void setProperties(int x,int y,String Slevel,String power,String SPloss,String name, Node C ){
		Nodei = Integer.parseInt(name);
		Name.setText("Node "+name);
		N = C;
		X.setText(" X : "+x);
		Y.setText(" Y : "+y);
		this.Slevel.setText(" Rate (kbps) : "+Slevel);
		Power.setText(" RSS (dBm): "+power);
                Ploss.setText(" Loss (%): "+SPloss);
		this.revalidate();
		this.repaint();
		f.revalidate();
		f.repaint();
	}
	
	void level(ActionEvent e){
		try{
			String i = (String)CSlevel.getSelectedItem();
			int n = Integer.parseInt(i);
			N.SLevel =i;
			Slevel.setText(" Rate (kbps) : " + i);
			//f.dp.constructGraph();
			//f.dp.arrowc =0;
			//f.dp.aow =0;
			//f.dp.dijkstra(f.dp.Graph, f.p.start, f.p.end);
			this.revalidate();
			this.repaint();
			f.revalidate();
			f.repaint();
			//graph();
		}
		catch(Exception E){
			JOptionPane.showMessageDialog(f,
				    "No Node is Selected");
                        System.out.println(E+"");
		}
	}
	
	void power(ActionEvent e){
		try{
			int i = CPower.getSelectedIndex();
			String msg = "";
			N.power=power[i];
			Power.setText(" RSS (dBm) : "+power[i]);
			this.revalidate();
			this.repaint();
			f.repaint();
			f.revalidate();
			//graph();
		}catch(Exception E){
			JOptionPane.showMessageDialog(f,
				    "No Node is selected");
		}
	}
	
        void ploss(ActionEvent e){
		try{
			String i = (String)CPloss.getSelectedItem();
			int n = Integer.parseInt(i);
			N.SPloss =i;
			Ploss.setText("Loss (%) : " + i);
			//f.dp.constructGraph();
			//f.dp.arrowc =0;
			//f.dp.aow =0;
			//f.dp.dijkstra(f.dp.Graph, f.p.start, f.p.end);
			this.revalidate();
			this.repaint();
			f.revalidate();
			f.repaint();
			//graph();
		}
		catch(Exception E){
			JOptionPane.showMessageDialog(f,
				    "No Node is Selected");
                        System.out.println(E+"");
		}
	}
	
        
	void graph(){
		f.td.txt.append("\n >>> /******* Node"+N.Name+" ***********/");
		f.td.txt.append("\n");
		f.td.txt.append("\n gram image of Graph change");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n| D\tDi\tG\tR\t|");
		f.td.txt.append("\n| 0\t0 \t1\t0\t|");
		f.td.txt.append("\n| S\tA\tRq\tRp\t|");
		f.td.txt.append("\n| 0\t0\t0 \t1 \t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tFrom : Node"+N.Name+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tBroadcast message\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t Graph \t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n");
	}
}
