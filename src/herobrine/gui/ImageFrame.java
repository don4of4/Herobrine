package herobrine.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ImageFrame extends JFrame implements Runnable {

	private BufferedImage image;
	private BufferStrategy buffer;
	
	public ImageFrame(BufferedImage image) {
		super.setVisible(true);
		this.image = image;
		
		super.createBufferStrategy(2);
		this.buffer = super.getBufferStrategy();
		
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while(true) {
			Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0,0,getWidth(),getHeight());
			
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
			
			g.dispose();
			buffer.show();
			
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
