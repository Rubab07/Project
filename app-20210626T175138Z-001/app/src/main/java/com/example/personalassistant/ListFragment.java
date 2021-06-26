package com.example.personalassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalassistant.Adapter.DataAdapter;
import com.example.personalassistant.Adapter.ExpenseAdapter;
import com.example.personalassistant.model.Balance;
import com.example.personalassistant.model.Summary;
import com.example.personalassistant.model.SummaryBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment {
    TextView p1incom,p1exp,p1bal,p2incom,p2exp,p2bal,p3incom,p3exp,p3bal,tincom,texp,tbal;
    EditText Year,Month,getall;
    Button submitbtn;
    RecyclerView recyclerView_incom,recyclerView_expense;
//    Long.d(recyclerView_incom,"lis fragmen");
    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=  inflater.inflate(R.layout.fragment_list, container, false);
      init(view);
      return view;

    }

    private void init(View view) {
        Month =view.findViewById(R.id.month);
        Year =view.findViewById(R.id.year);
//        getall=view.findViewById(R.id.getall);

        getall=view.findViewById(R.id.getall);
        submitbtn=view.findViewById(R.id.submit);
        recyclerView_incom=view.findViewById(R.id.incom_recview);
        recyclerView_expense=view.findViewById(R.id.expense_recview);
        p1incom=view.findViewById(R.id.p1incom);
        p1exp=view.findViewById(R.id.p1exp);
        p1bal=view.findViewById(R.id.p1bal);
        p2incom=view.findViewById(R.id.p2incom);
        p2exp=view.findViewById(R.id.p2exp);
        p2bal=view.findViewById(R.id.p2bal);
        p3incom=view.findViewById(R.id.p3incom);
        p3exp=view.findViewById(R.id.p3exp);
        p3bal=view.findViewById(R.id.p3bal);
        tincom=view.findViewById(R.id.totalincom);
        texp=view.findViewById(R.id.totalexp);
        tbal=view.findViewById(R.id.tbal);


//        expense=view.findViewById(R.id.expense_recview);
        recyclerView_incom.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_expense.setLayoutManager(new LinearLayoutManager(getContext()));
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                apiForSummary();

            }
        });
    }
        public void apiForSummary() {

            SummaryBody summaryBody = new SummaryBody();
            summaryBody.setMotnh(Integer.parseInt(Month.getText().toString()));
            summaryBody.setYear(Integer.parseInt(Year.getText().toString()));
            summaryBody.setAll(getall.getText().toString());

//        final Call<BalanceResponse> apiforlogin = RestClient.getInstance().getApiServices().userBalance(balanceBody);
//        apiforlogin.enqueue(new Callback<BalanceResponse>()
            final Call<Summary> listSummary= RestClient.getInstance().getApiServices().userSummary(summaryBody);
            listSummary.enqueue(new Callback<Summary>() {
                @Override
                public void onResponse(Call<Summary> call, Response<Summary> response) {
                    if (response.isSuccessful()) {
                       // Toast.makeText(getContext(), " successfully received data", Toast.LENGTH_SHORT).show();

                      //  ShowIt(response.body());
                        Log.d("blue",listSummary.toString() );

                        Balance balance=new Balance();
                        Log.e("message", String.valueOf(response.body().getBalance().getP1Inco()));
                        Log.e("message1", String.valueOf(response.body().getBalance().getP1Inco()));
                        Log.e("message2", String.valueOf(response.body().getBalance().getP1Exp()));
                        Log.e("message3", String.valueOf(response.body().getBalance().getP1Blnc()));
                        Log.e("p2incom", String.valueOf(response.body().getBalance().getP2Inc()));
                        Log.e("p2expense", String.valueOf(response.body().getBalance().getP2Exp()));
                        Log.e("p2bal", String.valueOf(response.body().getBalance().getP2Blnc()));
                        Log.e("incomp3", String.valueOf(response.body().getBalance().getP3Inc()));
                        Log.e("expensep3", String.valueOf(response.body().getBalance().getP3Exp()));
                        Log.e("balancep3", String.valueOf(response.body().getBalance().getP3Blnc()));
                        Log.e("totalIncom", String.valueOf(response.body().getBalance().getTotalInc()));
                        Log.e("totalExpense", String.valueOf(response.body().getBalance().getTotalExp()));
                        Log.e("totalBal", String.valueOf(response.body().getBalance().getTotalBlnc()));


                        String p1B = String.valueOf(response.body().getBalance().getP1Inco());
                        p1incom.setText(p1B);
                        String p12B = String.valueOf(response.body().getBalance().getP1Exp());
                        p1exp.setText(p12B);
                        String p13B = String.valueOf(response.body().getBalance().getP1Blnc());
                        p1bal.setText(p13B);
                        // p2 person data
                        String p2B = String.valueOf(response.body().getBalance().getP2Inc());
                        p2incom.setText(p2B);
                        String p22B = String.valueOf(response.body().getBalance().getP2Exp());
                        p2exp.setText(p22B);
                        String p23B = String.valueOf(response.body().getBalance().getP2Blnc());
                        p2bal.setText(p23B);
                        //p3 person data
                        String p3B = String.valueOf(response.body().getBalance().getP3Inc());
                        p3incom.setText(p3B);
                        String p32B = String.valueOf(response.body().getBalance().getP3Exp());
                        p3exp.setText(p32B);
                        String p33B = String.valueOf(response.body().getBalance().getP3Blnc());
                        p3bal.setText(p33B);
                       //  total data
                        String t1B = String.valueOf(response.body().getBalance().getTotalInc());
                        tincom.setText(t1B);
                        String t2B = String.valueOf(response.body().getBalance().getTotalExp());
                        texp.setText(t2B);
                        String t3B = String.valueOf(response.body().getBalance().getTotalBlnc());
                        tbal.setText(t3B);

                        DataAdapter dataAdapter=new DataAdapter(response.body().getIncomes(),getContext());
                        recyclerView_incom.setAdapter(dataAdapter);

                        ExpenseAdapter expenseAdapter=new ExpenseAdapter(response.body().getExpenses(),getContext());
                        recyclerView_expense.setAdapter(expenseAdapter);
//                        Log.d("getIncomes", recyclerView_incom.toString);


                        //  Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();

                        // startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        //  Log.e("responsedata", String.valueOf(response.body().getBalance()));
                        //  Log.e("responsedata", String.valueOf(response.body().getIncomes()));
                        //Log.e("responsedata", String.valueOf(response.body().getExpenses()));



                    } else {
                        Toast.makeText(getContext(), "Response Not Succesful", Toast.LENGTH_SHORT).show();
                        Log.e("responseerror", response.message());
                    }

                    //List<Summary> userList = response.body();
                    // dataAdapter = new DataAdapter(getContext().this, userList);
                    // listView.setAdapter(dataAdapter);
                    //  Log.e("responsedata", String.valueOf(response.body().p1Blnc()));




                     //
                }




                @Override
                public void onFailure(Call<Summary> call, Throwable t) {

                }
            });
        }

//    private void ShowIt(Summary body) {
//        DataAdapter dataAdapter=new DataAdapter(body.getIncomes(),getContext());
//        incom.setAdapter(dataAdapter);
//    }
}
