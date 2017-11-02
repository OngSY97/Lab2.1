package my.edu.tarc.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CalculateLoan extends AppCompatActivity {
    public static final String Loan_Payment = "payment";
    public static final String Loan_Status = "status";

    EditText editTextVehiclePrice,editTextDownpayment, editTextRepayment, editTextInterestRate, editTextSalary ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_loan);

        editTextVehiclePrice = (EditText)findViewById(R.id.editTextVehiclePrice);
        editTextDownpayment = (EditText)findViewById(R.id.editTextDownpayment);
        editTextRepayment = (EditText) findViewById(R.id.editTextRepayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
    }

    public void calculateLoan(View view){
        //TODO: calculate repayment amount and determine
        //the status of loan application
        double vehiclePrice , down_payment, repayment,interestRate,salary , LoanSalary;
        double totalInterest,totalLoan;
        double monthly_payment;
        String status;

        vehiclePrice = Double.parseDouble(editTextVehiclePrice.getText().toString());
        down_payment = Double.parseDouble(editTextDownpayment.getText().toString());
        repayment = Double.parseDouble(editTextRepayment.getText().toString());
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        salary = Double.parseDouble(editTextSalary.getText().toString());

        totalInterest = (vehiclePrice-down_payment) * (interestRate/100)* (repayment/12);

        totalLoan = (vehiclePrice-down_payment) + totalInterest;

        monthly_payment = totalLoan / repayment;

        LoanSalary = salary*0.3;

        if(monthly_payment <= LoanSalary ){
            status = "Loan Accepted";
        }
        else{
            status = "Loan Rejected";
        }

        //Define an intent object
        //this is an explicit intent
        Intent intent = new Intent(this, ResultActivity.class);
        //use the putExtra method to pass data
        //format; putExtra(TAG, value)

        intent.putExtra(Loan_Payment, monthly_payment);
        intent.putExtra(Loan_Status, status);


        startActivity(intent);

    }
}
