package id.ac.poliban.mi.vb.e020320055.powerreceiverchallenge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            int state = intent.getIntExtra("state", -1);
            switch (state) {
                case 0:
                    Toast.makeText(context, "Headset disconnected",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(context, "Headset connected",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}