package com.flores.navigationdrawercustom.menuDrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.flores.navigationdrawercustom.R;

import java.util.List;

/**
 * MenuDrawerCustom
 *
 * @author Bill Flores - Avantica
 * @since 08/09/2019
 */
public class MenuDrawerView extends LinearLayoutCompat {

    private int gIdItemDrawer;

    private LinearLayoutCompat menuDrawer;

    private List<ItemDrawerView> gItemDrawerViews;

    private MenuDrawerCustomInterface gMenuDrawerCustomInterface;

    public MenuDrawerView(Context context) {
        super(context);
        initUi(context);
    }

    public MenuDrawerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi(context);
    }

    public MenuDrawerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUi(context);
    }

    public void initUi(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_menu_drawer, this, true);
        menuDrawer = findViewById(R.id.menuDrawer);
    }

    public void addListItemDrawers(List<ItemDrawerView> pItemDrawerViews) {
        gItemDrawerViews = pItemDrawerViews;
        for (final ItemDrawerView itemDrawerView : gItemDrawerViews) {
            menuDrawer.addView(itemDrawerView);
            setUpItemDrawer(itemDrawerView);
        }
    }

    private void setUpItemDrawer(final ItemDrawerView pItemDrawerView) {
        pItemDrawerView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                pItemDrawerView.setSelect(true);
                gIdItemDrawer = pItemDrawerView.getId();
                refreshItemsDrawer();
                gMenuDrawerCustomInterface.setOnClickItem(pItemDrawerView);
            }
        });
    }

    private void refreshItemsDrawer() {
        for (final ItemDrawerView itemDrawerView : gItemDrawerViews) {
            if (itemDrawerView.getId() == gIdItemDrawer) {
                itemDrawerView.setSelect(true);
            } else {
                itemDrawerView.setSelect(false);
            }
        }
    }

    public void setMenuDrawerCustomInterface(MenuDrawerCustomInterface pMenuDrawerCustomInterface) {
        gMenuDrawerCustomInterface = pMenuDrawerCustomInterface;
    }

    public interface MenuDrawerCustomInterface {
        void setOnClickItem(ItemDrawerView pItemDrawerView);
    }

}
