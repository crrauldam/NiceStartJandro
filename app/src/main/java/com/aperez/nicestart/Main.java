package com.aperez.nicestart;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TextView mycontext = findViewById(R.id.text1);
        //Hago que el contextMenu salga al mantener el text1
        registerForContextMenu(mycontext);





//        ImageView logo = findViewById(R.id.profile);
//
//
//        Glide.with(this)
//                .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
////                .load(R.drawable.logo)
////                .transition(DrawableTransitionOptions.withCrossFade(2000))
//                .circleCrop()
////                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
//                .into(logo);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    //Creo el Menu ContextMenu que sale al mantener el text1
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected (MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
//            showAlertDialogButtonClicked(Main.this);

            Toast toast = Toast.makeText(this, "Copy", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (id == R.id.item2) {
            Toast toast = Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT);
            toast.show();
        }

        return super.onOptionsItemSelected(item);
    }


    //Creo el Menu OptionsMenu que aparece en el action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
//            showAlertDialogButtonClicked(Main.this);

            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(Main.this, Login.class);
            startActivity(intent);

        }
        if (id == R.id.item2) {
//            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_SHORT);
//            toast.show();

            final ConstraintLayout mLayout = findViewById(R.id.main);

            Snackbar snackbar = Snackbar
                .make(mLayout, "Has la pulsado personita?", Snackbar.LENGTH_LONG);
//                .setAction("UNDO", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
//                        snackbar1.show();
//                    }
//                });

            snackbar.show();
        }

        return super.onOptionsItemSelected(item);
    }

    
//    @Override
//    public void onRefresh() {
//        final ConstraintLayout mLayout = findViewById(R.id.main);
//
//        Snackbar snackbar = Snackbar
//                .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
//                        .setAction("UNDO", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
//                                snackbar1.show();
//                            }
//                        });
//
//        snackbar.show();
//    }
}