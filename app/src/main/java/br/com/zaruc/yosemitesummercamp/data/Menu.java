package br.com.zaruc.yosemitesummercamp.data;

import java.util.Arrays;
import java.util.List;

import br.com.zaruc.yosemitesummercamp.R;
import br.com.zaruc.yosemitesummercamp.domain.MenuItem;

public class Menu {

    public static final int NUMBER_COLUMNS = 3;

    public static List<MenuItem> getItems(){
        return Arrays.asList(
                new MenuItem(
                        "Acampamento",
                        R.drawable.ic_camp
                ),
                new MenuItem(
                        "Pescaria",
                        R.drawable.ic_fishing
                ),
                new MenuItem(
                        "Fazer as malas",
                        R.drawable.ic_packing
                ),
                new MenuItem(
                        "Trilha",
                        R.drawable.ic_forest
                ),
                new MenuItem(
                        "Transporte",
                        R.drawable.ic_transport
                ),
                new MenuItem(
                        "Rafting",
                        R.drawable.ic_rafting
                ),
                new MenuItem(
                        "Rádio",
                        R.drawable.ic_radio
                ),
                new MenuItem(
                        "Café",
                        R.drawable.ic_coffee
                ),
                new MenuItem(
                        "Telescópio",
                        R.drawable.ic_telescope
                ),
                new MenuItem(
                        "Rapel",
                        R.drawable.ic_rapel
                ),
                new MenuItem(
                        "Cart",
                        R.drawable.ic_cart
                ),
                new MenuItem(
                        "Surf",
                        R.drawable.ic_surfboard
                )
        );
    }

}
