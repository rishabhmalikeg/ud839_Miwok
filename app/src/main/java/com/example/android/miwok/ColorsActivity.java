/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<word> num = new ArrayList<word>();
        num.add(new word("red", "lal"));
        num.add(new word("green", "hara"));
        num.add(new word("yellow", "peela"));
        num.add(new word("black", "kalla"));
        num.add(new word("white", "saffad"));
        num.add(new word("red", "lal"));
        num.add(new word("green", "hara"));
        num.add(new word("yellow", "peela"));
        num.add(new word("black", "kalla"));
        num.add(new word("white", "saffad"));
        num.add(new word("red", "lal"));
        num.add(new word("green", "hara"));
        num.add(new word("yellow", "peela"));
        num.add(new word("black", "kalla"));
        num.add(new word("white", "saffad"));

        wordAdaptor adaptor = new wordAdaptor(this, num);

        ListView newview = (ListView)findViewById(R.id.list);
        newview.setAdapter(adaptor);

    }


}
