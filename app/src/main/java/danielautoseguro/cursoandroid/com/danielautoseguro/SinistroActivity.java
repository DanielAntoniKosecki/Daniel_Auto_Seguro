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

public class SinistroActivity extends Activity {

    private EditText sinistroClassificacao;
    private EditText sinistroDiscriminacao;
    private EditText sinistroParticipacao;
    private EditText sinistroHorario;
    private EditText sinistroMotorista;
    private EditText sinistroData;
    private EditText sinistroTaxas;

    private Button botao;
    private AlertDialog.Builder enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinistro);

        sinistroClassificacao = (EditText) findViewById(R.id.sinistro_classificacao_id);
        sinistroDiscriminacao = (EditText) findViewById(R.id.sinistro_discriminacao_id);
        sinistroParticipacao = (EditText) findViewById(R.id.sinistro_participacao_id);
        sinistroHorario = (EditText) findViewById(R.id.sinistro_horario_id);
        sinistroMotorista = (EditText) findViewById(R.id.sinistro_motorista_id);
        sinistroData = (EditText) findViewById(R.id.sinistro_data_id);
        sinistroTaxas = (EditText) findViewById(R.id.sinistro_taxa_id);

        botao = (Button) findViewById(R.id.button_sinistro_enviarid);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criar alert dialog

                enviar = new AlertDialog.Builder(SinistroActivity.this);

                //Configurar o titulo

                enviar.setTitle("Sinistro Daniel Auto Seguro");

                //Configurar a mensagem

                enviar.setMessage("Deseja enviar dados?");

                //Configurar botao NAO

                enviar.setNegativeButton("NAO Enviar Dados!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SinistroActivity.this, "Presionado botao NAO, dados NAO FORAM ENVIADOS!",
                                        Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });

                //Configurar botao SIM

                enviar.setPositiveButton("SIM, Enviar Dados.",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (validarCampos()) {
                                    Toast.makeText(SinistroActivity.this, "Presionado botao SIM, dados foram enviados com sucesso.",
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
        if (sinistroClassificacao.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Classificacao  não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sinistroDiscriminacao.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Discriminacao não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sinistroParticipacao.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "participacao não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sinistroHorario.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Horario não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sinistroMotorista.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Motorista  não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sinistroData.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Data não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sinistroTaxas.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Taxas não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}
