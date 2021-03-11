package com.example.examen_m8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //vinculamos nuestro objeto BTN con el del xml
        BottomNavigationView miMenu=findViewById(R.id.menu_view);
        /*AppBarConfiguration.builder es una clase interna de AppBarConfiguration en este ejemplo
        estamos usando un puntero de la superclase y almacenando en ella una referencia de una clase
        interna,el constructor AppBarConfiguration.Builder(int... topLevelDestinationIds) es el que estamos
        usando que recibe un conjunto destinaciones de un menu en nuestro caso
        R.id.unoFragment,R.id.dosFragment,R.id.tresFragment
        */
        AppBarConfiguration los_tres_fragments=new AppBarConfiguration.Builder(
                R.id.unoFragment,R.id.dosFragment,R.id.tresFragment
        ).build();
        //.build Construye de AppBarConfiguration instancia.

        /*NavController administra o controla una app navigation dentro de un NavHost.
        findNavController(Activity activity, int viewId) es un metodo de la clase Navigation
        su funcion es buscar un NavController por el id de la vista que le brindas y su actividad
        contenedora */
        /*fragment es el nombre de nuestro NavController del activityMain y le hemos dicho que lo busque en
        esa actividad*/
        NavController contenedor_que_mostrará_las_vistas= Navigation.findNavController(MainActivity.this,R.id.fragment);

        /*NavigationUI es el encargado de montar o instalar el AppbarConfiguration recibe un activity
        un NavController que tiene vinculado el lugar donde se mostrarán nuestros fragments creados.
        y una los_tres_fragments que tiene en su poder los 3 fragments
        */
        NavigationUI.setupActionBarWithNavController(this,
                contenedor_que_mostrará_las_vistas,
                los_tres_fragments);
        NavigationUI.setupWithNavController(miMenu, contenedor_que_mostrará_las_vistas);




    }
}