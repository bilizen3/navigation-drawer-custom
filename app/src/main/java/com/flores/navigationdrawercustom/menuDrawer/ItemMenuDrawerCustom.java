package com.flores.navigationdrawercustom.menuDrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.flores.navigationdrawercustom.R;

/**
 * ItemMenuDrawerCustom
 *
 * @author Bill Flores - Avantica
 * @since 08/09/2019
 */
public class ItemMenuDrawerCustom extends LinearLayoutCompat {

    private int gItemMenuDrawerId;
    private int gItemMenuDrawerImageSelected;
    private int gItemDrawerImageUnSelected;
    private int gItemDrawerBackgroundSelected;
    private int gItemDrawerBackgroundUnSelected;
    private int gItemDrawerTextColorSelected;
    private int gItemDrawerTextColorUnSelected;
    private LinearLayoutCompat gItemMenuDrawer;
    private AppCompatImageView gItemMenuDrawerImageView;
    private AppCompatTextView gItemMenuDrawerText;

    public ItemMenuDrawerCustom(Context context) {
        super(context);
        initUi(context);
    }

    public ItemMenuDrawerCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi(context);
    }

    public ItemMenuDrawerCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUi(context);
    }

    public void initUi(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.item_menu_drawer, this, true);
            gItemMenuDrawerImageView = findViewById(R.id.itemMenuDrawerImageView);
            gItemMenuDrawerText = findViewById(R.id.itemMenuDrawerText);
            gItemMenuDrawer = findViewById(R.id.itemMenuDrawer);
        }
    }

    public int getItemDrawerId() {
        return gItemMenuDrawerId;
    }

    public void setItemDrawerId(int pId) {
        gItemMenuDrawerId = pId;
    }


    public void setItemDrawerText(String text) {
        gItemMenuDrawerText.setText(text);
    }

    public String getItemDrawerText() {
        return gItemMenuDrawerText.getText().toString();
    }

    public void setItemDrawerImageSelected(@DrawableRes int pItemDrawerImageSelected) {
        gItemMenuDrawerImageSelected = pItemDrawerImageSelected;
    }

    public void setItemDrawerImageUnSelected(@DrawableRes int pItemDrawerImageUnSelected) {
        gItemDrawerImageUnSelected = pItemDrawerImageUnSelected;
    }

    public void setItemDrawerBackgroundSelected(@DrawableRes int pItemDrawerBackgroundSelected) {
        gItemDrawerBackgroundSelected = pItemDrawerBackgroundSelected;
    }

    public void setItemDrawerBackgroundUnSelected(@DrawableRes int pItemDrawerBackgroundUnSelected) {
        gItemDrawerBackgroundUnSelected = pItemDrawerBackgroundUnSelected;
    }

    public void setItemDrawerTextColorSelected(@DrawableRes int pItemDrawerTextColorSelected) {
        gItemDrawerTextColorSelected = pItemDrawerTextColorSelected;
    }

    public void setItemDrawerTextColorUnSelected(@DrawableRes int pItemDrawerTextColorUnSelected) {
        gItemDrawerTextColorUnSelected = pItemDrawerTextColorUnSelected;
    }

    public void setItemDrawerSelected(){
        gItemMenuDrawer.setBackgroundResource(gItemDrawerBackgroundSelected);
        gItemMenuDrawerImageView.setImageResource(gItemMenuDrawerImageSelected);
        gItemMenuDrawerText.setTextColor(getResources().getColor(gItemDrawerTextColorSelected));
    }

    public void setItemDrawerUnSelected(){
        gItemMenuDrawer.setBackgroundResource(gItemDrawerBackgroundUnSelected);
        gItemMenuDrawerImageView.setImageResource(gItemDrawerImageUnSelected);
        gItemMenuDrawerText.setTextColor(getResources().getColor(gItemDrawerTextColorUnSelected));
    }

    public void setSelectedItemDrawer(boolean pSelected) {
        if (pSelected) {
            setItemDrawerSelected();
        } else {
            setItemDrawerUnSelected();
        }
    }
}
