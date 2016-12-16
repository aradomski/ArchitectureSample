package pl.edu.radomski.architecturesample.ux.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoHelper {


    public static void load(Context context, String path, ImageView target) {
        Picasso.with(context)
                .load(path)
                .into(target);
    }

}
