package danielautoseguro.cursoandroid.com.danielautoseguro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;





public class StartActivity extends Activity {

        private ImageView botaoiconeDanielAutoSeguro;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        botaoiconeDanielAutoSeguro = (ImageView) findViewById(R.id.ImageViewLogin_id);



        botaoiconeDanielAutoSeguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,LoginActivity.class));
            }
        });

    }
}
