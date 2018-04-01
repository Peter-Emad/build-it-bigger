package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.common.helper.RetrieveJokeAsyncTask;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class RetrieveJokeAsyncTaskTest extends AndroidTestCase {


    public void testRetrieveJoke() {

        try {
            RetrieveJokeAsyncTask retrieveJokeAsyncTask = new RetrieveJokeAsyncTask();
            String retrievedJoke = retrieveJokeAsyncTask.execute().get(1, TimeUnit.MINUTES);
            assertThat(retrievedJoke, notNullValue());
        } catch (Exception e) {
            fail("Joke not retrieved");
        }
    }
}
