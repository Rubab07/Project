package com.example.personalassistant.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalassistant.R;
import com.example.personalassistant.model.Expense;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.DataViewHolder> {
    private List<Expense> list;
    private Context context;

    public ExpenseAdapter(List<Expense> list, Context context)  {
     this.list=list;
     this.context=context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.expenserow,parent,false);
        //  return null;
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int i) {
        Expense currentdata=list.get(i);
//                     holder.p1bal.setText((CharSequence) currentdata.getBalance());
//                     holder.p1exp.setText((CharSequence) currentdata.getBalance());
//        holder.p1incom.setText((CharSequence) currentdata.getBalance());
//        holder.p2bal.setText((CharSequence) currentdata.getBalance());
//        holder.p2exp.setText((CharSequence) currentdata.getBalance());
//        holder.p2incom.setText((CharSequence) currentdata.getBalance());
//        holder.p3bal.setText((CharSequence) currentdata.getBalance());
//        holder.p3exp.setText((CharSequence) currentdata.getBalance());
//        holder.p3incom.setText((CharSequence) currentdata.getBalance());
//        holder.tbal.setText((CharSequence) currentdata.getBalance());
//        holder.texp.setText((CharSequence) currentdata.getBalance());
//        holder.tincom.setText((CharSequence) currentdata.getBalance());
        holder.transId.setText(String.valueOf(currentdata.getTransId()));
        holder.totalExp.setText(String.valueOf(currentdata.getTotalExp()));
        holder.person1.setText(String.valueOf(currentdata.getP1()));
        holder.person2.setText(String.valueOf(currentdata.getP2()));
        holder.person3.setText(String.valueOf(currentdata.getP3()));
        holder.date.setText(String.valueOf(currentdata.getDate()));
        holder.detail.setText(String.valueOf(currentdata.getNarration()));
//
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

public class DataViewHolder extends RecyclerView.ViewHolder {
    TextView transId,totalExp,person1,person2,person3,userId,date,detail;
    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        transId=itemView.findViewById(R.id.transId);
        totalExp=itemView.findViewById(R.id.totalexp);
        person1=itemView.findViewById(R.id.person1);
        person2=itemView.findViewById(R.id.person2);
        person3=itemView.findViewById(R.id.person3);
        userId=itemView.findViewById(R.id.userId);
        date=itemView.findViewById(R.id.date);
        detail=itemView.findViewById(R.id.detail);

    }
}
}