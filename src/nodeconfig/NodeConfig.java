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
import java.awt.event.*;

import javax.swing.JFrame;

public class NodeConfig extends JFrame {

	/**
	 * 
	 */
	// TODO declaration
	private static final long serialVersionUID = 1L;
	OptionPanel p;
	DisplayPanel dp;
	PropertyPanel pp;
	TxtDisplay td;
	
	public NodeConfig() {
		super("Final Year Project- RDJ Security Scheme");
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		this.setLayout(null);
		this.setSize(1000,600);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeConfig a = new NodeConfig();
		a.init();
	}
	
	void init(){
		// TODO init function
		p = new OptionPanel(this);
		this.add(p);
		
		dp = new DisplayPanel(this);
		this.add(dp);
		
		pp = new PropertyPanel(this);
		this.add(pp);
		
		td = new TxtDisplay(this);
		this.add(td);
		this.revalidate();
		this.repaint();
	}

}
