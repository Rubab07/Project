package com.example.personalassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalassistant.model.BalanceResponse;
import com.example.personalassistant.model.BalanceBody;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BalanceFragment extends Fragment {
    Spinner spinYear;
   TextView p1incom,p1exp,p1bal,p2incom,p2exp,p2bal,p3incom,p3exp,p3bal,tincom,texp,tbal;
    EditText year,Month,getall;
    private int mYear, mMonth;
    Button submitbtn;

    public BalanceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_balance, container, false);



        init(view);

        return view;

    }

    private void init(View view) {
      //  dataTextView = view.findViewById(R.id.fragment_balacnce_data);
        // Monthtext=view.findViewById(R.id.Monthtext);
         //Yeartext=view.findViewById(R.id.Yeartext);
         Month =view.findViewById(R.id.month);
//          year =view.findViewById(R.id.year);

          getall=view.findViewById(R.id.getall);
          submitbtn=view.findViewById(R.id.submit);



      //  Month.setOnClickListener(Context(), "MM/dd/yyyy");
       // selectTime.setOnClickListener(this);

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

                  apiForData();


              }
          });


                //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }


   public void apiForData() {
        BalanceBody balanceBody = new BalanceBody();
        balanceBody.setMotnh(Integer.parseInt(Month.getText().toString()));
        balanceBody.setYear(Integer.parseInt(year.getText().toString()));
       balanceBody.setAll(getall.getText().toString());
       // balanceBody.setAll(getall.getText().toString());

        final Call<BalanceResponse> apiforlogin = RestClient.getInstance().getApiServices().userBalance(balanceBody);
        apiforlogin.enqueue(new Callback<BalanceResponse>() {
            @Override
            public void onResponse(Call<BalanceResponse> call, Response<BalanceResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "successfully received data", Toast.LENGTH_SHORT).show();
                  // Intent intent = new Intent(getContext().this,rowactivity.class);
                  //  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                 //   startActivity(intent);
                   // Intent i = new Intent(mContext,rowactivity.class);
                    //i.putExtra(INTENT_CHANNELURL,al_details.get(getLayoutPosition()).get().toString ());
                    //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //mContext.startActivity(i);
                    Log.d("responsghp",apiforlogin.toString() );
              dashbordFragment dashbordFragment= new dashbordFragment();
                    Bundle bundle=new Bundle();
                    dashbordFragment.setArguments(bundle);
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container,dashbordFragment).commit();
                    Log.e("responsdp", bundle.toString());
//                    String p1B = String.valueOf(response.body().getP1Inco());

////


                    ///
                    String p1B = String.valueOf(response.body().getP1Inco());
                    p1incom.setText(p1B);

                     //Send Data to Dashboard Fragment
                    String text1=p1incom.getText().toString();
                    bundle.putString("key1",text1);

                    Toast.makeText(getContext(),text1,Toast.LENGTH_SHORT).show();
                   String p12B = String.valueOf(response.body().getP1Exp());
                    p1exp.setText(p12B);
                    String text2=p1exp.getText().toString();
                    bundle.putString("key2",text2);

                    String p13B = String.valueOf(response.body().getP1Blnc());
                    p1bal.setText(p13B);
                    String text3=p1bal.getText().toString();
                    bundle.putString("key3",text3);
                   // p2 person data
                    String p2B = String.valueOf(response.body().getP2Inc());
                    p2incom.setText(p2B);
                    String text4=p2incom.getText().toString();
                    bundle.putString("key4",text4);
                    String p22B = String.valueOf(response.body().getP2Exp());
                    p2exp.setText(p22B);
                    String text5=p2exp.getText().toString();
                    bundle.putString("key5",text5);
                    String p23B = String.valueOf(response.body().getP2Blnc());
                    p2bal.setText(p23B);
                    String text6=p2bal.getText().toString();
                    bundle.putString("key6",text6);
                  //p3 person data
                    String p3B = String.valueOf(response.body().getP3Inc());
                    p3incom.setText(p3B);
                    String text7=p3incom.getText().toString();
                    bundle.putString("key7",text7);
                    String p32B = String.valueOf(response.body().getP3Exp());
                    p3exp.setText(p32B);
                    String text8=p3exp.getText().toString();
                    bundle.putString("key8",text8);
                    String p33B = String.valueOf(response.body().getP3Blnc());
                    p3bal.setText(p33B);
                    String text9=p3bal.getText().toString();
                    bundle.putString("key9",text9);

                    // total data
                    String t1B = String.valueOf(response.body().getTotalInc());
                    tincom.setText(t1B);
                    String text10=tincom.getText().toString();
                    bundle.putString("key10",text10);
                    String t2B = String.valueOf(response.body().getTotalExp());
                    texp.setText(t2B);
                    String text11=texp.getText().toString();
                    bundle.putString("key11",text11);
                    String t3B = String.valueOf(response.body().getTotalBlnc());
                    tbal.setText(t3B);
                    String text12=tbal.getText().toString();
                    bundle.putString("key12",text12);

//
//



                } else {
                    Toast.makeText(getContext(), "Response Not Succesful", Toast.LENGTH_SHORT).show();
                    Log.e("responseerror", response.message());
                }

            }

            @Override
            public void onFailure(Call<BalanceResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed!", Toast.LENGTH_SHORT).show();
                Log.e("responseerror", t.getMessage());
            }

        });
    }
}