package octopus.menu;

import octopus.view.GameView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.content.pm.ActivityInfo;

public class MainActivity extends Activity {
	
	private DisplayMetrics dm;
	private float screenWidth;
	private float screenHeight;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
		setContentView(R.layout.activity_main);
	}
	
	public void play(View view) {
		GameView gameView = new GameView(this);
		gameView.setScreenWidth(screenWidth);
		gameView.setScreenHeight(screenHeight);
		gameView.loadBackground();
		setContentView(gameView);
		gameView.requestFocus();
	}
	
	public void exit(View view) {
		finish();
		System.exit(0);
	}

}
