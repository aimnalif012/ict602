package com.example.ict602_assignmentaiman;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText goldWeight, currentValue;
    Button btnCalculate , btnReset;
    RadioButton btnKeep, btnWear;
    TextView result1, result2, result3 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        goldWeight = (EditText) findViewById(R.id.goldWeight);
        currentValue = (EditText) findViewById(R.id.currentValue);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnKeep = (RadioButton) findViewById(R.id.btnKeep);
        btnWear = (RadioButton) findViewById(R.id.btnWear);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
        result3 = (TextView) findViewById(R.id.result3);
        btnCalculate.setOnClickListener(this);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear input fields
                goldWeight.setText("");
                currentValue.setText("");
                btnKeep.setChecked(false);
                btnWear.setChecked(false);
                result1.setText("");
                result2.setText("");
                result3.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.item_share){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Please use my application - http://t.co/app");
            startActivity(Intent.createChooser(shareIntent, null));
            return true;
        } else if (item.getItemId() == R.id.item_about) {
            Intent aboutIntent = new Intent(this, about.class);
            startActivity(aboutIntent);
        } else {
            Intent infoIntent = new Intent(this, information.class);
            startActivity(infoIntent);

            return false;
        }
        return false;

    }

    @Override
    public void onClick(View view) {
        if (goldWeight.getText().toString().isEmpty() || currentValue.getText().toString().isEmpty() || (!btnKeep.isChecked() && !btnWear.isChecked())) {
            result1.setText("Please input the weight, value, and select a type first");
            // Clear other outputs
            result2.setText("");
            result3.setText("");
            return;
        }

        double weight = Double.parseDouble(goldWeight.getText().toString());
        double value = Double.parseDouble(currentValue.getText().toString());

        double output1 = 0, output2 = 0, output3 = 0;
        if (btnKeep.isChecked()) {

            output1 = weight * value;
            output2 = Math.max((weight - 85) * value, 0);
            output3 = output2 * 0.025;
        } else {

            output1 = weight * value;
            output2 = Math.max((weight - 200) * value, 0);
            output3 = output2 * 0.025;
        }

        result1.setText("Total Value of Gold : RM" + output1);
        result2.setText("Zakat Payable : RM" + output2);
        result3.setText("Total Zakat : RM" + output3);
    }
}