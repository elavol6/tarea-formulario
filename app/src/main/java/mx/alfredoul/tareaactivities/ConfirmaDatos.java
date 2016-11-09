package mx.alfredoul.tareaactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmaDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);

        Bundle extras = getIntent().getExtras();

        TextView tvNombre = (TextView) findViewById(R.id.tv_nombre);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tv_nacimiento);
        TextView tvTelefono = (TextView) findViewById(R.id.tv_telefono);
        TextView tvEmail = (TextView) findViewById(R.id.tv_email);
        TextView tvDescirpcionContacto = (TextView) findViewById(R.id.tv_descripcion_contacto);

        tvNombre.setText((CharSequence) extras.get("nombre"));
        tvFechaNacimiento.setText((CharSequence) extras.get("fechaNacimiento"));
        tvTelefono.setText((CharSequence) extras.get("telefono"));
        tvEmail.setText((CharSequence) extras.get("email"));
        tvDescirpcionContacto.setText((CharSequence) extras.get("descripcionContacto"));

        Button btnEditar = (Button) findViewById(R.id .btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
