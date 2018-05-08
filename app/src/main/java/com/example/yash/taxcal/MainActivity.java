package com.example.yash.taxcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText gross_et, mediclaim_et, equity_et, home_loan_et, interest_et, edu_et;
    TextView taxable, calculated, vat, total;
    Button cal;
    int gross, mediclaim, equity, home, interest, edu;
    float Calculated, Vat, Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (Button)findViewById(R.id.calculate);
        gross_et = (EditText)findViewById(R.id.gross);
        mediclaim_et = (EditText)findViewById(R.id.medi);
        equity_et = (EditText)findViewById(R.id.equity);
        home_loan_et = (EditText)findViewById(R.id.home_loan);
        interest_et = (EditText)findViewById(R.id.home_int);
        edu_et = (EditText)findViewById(R.id.edu);

        taxable = (TextView)findViewById(R.id.taxable);
        calculated = (TextView)findViewById(R.id.calculated);
        vat = (TextView)findViewById(R.id.vat);
        total = (TextView)findViewById(R.id.total);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gross = Integer.parseInt(gross_et.getText().toString());
                mediclaim = Integer.parseInt(mediclaim_et.getText().toString());
                equity = Integer.parseInt(equity_et.getText().toString());
                home = Integer.parseInt(home_loan_et.getText().toString());
                interest = Integer.parseInt(interest_et.getText().toString());
                edu = Integer.parseInt(edu_et.getText().toString());
                Calculated = 0;
                if(mediclaim <=50000){
                    gross -= mediclaim;
                }
                else
                    gross -= 50000;

                if(equity<=100000)
                    gross-=equity;
                else
                    gross-=100000;
                if(home<=300000)
                    gross-=home;
                else
                    gross-=300000;

                if(interest<=150000)
                    gross-=interest;
                else
                    gross-=150000;

                if(edu<=50000)
                    gross-=edu;
                else
                    gross-=50000;

                taxable.setText(String.valueOf(gross));

                if(gross>1000000)
                {
                    Calculated = (float)(Calculated + (0.35)*(gross-1000000));
                    Calculated +=150000;
                }

                else if(gross>750000)
                {
                    Calculated = (float)(Calculated + (0.3)*(gross-750000));
                    Calculated +=75000;
                }

                else if(gross>500000)
                {
                    Calculated = (float)(Calculated + (0.2)*(gross-500000));
                    Calculated +=25000;
                }

                else if(gross>250000)
                {
                    Calculated = (float)(Calculated + (0.1)*(gross-250000));
                }
                else
                    Calculated = 0;

                calculated.setText(String.valueOf(Calculated));

                Vat = (float)(0.03)*Calculated;
                vat.setText(String.valueOf(Vat));

                Total = Calculated + Vat;
                total.setText(String.valueOf(Total));
            }
        });
    }

}
