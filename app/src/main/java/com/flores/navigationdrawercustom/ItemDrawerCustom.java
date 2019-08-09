package com.flores.navigationdrawercustom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.appcompat.widget.LinearLayoutCompat;

/**
 * MenuDrawerCustom
 *
 * @author Bill Flores - Avantica
 * @since 08/09/2019
 */
public class ItemDrawerCustom extends LinearLayoutCompat {

    public ItemDrawerCustom(Context context) {
        super(context);
        initUi(context);
    }

    public ItemDrawerCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi(context);
    }

    public ItemDrawerCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUi(context);
    }

    public void initUi(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_menu_drawer, this, true);
        
    }
}
