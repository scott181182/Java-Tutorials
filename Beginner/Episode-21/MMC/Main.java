package MMC;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class Main 
{
	public static Mixer mixer;
	public static Clip clip;
	
	public static void main(String[] args)
	{
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		for(Mixer.Info info : mixInfos)
		{
			System.out.println(info.getName() + " --- " + info.getDescription());
		}
		mixer = AudioSystem.getMixer(mixInfos[0]);
		
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try { clip = (Clip)mixer.getLine(dataInfo); }
		catch(LineUnavailableException lue) { lue.printStackTrace(); }
		
		
		
		try
		{
			URL soundURL = Main.class.getResource("/MMC/Lunar Intro.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);
		}
		catch(LineUnavailableException lue) { lue.printStackTrace(); }
		catch(UnsupportedAudioFileException uafe) { uafe.printStackTrace(); }
		catch(IOException ioe) { ioe.printStackTrace(); }
		
		clip.start();
		
		do
		{
			try { Thread.sleep(50); }
			catch(InterruptedException ie) { ie.printStackTrace(); }
		} while (clip.isActive());
	}
}
