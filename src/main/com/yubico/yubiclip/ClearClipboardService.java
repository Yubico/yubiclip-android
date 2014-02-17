package com.yubico.yubiclip;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by dain on 2/17/14.
 */
public class ClearClipboardService extends Service {
    public static final String YUBI_CLIP_DATA = "YubiClip data";

    private Handler handler = new Handler();
    private int copyCount = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final int clearCount = ++copyCount;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (clearCount == copyCount) {
                    clearClipboard();
                    stopSelf();
                }
            }
        }, 10000); 
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void clearClipboard() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if(YUBI_CLIP_DATA.equals(clipboard.getPrimaryClip().getDescription().getLabel())) {
            clipboard.setPrimaryClip(ClipData.newPlainText("", ""));
            Toast.makeText(getApplication(), R.string.cleared, Toast.LENGTH_SHORT).show();
        }
    }
}
