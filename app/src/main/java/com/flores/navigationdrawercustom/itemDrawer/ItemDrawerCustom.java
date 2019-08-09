package com.flores.navigationdrawercustom.itemDrawer;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.flores.navigationdrawercustom.R;

/**
 * MenuDrawerCustom
 *
 * @author Bill Flores - Avantica
 * @since 08/09/2019
 */
public class ItemDrawerCustom extends LinearLayoutCompat {

    private int gId;
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

    public String getText() {
        return itemMenuText.getText().toString();
    }


    public int getId() {
        return gId;
    }

    public void setId(int pId) {
        gId = pId;
    }

    public void setSelect(boolean selected) {
        if (selected) {
            itemMenuDrawer.setBackground(getResources().getDrawable(R.drawable.bg_item));
            itemMenuImageView.setColorFilter(Color.GREEN);
        } else {
            itemMenuDrawer.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            itemMenuImageView.setColorFilter(Color.parseColor("#FF000000"));
        }
    }
}
