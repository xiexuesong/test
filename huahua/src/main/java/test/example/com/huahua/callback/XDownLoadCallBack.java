package test.example.com.huahua.callback;

import java.io.File;

/**
 * Created by admin on 2018/5/3.
 */

public interface XDownLoadCallBack {

    void onstart();
    void onLoading(long total, long current, boolean isDownloading);
    void onSuccess(File result);
    void onFail(String result);
    void onFinished();

}
