package chapter.android.aweme.ss.com.homework;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Stack;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_chatroom,null);
        setContentView(view);
        int viewCount = getViewCount(view);
        TextView textView = findViewById(R.id.tv_content_info);
        textView.setText(String.valueOf(viewCount));
        //textView.setText(viewCount);
        /**
         * 崩溃的原因，public final void setText(@StringRes int resid),public final void setText(CharSequence text)
         * 在于上述两个方法，传入参数为int时调用第一个方法，他将resid转为一个StringRes，是传入的资源的id而不是随便的定义的数字
         * 后面一个才是将一个字符串传入，将text内容改为字符串的内容
         * 所以要先将一个int型的数通过String.valueOf转为String类型
         **/
        Log.d("Exercises2", "viewCount: " + viewCount);
    }

    public static int getViewCount(View view) {
        //todo 补全你的代码
        if(view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int viewGroupLength = viewGroup.getChildCount();//预先定义长度，不用在每次循环的时候都运行一遍getChildCount
            int viewCount = 1;
            for (int i = 0; i < viewGroupLength; i++) {
                viewCount += getViewCount(viewGroup.getChildAt(i));
            }
            return viewCount;
        }
        else if(view == null) return 0;
        else return 1;
    }

    public static int getViewCountWithStack(View view){
        if(view instanceof ViewGroup){
            ViewGroup viewGroup = (ViewGroup) view;
            Stack stack = new Stack();
            stack.push(view);
            View temView = null;
            int viewGroupLength = 0;
            int viewCount = 0;
            while(!stack.empty()){
                temView = (View) stack.peek();
                viewCount++;
                if(temView instanceof  ViewGroup) {
                    ViewGroup temViewGroup = (ViewGroup) temView;
                    viewGroupLength = temViewGroup.getChildCount();
                    stack.pop();
                    for(int i = 0;i<viewGroupLength;i++){
                        stack.push(temViewGroup.getChildAt(i));
                    }
                }
                else{
                    stack.pop();
                }
            }
            return viewCount;
        }
        else if(view == null) return 0;
        else return 1;
    }
}
