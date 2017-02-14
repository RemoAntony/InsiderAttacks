package nodeconfig;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

	private static final String filename = "C:\\Users\\REMO\\Documents\\NetBeansProjects\\NodeConfig\\src\\nodeconfig\\omnetsim.txt";
	static final List<String> packetLoss = new ArrayList<String>();
	static final List<String> bitRate = new ArrayList<String>();
	static final List<String> delay = new ArrayList<String>();
        static final List<String> sensorreading = new ArrayList<String>();
	public static void main(String args[])
	{
		BufferedReader br = null;
		FileReader fr = null;
		
		try
		{
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String str;
			br = new BufferedReader(new FileReader(filename));
			while((str = br.readLine()) != null){
				//System.out.println(str);
				if(str.contains("exponential"))
				{
					String words[] = str.split(" ");
					for(int i=0; i<words.length; i++)
					{
						if(words[i].contains("exponential"))
						{
							str = str.replaceAll("\\D+", "");
							int num = Integer.parseInt(str);
							packetLoss.add(num+"");
							//System.out.println(num);
						}
						
					}
				}
				
				if(str.contains("bitrate"))
				{
					String words[] = str.split(" ");
					for(int i=0; i<words.length; i++)
					{
						if(words[i].contains("bitrate"))
						{
							str = str.replaceAll("\\D+", "");
							int num = Integer.parseInt(str);
							bitRate.add(num+"");
							//System.out.println(num);
						}
					}
				}
				if(str.contains("delay"))
				{
					String words[] = str.split(" ");
					for(int i=0; i<words.length; i++)
					{					
						if(words[i].contains("delay"))
						{
							str = str.replaceAll("\\D+", "");
							int num = Integer.parseInt(str);
							delay.add(num+"");
							//System.out.println(num);
						}
					}
				}
			}
                        /*
			System.out.println("PacketLoss :\n");
			for(int n=0; n< packetLoss.size();n++)
				System.out.println(packetLoss.get(n));
			
			System.out.println("Bit Rate :\n");
			for(int n=0;n< bitRate.size();n++)
				System.out.println(bitRate.get(n));

			System.out.println("Delay :\n");
			for(int n=0;n< delay.size();n++)
				System.out.println(delay.get(n));

			*/	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
                FuzzyNew.fuzzify(packetLoss,bitRate,delay,sensorreading);
	}
}
