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

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.media.AudioManager;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private MediaPlayer mmediaPlayer;
    private MediaPlayer.OnCompletionListener oncompletion = new MediaPlayer.OnCompletionListener(){
        public void onCompletion(MediaPlayer mp){
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {

                        mmediaPlayer.release();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ) {
                        mmediaPlayer.pause();
                        mmediaPlayer.seekTo(0);
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mmediaPlayer.start();
                    }
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mAudioManager = (AudioManager) getSystemService(Context .AUDIO_SERVICE);


        final ArrayList<word> num = new ArrayList<word>();
        num.add(new word("one", "ekk", R.drawable.androidparty, R.raw.music));
        num.add(new word("two", "doo", R.drawable.androidparty, R.raw.music1));
        num.add(new word("three", "teen", R.drawable.androidparty,R.raw.music1));
        num.add(new word("four", "chaar", R.drawable.androidparty,R.raw.music1));
        num.add(new word("five", "paach",R.drawable.androidparty,R.raw.music1));
        num.add(new word("one", "ekk", R.drawable.androidparty,R.raw.music1));
        num.add(new word("two", "doo", R.drawable.androidparty,R.raw.music1));
        num.add(new word("three", "teen", R.drawable.androidparty,R.raw.music1));
        num.add(new word("four", "chaar", R.drawable.androidparty,R.raw.music1));
        num.add(new word("five", "paach", R.drawable.androidparty,R.raw.music1));
        num.add(new word("one", "ekk", R.drawable.androidparty,R.raw.music1));
        num.add(new word("two", "doo", R.drawable.androidparty,R.raw.music1));
        num.add(new word("three", "teen", R.drawable.androidparty,R.raw.music1));
        num.add(new word("four", "chaar", R.drawable.androidparty,R.raw.music1));
        num.add(new word("five", "paach", R.drawable.androidparty,R.raw.music1));
        num.add(new word("one", "ekk", R.drawable.androidparty,R.raw.music1));
        num.add(new word("two", "doo", R.drawable.androidparty,R.raw.music1));
        num.add(new word("three", "teen", R.drawable.androidparty,R.raw.music1));
        num.add(new word("four", "chaar", R.drawable.androidparty,R.raw.music1));
        num.add(new word("five", "paach", R.drawable.androidparty,R.raw.music1));

        wordAdaptor itemsAdapter = new wordAdaptor(this, num, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                word posi = num.get(position);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mmediaPlayer = MediaPlayer.create(NumbersActivity.this, posi.music_record());

                    mmediaPlayer.start();
                    mmediaPlayer.setOnCompletionListener(oncompletion);
                }

////                it is used to set duration of music
//                CountDownTimer timer = new CountDownTimer(5000, 1000) {
//
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//                        // Nothing to do
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        if (mmediaPlayer.isPlaying()) {
//                            mmediaPlayer.stop();
//                            mmediaPlayer.release();
//                        }
//                    }
//                };
//                timer.start();

            }
        });
        }

    private void releaseMediaPlayer(){
        if(mmediaPlayer!=null){
            mmediaPlayer.release();
            mmediaPlayer=null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }}

    }

