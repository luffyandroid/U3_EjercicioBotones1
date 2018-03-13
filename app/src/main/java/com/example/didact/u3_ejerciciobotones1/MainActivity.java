package com.example.didact.u3_ejerciciobotones1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    CheckBox cbSopa, cbEnsalada, cbNachos, cbCarne, cbPescado;
    RadioGroup rgBebida;
    Spinner spBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbSopa = (CheckBox)findViewById(R.id.cb_sopa);
        cbEnsalada = (CheckBox)findViewById(R.id.cb_ensalada);
        cbNachos = (CheckBox)findViewById(R.id.cb_nachos);
        cbCarne = (CheckBox)findViewById(R.id.cb_carne);
        cbPescado = (CheckBox)findViewById(R.id.cb_pescado);
        rgBebida = (RadioGroup)findViewById(R.id.rg_bebida);
        spBebidas = (Spinner)findViewById(R.id.sp_bebidas);

        String[] bebidas = {"Coca Cola","Fanta Naranja","Fanta Limon","7Up",
                "Cerveza","Tinto de verano"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,bebidas);

        spBebidas.setAdapter(adaptador);





    }//fin onCreate

    public void pulsarPedido (View view){
        String pedido="";
        if(cbSopa.isChecked()){
            pedido+="Sopa ";
        }
        if(cbEnsalada.isChecked()){
            pedido+="Ensalada ";
        }
        if(cbNachos.isChecked()){
            pedido+="Nachos ";
        }
        String pedido2="";
        if(cbCarne.isChecked()){
            pedido2+="Carne ";
        }
        if(cbPescado.isChecked()){
            pedido2+="Pescado ";
        }

        int id=rgBebida.getCheckedRadioButtonId();

        RadioButton rbseleccionado = (RadioButton)findViewById(id);
        String textoRbSeleccionado = rbseleccionado.getText().toString();
        String bebidaSeleccionada = spBebidas.getSelectedItem().toString();

        if(textoRbSeleccionado.equals("Si")){
            Toast.makeText(getApplicationContext(),
                    "Usted ha pedido de primer plato "+pedido+" y de segundo "+pedido2+
                            ". Para beber "+bebidaSeleccionada,
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),
                    "Usted ha pedido de primer plato "+pedido+" y de segundo "+pedido2+". Sin bebida.",
                    Toast.LENGTH_LONG).show();
        }

    }


}//fin MainActivity
