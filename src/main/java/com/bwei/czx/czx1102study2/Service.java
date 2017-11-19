package com.bwei.czx.czx1102study2;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by czx on 2017/11/2.
 */

//Service服务类，把请求数据的方法写到里面，然后让主界面调用
public class Service extends BaseService{//继承BaseService可以用里面的东西
    private Http mHttp;
    private BookDb mDb = new BookDb();
    public Service(){//构造方法
        //在构造方法里面调用tetorfit的请求数据方法
        mHttp = getmRetrofit().create(Http.class);
    }
    //方法,返回被观察者
    //被主界面调用的请求数据的方法，如果数据库不为空，那么直接调用数据库的数据，如果数据库为空，那么，
    //从网络请求数据，请求到数据直接存到数据库中，然后把数据返回到主界面
    public Observable<BookEntity> getDetail(int id){
        final Observable<BookEntity> httpObservable = getDetailByHttp(id);
        final Observable<BookEntity> dbObservable = getDetailByDb(id);

        return dbObservable.flatMap(new Func1<BookEntity, Observable<BookEntity>>() {
            @Override
            public Observable<BookEntity> call(BookEntity bookEntity) {
                if(bookEntity != null){
                    return dbObservable;
                }else{
                    return httpObservable;
                }

            }
        });
    }

    //数据库请求数据
    public Observable<BookEntity> getDetailByDb(int id){
        return mDb.getDetail(id);
    }
    //http请求数据
    public Observable<BookEntity> getDetailByHttp(final int id){
        //子线程的被观察者
        Observable<BookEntity> observable = mHttp.getDetail(id).subscribeOn(Schedulers.io());
        //订阅一个观察者
        observable.observeOn(Schedulers.io()).subscribe(new Observer<BookEntity>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(BookEntity bookEntity) {
                //请求到数据直接存到数据库
                mDb.saveDetail(bookEntity);
            }
        });
        //子线程，返回被观察者，同时连带着把数据也返回上去了
        return observable.observeOn(AndroidSchedulers.mainThread());
    }






}
