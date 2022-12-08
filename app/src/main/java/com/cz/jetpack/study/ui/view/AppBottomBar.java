package com.cz.jetpack.study.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cz.jetpack.study.R;
import com.cz.jetpack.study.model.BottomBar;
import com.cz.jetpack.study.model.Destination;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
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
        this(context, attrs,0);
    }

    @SuppressLint("RestrictedApi")
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
            BottomBar.Tabs tab = tabs.get(i);
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
            BottomBar.Tabs tab = tabs.get(i);
            int iconSize = dp2px(tab.size);
            BottomNavigationMenuView menuView = (BottomNavigationMenuView)getChildAt(0);
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(tab.index);

            itemView.setIconSize(iconSize);

            // 中间的大按钮
            if(TextUtils.isEmpty(tab.title)) {
                itemView.setIconTintList(ColorStateList.valueOf(Color.parseColor(tab.tintColor)));
                // 阻止点击上下浮动
                itemView.setShifting(false);
            }
        }
    }

    private int dp2px(int size) {
        float value = getContext().getResources().getDisplayMetrics().density * size + 0.5f;
        return (int) value;
    }

    private int getId(String pageUrl) {
        Destination destination = AppConfig.getDestConfig().get(pageUrl);
        if(destination == null) {
            return -1;
        }
        return destination.id;
    }
}
