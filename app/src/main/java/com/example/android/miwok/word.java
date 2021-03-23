package com.example.android.miwok;

import android.view.View;

public class word{

    private String mDefault;
    private String mhindi;

    public word(String defaults1,String hindi){
        mDefault = defaults1;
        mhindi = hindi;
    }
    public String DefaultTranslation(){
        return(mDefault);
    }
    public String hindiTranslation(){
        return (mhindi);
    }
}
