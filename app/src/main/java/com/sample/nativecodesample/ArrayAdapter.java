package com.sample.nativecodesample;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;

public class ArrayAdapter extends android.widget.ArrayAdapter<String> {
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public ArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<String> objects) {
        super(context, resource, textViewResourceId, objects);
        for(int i=0;i<objects.size();i++){
            mIdMap.put(objects.get(i),i);
        }
    }


    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId(int position) {
        String item=getItem(position);
        return mIdMap.get(item);
    }

}
