package br.com.senac.show;



import android.widget.EditText;

import br.com.senac.show.modelo.Show;

public class FormularioHelper {
    private final EditText camposhow;
    private final EditText campodias;
    private final EditText campohoras;



    public FormularioHelper(FormularioShowActivity activity) {

        camposhow = activity.findViewById(R.id.nomeevento);
        campodias = activity.findViewById(R.id.dias);
        campohoras =activity.findViewById(R.id.horas);



    }

    public Show getShow(){
        Show show = new Show();
        show.setShow(camposhow.getText().toString());
        show.setDias(campodias.getText().toString());
        show.setHoras(campohoras.getText().toString());


        return show;
    }

}
