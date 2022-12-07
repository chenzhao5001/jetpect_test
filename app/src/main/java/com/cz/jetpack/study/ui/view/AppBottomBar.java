package com.cz.jetpack.study.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cz.jetpack.study.R;
import com.cz.jetpack.study.medel.BottomBar;
import com.cz.jetpack.study.medel.Destination;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import utils.AppConfig;

public class AppBottomBar extends BottomNavigationView {

    private static int[] sIcons = new int[]{
            R.drawable.icon_tab_home,R.drawable.icon_tab_sofa,
            R.drawable.ic_publish_close,R.drawable.icon_tab_find,R.drawable.icon_tab_mine
    };

    public AppBottomBar(@NonNull Context context) {
        this(context,null);
    }

    public AppBottomBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public AppBottomBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        BottomBar bottomBar = AppConfig.getsBottomBar();
        List<BottomBar.Tabs> tabs = bottomBar.tabs;
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_selected};
        states[1] = new int[]{};

        int[] colors = new int[]{Color.parseColor(bottomBar.activeColor),Color.parseColor(bottomBar.inActiveColor)};
        ColorStateList colorStateList = new ColorStateList(states,colors);
        setItemIconTintList(colorStateList);
        setItemTextColor(colorStateList);
        setLabelVisibilityMode(LABEL_VISIBILITY_LABELED);
        setSelectedItemId(bottomBar.selectTab);

        for(int i = 0; i < tabs.size();i++) {
            BottomBar.Tabs tab = tabs.get(0);
            if(!tab.enable) {
                return;
            }
            int id = getId(tab.pageUrl);
            if(id < 0) {
                return;
            }
            MenuItem item = getMenu().add(0,id,tab.index,tab.title);
            item.setIcon(sIcons[tab.index]);
        }

        for(int i = 0; i < tabs.size();i++) {
            BottomBar.Tabs tab = tabs.get(0);
        }
    }

    private int getId(String pageUrl) {
        Destination destination = AppConfig.getDestConfig().get(pageUrl);
        if(destination == null) {
            return -1;
        }
        return destination.id;
    }
}
