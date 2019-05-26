package danielautoseguro.cursoandroid.com.danielautoseguro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class ValidadorActivity extends Activity {
    private Button iniciarApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        iniciarApp = (Button) findViewById(R.id.inicira_app_id);

        iniciarApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ValidadorActivity.this, IniciarActivity.class));
            }
        });
    }
}
