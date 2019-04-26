package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Method;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

public class UserButtonsMenuListActivity extends AppCompatActivity implements UserButtonsMenuListContract.View {

    private UserButtonsMenuListContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar toolbar;
    private Button pickForADateButton;

    private UserButtonsMenuListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserButtonsMenuListScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }

        setContentView(R.layout.activity_user_buttons_menu_list);

        //Configuracion de la toolBar/actionBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menú");

        //Búsqueda de los elementos de la vista
        pickForADateButton = findViewById(R.id.user_buttons_menu_list_pick_for_a_date_button);

        //Listeners
        listAdapter = new UserButtonsMenuListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 UserButtonMenuItem item = (UserButtonMenuItem) view.getTag();
                 presenter.selectUserButtonsMenuListData(item);
            }
        });

        pickForADateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.pickForADateButtonPressed();
            }
        });

        //RecycleView
        RecyclerView recyclerView =  findViewById(R.id.user_buttons_menu_list);
        recyclerView.setAdapter(listAdapter);

        int columns = getResources().getInteger(R.integer.user_grid_colums);
        GridLayoutManager layoutManager = new GridLayoutManager(this, columns);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.checkThemeChanged();
        presenter.fetchUserButtonsMenuListData();
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void reboot() {
        finish();
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(UserButtonsMenuListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_appbar_buttons_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void displayUserButtonsMenuListData(final UserButtonsMenuListViewModel viewModel) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listAdapter.setItems(viewModel.userButtons);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out:
                presenter.signOutButtonPressed();
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_change_theme:
                presenter.changeThemeButtonPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
