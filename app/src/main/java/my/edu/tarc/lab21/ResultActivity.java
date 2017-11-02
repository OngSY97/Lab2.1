package my.edu.tarc.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView  textViewMonthlyPayment , textViewStatus;
    ImageView imageViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //to get the intent
        Intent intent = getIntent(); //asking "who calling me?"
        double payment = intent.getDoubleExtra(CalculateLoan.Loan_Payment,0);
        String status = intent.getStringExtra(CalculateLoan.Loan_Status); //String no need default value

        //TODO display outputs
        textViewMonthlyPayment.setText("Monthly Payment = RM" + String.format("%.2f",payment));
        textViewStatus.setText(status);

        if (status == "Loan Accepted"){
            imageViewResult.setImageResource(R.drawable.like_emoji);
        }
        else{
            imageViewResult.setImageResource(R.drawable.dislike_emoji);
        }

    }

    public void closeActivity (View view){
        //terminate an activity
        finish();
    }
}
