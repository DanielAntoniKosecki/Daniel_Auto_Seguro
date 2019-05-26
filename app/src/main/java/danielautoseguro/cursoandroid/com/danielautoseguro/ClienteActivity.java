package danielautoseguro.cursoandroid.com.danielautoseguro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ClienteActivity extends Activity {

    private EditText clienteNome;
    private EditText clienteIdade;
    private EditText clienteRg;
    private EditText clienteCpf;
    private EditText clienteCnhAnos;
    private Spinner clienteSexo;

    private Button botao;
    private AlertDialog.Builder enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        clienteNome = (EditText) findViewById(R.id.cliente_nome_id);
        clienteIdade = (EditText) findViewById(R.id.cliente_idade_id);
        clienteRg = (EditText) findViewById(R.id.cliente_rg_id);
        clienteCpf = (EditText) findViewById(R.id.cliente_cpf_id);
        clienteCnhAnos = (EditText) findViewById(R.id.cliente_cnh_anos_id);

        String sexoSpinner[] = new String[3];
        sexoSpinner[0] = "Sexo*";
        sexoSpinner[1] = "Masculino";
        sexoSpinner[2] = "Feminino";

        clienteSexo = (Spinner) findViewById(R.id.cliente_sexo_id);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sexoSpinner);
        clienteSexo.setAdapter(adapter);

        botao = (Button) findViewById(R.id.button_cliente_enviarid);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criar alert dialog

                enviar =new AlertDialog.Builder(ClienteActivity.this);

                //Configurar o titulo

                enviar.setTitle("Cliente Daniel Auto Seguro");

                //Configurar a mensagem

                enviar.setMessage("Deseja enviar dados?");

                //Configurar botao NAO

                enviar.setNegativeButton("NAO Enviar Dados!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ClienteActivity.this, "Presionado botao NAO, dados NAO FORAM ENVIADOS!",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                //Configurar botao SIM

                enviar.setPositiveButton("SIM, Enviar Dados.",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(validarCampos()) {
                                    Toast.makeText(ClienteActivity.this, "Presionado botao SIM, dados foram enviados com sucesso.",
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
        if(clienteNome.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Nome não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(clienteIdade.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Idade não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(clienteRg.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "RG não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(clienteRg.getText().toString().trim().length() != 9){
            Toast.makeText(this, "RG deve ter 9 dígitos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(clienteCpf.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "CPF não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(clienteCpf.getText().toString().trim().length() != 11){
            Toast.makeText(this, "CPF deve ter 11 dígitos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(clienteCnhAnos.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Anos de CNH não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(clienteSexo.getSelectedItemPosition() == 0){
            Toast.makeText(this, "Sexo não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
