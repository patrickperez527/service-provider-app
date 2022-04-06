package com.np.onei.servicesapp.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.np.onei.servicesapp.BuildConfig;
import com.np.onei.servicesapp.R;
import com.np.onei.servicesapp.intfc.PayDoneInterface;
import com.np.onei.servicesapp.repositrys.PayDoneRepositry;
import com.np.onei.servicesapp.services.RetrofitRequrest;
import com.np.onei.utils.ApplicationController;

import co.paystack.android.Paystack;
import co.paystack.android.PaystackSdk;
import co.paystack.android.Transaction;
import co.paystack.android.model.Card;
import co.paystack.android.model.Charge;

public class PaymentActivity extends AppCompatActivity implements PayDoneInterface {

    //variables
    private Card card;
    private Charge charge;

    private EditText emailField;
    private EditText cardNumberField;
    private EditText expiryMonthField;
    private EditText expiryYearField;
    private EditText cvvField;

    ApplicationController obj;
    private String email, cardNumber, cvv;
    private int expiryMonth, expiryYear;

    private TextView headertxt;
    private ImageView bck;
  PayDoneRepositry PDRObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PDRObj=new PayDoneRepositry(PaymentActivity.this, RetrofitRequrest.ProgressForDriver(PaymentActivity.this),this);
        obj=(ApplicationController)getApplicationContext();
        //init paystack sdk
        PaystackSdk.setPublicKey("pk_live_4010f9e181720f41715b6135ed03bff0fa1da1f5");
        //PaystackSdk.initialize(getApplicationContext());
        setContentView(R.layout.pay_lay);
        headertxt=(TextView)findViewById(R.id.headertxt);
        bck=(ImageView) findViewById(R.id.bck);
        headertxt.setText("Payment");
        headertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //init view
        Button payBtn = (Button) findViewById(R.id.pay_button);

        emailField = (EditText) findViewById(R.id.edit_email_address);
        cardNumberField = (EditText) findViewById(R.id.edit_card_number);
        expiryMonthField = (EditText) findViewById(R.id.edit_expiry_month);
        expiryYearField = (EditText) findViewById(R.id.edit_expiry_year);
        cvvField = (EditText) findViewById(R.id.edit_cvv);


        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateForm()) {
                    return;
                }
                try {
                    email = emailField.getText().toString().trim();
                    cardNumber = cardNumberField.getText().toString().trim();
                    expiryMonth = Integer.parseInt(expiryMonthField.getText().toString().trim());
                    expiryYear = Integer.parseInt(expiryYearField.getText().toString().trim());
                    cvv = cvvField.getText().toString().trim();

                    //String cardNumber = "4084084084084081";
                    //int expiryMonth = 11; //any month in the future
                    //int expiryYear = 18; // any year in the future
                    //String cvv = "408";
                    card = new Card(cardNumber, expiryMonth, expiryYear, cvv);

                    if (card.isValid()) {
                        Toast.makeText(PaymentActivity.this, "Card is Valid", Toast.LENGTH_LONG).show();
                        performCharge();
                    } else {
                        Toast.makeText(PaymentActivity.this, "Card not Valid", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Method to perform the charging of the card
     */
    private void performCharge() {
        //create a Charge object
        charge = new Charge();

        //set the card to charge
        charge.setCard(card);

        //call this method if you set a plan
        //charge.setPlan("PLN_yourplan");

        charge.setEmail(email); //dummy email address

       // charge.setAmount(100); //test amount
        int amt=Integer.parseInt(obj.getTotalPaymentAmount());
       amt *=100;
        charge.setAmount(amt); //test amount

        PaystackSdk.chargeCard(PaymentActivity.this, charge, new Paystack.TransactionCallback() {
            @Override
            public void onSuccess(Transaction transaction) {
                String paymentReference = transaction.getReference();
                PDRObj.donePay(obj.getReqId(),paymentReference);
                // This is called only after transaction is deemed successful.
                // Retrieve the transaction, and send its reference to your server
                // for verification.

                //String paymentReference = transaction.getReference();
                Toast.makeText(PaymentActivity.this, "Transaction Successful! payment reference: "
                        + paymentReference, Toast.LENGTH_LONG).show();
//                finish();
            }

            @Override
            public void beforeValidate(Transaction transaction) {
                // This is called only before requesting OTP.
                // Save reference so you may send to server. If
                // error occurs with OTP, you should still verify on server.
            }

            @Override
            public void onError(Throwable error, Transaction transaction) {
                //handle error here
            }
        });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = emailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailField.setError("Required.");
            valid = false;
        } else {
            emailField.setError(null);
        }

        String cardNumber = cardNumberField.getText().toString();
        if (TextUtils.isEmpty(cardNumber)) {
            cardNumberField.setError("Required.");
            valid = false;
        } else {
            cardNumberField.setError(null);
        }


        String expiryMonth = expiryMonthField.getText().toString();
        if (TextUtils.isEmpty(expiryMonth)) {
            expiryMonthField.setError("Required.");
            valid = false;
        } else {
            expiryMonthField.setError(null);
        }

        String expiryYear = expiryYearField.getText().toString();
        if (TextUtils.isEmpty(expiryYear)) {
            expiryYearField.setError("Required.");
            valid = false;
        } else {
            expiryYearField.setError(null);
        }

        String cvv = cvvField.getText().toString();
        if (TextUtils.isEmpty(cvv)) {
            cvvField.setError("Required.");
            valid = false;
        } else {
            cvvField.setError(null);
        }

        return valid;
    }

    @Override
    public void PaySuccess(String msg) {
        Toast.makeText(PaymentActivity.this,""+msg,Toast.LENGTH_LONG).show();
     startActivity(new Intent(PaymentActivity.this,SatisfyActivity.class));
        finish();
    }

    @Override
    public void PayFailed(String msg) {
        Toast.makeText(PaymentActivity.this,""+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void RequestProgressShow(ProgressDialog pd) {
    pd.setMessage("Please wait...");
    pd.show();
    }

    @Override
    public void RequestProgressFinish(ProgressDialog pd) {

        pd.dismiss();
    }
}