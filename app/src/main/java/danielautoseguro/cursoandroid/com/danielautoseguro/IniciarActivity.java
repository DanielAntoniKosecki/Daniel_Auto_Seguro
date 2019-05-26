package danielautoseguro.cursoandroid.com.danielautoseguro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class IniciarActivity extends Activity {
    private ImageView botaoDanielAutoSeguros;
    private ImageView botaoCliente;
    private ImageView botaoSeguro;
    private ImageView botaoVeiculo;
    private ImageView botaoSinistro;
    private ImageView botaoCorretor;
    private ImageView botaoLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);

        botaoDanielAutoSeguros = (ImageView) findViewById(R.id.logoDanielSeguroid);
        botaoCliente = (ImageView) findViewById(R.id.clienteid);
        botaoSeguro = (ImageView) findViewById(R.id.seguroid);
        botaoVeiculo =(ImageView) findViewById(R.id.veiculoid);
        botaoSinistro = (ImageView) findViewById(R.id.sinistroid);
        botaoCorretor = (ImageView) findViewById(R.id.corretorid);
        botaoLogout = (ImageView) findViewById(R.id.logout_id);

        botaoDanielAutoSeguros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IniciarActivity.this, DanielAutoSegurosActivity.class));
            }
        });

        botaoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IniciarActivity.this, ClienteActivity.class));
            }
        });

        botaoSeguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IniciarActivity.this, SeguroActivity.class));
            }
        });

        botaoVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IniciarActivity.this, VeiculoActivity.class));
            }
        });

        botaoSinistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IniciarActivity.this, SinistroActivity.class));
            }
        });

        botaoCorretor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IniciarActivity.this, CorretorActivity.class));
            }
        });

        botaoLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IniciarActivity.this, "Logout feito com sucesso", Toast.LENGTH_LONG).show();
                startActivity(new Intent(IniciarActivity.this, StartActivity.class));

            }
        });

    }
}
