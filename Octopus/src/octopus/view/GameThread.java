package octopus.view;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	
	private final static int SLEEP_TIME = 40;
	private GameView canvas;
	private SurfaceHolder surfaceHolder = null;
	boolean running = false;
	
	public GameThread(GameView gameView){
		super();
		canvas = gameView;
		surfaceHolder = gameView.getHolder();
	}
	
	public void startThread(){
		running = true;
		super.start();
	}
	
	public void stopThread(){
		running = false;
	}
	
	public void run(){
		Canvas c = null;
		
		while(running){
			c = null;
			try {
				c = surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					if (c != null) {
						canvas.draw(c);
					}
				}
				sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				
			} finally {
				if (c != null) {
					surfaceHolder.unlockCanvasAndPost(c);
				}
			}
		}
	}
}
