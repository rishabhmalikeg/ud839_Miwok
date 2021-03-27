package com.example.android.miwok;

import android.view.View;
import android.widget.ImageView;
//this is the new user defined data type defined by the user to pass in array adapter
public class word{

    private String mDefault;
    private String mhindi;
    private int mresourceid = -1;
    private int mmusicvid;

    public word(String defaults1,String hindi, int image, int music){
        mDefault = defaults1;
        mhindi = hindi;
        mresourceid = image;
        mmusicvid = music;
    }
    public word(String defaults1 ,String hindi, int music){
        mDefault = defaults1;
        mhindi = hindi;
        mmusicvid = music;

    }

    public String DefaultTranslation(){
        return(mDefault);
    }
    public String hindiTranslation(){
        return (mhindi);
    }
    public int imageResource(){return(mresourceid);}
    public boolean hasimage(){
        return (mresourceid!=-1);
    }
    public int music_record(){return(mmusicvid);}

}
