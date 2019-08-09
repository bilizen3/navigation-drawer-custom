package com.flores.navigationdrawercustom.menuDrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.flores.navigationdrawercustom.R;
import com.flores.navigationdrawercustom.itemDrawer.ItemDrawerCustom;

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

    private List<ItemDrawerCustom> gItemDrawerCustoms;

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
        inflater.inflate(R.layout.layout_menu_drawer, this, true);
        menuDrawer = findViewById(R.id.menuDrawer);
    }

    public void addListItemDrawers(List<ItemDrawerCustom> pItemDrawerCustoms) {
        gItemDrawerCustoms = pItemDrawerCustoms;
        for (final ItemDrawerCustom itemDrawerCustom : gItemDrawerCustoms) {
            menuDrawer.addView(itemDrawerCustom);
            setUpItemDrawer(itemDrawerCustom);
        }
    }

    private void setUpItemDrawer(final ItemDrawerCustom pItemDrawerCustom) {
        pItemDrawerCustom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                pItemDrawerCustom.setSelect(true);
                gIdItemDrawer = pItemDrawerCustom.getId();
                refreshItemsDrawer();
                gMenuDrawerCustomInterface.setOnClickItem(pItemDrawerCustom);
            }
        });
    }

    private void refreshItemsDrawer() {
        for (final ItemDrawerCustom itemDrawerCustom : gItemDrawerCustoms) {
            if (itemDrawerCustom.getId() == gIdItemDrawer) {
                itemDrawerCustom.setSelect(true);
            } else {
                itemDrawerCustom.setSelect(false);
            }
        }
    }

    public void setMenuDrawerCustomInterface(MenuDrawerCustomInterface pMenuDrawerCustomInterface) {
        gMenuDrawerCustomInterface = pMenuDrawerCustomInterface;
    }

    public interface MenuDrawerCustomInterface {
        void setOnClickItem(ItemDrawerCustom pItemDrawerCustom);
    }

}
