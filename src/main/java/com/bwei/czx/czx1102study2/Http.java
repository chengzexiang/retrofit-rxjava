package com.bwei.czx.czx1102study2;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * retrofit请求数据接口
 * Created by czx on 2017/11/2.
 */

public interface Http {
    @GET("action/book_detail")
    Observable<BookEntity> getDetail(@Query("id") int id);
}
