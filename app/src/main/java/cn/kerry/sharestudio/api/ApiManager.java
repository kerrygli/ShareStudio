package cn.kerry.sharestudio.api;

import java.io.IOException;

import cn.kerry.sharestudio.global.MyApplication;
import cn.kerry.sharestudio.util.NetWorkUtil;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/13.
 */

public class ApiManager {

    private static final Interceptor REWITER_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            if (NetWorkUtil.isNetWorkAvailable(MyApplication.getInstance())) {
                int maxAge = 60;//在线一分钟可读取
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public,max-age=" + maxAge)
                        .build();
            } else {
                int maxStatue = 60 * 60 * 24 * 28;//离线保存4周
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public,only-if-cached,max-stale=" + maxStatue)
                        .build();
            }
        }
    };
}
