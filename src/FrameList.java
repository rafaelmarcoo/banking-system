import java.util.ArrayList;
import javax.swing.*;

public class FrameList 
{
	private static ArrayList<JFrame> activeFrames = new ArrayList<>();
	
	public static void addFrame(JFrame frame)
	{
		activeFrames.add(frame);
	}
	
	public static void removeFrame(JFrame frame)
	{
		activeFrames.remove(frame);
	}
	
	public static void closeActiveFrames()
	{
		for(JFrame j : activeFrames)
		{
			j.dispose();
		}
		activeFrames.clear();
	}
}
