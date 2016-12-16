package pl.edu.radomski.architecturesample.utils;

import android.content.Context;
import android.util.Log;

public class ErrorHandler {
    private static final String TAG = ErrorHandler.class.getSimpleName();

    private Context context;

    public ErrorHandler(Context context) {
        this.context = context;
    }


    public void handleError(Throwable throwable) {
        Log.d(TAG, "Generic exception handler: ", throwable);
//        Toast.makeText(context, "Exception: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
