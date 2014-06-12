package simulation;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Program Starts here.
 * 
 * @author Jeffrey Carter, Dharmin Shah, Zack Stewart Created Oct 10, 2011.
 */
public class Main {

	/**
	 * Starts here.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 */
	public static void main(String[] args) throws LineUnavailableException,
			UnsupportedAudioFileException, IOException {
		new StartUpScreen();
	}
}
