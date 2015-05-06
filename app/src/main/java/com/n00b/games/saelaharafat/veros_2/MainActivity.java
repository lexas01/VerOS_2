package com.n00b.games.saelaharafat.veros_2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    public static String rsc;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


               spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.desktop, android.R.layout.simple_spinner_item);


// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        rsc = (String)  spinner.getSelectedItem();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.acerca) {
            return true;
        }
        if (id == R.id.salir) {

            finish();
            System.exit(0);
            return true;
        }
        if (id == R.id.verOS) {


            Intent itn=new Intent(this,MainActivity2.class);
            itn.putExtra("sistema",rsc);

            startActivity(itn);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {

             spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.mobile, android.R.layout.simple_spinner_item);


// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spinner.setAdapter(adapter);
            // Enable vibrate
            rsc = (String)  spinner.getSelectedItem();
        } else {

             spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.desktop, android.R.layout.simple_spinner_item);


// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spinner.setAdapter(adapter);

            // Disable vibrate
            rsc = (String)  spinner.getSelectedItem();
        }
    }

    @Override
    public void onBackPressed() {
        Context context = getApplicationContext();
        CharSequence text = "No morro!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public void onClick(View view) {

        rsc = (String)  spinner.getSelectedItem();

    }
}
