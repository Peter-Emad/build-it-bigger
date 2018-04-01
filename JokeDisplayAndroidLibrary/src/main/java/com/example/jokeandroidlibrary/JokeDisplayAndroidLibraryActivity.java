package com.example.jokeandroidlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by peter on 14/03/18.
 */

public class JokeDisplayAndroidLibraryActivity extends AppCompatActivity {

    static final String JOKE_KEY = "joke_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_android_library);

        if (getIntent().getExtras() != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,
                            JokeDisplayAndroidLibraryFragment.newInstance(getIntent()
                                    .getStringExtra(JOKE_KEY))).commit();
        }
    }

    public static Intent JokeDisplayActivityIntent(Context context, String jokeString) {
        Intent intent = new Intent(context, JokeDisplayAndroidLibraryActivity.class);
        intent.putExtra(JOKE_KEY, jokeString);
        return intent;
    }
}
