package danielautoseguro.cursoandroid.com.danielautoseguro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VeiculoActivity extends Activity {

    private EditText veiculoCor;
    private EditText veiculoModelo;
    private EditText veiculoAno;
    private EditText veiculoFabricante;

    private Button botao;
    private AlertDialog.Builder enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        veiculoCor = (EditText) findViewById(R.id.veiculo_cor_id);
        veiculoModelo = (EditText) findViewById(R.id.veiculo_modelo_id);
        veiculoAno = (EditText) findViewById(R.id.veiculo_ano_id);
        veiculoFabricante = (EditText) findViewById(R.id.veiculo_fabricante_id);


        botao = (Button) findViewById(R.id.button_veiculo_enviarid);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criar alert dialog

                enviar =new AlertDialog.Builder(VeiculoActivity.this);

                //Configurar o titulo

                enviar.setTitle("Veiculo Daniel Auto Seguro");

                //Configurar a mensagem

                enviar.setMessage("Deseja enviar dados?");

                //Configurar botao NAO

                enviar.setNegativeButton("NAO Enviar Dados!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(VeiculoActivity.this, "Presionado botao NAO, dados NAO FORAM ENVIADOS!",
                                        Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });

                //Configurar botao SIM

                enviar.setPositiveButton("SIM, Enviar Dados.",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(validarCampos()) {
                                    Toast.makeText(VeiculoActivity.this, "Presionado botao SIM, dados foram enviados com sucesso.",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            }
                        });
                enviar.create();
                enviar.show();
            }
        });
    }


    private boolean validarCampos() {
        if (veiculoCor.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Cor do veiculo não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (veiculoModelo.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Modelo do veiculo não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (veiculoAno.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ano do veiculo não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (veiculoFabricante.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Fabricante do veiculo não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}
