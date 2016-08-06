package ua.dashan.cafe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.jude.rollviewpager.hintview.TextHintView;


public class ImageSlider extends Fragment {
    private RollPagerView mLoopViewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pager_view, null);
        mLoopViewPager=(RollPagerView)v.findViewById(R.id.roll);
       // RollPagerView pagerView=new RollPagerView(getContext());
        mLoopViewPager.setPlayDelay(5000);
        mLoopViewPager.setAdapter(new PageAdapter());

        mLoopViewPager.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));
        mLoopViewPager.setHintView(new TextHintView(getContext()));
        return v;
    }
}
