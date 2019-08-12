package com.flores.navigationdrawercustom;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.flores.navigationdrawercustom.menuDrawer.ItemMenuDrawerCustom;
import com.flores.navigationdrawercustom.menuDrawer.MenuDrawerCustom;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MenuDrawerCustom.MenuDrawerCustomInterface {

    private MenuDrawerCustom menuDrawerCustom;

    private final int MY_ACCOUNTS = 1;
    private final int TRANSFERENCE = 2;
    private final int PAYMENTS = 3;
    private final int FIXED_TERM = 4;
    private final int NOTIFICATIONS = 5;
    private final int FREQUENT_OPERATIONS = 6;
    private final int SETTINGS = 7;
    private final int LOCAL_US = 8;
    private final int FREQUENT_QUESTIONS = 9;
    private final int PROMOTIONS= 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setMenuDrawer();
    }

    public void setMenuDrawer() {
        menuDrawerCustom = findViewById(R.id.mainMenuDrawerCustom);
        addDataFake();
    }

    private void addDataFake() {
        List<ItemMenuDrawerCustom> arrayList = new ArrayList();

        ItemMenuDrawerCustom itemMenuDrawerCustom = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom.setItemDrawerId(MY_ACCOUNTS);
        itemMenuDrawerCustom.setItemDrawerText("Mis Cuentas");
        itemMenuDrawerCustom.setItemDrawerImageUnSelected(R.drawable.ic_disable_my_accounts);
        itemMenuDrawerCustom.setItemDrawerImageSelected(R.drawable.ic_active_my_accounts);
        arrayList.add(itemMenuDrawerCustom);

        ItemMenuDrawerCustom itemMenuDrawerCustom1 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom1.setItemDrawerId(TRANSFERENCE);
        itemMenuDrawerCustom1.setItemDrawerText("Transferencias");
        itemMenuDrawerCustom1.setItemDrawerImageSelected(R.drawable.ic_active_transfers);
        itemMenuDrawerCustom1.setItemDrawerImageUnSelected(R.drawable.ic_disable_transfers);
        arrayList.add(itemMenuDrawerCustom1);

        ItemMenuDrawerCustom itemMenuDrawerCustom2 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom2.setItemDrawerId(PAYMENTS);
        itemMenuDrawerCustom2.setItemDrawerText("Pagos");
        itemMenuDrawerCustom2.setItemDrawerImageSelected(R.drawable.ic_active_payments);
        itemMenuDrawerCustom2.setItemDrawerImageUnSelected(R.drawable.ic_disable_payments);
        arrayList.add(itemMenuDrawerCustom2);

        ItemMenuDrawerCustom itemMenuDrawerCustom3 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom3.setItemDrawerId(FIXED_TERM);
        itemMenuDrawerCustom3.setItemDrawerText("Plazo Fijo");
        itemMenuDrawerCustom3.setItemDrawerImageSelected(R.drawable.ic_active_fixed_term);
        itemMenuDrawerCustom3.setItemDrawerImageUnSelected(R.drawable.ic_disable_fixed_term);
        arrayList.add(itemMenuDrawerCustom3);

        ItemMenuDrawerCustom itemMenuDrawerCustom4 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom4.setItemDrawerId(NOTIFICATIONS);
        itemMenuDrawerCustom4.setItemDrawerText("Notificaciones");
        itemMenuDrawerCustom4.setItemDrawerImageSelected(R.drawable.ic_active_notifications);
        itemMenuDrawerCustom4.setItemDrawerImageUnSelected(R.drawable.ic_disable_notifications);
        arrayList.add(itemMenuDrawerCustom4);

        ItemMenuDrawerCustom itemMenuDrawerCustom5 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom5.setItemDrawerId(FREQUENT_OPERATIONS);
        itemMenuDrawerCustom5.setItemDrawerText("Operaciones frecuentes");
        itemMenuDrawerCustom5.setItemDrawerImageSelected(R.drawable.ic_active_frequent_operations);
        itemMenuDrawerCustom5.setItemDrawerImageUnSelected(R.drawable.ic_disable_frequent_operations);
        arrayList.add(itemMenuDrawerCustom5);

        ItemMenuDrawerCustom itemMenuDrawerCustom6 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom6.setItemDrawerId(SETTINGS);
        itemMenuDrawerCustom6.setItemDrawerText("Configuración");
        itemMenuDrawerCustom6.setItemDrawerImageSelected(R.drawable.ic_active_configuration);
        itemMenuDrawerCustom6.setItemDrawerImageUnSelected(R.drawable.ic_disable_configuration);
        arrayList.add(itemMenuDrawerCustom6);

        ItemMenuDrawerCustom itemMenuDrawerCustom7 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom7.setItemDrawerId(LOCAL_US);
        itemMenuDrawerCustom7.setItemDrawerText("Ubícanos");
        itemMenuDrawerCustom7.setItemDrawerImageSelected(R.drawable.ic_active_locate_us);
        itemMenuDrawerCustom7.setItemDrawerImageUnSelected(R.drawable.ic_disable_locate_us);
        arrayList.add(itemMenuDrawerCustom7);

        ItemMenuDrawerCustom itemMenuDrawerCustom8 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom8.setItemDrawerId(FREQUENT_QUESTIONS);
        itemMenuDrawerCustom8.setItemDrawerText("Preguntas frecuentes");
        itemMenuDrawerCustom8.setItemDrawerImageSelected(R.drawable.ic_active_frequent_questions);
        itemMenuDrawerCustom8.setItemDrawerImageUnSelected(R.drawable.ic_disable_frequent_questions);
        arrayList.add(itemMenuDrawerCustom8);

        ItemMenuDrawerCustom itemMenuDrawerCustom9 = new ItemMenuDrawerCustom(this);
        itemMenuDrawerCustom9.setItemDrawerId(PROMOTIONS);
        itemMenuDrawerCustom9.setItemDrawerText("Promociones");
        itemMenuDrawerCustom9.setItemDrawerImageSelected(R.drawable.ic_active_promotions);
        itemMenuDrawerCustom9.setItemDrawerImageUnSelected(R.drawable.ic_disable_promotions);
        arrayList.add(itemMenuDrawerCustom9);

        menuDrawerCustom.setMenuDrawerCustomInterface(this);
        menuDrawerCustom.addListItemDrawers(
                arrayList,
                R.drawable.bg_item,
                R.color.colorTransparent,
                R.color.colorSelected,
                R.color.colorWhite);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setOnClickItem(ItemMenuDrawerCustom pItemMenuDrawerCustom) {
        Toast.makeText(this, pItemMenuDrawerCustom.getItemDrawerText(), Toast.LENGTH_SHORT).show();
        switch (pItemMenuDrawerCustom.getItemDrawerId()) {
            case MY_ACCOUNTS:
                break;
            case TRANSFERENCE:
                break;
            case PAYMENTS:
                break;
            case FIXED_TERM:
                break;
            case NOTIFICATIONS:
                break;
            case FREQUENT_OPERATIONS:
                break;
            case SETTINGS:
                break;
        }
        onBackPressed();
    }
}
