package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jokeandroidlibrary.JokeDisplayAndroidLibraryActivity;
import com.udacity.gradle.builditbigger.common.base.BaseFragment;
import com.udacity.gradle.builditbigger.common.helper.RetrieveJokeAsyncTask;

/**
 * Created by peter on 01/04/18.
 */

public class PaidAppFragment extends BaseFragment {
    private Context context;
    private Button btnTellJoke;

    public static PaidAppFragment newInstance() {
        return new PaidAppFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.paid_fragment_main, container, false);
        initializeViews(root);
        setListeners();
        return root;
    }

    @Override
    protected void initializeViews(View v) {
        btnTellJoke = v.findViewById(R.id.btnTellJoke);
    }

    @Override
    protected void setListeners() {
        btnTellJoke.setOnClickListener(btnTellJokeOnClickListener);
    }

    private View.OnClickListener btnTellJokeOnClickListener = new View.OnClickListener() {
        @SuppressLint("StaticFieldLeak")
        @Override
        public void onClick(View v) {

            new RetrieveJokeAsyncTask() {
                @Override
                protected void onPostExecute(String result) {
                    if (!TextUtils.isEmpty(result))
                        context.startActivity(JokeDisplayAndroidLibraryActivity.JokeDisplayActivityIntent(context, result));
                    else
                        Toast.makeText(context, context.getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
                }
            }.execute();


        }
    };
}
