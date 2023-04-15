package com.ahmadkhan.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextCashInHand = findViewById(R.id.editTextCashInHand);
        EditText editTextSavings = findViewById(R.id.editTextSavings);
        EditText editTextGoldSilver = findViewById(R.id.editTextGoldSilver);
        EditText editTextLoans = findViewById(R.id.editTextLoans);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewPayableZakat = findViewById(R.id.textViewPayableZakat);

        buttonCalculate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double totalAmount = Double.parseDouble(editTextCashInHand.getText().toString()) + Double.parseDouble(editTextSavings.getText().toString()) + Double.parseDouble(editTextGoldSilver.getText().toString()) - Double.parseDouble(editTextLoans.getText().toString());
                        double calculatedZakat = totalAmount*0.025;

                        String payableZakat = totalAmount >= 80933 ? String.format("Payable Zakat: %s PKR", calculatedZakat) : "Zakat is not applicable ot your finances.";

                        textViewPayableZakat.setText(payableZakat);
                    }
                }
        );
    }
}