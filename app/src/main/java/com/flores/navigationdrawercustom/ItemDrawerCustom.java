package com.flores.navigationdrawercustom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

/**
 * MenuDrawerCustom
 *
 * @author Bill Flores - Avantica
 * @since 08/09/2019
 */
public class ItemDrawerCustom extends LinearLayoutCompat {

    private LinearLayoutCompat itemMenuDrawer;
    private AppCompatImageView itemMenuImageView;
    private AppCompatTextView itemMenuText;

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
        itemMenuImageView = findViewById(R.id.itemMenuImageView);
        itemMenuText = findViewById(R.id.itemMenuText);
        itemMenuDrawer = findViewById(R.id.itemMenuDrawer);
    }

    public void setImage(@DrawableRes int id) {
        itemMenuImageView.setImageResource(id);
    }

    public void setText(String text) {
        itemMenuText.setText(text);
    }

    public void setSelect(boolean selected){
        if(selected){
            itemMenuDrawer.setBackground(getResources().getDrawable(R.drawable.bg_item));
        }else{
            itemMenuDrawer.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        }
    }
}
