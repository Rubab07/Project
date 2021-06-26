package com.example.personalassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalassistant.model.ExpenseResponse;
import com.example.personalassistant.model.ExpenseBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExpenseFragment extends Fragment {
    EditText person1exp,person2exp,person3exp,alldetail,userid;
    TextView p1incom,p1exp,p1bal,p2incom,p2exp,p2bal,p3incom,p3exp,p3bal,tincom,texp,tbal;
    Button submitbtn;

    public ExpenseFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_expense, container, false);
        View view = inflater.inflate(R.layout.fragment_expense, container, false);
        init(view);

        return view;
    }
    private void init(View view) {
        //  dataTextView = view.findViewById(R.id.fragment_balacnce_data);
        // Monthtext=view.findViewById(R.id.Monthtext);
        //Yeartext=view.findViewById(R.id.Yeartext);
        //incom,detail, userid
        person1exp =view.findViewById(R.id.person1exp);
        person2exp =view.findViewById(R.id.person2exp);
        person3exp =view.findViewById(R.id.person3exp);
        alldetail =view.findViewById(R.id.alldetail);
        userid=view.findViewById(R.id.userid);
        submitbtn=view.findViewById(R.id.submit);
        //   p1incom,p1exp,p1bal,p2incom,p2exp,p2bal,p3incom,p3exp,p3bal,totalincom,totalexp,totalbal
        p1incom=view.findViewById(R.id.p1incom);
        p1exp=view.findViewById(R.id.p1exp);
        p1bal=view.findViewById(R.id.p1bal);
        p2incom=view.findViewById(R.id.p2incom);
        p2exp=view.findViewById(R.id.p2exp);
        p2bal=view.findViewById(R.id.p2bal);
        p3incom=view.findViewById(R.id.p3incom);
        p3exp=view.findViewById(R.id.p3exp);
        p3bal=view.findViewById(R.id.p3bal);
        tincom=view.findViewById(R.id.tincom);
        texp=view.findViewById(R.id.texp);
        tbal=view.findViewById(R.id.tbal);


//        p2exp=view.findViewById(R.id.p2exp);
//        p2bal=view.findViewById(R.id.p2bal);
//        p3incom=view.findViewById(R.id.p3incom);
//        p3exp=view.findViewById(R.id.p3exp);
//        p3bal=view.findViewById(R.id.p3bal);


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apiForExpense();

            }
        });


        //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    public void apiForExpense() {
        ExpenseBody expenseBody = new ExpenseBody();
//        incomBody.setTotalIncome(Integer.parseInt(incom.getText().toString()));
//        incomBody.setNarration(detail.getText().toString());
//        // IncomBody.setUserId(userid.getText().toString());
//        incomBody.setUserId(userid.getText().toString());
        expenseBody.setP1(Integer.parseInt(person1exp.getText().toString()));
        expenseBody.setP2(Integer.parseInt(person2exp.getText().toString()));
        expenseBody.setP3(Integer.parseInt(person3exp.getText().toString()));
        expenseBody.setNarration(alldetail.getText().toString());
        expenseBody.setUserId(Singleton.userID);
         final Call<ExpenseResponse> apiforExpense = RestClient.getInstance().getApiServices().userExpense(expenseBody);
        apiforExpense.enqueue(new Callback<ExpenseResponse>() {
            @Override
            public void onResponse(Call<ExpenseResponse> call, Response<ExpenseResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), " successfully received data", Toast.LENGTH_SHORT).show();

                    Log.e("responsedata", String.valueOf(response.body().getP1Blnc()));
                    Log.e("responsedata", String.valueOf(response.body().getP1Exp()));
                    Log.e("responsedata", String.valueOf(response.body().getP1Blnc()));
                    Log.e("responsedata", String.valueOf(response.body().getP2Blnc()));
                    Log.e("responsedata", String.valueOf(response.body().getP2Exp()));
                    Log.e("responsedata", String.valueOf(response.body().getP2Blnc()));
                    Log.e("responsedata", String.valueOf(response.body().getP3Blnc()));
                    Log.e("responsedata", String.valueOf(response.body().getP3Exp()));
                    Log.e("responsedata", String.valueOf(response.body().getP3Blnc()));
                    Log.e("responsedata", String.valueOf(response.body().getTotalBlnc()));
                    Log.e("responsedata", String.valueOf(response.body().getTotalExp()));
                    Log.e("responsedata", String.valueOf(response.body().getTotalInc()));


                    String p1B = String.valueOf(response.body().getP1Inco());
                    p1incom.setText(p1B);
                    String p12B = String.valueOf(response.body().getP1Exp());
                    p1exp.setText(p12B);
                    String p13B = String.valueOf(response.body().getP1Blnc());
                    p1bal.setText(p13B);
                    // p2 person data
                    String p2B = String.valueOf(response.body().getP2Inc());
                    p2incom.setText(p2B);
                    String p22B = String.valueOf(response.body().getP2Exp());
                    p2exp.setText(p22B);
                    String p23B = String.valueOf(response.body().getP2Blnc());
                    p2bal.setText(p23B);
                    //p3 person data
                    String p3B = String.valueOf(response.body().getP3Inc());
                    p3incom.setText(p3B);
                    String p32B = String.valueOf(response.body().getP3Exp());
                    p3exp.setText(p32B);
                    String p33B = String.valueOf(response.body().getP3Blnc());
                    p3bal.setText(p33B);
                    // total data
                    String t1B = String.valueOf(response.body().getTotalInc());
                    tincom.setText(t1B);
                    String t2B = String.valueOf(response.body().getTotalExp());
                    texp.setText(t2B);
                    String t3B = String.valueOf(response.body().getTotalBlnc());
                    tbal.setText(t3B);





                } else {
                    Toast.makeText(getContext(), "Response Not Succesful", Toast.LENGTH_SHORT).show();
                    Log.e("responseerror", response.message());
                }

            }

            @Override
            public void onFailure(Call<ExpenseResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}