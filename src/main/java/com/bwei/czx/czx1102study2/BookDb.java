package com.bwei.czx.czx1102study2;

import com.bwei.czx.czx1102study2.helper.DbRegistry;
import com.google.gson.Gson;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by czx on 2017/11/2.
 */

public class BookDb {//数据库请求
    public static final String KEY_DETAIL_PREV="BOOK_ID_";

    private DbRegistry mDbRegistry;
    private Gson mGson = new Gson();

    public BookDb(){
        mDbRegistry = DbRegistry.getInstance(MyApplication.getContext());
    }

    //从老师封装的数据库中调取数据
    public Observable<BookEntity> getDetail(final int id){
        Observable<BookEntity> observable = Observable.create(new Observable.OnSubscribe<BookEntity>() {
            @Override
            public void call(Subscriber<? super BookEntity> subscriber) {
                String data = mDbRegistry.getString(KEY_DETAIL_PREV+ id ,"");
                if(data.isEmpty()){
                    subscriber.onNext(null);
                }else{
                    BookEntity bookEntity = new Gson().fromJson(data,BookEntity.class);
                    subscriber.onNext(bookEntity);
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        return observable;
    }
    public void saveDetail(BookEntity bookEntity){
        String data = mGson.toJson(bookEntity);
        mDbRegistry.putString(KEY_DETAIL_PREV+bookEntity.getData().getId(),data);
    }
}
