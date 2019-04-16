package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;


public class ChangeThemeActivity extends AppCompatActivity implements ChangeThemeContract.View {

    private ChangeThemeContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar toolbar;

    private ChangeThemeAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);

        //Configuracion de la toolBar/actionBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Temas");

        //Listeners
        listAdapter = new ChangeThemeAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeThemeItem item = (ChangeThemeItem) view.getTag();
                presenter.selectChangeThemeListData(item);
            }
        });

        //RecycleView
        RecyclerView recyclerView = findViewById(R.id.change_theme_list);
        recyclerView.setAdapter(listAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        ChangeThemeScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.fetchChangeThemeListData();
    }

    @Override
    public void displayChangeThemeListData(final ChangeThemeViewModel viewModel) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                listAdapter.setItems(viewModel.themeList);
            }
        });
    }

    @Override
    public void injectPresenter(ChangeThemeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
