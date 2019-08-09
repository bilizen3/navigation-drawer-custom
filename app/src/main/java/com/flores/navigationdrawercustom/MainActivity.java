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
import com.flores.navigationdrawercustom.itemDrawer.ItemDrawerCustom;
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
        List<ItemDrawerCustom> arrayList = new ArrayList();

        ItemDrawerCustom itemDrawerCustom = new ItemDrawerCustom(this);
        itemDrawerCustom.setId(MY_ACCOUNTS);
        itemDrawerCustom.setSelected(true);
        itemDrawerCustom.setText("Mis perfil");
        arrayList.add(itemDrawerCustom);

        ItemDrawerCustom itemDrawerCustom1 = new ItemDrawerCustom(this);
        itemDrawerCustom1.setId(TRANSFERENCE);
        itemDrawerCustom1.setText("Transferencias");
        arrayList.add(itemDrawerCustom1);

        ItemDrawerCustom itemDrawerCustom2 = new ItemDrawerCustom(this);
        itemDrawerCustom2.setId(PAYMENTS);
        itemDrawerCustom2.setText("Pagos");
        arrayList.add(itemDrawerCustom2);

        ItemDrawerCustom itemDrawerCustom3 = new ItemDrawerCustom(this);
        itemDrawerCustom3.setId(FIXED_TERM);
        itemDrawerCustom3.setText("Plazo Fijo");
        arrayList.add(itemDrawerCustom3);

        ItemDrawerCustom itemDrawerCustom4 = new ItemDrawerCustom(this);
        itemDrawerCustom4.setId(NOTIFICATIONS);
        itemDrawerCustom4.setText("Notificaciones");
        arrayList.add(itemDrawerCustom4);

        ItemDrawerCustom itemDrawerCustom5 = new ItemDrawerCustom(this);
        itemDrawerCustom5.setId(FREQUENT_OPERATIONS);
        itemDrawerCustom5.setText("Operaciones frecuentes");
        arrayList.add(itemDrawerCustom5);

        ItemDrawerCustom itemDrawerCustom6 = new ItemDrawerCustom(this);
        itemDrawerCustom6.setId(SETTINGS);
        itemDrawerCustom6.setText("Configuración");
        arrayList.add(itemDrawerCustom6);

        menuDrawerCustom.setMenuDrawerCustomInterface(this);
        menuDrawerCustom.addListItemDrawers(arrayList);
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
    public void setOnClickItem(ItemDrawerCustom pItemDrawerCustom) {
        Toast.makeText(this, pItemDrawerCustom.getText(), Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}
