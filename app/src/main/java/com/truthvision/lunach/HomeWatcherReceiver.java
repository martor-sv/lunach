package com.truthvision.lunach;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HomeWatcherReceiver extends BroadcastReceiver {
    private static final String TAG = "HomeWatcherReceiver";

    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";

    private static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALOG_REASON_LOCK = "lock";
    private static final String SYSTEM_DIALOG_REASON_ASSIST = "assist";


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i(TAG, "onReceive: action: " + action);
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)){
            String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
            Log.i(TAG, "onReceive: reason: " + reason);

            if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)){
                Log.i(TAG, "onReceive: homekey");
                Intent intent1 = new Intent(context,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }else if (SYSTEM_DIALOG_REASON_RECENT_APPS.equals(reason)){
                Intent intent1 = new Intent(context,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
                Log.i(TAG, "onReceive: long press home key");
            }
            else if (SYSTEM_DIALOG_REASON_LOCK.equals(reason)){
                Log.i(TAG, "onReceive: lock");
            }else if (SYSTEM_DIALOG_REASON_ASSIST.equals(reason)){

            }
        }
    }
}
