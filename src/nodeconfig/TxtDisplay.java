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
import javax.swing.*;

public class TxtDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea txt;
	NodeConfig f;
	public TxtDisplay(NodeConfig f) {
		// TODO Auto-generated constructor stub
		this.setBounds(550, 250,445,320);
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		txt = new JTextArea();
		txt.setEditable(false);
		txt.setLineWrap(true);
		txt.setBorder(BorderFactory.createCompoundBorder(txt.getBorder(),BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		JScrollPane sp = new JScrollPane(txt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(sp,BorderLayout.CENTER);
	}

}
