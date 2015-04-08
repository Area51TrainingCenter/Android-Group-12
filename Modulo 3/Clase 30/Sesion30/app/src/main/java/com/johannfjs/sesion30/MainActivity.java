package com.johannfjs.sesion30;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.viewpagerindicator.CirclePageIndicator;


public class MainActivity extends ActionBarActivity {
    ViewPager pager;
    CirclePageIndicator circlePageIndicator;
    Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.cpIndicator);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter();
        pager.setAdapter(imagePagerAdapter);

        circlePageIndicator.setViewPager(pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public class ImagePagerAdapter extends PagerAdapter {
        private int[] images = new int[]{R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4};
        int cont = 0;

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d("TAG", "-->" + position);
            if (cont == 0) {
                if (position == 1) {
                    cont = 1;
                    btnCerrar.setVisibility(View.VISIBLE);
                }
            } else {
                if (position != 1) {
                    cont = 0;
                    btnCerrar.setVisibility(View.INVISIBLE);
                }
            }
            ((ViewPager) container).removeView((ImageView) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public int getCount() {
            return this.images.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = MainActivity.this;
            ImageView imageView = new ImageView(context);
            int padd = context.getResources().getDimensionPixelSize(R.dimen.dimension);
            imageView.setPadding(padd, padd, padd, padd);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(images[position]);
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }
    }
}
