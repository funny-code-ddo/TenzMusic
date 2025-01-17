package com.tenz.tenzmusic.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.tenz.tenzmusic.R;
import com.tenz.tenzmusic.util.GlideUtil;
import com.youth.banner.loader.ImageLoader;


/**
 * Author: TenzLiu
 * Date: 2018/8/23 9:23
 * Description: Banner图片加载器
 */

public class BannerImageLoader extends ImageLoader {

    private static RequestOptions mRequestOptions = new RequestOptions()
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.banner_default)
            .error(R.drawable.banner_default);

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */
        //Glide 加载图片简单用法
        GlideUtil.loadImage(context,path,mRequestOptions,imageView);
    }

    //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
    @Override
    public ImageView createImageView(Context context) {
        //需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
        ImageView imageView=new ImageView(context);
        return imageView;
    }

}
