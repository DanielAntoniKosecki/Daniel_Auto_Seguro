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

public class SeguroActivity extends Activity {

    private EditText seguroNumero;
    private EditText seguroValor;
    private EditText seguroParcela;
    private EditText seguroValidade;
    private EditText seguroConta;
    private EditText seguroDesconto;

    private Button botao;
    private AlertDialog.Builder enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguro);

        seguroNumero = (EditText) findViewById(R.id.seguro_numero_id);
        seguroValor = (EditText) findViewById(R.id.seguro_valor_id);
        seguroParcela = (EditText) findViewById(R.id.seguro_parcelas_id);
        seguroValidade = (EditText) findViewById(R.id.seguro_validade_id);
        seguroConta = (EditText) findViewById(R.id.seguro_vencimento_id);
        seguroDesconto = (EditText) findViewById(R.id.seguro_desconto_id);

        botao = (Button) findViewById(R.id.button_seguro_enviarid);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criar alert dialog

                enviar = new AlertDialog.Builder(SeguroActivity.this);

                //Configurar o titulo

                enviar.setTitle("Seguro Daniel Auto Seguro");

                //Configurar a mensagem

                enviar.setMessage("Deseja enviar dados?");

                //Configurar botao NAO

                enviar.setNegativeButton("NAO Enviar Dados!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SeguroActivity.this, "Presionado botao NAO, dados NAO FORAM ENVIADOS!",
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
                                    Toast.makeText(SeguroActivity.this, "Presionado botao SIM, dados foram enviados com sucesso.",
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
        if (seguroNumero.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Numero do seguro não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (seguroValor.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Valor do seguro não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (seguroParcela.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Parcela do seguro não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (seguroValidade.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Validade do seguro deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (seguroConta.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Conta do seguro não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (seguroDesconto.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Desconto nao  deve ter estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

}
