package pl.edu.radomski.architecturesample.ux.utils.datagbinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import pl.edu.radomski.architecturesample.ux.utils.GlideHelper;

public class BindingAdapters {

    @BindingAdapter({"bind:image"})
    public static void loadImage(ImageView view, String url) {
        GlideHelper.load(view.getContext(), url, view);
    }


}
