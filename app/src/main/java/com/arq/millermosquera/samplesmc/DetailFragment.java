package com.arq.millermosquera.samplesmc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DetailFragment extends Fragment {

    private ImageView mImageDetail;

    public DetailFragment() {}

    public static DetailFragment newInstance(@IntRange(from = 1, to = 6) int kittenNumber) {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        mImageDetail = view.findViewById(R.id.detail_image);
        mImageDetail.setImageResource(R.drawable.mazda);


       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(container, new TransitionSet()
                    .addTransition(new ChangeBounds())
                    .addTransition(new ChangeImageTransform()));
        }

        ViewGroup.LayoutParams params = mImageDetail.getLayoutParams();
        params.height = true ? ViewGroup.LayoutParams.MATCH_PARENT : ViewGroup.LayoutParams.WRAP_CONTENT;
        mImageDetail.setLayoutParams(params);
        mImageDetail.setScaleType(true ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER);*/

        return view;
    }

}
