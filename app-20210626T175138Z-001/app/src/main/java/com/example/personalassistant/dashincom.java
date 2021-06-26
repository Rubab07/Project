package com.example.personalassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;


public class dashincom extends Fragment {
    TextView incom_p1_text ,expense_p1_text,bal_p1_text,incom_p2_text ,expense_p2_text,bal_p2_text,incom_p3_text ,expense_p3_text,bal_p3_text,tbal,texpense,tincome;



    public dashincom() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dashincom, container, false);
        init(view);

        return view;

    }

    private void init(View view) {
        incom_p1_text=view.findViewById(R.id.incom_p1_text);
        expense_p1_text=view.findViewById(R.id.expense_p1_text);
        bal_p1_text=view.findViewById(R.id.bal_p1_text);
        // incom_p2_text ,expense_p2_text,bal_p2_text,
        incom_p2_text=view.findViewById(R.id.incom_p2_text);
        expense_p2_text=view.findViewById(R.id.expense_p2_text);
        bal_p2_text=view.findViewById(R.id.bal_p2_text);
        incom_p3_text=view.findViewById(R.id.incom_p3_text);
        expense_p3_text=view.findViewById(R.id.expense_p3_text);
        bal_p3_text=view.findViewById(R.id.bal_p3_text);

        tbal=view.findViewById(R.id.tbal);
        texpense=view.findViewById(R.id.texp);
        tincome=view.findViewById(R.id.tincom);

        String one = getArguments().getString("key51");

        Bundle bundle=this.getArguments();
        if(bundle !=null){
            incom_p1_text.setText(one);
            //Toast.makeText(getContext(), one, Toast.LENGTH_SHORT).show();
            Log.d("message",one);

            String tow  = getArguments().getString("key52");
            expense_p1_text.setText(tow);
            Log.d("message",tow);

            String three  = getArguments().getString("key53");
            bal_p1_text.setText(three);
            Log.d("message",three);

            String four = getArguments().getString("key54");
            incom_p2_text.setText(four);
            Log.d("message",four);

            String five  = getArguments().getString("key55");
            expense_p2_text.setText(five);
            Log.d("message",five);

            String six  = getArguments().getString("key56");
            bal_p2_text.setText(six);
            Log.d("message",six);
            // p3bal
            String seven = getArguments().getString("key57");
            incom_p3_text.setText(seven);
            Log.d("message",seven);

            String eight  = getArguments().getString("key58");
            expense_p3_text.setText(eight);
            Log.d("message",eight);

            String nine = getArguments().getString("key59");
            bal_p3_text.setText(nine);
            Log.d("message",nine);

            String ten = getArguments().getString("key60");
            tincome.setText(ten);
            Log.d("message",ten);

            String eleven  = getArguments().getString("key61");
            texpense.setText(eleven);
            Log.d("message",eleven);

            String twelve = getArguments().getString("key62");
            tbal.setText(twelve);
            Log.d("message",twelve);

        }


    }


}