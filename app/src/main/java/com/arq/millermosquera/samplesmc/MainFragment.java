package com.arq.millermosquera.samplesmc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainFragment extends Fragment {

    private ImageView mImage;

    public MainFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mImage = view.findViewById(R.id.main_image);
        ViewCompat.setTransitionName(mImage, "1_image");

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DetailFragment detailFragment = DetailFragment.newInstance(1);

                // Note that we need the API version check here because the actual transition classes (e.g. Fade)
                // are not in the support library and are only available in API 21+. The methods we are calling on the Fragment
                // ARE available in the support library (though they don't do anything on API < 21)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    detailFragment.setSharedElementEnterTransition(new DetailsTransition());
                    detailFragment.setEnterTransition(new Fade());
                    setExitTransition(new Fade());
                    detailFragment.setSharedElementReturnTransition(new DetailsTransition());
                }

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addSharedElement(mImage, "kittenImage")
                        .replace(R.id.container, detailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
