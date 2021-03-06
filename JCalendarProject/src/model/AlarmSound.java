package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
* this class holds a reference to a sound file
* used for alarm
*
*/
public class AlarmSound {
	private String filePath;
	private InputStream in;
	private AudioStream audioStream;
	/**
	 * Constructor requires path to a audio file used as an alarm sound
	 * @param path
	 */
	public AlarmSound(String path){
		this.filePath = path;
		try {
			this.in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.audioStream = new AudioStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * this method is responsible for playing alarm sound
	 */
	public void playAlarm()
	{
		try {
			this.in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.audioStream = new AudioStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AudioPlayer.player.start(this.audioStream);
	}
	/*
	 * this method is responsible for stopping alarm sound
	 */
	public void stopAlarm() {
		AudioPlayer.player.stop(this.audioStream);
		try {
			audioStream.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
