package br.com.zaruc.yosemitesummercamp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.zaruc.yosemitesummercamp.R;
import br.com.zaruc.yosemitesummercamp.domain.MenuItem;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    Context context;
    List<MenuItem> items;
    ICallback iCallback;


    public MenuAdapter(Context context, List<MenuItem> items, ICallback iCallback) {
        this.context = context;
        this.items = items;
        this.iCallback = iCallback;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater
                .from(context)
                .inflate(
                        R.layout.menu_item,
                        parent,
                        false
                );

        return new MenuViewHolder(
                layout,
                this,
                iCallback
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.setModel(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
