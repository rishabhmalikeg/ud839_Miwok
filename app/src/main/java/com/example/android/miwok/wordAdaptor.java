package com.example.android.miwok;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class wordAdaptor extends ArrayAdapter<word> {
    public wordAdaptor(Activity context, ArrayList<word> num){

        super(context, 0, num);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        word currentword = getItem(position);
        TextView english = (TextView) listItemView.findViewById(R.id.nmber);
        english.setText(currentword.DefaultTranslation());

        TextView hindi = (TextView) listItemView.findViewById(R.id.lan);
        hindi.setText(currentword.hindiTranslation());
        return listItemView;
    }
}
