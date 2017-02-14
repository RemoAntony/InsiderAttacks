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


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class DisplayPanel extends JPanel{

	/**
	 * 
	 */
	// TODO Declaration 
	private static final long serialVersionUID = 1L;
	NodeConfig f;
	DisplayPanel my;
	int n=0;
	int X[] = new int[20];
	int Y[] = new int[20];
	int Graph[][] = new int[20][20];
	Node N[] = new Node[20];
	int r = 100;
	int arrow[] = new int[20];
	int arrowc = 0;
	int aow = 0;
	int dateRate = 20;
	
	public DisplayPanel(NodeConfig x) {
		// TODO Auto-generated constructor stub
		
		f = x;
		my = this;
		this.setBounds(0, 50, 550, 550);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		init();
		
	}
	
	void init(){
		//TODO Init function
		
		this.addMouseListener(new MouseAdapter(){
			
			@Override
			public void mouseClicked(MouseEvent e){
				try{
					if(f.p.NB.isSelected() && n < 100){
						X[n] = e.getX();
						Y[n] = e.getY();
						Node node = new Node(f,X[n],Y[n],n);
                                                
                                                StoringNodes.SetOfAllNodes.add(node);
                                                
						N[n] = node;
	//					f.p.s.addItem(""+n);
	//					f.p.e.addItem(""+n);
						my.add(node);
						my.revalidate();
						my.repaint();
						f.revalidate();
						f.repaint();
						n++;
	//					constructGraph();
					}
					
				}catch(Exception E){
					System.out.println(E);
				}
			}
		});
		
	}
	/*
	void constructGraph(){
		for(int i=0;i<n;i++){
			Node node = N[i];
			
			for(int j=0;j<n;j++){
				Node node2 = N[j];
				if(node == node2){
					Graph[i][j] = 0;
				}
				else if(!node.power){
					Graph[i][j] = 0;
				}
				else if(!node2.power){
					
				}
				else{
					// System.out.println(node.X+" <- value -> "+node2.X);
					int x = node.X - node2.X;
					x = x*x;
					int y = node.Y - node2.Y;
					y= y*y;
					if((x+y) < (r*r)){
						Graph[i][j] = node2.SLevel * dateRate;
					}
					else{
						Graph[i][j] = 0;
					}
				}
			}
		}
		
		display();
		
	}
	
	void display(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(" "+Graph[i][j]);
			}
			System.out.println("");
		}
	}
	*/
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
                g.setColor(Color.BLUE);
		g.fillOval(250, 250, 40, 40);
		g.setColor(Color.RED);
                for(int i=0;i<n;i++){
			int x = X[i] - (r/2);
			int y = Y[i] - (r/2);
			g.drawOval(x, y, r, r);
		}
		
		for(int i=0;i<(aow-1);i++){
			g.drawLine(X[arrow[i]], Y[arrow[i]], X[arrow[i+1]], Y[arrow[i+1]]);
		}
		
		
		
	}
	/*
	void drawlines(Graphics g){
		
	}
	
	
	void dijkstra(int graph[][], int src,int dest)
	{
	    int dist[] = new int[20];  
	    
	    boolean sptSet[] = new boolean[20];
	 
	    int parent[] = new int[20];
	 
	    for (int i = 0; i < 20; i++)
	    {
	        parent[i] = -1;
	        dist[i] = 9999;
	        sptSet[i] = false;
	    }
	 
	    dist[src] = 0;
	 
	    for (int count = 0; count < n; count++)
	    {
	        int u = minDistance(dist, sptSet);
	 
	        sptSet[u] = true;
	 
	        for (int v = 0; v < n; v++)
	 
	            if (!sptSet[v] && graph[u][v]!=0 && dist[u] + graph[u][v] < dist[v])
	            {
	                parent[v]  = u;
	                dist[v] = dist[u] + graph[u][v];
	            }  
	    }
	 
	    printSolution(dist, n, parent,src,dest);
	}
	
	int minDistance(int dist[], boolean sptSet[])
	{
	    int min = 9999, min_index = 0;
	 
	    for (int v = 0; v < n; v++)
	        if (sptSet[v] == false && dist[v] <= min){
	            min = dist[v];
	            min_index = v;
	        }
	 
	    return min_index;
	}
	 
	void printPath(int parent[], int j)
	{
	    if (parent[j]==-1)
	        return;
	 
	    printPath(parent, parent[j]);
	 
	    System.out.print(" "+ j);
	    arrow[arrowc]=j;
	    arrowc++;
	}
	 
	void printSolution(int dist[], int n, int parent[],int src,int dest)
	{
			if(dist[dest]>=9999){
				JOptionPane.showMessageDialog(f,"Connection Lost");
				repaint();
			}
			else{
		    	System.out.println("Vertex\t  Distance\tPath");
		        System.out.print(src+"->"+dest+" \t\t "+dist[dest]+"\t\t"+src);
		        arrow[arrowc]=src;
		        arrowc++;
		        printPath(parent, dest);
		        displayLink();
			}
	}
	
	void displayLink(){
		
		repaint();
		f.repaint();
		f.revalidate();
		
		Thread t = new Thread(){
			public void run(){
				for(int i=0;i<arrowc;i++){
					aow++;
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
					}
					repaint();
				}
		//		ack(f.p.start,f.p.end);
		//		data(f.p.start,f.p.end);
			}
		};
		t.start();
	}
	
	void dijkstra(int graph[][], int src)
	{
	    int dist[] = new int[20];
	    boolean sptSet[] = new boolean[20];
	 
	    int parent[] = new int[20];
	 
	    for (int i = 0; i < 20; i++)
	    {
	        parent[i] = -1;
	        dist[i] = 9999;
	        sptSet[i] = false;
	    }
	 
	    dist[src] = 0;
	 
	    for (int count = 0; count < n; count++)
	    {
	        int u = minDistance(dist, sptSet);
	 
	        sptSet[u] = true;
	 
	        for (int v = 0; v < n; v++)
	 
	            if (!sptSet[v] && graph[u][v]!=0 && dist[u] + graph[u][v] < dist[v])
	            {
	                parent[v]  = u;
	                dist[v] = dist[u] + graph[u][v];
	            }  
	    }
	 
	   // printSolution(dist, n, parent,src);
	}
	/*
	void printSolution(int dist[],int n, int parent[],int src)
	{
	    System.out.println("\n Vertex\t  Distance\tPath");
	    f.td.txt.append("\n Vertex\t  Distance\tPath");
	    for (int i = 1; i < n; i++)
	    {
	    	if(dist[i]>=9999){
	    		
	    	}
	    	else{
	    		f.td.txt.append("\n"+src+"->"+i+" \t "+dist[i]+"\t"+src+"");
	    		System.out.println("\n"+src+"->"+i+" \t\t "+dist[i]+"\t\t"+src+"");
		        printPathtxt(parent, i);
	    	}
	    	
	    }
	}*/
/*	
	void printPathtxt(int parent[], int j)
	{
	    if (parent[j]==-1)
	        return;
	 
	    printPathtxt(parent, parent[j]);
	    f.td.txt.append(" "+ j);
	}
	
	void ack(int start,int end){
		f.td.txt.append("\n >>> /******* Acknowlegde request ***********");
		f.td.txt.append("\n");
		f.td.txt.append("\n Datagram image of Ack request");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n| D\tDi\tG\tR\t|");
		f.td.txt.append("\n| 1\t0 \t0\t0\t|");
		f.td.txt.append("\n| S\tA\tRq\tRp\t|");
		f.td.txt.append("\n| 0\t1\t0 \t0 \t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t From : Node"+end+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t To : Node"+start+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\tNo Data\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n");
	}
	
	void data(int start,int end){
		f.td.txt.append("\n >>> /******* Sending data ***********");
		f.td.txt.append("\n");
		f.td.txt.append("\n Datagram image of Data request r sending");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n| D\tDi\tG\tR\t|");
		f.td.txt.append("\n| 1\t0 \t0\t0\t|");
		f.td.txt.append("\n| S\tA\tRq\tRp\t|");
		f.td.txt.append("\n| 0\t0\t1 \t0 \t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t From : Node"+end+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t To : Node"+start+"\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n|\t  Data\t\t\t|");
		f.td.txt.append("\n __________________________________________________");
		f.td.txt.append("\n");
	}
*/	
}
