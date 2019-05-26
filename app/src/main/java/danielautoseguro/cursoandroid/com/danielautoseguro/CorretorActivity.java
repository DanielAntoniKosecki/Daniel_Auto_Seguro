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

public class CorretorActivity extends Activity {

    private EditText corretorNome;
    private EditText corretorNumero;

    private Button botao;
    private AlertDialog.Builder enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corretor);

        corretorNome = (EditText) findViewById(R.id.corretor_nome_id);
        corretorNumero = (EditText) findViewById(R.id.corretor_cadastro_id);

        botao = (Button) findViewById(R.id.button_corretor_enviarid);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criar alert dialog

                enviar =new AlertDialog.Builder(CorretorActivity.this);

                //Configurar o titulo

                enviar.setTitle("Corretor Daniel Auto Seguro");

                //Configurar a mensagem

                enviar.setMessage("Deseja enviar dados?");

                //Configurar botao NAO

                enviar.setNegativeButton("NAO Enviar Dados!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(CorretorActivity.this, "Presionado botao NAO, dados NAO FORAM ENVIADOS!",
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
                                    Toast.makeText(CorretorActivity.this, "Presionado botao SIM, dados foram enviados com sucesso.",
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
        if (corretorNome.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Nome do corretor não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (corretorNumero.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Numero de corretor não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}