package johannfjs.com.application;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import johannfjs.com.sesion09.R;

/**
 * Created by Johann on 11/02/2015.
 */
public class Configuration extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher)
                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .defaultDisplayImageOptions(options)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .imageDownloader(new BaseImageDownloader(getApplicationContext()))
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();

        ImageLoader.getInstance().init(config);
    }
}
