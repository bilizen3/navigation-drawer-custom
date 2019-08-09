package com.flores.navigationdrawercustom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.LinearLayoutCompat;

import java.util.List;

/**
 * MenuDrawerCustom
 *
 * @author Bill Flores - Avantica
 * @since 08/09/2019
 */
public class MenuDrawerCustom extends LinearLayoutCompat {
    private LinearLayoutCompat menuDrawer;

    public MenuDrawerCustom(Context context) {
        super(context);
        initUi(context);
    }

    public MenuDrawerCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi(context);
    }

    public MenuDrawerCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUi(context);
    }

    public void initUi(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_menu_drawer, this, true);
        menuDrawer = findViewById(R.id.menuDrawer);
    }

    public void addItems(List<ItemDrawerCustom> itemDrawerCustoms) {
        for (final ItemDrawerCustom itemDrawerCustom : itemDrawerCustoms) {
            menuDrawer.addView(itemDrawerCustom);
            itemDrawerCustom.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemDrawerCustom.setSelect(true);
                }
            });
        }
    }



}
