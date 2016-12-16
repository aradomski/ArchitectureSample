package pl.edu.radomski.architecturesample.ux.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideHelper {


    public static void load(Context context, String path, ImageView target) {
        Glide.with(context)
                .load(path)
                .into(target);
    }

}
