package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.KeyEvent;

public class MediaReciever extends BroadcastReceiver {
    @Override

    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())){
            KeyEvent event=(KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if (event == null) {
                return;
            }

            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_MEDIA_BUTTON);
                Log.d("ENTERED","headBroad");
                context.sendBroadcast(i);
            }


        }
    }
}
