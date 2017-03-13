package cn.kerry.sharestudio.util;

import io.realm.Realm;

/**
 * Created by Administrator on 2017/3/13.
 */

public class RealmHepler {

    public static final String DB_NAME = "share_studio.reaml";
    private Realm mRealm;
    private static RealmHepler instatnce;

    private RealmHepler() {
    }

    public static synchronized RealmHepler getInstatnce() {
        if (null == instatnce) {
            synchronized (RealmHepler.class) {
                if (null == instatnce) {
                    instatnce = new RealmHepler();
                }
            }
        }
        return instatnce;
    }

    protected Realm getRealm() {
        if (null == mRealm || mRealm.isClosed()) {
            mRealm = Realm.getDefaultInstance();
        }
        return mRealm;
    }

}
