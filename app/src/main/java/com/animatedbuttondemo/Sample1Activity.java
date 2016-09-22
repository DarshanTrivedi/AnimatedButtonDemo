package com.animatedbuttondemo;

import android.os.Bundle;
import android.view.View;

import com.animatedbuttondemo.customview.CustomAnimatedButton;

public class Sample1Activity extends BaseActivity {

    private int mBtCounter1 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sample_animated_bt);

        final CustomAnimatedButton btnAnimated1 = (CustomAnimatedButton) findViewById(R.id.btnAnimated);
        btnAnimated1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnimatedButton1Clicked(btnAnimated1);
            }
        });

        buttonToSquare(btnAnimated1, 0);
    }

    private void onAnimatedButton1Clicked(final CustomAnimatedButton btnAnimated) {
        if (mBtCounter1 == 0) {
            mBtCounter1++;
            buttonToSquare(btnAnimated, integer(R.integer.bt_animation));
        } else if (mBtCounter1 == 1) {
            mBtCounter1 = 0;
            buttonToSuccess(btnAnimated);
        }
    }

    private void buttonToSquare(final CustomAnimatedButton btnMorph, int duration) {
        CustomAnimatedButton.Params square = CustomAnimatedButton.Params.create()
                .duration(duration)
                .cornerRadius(dimen(R.dimen.bt_corner_radius_2))
                .width(dimen(R.dimen.bt_width_200))
                .height(dimen(R.dimen.bt_height_56))
                .color(color(R.color.bt_purple))
                .colorPressed(color(R.color.bt_purple_dark))
                .text(getString(R.string.bt_button));
        btnMorph.animation(square);
    }

    private void buttonToSuccess(final CustomAnimatedButton btnMorph) {
        CustomAnimatedButton.Params circle = CustomAnimatedButton.Params.create()
                .duration(integer(R.integer.bt_animation))
                .cornerRadius(dimen(R.dimen.bt_height_56))
                .width(dimen(R.dimen.bt_height_56))
                .height(dimen(R.dimen.bt_height_56))
                .color(color(R.color.bt_red))
                .colorPressed(color(R.color.bt_red_dark))
                .icon(R.drawable.ic_done);
        btnMorph.animation(circle);
    }


}
