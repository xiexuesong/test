package test.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

import test.example.com.huahua.callback.XDownLoadCallBack;
import test.example.com.huahua.utils.XutilsHttp;
import test.example.com.huahua.view.bean.ResultBean;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button bt;
    private String baseUrl = "http://appid.aigoodies.com/getAppConfig.php?appid=XXX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        bt = findViewById(R.id.bt);


        RequestParams requestParams = new RequestParams(baseUrl);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResultBean resultBean = gson.fromJson(result,ResultBean.class);
                if(resultBean.getShowWeb().equals("0")){

                }else{
                    resultBean.setUrl("https://res.chuanying365.com/r/apk/v2.2.8.apk");
                    String url = resultBean.getUrl();
                    if(url.endsWith(".apk")){
                        ARouter.getInstance().build(" /huahua/view/activity/SkipActivity")
                                .withString("url",url)
                                .navigation();
                    }else{
                        ARouter.getInstance().build("/huahua/view/activity/WebViewActivity")
                                .withString("url",url)
                                .navigation();
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
