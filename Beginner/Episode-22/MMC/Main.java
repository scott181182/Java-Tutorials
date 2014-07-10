package MMC;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.TargetDataLine;

public class Main
{
	
	
	public static void main(String[] args)
	{
		System.out.println("Starting Sound Test...");
		
		try
		{
			AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
			
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			if(!AudioSystem.isLineSupported(info)) { System.err.println("Line not supported"); }
			
			final TargetDataLine targetLine = (TargetDataLine)AudioSystem.getLine(info);
			targetLine.open();
			
			System.out.println("Starting Recording...");
			targetLine.start();
			
			Thread thread = new Thread()
			{
				@Override public void run()
				{
					AudioInputStream audioStream = new AudioInputStream(targetLine);
					File audioFile = new File("record.wav");
					try { AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile); }
					catch(IOException ioe) { ioe.printStackTrace(); }
					System.out.println("Stopped Recording");
				}
			};
			
			thread.start();
			Thread.sleep(10000);
			targetLine.stop();
			targetLine.close();
			
			System.out.println("Ended Sound Test");
		}
		catch(LineUnavailableException lue) { lue.printStackTrace(); }
		catch(InterruptedException ie) { ie.printStackTrace(); }
	}
}
