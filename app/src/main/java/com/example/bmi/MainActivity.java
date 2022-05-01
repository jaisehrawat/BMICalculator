package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHeightFt, editHeightIn;
        TextView txt;
        Button btnCalculate;
        LinearLayout llMain;

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn = findViewById(R.id.editHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txt = findViewById(R.id.txt);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(editWeight.getText().toString());
                int htf = Integer.parseInt(editHeightFt.getText().toString());
                int hti = Integer.parseInt(editHeightIn.getText().toString());

                int totalInch = htf*hti + hti;
                double totalCm = totalInch*2.53;
                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if (bmi>25)
                {
                    txt.setText("You're OverWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                }
                else if (bmi<18)
                {
                    txt.setText("You're UnderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
                }
                else
                {
                    txt.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });

    }
}