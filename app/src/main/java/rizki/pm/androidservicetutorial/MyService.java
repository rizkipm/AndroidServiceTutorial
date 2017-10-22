package rizki.pm.androidservicetutorial;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

/**
 * Created by rizkisyaputra on 10/22/17.
 */

public class MyService extends Service {

    //menambahkan media player

    private MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //mendapatkan ringtone system default
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        //setting looping play true
        //this will make the ringtone continously playing
        mediaPlayer.setLooping(true);
        //staring the player
        mediaPlayer.start();

        //we have some options for service
        //start sticky means service will be explicity started and stopped

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //stopping media playing when service is destroyed
        mediaPlayer.stop();
    }
}
