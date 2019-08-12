package com.flores.navigationdrawercustom.menuDrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.flores.navigationdrawercustom.R;

import java.util.List;

/**
 * MenuDrawerCustom
 *
 * @author Bill Flores - Avantica
 * @since 08/09/2019
 */
public class MenuDrawerCustom extends LinearLayoutCompat {

    private int gIdItemDrawer;

    private LinearLayoutCompat menuDrawer;

    private List<ItemMenuDrawerCustom> gItemMenuDrawerCustoms;

    private MenuDrawerCustomInterface gMenuDrawerCustomInterface;

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
        if (inflater != null) {
            inflater.inflate(R.layout.layout_menu_drawer, this, true);
            menuDrawer = findViewById(R.id.menuDrawer);
        }
    }

    public void addListItemDrawers(List<ItemMenuDrawerCustom> pItemMenuDrawerCustoms) {
        gItemMenuDrawerCustoms = pItemMenuDrawerCustoms;
        for (final ItemMenuDrawerCustom itemMenuDrawerCustom : gItemMenuDrawerCustoms) {
            menuDrawer.addView(itemMenuDrawerCustom);
            setUpItemDrawer(itemMenuDrawerCustom);
        }
    }

    public void addListItemDrawers(List<ItemMenuDrawerCustom> pItemMenuDrawerCustoms,
                                   @DrawableRes int pItemDrawerBackgroundSelected,
                                   @DrawableRes int pItemDrawerBackgroundUnSelected,
                                   @DrawableRes int pItemDrawerTextColorSelected,
                                   @DrawableRes int pItemDrawerTextColorUnSelected) {
        gItemMenuDrawerCustoms = pItemMenuDrawerCustoms;
        for (final ItemMenuDrawerCustom itemMenuDrawerCustom : gItemMenuDrawerCustoms) {
            itemMenuDrawerCustom.setItemDrawerBackgroundSelected(pItemDrawerBackgroundSelected);
            itemMenuDrawerCustom.setItemDrawerBackgroundUnSelected(pItemDrawerBackgroundUnSelected);
            itemMenuDrawerCustom.setItemDrawerTextColorSelected(pItemDrawerTextColorSelected);
            itemMenuDrawerCustom.setItemDrawerTextColorUnSelected(pItemDrawerTextColorUnSelected);
            itemMenuDrawerCustom.setItemDrawerUnSelected();
            menuDrawer.addView(itemMenuDrawerCustom);
            setUpItemDrawer(itemMenuDrawerCustom);
        }
    }

    private void setUpItemDrawer(final ItemMenuDrawerCustom pItemMenuDrawerCustom) {
        pItemMenuDrawerCustom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                pItemMenuDrawerCustom.setSelectedItemDrawer(true);
                gIdItemDrawer = pItemMenuDrawerCustom.getItemDrawerId();
                refreshItemsDrawer();
                gMenuDrawerCustomInterface.setOnClickItem(pItemMenuDrawerCustom);
            }
        });
    }

    private void refreshItemsDrawer() {
        for (final ItemMenuDrawerCustom itemMenuDrawerCustom : gItemMenuDrawerCustoms) {
            if (itemMenuDrawerCustom.getItemDrawerId() == gIdItemDrawer) {
                itemMenuDrawerCustom.setSelectedItemDrawer(true);
            } else {
                itemMenuDrawerCustom.setSelectedItemDrawer(false);
            }
        }
    }

    public void setMenuDrawerCustomInterface(MenuDrawerCustomInterface pMenuDrawerCustomInterface) {
        gMenuDrawerCustomInterface = pMenuDrawerCustomInterface;
    }

    public interface MenuDrawerCustomInterface {
        void setOnClickItem(ItemMenuDrawerCustom pItemMenuDrawerCustom);
    }

}
