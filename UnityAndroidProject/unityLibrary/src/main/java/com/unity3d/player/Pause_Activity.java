package com.unity3d.player;

import android.app.Activity;
import android.os.Bundle;

/**
 * Pause_Activity Class
 * @author Danil Kuzin
 * @version 0.1
 */
public class Pause_Activity extends Activity {

    /**
     * The onCreate method opens the menu interface, assigns the Listener to the Resume button
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);
        findViewById(R.id.resume).setOnClickListener(view -> {finish();});
    }

}
