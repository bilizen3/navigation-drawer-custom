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
import com.flores.navigationdrawercustom.menuDrawer.ItemDrawerView;
import com.flores.navigationdrawercustom.menuDrawer.MenuDrawerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MenuDrawerView.MenuDrawerCustomInterface {

    private MenuDrawerView menuDrawerView;

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
        menuDrawerView = findViewById(R.id.mainMenuDrawerCustom);
        addDataFake();
    }

    private void addDataFake() {
        List<ItemDrawerView> arrayList = new ArrayList();

        ItemDrawerView itemDrawerView = new ItemDrawerView(this);
        itemDrawerView.setId(MY_ACCOUNTS);
        itemDrawerView.setSelected(true);
        itemDrawerView.setText("Mis perfil");
        arrayList.add(itemDrawerView);

        ItemDrawerView itemDrawerView1 = new ItemDrawerView(this);
        itemDrawerView1.setId(TRANSFERENCE);
        itemDrawerView1.setText("Transferencias");
        arrayList.add(itemDrawerView1);

        ItemDrawerView itemDrawerView2 = new ItemDrawerView(this);
        itemDrawerView2.setId(PAYMENTS);
        itemDrawerView2.setText("Pagos");
        arrayList.add(itemDrawerView2);

        ItemDrawerView itemDrawerView3 = new ItemDrawerView(this);
        itemDrawerView3.setId(FIXED_TERM);
        itemDrawerView3.setText("Plazo Fijo");
        arrayList.add(itemDrawerView3);

        ItemDrawerView itemDrawerView4 = new ItemDrawerView(this);
        itemDrawerView4.setId(NOTIFICATIONS);
        itemDrawerView4.setText("Notificaciones");
        arrayList.add(itemDrawerView4);

        ItemDrawerView itemDrawerView5 = new ItemDrawerView(this);
        itemDrawerView5.setId(FREQUENT_OPERATIONS);
        itemDrawerView5.setText("Operaciones frecuentes");
        arrayList.add(itemDrawerView5);

        ItemDrawerView itemDrawerView6 = new ItemDrawerView(this);
        itemDrawerView6.setId(SETTINGS);
        itemDrawerView6.setText("Configuración");
        arrayList.add(itemDrawerView6);

        menuDrawerView.setMenuDrawerCustomInterface(this);
        menuDrawerView.addListItemDrawers(arrayList);
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
    public void setOnClickItem(ItemDrawerView pItemDrawerView) {
        Toast.makeText(this, pItemDrawerView.getText(), Toast.LENGTH_SHORT).show();
        switch (pItemDrawerView.getId()) {
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
