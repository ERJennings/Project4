package com.example.project4;

/**
 * Created by keith on 3/4/18.
 */

public class DownloadTask_KP extends DownloadTask {
    MainActivity myActivity;

    DownloadTask_KP(MainActivity activity) {
        super();
        attach(activity);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if (myActivity != null) {
            myActivity.processJSON(result);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    /**
     * important do not hold a reference so garbage collector can grab old
     * defunct dying activity
     */
    void detach() {
        myActivity = null;
    }

    /**
     * @param activity
     *            grab a reference to this activity, mindful of leaks
     */
    void attach(MainActivity activity) {
        this.myActivity = activity;
    }
}
