package mx.alfredoul.tareaactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker dp;
    private EditText teNombre, teTelefono, teEmail, teDescripcionContacto;

    private Button btnSiguiente;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias a los elementos en el activity_main.xml
        dp = (DatePicker) findViewById(R.id.dp);
        teNombre = (EditText) findViewById(R.id.inputNombre);
        teTelefono = (EditText) findViewById(R.id.inputTelefono);
        teEmail = (EditText) findViewById(R.id.inputEmail);
        teDescripcionContacto = (EditText) findViewById(R.id.inputDescripcionContacto);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        //Inicializamos con la fecha del día de hoy.
        final Calendar c = Calendar.getInstance();
        dp.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), null);

        //Escuchamos el evento on click en el botón
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtenemos la fecha de nacimiento del picker
                int day = dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year = dp.getYear();

                //Pasamos las variables en el intent a la siguiente actividad (ConfirmaDatos)
                Intent intent = new Intent(getBaseContext(), ConfirmaDatos.class);

                intent.putExtra("nombre", "Nombre completo: "+teNombre.getText().toString());
                intent.putExtra("fechaNacimiento", "Fecha de nacimiento: "+year+"-"+month+"-"+day);
                intent.putExtra("telefono", "Teléfono: "+ teTelefono.getText().toString());
                intent.putExtra("email", "Email: "+ teEmail.getText().toString());
                intent.putExtra("descripcionContacto", "Descripcion del contacto: "+ teDescripcionContacto.getText().toString());

                //Inicializamos la actividad nueva
                startActivity(intent);

            }
        });

    }
}
