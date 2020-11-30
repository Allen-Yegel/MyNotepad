package com.example.mynotepad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mynotepad.R;
import com.example.mynotepad.bean.NotepadBean;

import java.util.List;

public class NotepadAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;//这个对象用于加载item的布局文件
    private List<NotepadBean>list;//list集合是列表中需要显示的集合
    public NotepadAdapter(Context context, List<NotepadBean>list){
        layoutInflater=LayoutInflater.from(context);
        this.list=list;
    }
    @Override
    public int getCount() {
        return list==null?0:list.size();
    }//获取集合长度

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }//返回集合的内容

    @Override
    public long getItemId(int position) {
        return position;
    }//返回位置信息

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.notepad_item,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        NotepadBean notepadBean=(NotepadBean)getItem(position);
        int content_lengh = notepadBean.getNotepadContent().length();
        if(content_lengh < 5){
            viewHolder.tvNotepadContent.setText(notepadBean.getNotepadContent());
        }
        else{
            viewHolder.tvNotepadContent.setText(notepadBean.getNotepadContent().substring(0,5));
        }

        viewHolder.tvNotepadTime.setText(notepadBean.getNotepadTime());

        int author_lengh = notepadBean.getNotepadAuthor().length();
        if(author_lengh == 0){
            notepadBean.setNotepadAuthor("暂无作者");
            viewHolder.tvNotepadAuthor.setText(notepadBean.getNotepadAuthor());
        }
        if(author_lengh < 5){
            viewHolder.tvNotepadAuthor.setText(notepadBean.getNotepadAuthor());
        }
        else{
            viewHolder.tvNotepadAuthor.setText(notepadBean.getNotepadAuthor().substring(0,5));
        }
        return convertView;
    }
    class ViewHolder{
        TextView tvNotepadContent;
        TextView tvNotepadTime;
        TextView tvNotepadAuthor;
        public ViewHolder(View view){
            tvNotepadContent=view.findViewById(R.id.item_content);//记录的内容
            tvNotepadTime=view.findViewById(R.id.item_time);//保存记录的时间
            tvNotepadAuthor = view.findViewById(R.id.item_author);//内容作者
        }
    }
}

