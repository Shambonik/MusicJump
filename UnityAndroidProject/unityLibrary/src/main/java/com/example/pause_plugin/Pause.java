package com.example.pause_plugin;


import android.app.Activity;
import android.content.Intent;

import com.unity3d.player.Pause_Activity;

/**
 * The class whose method Unity accesses to launch the pause menu
 * @author Danil Kuzin
 * @version 0.1
 */
public class Pause{

    /**
     * The Pause_Start method starts the pause menu
     * @param activity - active Unity activity
     */
    public static void Pause_Start(Activity activity){
        Intent intent = new Intent(activity, Pause_Activity.class);
        activity.startActivity(intent);
    }
}
