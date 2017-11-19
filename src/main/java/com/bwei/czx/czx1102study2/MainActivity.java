package com.bwei.czx.czx1102study2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    private Http mHttp;
    private TextView tv_title;
    private TextView tv_description;
    private TextView tv_dt_created;
    //观察者---接收数据---主线程，用来渲染界面
    Observer<BookEntity> observer = new Observer<BookEntity>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "请求HTTP失败！", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNext(BookEntity bookEntity) {
            Toast.makeText(MainActivity.this, ""+bookEntity, Toast.LENGTH_SHORT).show();
            System.out.println("bookEntity =================== " + bookEntity.toString());
            tv_title.setText(bookEntity.getData().getTitle());
            tv_dt_created.setText(bookEntity.getData().getDtCreated());
            tv_description.setText(bookEntity.getData().getDescription());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_description = (TextView) findViewById(R.id.tv_description);
        tv_dt_created = (TextView) findViewById(R.id.tv_dt_created);

        final Service service = new Service();
        //调用请求数据的方法
        service.getDetail(5).subscribe(observer);


        //定时发送消息
        Observable.timer(5000, TimeUnit.MICROSECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                service.getDetail(9).subscribe(observer);
            }
        });



    }
    
}
