package br.com.zaruc.yosemitesummercamp.adapter;

import java.util.List;

import br.com.zaruc.yosemitesummercamp.domain.MenuItem;

public interface ICallback {
    void changeButtonStatusCallback(List<MenuItem> menuItems);
}
