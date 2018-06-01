package com.example.android.notepad;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.android.notepad.adapter.NoteAdapter;
import com.example.android.notepad.adapter.PlanAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2018/6/1
 * Time: 19:42

 */
public class ShowPlanActivity extends Activity {

    private RecyclerView notShowRv;

    private List<NoteBean> noteBeansList, planBeans;

    private PlanAdapter planAdapter;

    private RecyclerView.LayoutManager layoutManager;

    private TextView scheduleTv;

    private TextView noteTv;

    private LinearLayout showNoteLl;


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
        planBeans = new ArrayList<>();
        noteBeansList.addAll(JSON.parseArray(noteHistory, NoteBean.class));
        for (int i = noteBeansList.size() - 1; i >= 0; i--) {

            if (noteBeansList.get(i).getType().equals("save_as_plan")) {
                planBeans.add(noteBeansList.get(i));
            }

        }

    }

    private void initView() {
        notShowRv = (RecyclerView) findViewById(R.id.note_show_rv);
        scheduleTv = (TextView) findViewById(R.id.schedule);
        noteTv = (TextView) findViewById(R.id.note);
        showNoteLl=(LinearLayout)findViewById(R.id.show_note_ll);
        scheduleTv.setVisibility(View.GONE);
        noteTv.setVisibility(View.GONE);
        showNoteLl.setVisibility(View.GONE);
        layoutManager = new LinearLayoutManager(ShowPlanActivity.this);
        notShowRv.setLayoutManager(layoutManager);
        planAdapter = new PlanAdapter( planBeans, ShowPlanActivity.this);
        notShowRv.setAdapter(planAdapter);
    }


}
