package br.com.senac.show;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.senac.show.DAO.ShowDAO;
import br.com.senac.show.modelo.Show;

public class FormularioShowActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityformularioshow);

        helper= new FormularioHelper(this);

        Button botaosalvar = (Button) findViewById(R.id.botaosalvar);
        botaosalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show  show =helper.getShow();
                ShowDAO dao = new ShowDAO(FormularioShowActivity.this);

                dao.inserirShow(show);
                dao.close();

                Toast.makeText(FormularioShowActivity.this, " O Show " + show.getShow() + " Salvo", Toast.LENGTH_SHORT).show();
            }
        });

        Button botaolista = (Button) findViewById(R.id.botaolista);
        botaolista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linklista = new Intent(FormularioShowActivity.this, ListaShowActivity.class);
                startActivity(linklista);
            }
        });

    }
}
