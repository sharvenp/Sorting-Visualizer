package utils;

import javax.sound.sampled.*;

import main.Settings;
import stratergies.SortStratergy;
public class ToneGenerator {
	
    public static float SAMPLE_RATE = 8000f;

    private static void tone(int hz, int msecs, double vol) throws LineUnavailableException {
        byte[] buf = new byte[1];
        AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1, true, false);     
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i=0; i < msecs*8; i++) {
              double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
              buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
              sdl.write(buf,0,1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }
    
    public static void generateTone(double value) {
    	try {
    		double maxVal = (double) (SortStratergy.sortingArray.length - 1);
    		double percentage = value / maxVal;
			tone((int) (percentage * Settings.maxFrequency), Settings.toneDuration, Settings.toneVolume);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
    }
}
