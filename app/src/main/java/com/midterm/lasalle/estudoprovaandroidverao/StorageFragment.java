package com.midterm.lasalle.estudoprovaandroidverao;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StorageFragment extends Fragment {


    public StorageFragment() {
        // Required empty public constructor
    }


    private Button btnMais;
    private Button btnMenos;
    private TextView textViewNumero;
    private int number = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_storage, container, false);
        btnMais = rootView.findViewById(R.id.btnMais);
        btnMenos = rootView.findViewById(R.id.btnMenos);
        textViewNumero = rootView.findViewById(R.id.textViewNumber);

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                updateNumber(number);
            }

        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number > 0) {
                    number--;
                }
                updateNumber(number);
            }
        });

        return rootView;

    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("number",number).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        number = sharedPreferences.getInt("number", 0);
        updateNumber(number);

    }

    public void updateNumber(int number){

        textViewNumero.setText(Integer.toString(number));
    }
}
