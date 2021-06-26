package com.example.personalassistant;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalassistant.model.IncomResponse;
import com.example.personalassistant.model.IncomBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IncomFragment extends Fragment {

      EditText incom,detail, userid;
      TextView p1incom,p1exp,p1bal,p2incom,p2exp,p2bal,p3incom,p3exp,p3bal,tincom,texp,tbal;
       Button submitbtn;
    public IncomFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View view = inflater.inflate(R.layout.fragment_incom, container, false);
           init(view);

        return view;
    }
    private void init(View view) {
        //  dataTextView = view.findViewById(R.id.fragment_balacnce_data);
        // Monthtext=view.findViewById(R.id.Monthtext);
        //Yeartext=view.findViewById(R.id.Yeartext);
        //incom,detail, userid
        incom =view.findViewById(R.id.incom);
        detail =view.findViewById(R.id.detail);
        userid=view.findViewById(R.id.getall);
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
                String Incom = incom.getText().toString().trim();
                String Detail = detail.getText().toString().trim();
                String UserId = userid.getText().toString().trim();
                if (TextUtils.isEmpty(Incom)) {
                    Toast.makeText(getContext(), "Please Enter Incom", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(Detail)) {
                    Toast.makeText(getContext(), "Please Enter detail", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(UserId)) {
                    Toast.makeText(getContext(), "Please Enter user Id", Toast.LENGTH_SHORT).show();

                }

                apiForincom();

            }
        });


        //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    public void apiForincom() {
        IncomBody incomBody = new IncomBody();
        incomBody.setTotalIncome(Integer.parseInt(incom.getText().toString()));
        incomBody.setNarration(detail.getText().toString());
       // IncomBody.setUserId(userid.getText().toString());
        incomBody.setUserId(userid.getText().toString());

        final Call<IncomResponse> apiforlogin = RestClient.getInstance().getApiServices().userIncom(incomBody);
        apiforlogin.enqueue(new Callback<IncomResponse>() {
            @Override
            public void onResponse(Call<IncomResponse> call, Response<IncomResponse> response) {
                if (response.isSuccessful()) {
                      Toast.makeText(getContext(), " successfully received data", Toast.LENGTH_SHORT).show();
//
//                    Log.e("responsedata", String.valueOf(response.body().getP1Blnc()));
//                    Log.e("responsedata", String.valueOf(response.body().getP1Exp()));
//                    Log.e("responsedata", String.valueOf(response.body().getP1Blnc()));
//                    Log.e("responsedata", String.valueOf(response.body().getP2Blnc()));
//                    Log.e("responsedata", String.valueOf(response.body().getP2Exp()));
//                    Log.e("responsedata", String.valueOf(response.body().getP2Blnc()));
//                    Log.e("responsedata", String.valueOf(response.body().getP3Blnc()));
//                    Log.e("responsedata", String.valueOf(response.body().getP3Exp()));
//                    Log.e("responsedata", String.valueOf(response.body().getP3Blnc()));
//                    Log.e("responsedata", String.valueOf(response.body().getTotalBlnc()));
//                    Log.e("responsedata", String.valueOf(response.body().getTotalExp()));
//                    Log.e("responsedata", String.valueOf(response.body().getTotalInc()));
//
//
//                    String p1B = String.valueOf(response.body().getP1Inco());
//                    p1incom.setText(p1B);
//                    String p12B = String.valueOf(response.body().getP1Exp());
//                    p1exp.setText(p12B);
//                    String p13B = String.valueOf(response.body().getP1Blnc());
//                    p1bal.setText(p13B);
//                    // p2 person data
//                    String p2B = String.valueOf(response.body().getP2Inc());
//                    p2incom.setText(p2B);
//                    String p22B = String.valueOf(response.body().getP2Exp());
//                    p2exp.setText(p22B);
//                    String p23B = String.valueOf(response.body().getP2Blnc());
//                    p2bal.setText(p23B);
//                    //p3 person data
//                    String p3B = String.valueOf(response.body().getP3Inc());
//                    p3incom.setText(p3B);
//                    String p32B = String.valueOf(response.body().getP3Exp());
//                    p3exp.setText(p32B);
//                    String p33B = String.valueOf(response.body().getP3Blnc());
//                    p3bal.setText(p33B);
//                    // total data
//                    String t1B = String.valueOf(response.body().getTotalInc());
//                    tincom.setText(t1B);
//                    String t2B = String.valueOf(response.body().getTotalExp());
//                    texp.setText(t2B);
//                    String t3B = String.valueOf(response.body().getTotalBlnc());
//                    tbal.setText(t3B);
                    dashincom dashincom= new dashincom();
                    Bundle bundle=new Bundle();
                    dashincom.setArguments(bundle);
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container,dashincom).commit();
                    Log.e("responsdp", bundle.toString());
//                    String p1B = String.valueOf(response.body().getP1Inco());

////


                    ///
                    String p1B = String.valueOf(response.body().getP1Inco());
                    p1incom.setText(p1B);

                    //Send Data to Dashboard Fragment
                    String text51=p1incom.getText().toString();
                    bundle.putString("key51",text51);

                    Toast.makeText(getContext(),text51,Toast.LENGTH_SHORT).show();
                    String p12B = String.valueOf(response.body().getP1Exp());
                    p1exp.setText(p12B);
                    String text52=p1exp.getText().toString();
                    bundle.putString("key52",text52);

                    String p13B = String.valueOf(response.body().getP1Blnc());
                    p1bal.setText(p13B);
                    String text53=p1bal.getText().toString();
                    bundle.putString("key53",text53);
                    // p2 person data
                    String p2B = String.valueOf(response.body().getP2Inc());
                    p2incom.setText(p2B);
                    String text54=p2incom.getText().toString();
                    bundle.putString("key54",text54);
                    String p22B = String.valueOf(response.body().getP2Exp());
                    p2exp.setText(p22B);
                    String text5=p2exp.getText().toString();
                    bundle.putString("key55",text5);
                    String p23B = String.valueOf(response.body().getP2Blnc());
                    p2bal.setText(p23B);
                    String text6=p2bal.getText().toString();
                    bundle.putString("key56",text6);
                    //p3 person data
                    String p3B = String.valueOf(response.body().getP3Inc());
                    p3incom.setText(p3B);
                    String text7=p3incom.getText().toString();
                    bundle.putString("key57",text7);
                    String p32B = String.valueOf(response.body().getP3Exp());
                    p3exp.setText(p32B);
                    String text58=p3exp.getText().toString();
                    bundle.putString("key58",text58);
                    String p33B = String.valueOf(response.body().getP3Blnc());
                    p3bal.setText(p33B);
                    String text59=p3bal.getText().toString();
                    bundle.putString("key59",text59);

                    // total data
                    String t1B = String.valueOf(response.body().getTotalInc());
                    tincom.setText(t1B);
                    String text60=tincom.getText().toString();
                    bundle.putString("key60",text60);
                    String t2B = String.valueOf(response.body().getTotalExp());
                    texp.setText(t2B);
                    String text61=texp.getText().toString();
                    bundle.putString("key61",text61);
                    String t3B = String.valueOf(response.body().getTotalBlnc());
                    tbal.setText(t3B);
                    String text62=tbal.getText().toString();
                    bundle.putString("key62",text62);




                } else {
                    Toast.makeText(getContext(), "Response Not Succesful", Toast.LENGTH_SHORT).show();
                    Log.e("responseerror", response.message());
                }

            }

            @Override
            public void onFailure(Call<IncomResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed!", Toast.LENGTH_SHORT).show();
            }

        });
    }


}