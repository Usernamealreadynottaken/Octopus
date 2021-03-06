package octopus.view;

import octopus.menu.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameView extends SurfaceView implements OnTouchListener, SurfaceHolder.Callback {

	private GameThread thread;
	private Bitmap cueTable = null;
	private Paint paint;
	
	private float screenWidth;
	private float screenHeight;
	
	public GameView(Context context) {
		super(context);
		getHolder().addCallback(this);
		paint = new Paint();
		paint.setColor(Color.RED);
	}
	
	public void loadBackground() {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cue_table);
		cueTable = Bitmap.createScaledBitmap(bitmap, (int)screenWidth, (int)screenHeight, true);
	}
	
	public void startGame() {
		if (thread == null) {
			thread = new GameThread(this);
			thread.startThread();
		}
	}
	
	public void stopGame() {
		if (thread != null) {
			thread.stopThread();
			boolean retry = true;
			while (retry) {
				try {
					thread.join();
					retry = false;
				} catch (InterruptedException e) {
					
				}
			}
			thread = null;
		}
	}
	
	public void draw(Canvas canvas) {
		if (cueTable != null) {
			canvas.drawBitmap(cueTable, 0, 0, null);
		}
	}

	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		
	}

	public void surfaceCreated(SurfaceHolder arg0) {
		startGame();
	}

	public void surfaceDestroyed(SurfaceHolder arg0) {
		stopGame();
	}

	public boolean onTouch(View arg0, MotionEvent arg1) {
		
		return true;
	}

	public float getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(float screenWidth) {
		this.screenWidth = screenWidth;
	}

	public float getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(float screenHeight) {
		this.screenHeight = screenHeight;
	}
	
	

}
