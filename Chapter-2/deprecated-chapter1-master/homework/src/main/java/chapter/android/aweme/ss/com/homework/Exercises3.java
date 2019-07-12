package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import chapter.android.aweme.ss.com.homework.widget.MyViewBaseAdapter;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises3_main);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new MyViewBaseAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("ClickPosition", "Position : "+ position);
                Intent intent = new Intent(Exercises3.this, MainActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
