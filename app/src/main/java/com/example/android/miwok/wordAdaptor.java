package com.example.android.miwok;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class wordAdaptor extends ArrayAdapter<word> {
    private int mColorResourceId;
    public wordAdaptor(Activity context, ArrayList<word> num, int colorResourceId){

        super(context, 0, num);
        mColorResourceId = colorResourceId;
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
        ImageView image = (ImageView) listItemView.findViewById(R.id.images);
        if (currentword.hasimage()) {

            image.setImageResource(currentword.imageResource());
        }
        else{
            image.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



            return listItemView;
    }
    }
