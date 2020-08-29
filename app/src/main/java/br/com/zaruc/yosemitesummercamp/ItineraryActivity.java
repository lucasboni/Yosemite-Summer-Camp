package br.com.zaruc.yosemitesummercamp;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.zaruc.yosemitesummercamp.adapter.ICallback;
import br.com.zaruc.yosemitesummercamp.adapter.MenuAdapter;
import br.com.zaruc.yosemitesummercamp.data.Menu;
import br.com.zaruc.yosemitesummercamp.domain.MenuItem;
import br.com.zaruc.yosemitesummercamp.domain.MenuItemStatus;

public class ItineraryActivity extends AppCompatActivity {

    RecyclerView rv_menu_items;
    Button bt_continue;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);

        rv_menu_items = findViewById(R.id.rv_menu_items);
        bt_continue = findViewById(R.id.bt_continue);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar( toolbar );

        /*
         * HackCode para colocar um ícone  no canto superior
         * esquerdo da tela (lado esquerdo da Toolbar).
         * */
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );


        rv_menu_items = findViewById(R.id.rv_menu_items);
        bt_continue = findViewById(R.id.bt_continue);

        initItineraryMenu();

    }


    private void initItineraryMenu(){

        GridLayoutManager layoutManager = new GridLayoutManager(
                this,
                Menu.NUMBER_COLUMNS
        );
        rv_menu_items.setLayoutManager(layoutManager);

        rv_menu_items.setHasFixedSize( true );
        rv_menu_items.setAdapter(new MenuAdapter(
                this,
                Menu.getItems(),
                new ICallback() {
                    @Override
                    public void changeButtonStatusCallback(List<MenuItem> menuItems) {
                        changeButtonStatus(menuItems);
                    }
                }
        ));
    }

    /*
     * Método responsável por atualizar o status de clique e o
     * background do botão "CONTINUE".
     *
     * Se houver ao menos um item selecionado, então o botão
     * fica como "disponível para clique", com o background
     * laranja (bt_orange_ripple) aplicado a ele.
     * */
    private void changeButtonStatus(List<MenuItem> items){

        boolean isEnabled = false;
        int backgroundId = R.color.colorMediumGrey;

        /*
         * O método any() precisa encontrar somente um item que
         * retorne true para o predicato
         * "it.isSelected == MenuItemStatus.SELECTED" que assim
         * ele para com a execução e retorna true para a variável
         * status.
         * */
        boolean status = false;
        for(MenuItem item:items){
            if(item.getIsSelected() == MenuItemStatus.SELECTED){
                status =  true;
                break;
            }
        }


        if( status ) {
            isEnabled = true;

            /*
             * Abaixo da API 21 (Lollipop) do Android não é possível
             * utilizar a API Ripple. Uma exceção será gerada caso
             * isso ocorra.
             *
             * Por isso o bloco condicional a seguir.
             * */
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                backgroundId = R.drawable.bt_orange_ripple;
            } else {
                backgroundId = R.color.colorAccent;
            }
        }

        bt_continue.setEnabled(isEnabled);
        bt_continue.setBackground(ResourcesCompat.getDrawable(
                getResources(),
                backgroundId,
                null
        ));
    }

}