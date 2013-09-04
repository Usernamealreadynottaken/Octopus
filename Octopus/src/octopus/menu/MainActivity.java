package octopus.menu;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}
	
	public void exit() {
		finish();
		System.exit(0);
	}

}
