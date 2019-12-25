package test.example.com.huahua.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.io.File;

import test.example.com.huahua.R;
import test.example.com.huahua.callback.XDownLoadCallBack;
import test.example.com.huahua.utils.InstallApk;
import test.example.com.huahua.utils.XutilsHttp;

@Route(path =  "/huahua/view/activity/SkipActivity")
public class SkipActivity extends Activity implements XDownLoadCallBack {

    private ProgressBar progressBar;
    private TextView tv_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);

        progressBar = findViewById(R.id.progressBar);
        tv_progress = findViewById(R.id.tv_progress);
        Log.i("MDL","1111");
        XutilsHttp.getInstance().downFile("https://res.chuanying365.com/r/apk/v2.2.8.apk",getFilesDir().getAbsolutePath() + "/test.apk",this);
    }

    @Override
    public void onstart() {

    }

    @Override
    public void onLoading(long total, long current, boolean isDownloading) {
        int progress = (int) (current  / (total * 1f) * 100);
        Log.i("MDL","progress:" + progress);
        progressBar.setProgress(progress);
        tv_progress.setText(progress + "%");
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
