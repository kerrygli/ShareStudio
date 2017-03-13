package cn.kerry.sharestudio.api;

import cn.kerry.sharestudio.model.meizhi.GankData;
import cn.kerry.sharestudio.model.meizhi.MeiziData;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/13.
 */

public interface GankApi {

    @GET("/api/data/福利/10/{page}")
    Observable<MeiziData> getMeizhiData(@Path("page") int path);

    @GET("/day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year") int year,
                                     @Path("month") int month, @Path("day") int day );
}
