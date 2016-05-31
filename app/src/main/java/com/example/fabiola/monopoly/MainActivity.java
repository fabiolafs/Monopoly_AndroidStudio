package com.example.fabiola.monopoly;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends Activity implements OnClickListener {

    private Socket client;
    private PrintWriter printwriter;
    private EditText textField;
    private Button button;
    private String messsage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up click listeners for all the buttons
        View playNowButton = findViewById(R.id.playNow_button);
        playNowButton.setOnClickListener(this);

        View optionsButton = findViewById(R.id.options_button);
        optionsButton.setOnClickListener(this);

        View helpButton = findViewById(R.id.help_button);
        helpButton.setOnClickListener(this);

        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        //---------------------------------------------
    }

    public void teste(){
        //i = new Intent(this, PlayNowActivity.class);
        //startActivity(i);

        messsage = "qudsckjsbvhba";//textField.getText().toString(); // get the text message on the text field
        textField.setText(""); // Reset the text field to blank

        try {

            System.out.println("entrei");
            client = new Socket("192.168.56.1", 4444); // connect to server
            printwriter = new PrintWriter(client.getOutputStream(),
                    true);
            printwriter.write(messsage); // write the message to output stream
            printwriter.flush();
            printwriter.close();
            client.close(); // closing the connection

        } catch (UnknownHostException e) {
            System.out.println("ecsadvcszlcnhsbcvdscuyv");
            e.printStackTrace();
        } catch (IOException e) {

            System.out.println("ecsadvcszlcnhsbcvdscuyv");
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.playNow_button:
                i = new Intent(this, PlayNowActivity.class);
                startActivity(i);
                break;
            case R.id.options_button:
                i = new Intent(this, OptionsActivity.class);
                startActivity(i);
                break;
            case R.id.help_button:
                i = new Intent(this, HelpActivity.class);
                startActivity(i);
                break;
            case R.id.exit_button:
                finish();
                break;
            case R.id.login_button:
                teste();
                break;
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
