package pl.edu.radomski.architecturesample.ux;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.squareup.picasso.Picasso;

import io.palaima.debugdrawer.DebugDrawer;
import io.palaima.debugdrawer.commons.BuildModule;
import io.palaima.debugdrawer.commons.DeviceModule;
import io.palaima.debugdrawer.commons.NetworkModule;
import io.palaima.debugdrawer.commons.SettingsModule;
import io.palaima.debugdrawer.okhttp3.OkHttp3Module;
import io.palaima.debugdrawer.picasso.PicassoModule;
import io.palaima.debugdrawer.scalpel.ScalpelModule;
import io.palaima.debugdrawer.timber.TimberModule;
import pl.edu.radomski.architecturesample.api.utils.OkHttpProvider;

public class FlavouredActivity extends SuperBaseActivity {


    private DebugDrawer debugDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        debugDrawer = new DebugDrawer.Builder(this)
                .modules(
                        new BuildModule(this),
                        new DeviceModule(this),
                        new TimberModule(),
                        new ScalpelModule(this),
                        new OkHttp3Module(OkHttpProvider.provideOkHttp(this)),
                        new PicassoModule(Picasso.with(this)),
                        new NetworkModule(this),
                        new SettingsModule(this)
                ).build();


    }

    protected void onStart() {
        super.onStart();
        if (debugDrawer != null) {
            debugDrawer.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (debugDrawer != null) {
            debugDrawer.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (debugDrawer != null) {
            debugDrawer.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (debugDrawer != null) {
            debugDrawer.onStop();
        }
    }
}
