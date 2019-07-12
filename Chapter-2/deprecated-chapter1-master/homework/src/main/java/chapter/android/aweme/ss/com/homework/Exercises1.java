package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 * 作业1回答：
 *     旋转屏幕之后执行的函数的顺序为：
 *
 *         onPause -> onStop -> onDestroy -> onCreate -> onStart -> onResume
 *
 *     可见当进行屏幕旋转时进行的操作与退出进行的操作一致，都将activity destroy之后再重新create新的，
 *     等同于加载一个新的activity，所以如果需要适配屏幕旋转的话相当于工作量翻倍(不考虑代码复用)，成本增加巨大。
 */
public class Exercises1 extends AppCompatActivity {

    String TAG = "Exercises1";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }
    @Override
    protected  void onDestroy(){
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected  void onStart(){
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume(){
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected  void onStop(){
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected  void onPause(){
        Log.d(TAG, "onPause: ");
        super.onPause();
    }
}
