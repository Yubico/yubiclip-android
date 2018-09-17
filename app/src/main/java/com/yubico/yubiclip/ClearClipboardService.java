package com.yubico.yubiclip;

import android.app.Service;
import android.content.*;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by dain on 2/17/14.
 */
public class ClearClipboardService extends Service {
    public static final String YUBI_CLIP_DATA = "YubiClip data";

    private final Handler handler = new Handler();
    private int copyCount = 0;

    public ClearClipboardService() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final int clearCount = ++copyCount;
        int timeout = Integer.parseInt(prefs.getString(getString(R.string.pref_timeout), "-1"));
        if(timeout > 0) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (clearCount == copyCount) {
                        clearClipboard();
                        stopSelf();
                    }
                }
            }, timeout * 1000);
        }
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
