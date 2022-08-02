package com.example.useaapp.student.student_adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListviewHelper {
    public static void getLisViewSize(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter==null){
            //do nothing return null
            return;
        }
        //set list adapter in loop for getting final size
        int totalHeight = 0;
        for (int size = 0; size<listAdapter.getCount();size++){
            View listItem = listAdapter.getView(size,null,listView);
            listItem.measure(0,0);
            totalHeight+=listItem.getMeasuredHeight();
        }
        //setting listview item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+(listView.getDividerHeight())*(listAdapter.getCount()-1);
        listView.setLayoutParams(params);
        // print height f adapter on log
        Log.i("height of listitem:", String.valueOf(totalHeight));
    }
}
