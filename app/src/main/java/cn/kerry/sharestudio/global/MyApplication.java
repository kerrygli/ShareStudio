package cn.kerry.sharestudio.global;


import android.app.Activity;
import android.app.Application;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;

/**
 * Created by Administrator on 2017/3/7.
 */

public class MyApplication extends Application {


    private static MyApplication instance;
    private Set<Activity> allActivities;


    public static synchronized MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        initReaml();


        super.onCreate();
    }

    /**
     * 添加Activity
     */
    public void registerActivity(Activity activity) {
        if (null == allActivities) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    /**
     * 移除Activity
     */
    public void remove(Activity activity) {
        if (null != allActivities) {
            allActivities.remove(activity);
        }
    }

    /**
     * 循环退出App
     */
    public void exitApp() {
        if (null != allActivities) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (null != act && !act.isFinishing()) {
                        act.finish();
                    }
                }
            }
        }
        //关闭系统进程
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 初始化数据库
     */
    private void initReaml() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("share_studio.realm")
                .schemaVersion(1)
                .rxFactory(new RealmObservableFactory())
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
