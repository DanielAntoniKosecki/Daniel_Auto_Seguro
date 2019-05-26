package danielautoseguro.cursoandroid.com.danielautoseguro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends Activity {

    private ImageView botaoDanielAutoSeguros;
    private ImageView botaoCliente;
    private ImageView botaoSeguro;
    private ImageView botaoVeiculo;
    private ImageView botaoSinistro;
    private ImageView botaoCorretor;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoDanielAutoSeguros = (ImageView) findViewById(R.id.logoDanielSeguroid);
        botaoCliente = (ImageView) findViewById(R.id.clienteid);
        botaoSeguro = (ImageView) findViewById(R.id.seguroid);
        botaoVeiculo =(ImageView) findViewById(R.id.veiculoid);
        botaoSinistro = (ImageView) findViewById(R.id.sinistroid);
        botaoCorretor = (ImageView) findViewById(R.id.corretorid);





        botaoDanielAutoSeguros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DanielAutoSegurosActivity.class));
            }
        });

        botaoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClienteActivity.class));
            }
        });

        botaoSeguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SeguroActivity.class));
            }
        });

        botaoVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VeiculoActivity.class));
            }
        });

        botaoSinistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SinistroActivity.class));
            }
        });

        botaoCorretor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CorretorActivity.class));
            }
        });



    }
}
