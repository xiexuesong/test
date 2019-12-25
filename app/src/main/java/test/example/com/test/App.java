package test.example.com.test;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import org.xutils.x;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
        x.Ext.init(this);
    }
}
