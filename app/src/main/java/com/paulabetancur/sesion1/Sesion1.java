package com.paulabetancur.sesion1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Sesion1 extends AppCompatActivity {

    private String nombre, apellido, mail, telefono, sexo, hobbies = "", ciudad;
    private EditText eNombre, eApellido, eMail, eTelefono;
    private Button bRegistrar;
    private TextView tInfo;
    private RadioButton rMasculino, rFemenino;
    private CheckBox cCine, cDormir, cComer, cBailar;
    private Spinner sCiudades;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion1);


        eNombre = (EditText) findViewById( R.id.eNombre);
        eApellido = (EditText) findViewById( R.id.eApellido);
        bRegistrar = (Button) findViewById( R.id.bRegistrar);
        tInfo = (TextView) findViewById( R.id.tInfo);
        eMail = (EditText) findViewById(R.id.eMail);
        eTelefono = (EditText) findViewById( R.id.eTelefono);
        rMasculino = (RadioButton) findViewById ( R.id.rMasculino) ;
        rFemenino = (RadioButton) findViewById( R.id.rFemenino);
        cCine = (CheckBox) findViewById( R.id.cCine);
        cComer = (CheckBox) findViewById( R.id.cComer);
        cDormir = (CheckBox) findViewById( R.id.cDormir);
        cBailar = (CheckBox) findViewById( R.id.cBailar);
        sCiudades = (Spinner) findViewById( R.id.sCiudades);






        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





     bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = eNombre.getText().toString();
                apellido = eApellido.getText().toString();
                mail = eMail.getText().toString();
                telefono = eTelefono.getText().toString();


                if (rMasculino.isChecked()) {
                    sexo = "Masculino";
                } else {
                        sexo = "Femenino";
                 }

                if(cCine.isChecked()){ hobbies+= "Cine ";}
                if(cComer.isChecked()){ hobbies+= "Comer ";}
                if(cBailar.isChecked()){ hobbies+= "Dormir ";}
                if(cCine.isChecked()){ hobbies+= "Bailar ";}




                tInfo.setText("Nombre: " +nombre+ "\nApellido: " +apellido+ "\nTelefono: " +telefono+ "\nSexo: " +sexo+ "\nHobbies: " +hobbies);
            }
        });






    }
}







