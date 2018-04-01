package com.example.jokeandroidlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by peter on 14/03/18.
 */

public class JokeDisplayAndroidLibraryFragment extends Fragment {

    public static JokeDisplayAndroidLibraryFragment newInstance(String jokeString) {
        JokeDisplayAndroidLibraryFragment jokeDisplayAndroidLibraryFragment = new JokeDisplayAndroidLibraryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(JokeDisplayAndroidLibraryActivity.JOKE_KEY, jokeString);
        jokeDisplayAndroidLibraryFragment.setArguments(bundle);
        return jokeDisplayAndroidLibraryFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_joke_android_library, container, false);
        initViewAndSetText(view);
        return view;
    }

    private void initViewAndSetText(View view) {
        TextView txtFragmentJoke = view.findViewById(R.id.txtFragmentJoke);
        txtFragmentJoke.setText(getArguments().getString(JokeDisplayAndroidLibraryActivity.JOKE_KEY));
    }
}
