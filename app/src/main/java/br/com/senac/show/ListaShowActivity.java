package br.com.senac.show;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.senac.show.DAO.ShowDAO;
import br.com.senac.show.modelo.Show;

public class ListaShowActivity extends AppCompatActivity {
    private ListView listanomes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylistashow);

        ShowDAO dao = new ShowDAO(this);
        final List<Show> shows = dao.listashow();

        listanomes =(ListView) findViewById(R.id.listashow);
        ArrayAdapter<Show> adapter = new ArrayAdapter<Show>(this, android.R.layout.simple_list_item_activated_1, shows);
        listanomes.setAdapter(adapter);

        Button novoshow = findViewById(R.id.botaonovo);
        novoshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlinkFormulario = new Intent(ListaShowActivity.this, FormularioShowActivity.class );
                startActivity(intentlinkFormulario);
            }
        });
        registerForContextMenu(listanomes);




    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        final MenuItem deletar = menu.add("deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Show show = (Show) listanomes.getItemAtPosition(info.position);
                Toast.makeText(ListaShowActivity.this, "Será deletado" + show.getShow() + "Foi deletado", Toast.LENGTH_LONG).show();
                ShowDAO dao = new ShowDAO(ListaShowActivity.this);
                dao.deleta(show);
                dao.close();
                carregarLista();
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    private void carregarLista(){
        ShowDAO dao =   new ShowDAO(this);
        List<Show> shows =dao.listashow();
        dao.close();

        ArrayAdapter<Show> adapter =new ArrayAdapter<Show>(this,android.R.layout.simple_list_item_1, shows);
        listanomes.setAdapter(adapter);
    }
}
