package danielautoseguro.cursoandroid.com.danielautoseguro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import danielautoseguro.cursoandroid.com.danielautoseguro.data.Usuario;
import danielautoseguro.cursoandroid.com.danielautoseguro.helper.Registros;


public class LoginActivity extends Activity {

    private EditText digiteEmail;
    private EditText digiteSenha;
    private Button botaoCadastrar;
    private Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        digiteEmail = (EditText) findViewById(R.id.digite_seu_email_id);
        digiteSenha = (EditText) findViewById(R.id.digite_sua_senha_id);
        botaoCadastrar = (Button) findViewById(R.id.botao_cadastrar_id);
        botaoLogin = (Button) findViewById(R.id.botao_login_id);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCampos()) {
                    String email = digiteEmail.getText().toString();
                    String senha = digiteSenha.getText().toString();
                    Usuario novoUsuario = new Usuario(email, senha);
                    Registros.cadastrarUsuario(novoUsuario);
                    Toast.makeText(LoginActivity.this, "Cadastro feito com sucesso", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, ValidadorActivity.class));
                }
            }
        });

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = digiteEmail.getText().toString();
                String senha = digiteSenha.getText().toString();
                if(Registros.verificarUsuario(email, senha)) {
                    Toast.makeText(LoginActivity.this, "Login feito com sucesso", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, IniciarActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Usuário ou senha incorreta", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validarCampos() {
        if(digiteEmail.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Email não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(digiteSenha.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Senha não deve estar em branco", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(digiteSenha.getText().toString().trim().length() != 6){
            Toast.makeText(this, "Senha deve ter 6 dígitos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}