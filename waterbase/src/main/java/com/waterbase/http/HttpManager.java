package com.waterbase.http;

import android.os.Message;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.waterbase.R;
import com.waterbase.http.common.DefaultObserver;
import com.waterbase.http.common.ProgressUtils;
import com.waterbase.ui.BaseActivity;
import com.waterbase.ui.BaseFragment;
import com.waterbase.utile.LogUtil;

import java.lang.ref.SoftReference;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by Water on 2018/3/30.
 */

public class HttpManager {

    /*软引用對象*/
    private BaseActivity baseActivity;
    private LifecycleProvider lifecycleProvider;

    public HttpManager(BaseActivity baseActivity, LifecycleProvider lifecycleProvider) {
        this.baseActivity = baseActivity;
        this.lifecycleProvider = lifecycleProvider;
    }

    public void doHttpDeal(Observable observable, DefaultObserver defaultObserver) {
        defaultObserver.setContext(baseActivity);
        observable.compose(lifecycleProvider.bindToLifecycle())
                .compose(ProgressUtils.applyProgressBar(baseActivity))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultObserver);
    }

    public void doHttpDeal(String msg, Observable observable, DefaultObserver defaultObserver) {
        defaultObserver.setContext(baseActivity);
        observable.compose(lifecycleProvider.bindToLifecycle())
                .compose(ProgressUtils.applyProgressBar(baseActivity, msg))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultObserver);
    }
}
