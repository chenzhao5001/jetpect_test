package com.cz.jetpack.study.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

public class MyImageView extends AppCompatImageView {
    public MyImageView(@NonNull Context context) {
        super(context);
    }

    public MyImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // requireAll = true（默认，只有参数全了才调用）
    @BindingAdapter(value = {"image_url","isCircle"},requireAll = true)
    public static void SetImageViewUrl(MyImageView view,String imageUrl,boolean isCircle) {
        RequestBuilder<Drawable> builder = Glide.with(view).load(imageUrl);
        if(isCircle) {
            builder.transform(new CircleCrop());
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if(layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            builder.override(layoutParams.width,layoutParams.height);
        }
        builder.into(view);
    }
}
