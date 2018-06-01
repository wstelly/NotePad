package com.example.android.notepad;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.android.notepad.adapter.NoteAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * Date: 2018/5/31
 * Time: 17:15
 */
public class ShowNoteActivity extends Activity implements View.OnClickListener {

    private RecyclerView notShowRv;

    private List<NoteBean> noteBeansList, scheduleBeans, noteBeans;

    private NoteAdapter noteAdapter;

    private RecyclerView.LayoutManager layoutManager;

    private TextView scheduleTv;

    private TextView noteTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);
        initData();
        initView();
    }

    private void initData() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("note", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String noteHistory = sharedPreferences.getString("note", "[{}]");
        noteBeansList = new ArrayList<>();
        scheduleBeans = new ArrayList<>();
        noteBeans = new ArrayList<>();
        noteBeansList.addAll(JSON.parseArray(noteHistory, NoteBean.class));
        List<String> titles = new ArrayList<>();

        for (int i = noteBeansList.size() - 1; i >= 0; i--) {

               if (noteBeansList.get(i).getType().equals("save_as_schedule")) {
                    scheduleBeans.add(noteBeansList.get(i));
                } else if (noteBeansList.get(i).getType().equals("save_as_note")){
                    noteBeans.add(noteBeansList.get(i));
                }
           // }
        }

    }

    private void initView() {
        notShowRv = (RecyclerView) findViewById(R.id.note_show_rv);
        scheduleTv = (TextView) findViewById(R.id.schedule);
        noteTv = (TextView) findViewById(R.id.note);
        scheduleTv.setOnClickListener(this);
        noteTv.setOnClickListener(this);

        layoutManager = new LinearLayoutManager(ShowNoteActivity.this);
        notShowRv.setLayoutManager(layoutManager);
        noteAdapter = new NoteAdapter(scheduleBeans, ShowNoteActivity.this);
        scheduleTv.setBackgroundColor(getResources().getColor(R.color.green_light));
        notShowRv.setAdapter(noteAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.schedule:
                scheduleTv.setBackgroundColor(getResources().getColor(R.color.green_light));
                noteTv.setBackgroundColor(getResources().getColor(R.color.white));
                noteAdapter.setFilter(scheduleBeans);
                break;
            case R.id.note:
                scheduleTv.setBackgroundColor(getResources().getColor(R.color.white));
                noteTv.setBackgroundColor(getResources().getColor(R.color.green_light));
                noteAdapter.setFilter(noteBeans);
                break;
        }

    }
}
