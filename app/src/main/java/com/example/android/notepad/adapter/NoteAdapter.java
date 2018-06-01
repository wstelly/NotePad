package com.example.android.notepad.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.notepad.NoteBean;
import com.example.android.notepad.R;

import java.util.List;



/**
 * Date: 2018/5/31
 * Time: 17:16
 */
public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NoteBean>noteBeans;

    private Context context;

    public NoteAdapter(List<NoteBean>noteBeans,Context context){
        this.noteBeans=noteBeans;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_type_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).noteTitle.setText(noteBeans.get(position).getNote());
        ((ViewHolder)holder).noteTime.setText(noteBeans.get(position).getTime());
        switch (noteBeans.get(position).getColor()){
            case "yellow":
                ((ViewHolder)holder).noteTypeLl.setBackgroundColor(context.getResources().getColor(R.color.orange));
                break;
            case "green":
                ((ViewHolder)holder).noteTypeLl.setBackgroundColor(context.getResources().getColor(R.color.green));
                break;
            case "blue":
                ((ViewHolder)holder).noteTypeLl.setBackgroundColor(context.getResources().getColor(R.color.blue));
                break;
                default:
                    ((ViewHolder)holder).noteTypeLl.setBackgroundColor(context.getResources().getColor(R.color.orange));
                    break;
        }
    }

    @Override
    public int getItemCount() {
        return noteBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView noteTitle;

        TextView noteTime;

        LinearLayout noteTypeLl;

        public ViewHolder(View itemView) {
            super(itemView);
            noteTitle=(TextView)itemView.findViewById(R.id.note_title);
            noteTime=(TextView)itemView.findViewById(R.id.note_time);
            noteTypeLl=(LinearLayout)itemView.findViewById(R.id.note_type_ll);
        }
    }

    public void setFilter(List<NoteBean>noteBeans){
        this.noteBeans=noteBeans;
        notifyDataSetChanged();
    }
}
