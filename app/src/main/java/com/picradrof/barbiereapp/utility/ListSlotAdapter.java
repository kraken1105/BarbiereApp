package com.picradrof.barbiereapp.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.picradrof.barbiereapp.R;
import com.picradrof.barbiereapp.entity.IEntitySlotOrario;

import java.util.ArrayList;

public class ListSlotAdapter extends BaseAdapter {

    private Context context;
    ArrayList<IEntitySlotOrario> listaSlot;

    public ListSlotAdapter(Context context, ArrayList<IEntitySlotOrario> listaSlot) {
        this.context = context;
        this.listaSlot = listaSlot;
    }

    @Override
    public int getCount() {
        return listaSlot.size();
    }

    @Override
    public Object getItem(int position) {
        return listaSlot.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // se non è una view già usata creala con il suo layout
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_slot_item_layout, null);
        }

        //otteniamo lo slot alla posizione richiesta
        IEntitySlotOrario slotOrario = (IEntitySlotOrario) getItem(position);

        // icon
        ImageView thumbnail = (ImageView) convertView.findViewById(R.id.icon);
        thumbnail.setImageResource(R.drawable.logo_app);

        // testo
        TextView titolo = (TextView) convertView.findViewById(R.id.line);
        titolo.setText(slotOrario.getOraInizio()+"/"+slotOrario.getOraFine());

        return convertView;
    }
}
