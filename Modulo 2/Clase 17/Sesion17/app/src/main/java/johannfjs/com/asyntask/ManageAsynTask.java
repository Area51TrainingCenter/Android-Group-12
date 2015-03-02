package johannfjs.com.asyntask;

import android.content.Context;

/**
 * Created by Johann on 02/03/2015.
 */
public class ManageAsynTask {
    Context context;

    public ManageAsynTask(Context context) {
        this.context = context;
    }

    public void listar(String url) {
        ListarTodo obj = new ListarTodo(context);
        obj.execute(url);
    }

}
