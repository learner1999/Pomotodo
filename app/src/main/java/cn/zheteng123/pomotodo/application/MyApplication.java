package cn.zheteng123.pomotodo.application;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/08
 *     desc   : 自定义 Application
 *     version: 1.0
 * </pre>
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 配置 Realm
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }
}
