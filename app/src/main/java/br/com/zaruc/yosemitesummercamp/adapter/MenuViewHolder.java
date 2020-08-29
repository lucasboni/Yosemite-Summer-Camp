package br.com.zaruc.yosemitesummercamp.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import br.com.zaruc.yosemitesummercamp.R;
import br.com.zaruc.yosemitesummercamp.domain.MenuItem;
import br.com.zaruc.yosemitesummercamp.domain.MenuItemStatus;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    CardView cvIcon;
    ImageView ivSelected;
    View vvGradient;
    ImageView ivIcon;
    TextView tvLabel;

    MenuAdapter adapter;
    ICallback iCallback;

    public MenuViewHolder(@NonNull View itemView, MenuAdapter adapter,ICallback iCallback) {
        super(itemView);
        this.adapter = adapter;
        this.iCallback = iCallback;
        itemView.setOnClickListener( this );

        cvIcon = itemView.findViewById( R.id.cv_icon );
        ivSelected = itemView.findViewById( R.id.iv_selected );
        vvGradient = itemView.findViewById( R.id.vv_gradient );
        ivIcon = itemView.findViewById( R.id.iv_icon );
        tvLabel = itemView.findViewById( R.id.tv_label );
    }


    void setModel( MenuItem item  ) {
        tvLabel.setText(item.getLabel());
        ivIcon.setImageResource(item.getIcon());
        ivIcon.setContentDescription(item.getLabel());

        setStyle(item);
    }


    private void setStyle(MenuItem item){
        /*
         * Até a última declaração de variável mutável (var)
         * tem toda a definição de estilo de um
         * "item não selecionado" (isSelected == false) que
         * é o valor inicial de cada item de itinerário em
         * tela.
         * */
        int cvBackgroundResource = R.drawable.cv_background_normal;
        int ivSelectedVisibility = View.INVISIBLE;
        int vvGradientVisibility = View.VISIBLE;
        int tvLabelColor = R.color.colorDarkGrey;
        int ivIconColor = ResourcesCompat.getColor(
                itemView.getContext().getResources(),
                R.color.colorDarkPurple,
                null
        );

        if( item.getIsSelected() == MenuItemStatus.SELECTED ){//caso esteja selecionado muda o background
            /*
             * A seguir toda a definição de valores de um
             * "item selecionado" (isSelected == true).
             * */
            cvBackgroundResource = R.drawable.cv_background_selected;
            ivSelectedVisibility = View.VISIBLE;
            vvGradientVisibility = View.INVISIBLE;
            ivIconColor = Color.WHITE;
            tvLabelColor = R.color.colorDarkPurple;
        }

        cvIcon.setBackgroundResource( cvBackgroundResource );
        ivSelected.setVisibility(ivSelectedVisibility);
        vvGradient.setVisibility(vvGradientVisibility);

        /*
         * A invocação setColorFilter( ivIconColor, PorterDuff.Mode.SRC_IN )
         * informa que somente os pixels não transparentes da
         * imagem (dentro do ImageView) é que devem receber a
         * cor definida em ivIconColor.
         *
         * A constante PorterDuff.Mode.SRC_IN é responsável pela
         * regra de negócio "somente os pixels não transparentes (...)".
         * */
        ivIcon.setColorFilter( ivIconColor, PorterDuff.Mode.SRC_IN );

        tvLabel.setTextColor(
                ResourcesCompat.getColor(
                        itemView.getContext().getResources(),
                        tvLabelColor,
                        null
                )
        );
    }


    @Override
    public void onClick(View view) {
        /*
         * O algoritmo a seguir é responsável por colocar, no
         * item acionado pelo usuário, o status e estilo adequados
         * de acordo com o status atual do item.
         *
         * Com a função with() sendo utilizada nós podemos abreviar
         * o código. Dentro do bloco desta função podemos utilizar
         * "this" ao invés de "adapter.items[ adapterPosition ]".
         * */
        MenuItem menuItem = adapter.getItems().get(getAdapterPosition());
        if(menuItem.getIsSelected() == MenuItemStatus.SELECTED){
            menuItem.setIsSelected(MenuItemStatus.NOT_SELECTED);
        }else{
            menuItem.setIsSelected(MenuItemStatus.SELECTED);
        }
        adapter.notifyItemChanged(getAdapterPosition());
        iCallback.changeButtonStatusCallback( adapter.getItems());

    }
}
