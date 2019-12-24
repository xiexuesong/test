package test.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.File;

import test.example.com.huahua.callback.XDownLoadCallBack;
import test.example.com.huahua.utils.InstallApk;
import test.example.com.huahua.utils.XutilsHttp;

public class MainActivity extends AppCompatActivity implements XDownLoadCallBack {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        XutilsHttp.getInstance().downFile("https://res.chuanying365.com/r/apk/v2.2.8.apk ",getFilesDir().getAbsolutePath() + "/test.apk",this);
    }

    @Override
    public void onstart() {

    }

    @Override
    public void onLoading(long total, long current, boolean isDownloading) {
        Log.i("MDL","total:" + total + " current:" + current);
        progressBar.setProgress((int) (current  / (total * 1f)));
    }

    @Override
    public void onSuccess(File result) {
        InstallApk.installApp(this,result.getAbsolutePath());
    }

    @Override
    public void onFail(String result) {

    }

    @Override
    public void onFinished() {

    }
}
