package octopus.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameView extends SurfaceView implements OnTouchListener, SurfaceHolder.Callback {

	public GameView(Context context) {
		super(context);
		getHolder().addCallback(this);
		
	}

	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		
	}

	public void surfaceCreated(SurfaceHolder arg0) {
		
	}

	public void surfaceDestroyed(SurfaceHolder arg0) {
		
	}

	public boolean onTouch(View arg0, MotionEvent arg1) {
		
		return true;
	}
	
	

}
