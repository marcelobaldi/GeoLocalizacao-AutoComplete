package com.project.petslocation.helper;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

public class Permissao {

    private static class InstanceHolder{
        private static final Permissao instance = new Permissao();
    }

    public static Permissao getInstance() {
        return InstanceHolder.instance;
    }

    public void solicitarPermissoes(Activity activity, String[] permissoes,int requestCode) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> listaPermissoes = new ArrayList<>();
            for (String permissao : permissoes)
                if (ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_DENIED)
                    listaPermissoes.add(permissao);
            if(listaPermissoes.size() > 0){
                String[] solicitarPermissoes = new String[listaPermissoes.size()];
                listaPermissoes.toArray(solicitarPermissoes);
                ActivityCompat.requestPermissions(activity,solicitarPermissoes,requestCode);
            }
        }
    }
}
