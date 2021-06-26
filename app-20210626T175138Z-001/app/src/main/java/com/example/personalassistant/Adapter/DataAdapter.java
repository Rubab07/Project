package com.example.personalassistant.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalassistant.ListFragment;
import com.example.personalassistant.R;
import com.example.personalassistant.model.Income;
import com.example.personalassistant.model.Summary;

import java.util.List;

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.DataViewHolder >{
    public List<Income> list;
    private Context context;

    public DataAdapter(List<Income> list, Context context)  {
        this.list=list;
        this.context=context;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        //  return null;
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
//        Income currentdata=list.get(i);
//
//        holder.transId.setText(currentdata.getTransId());
//        holder.totalIncom.setText(String.valueOf(currentdata.getTotalIncome()));
//        holder.person1.setText(String.valueOf(currentdata.getP1()));
//        holder.person2.setText(String.valueOf(currentdata.getP2()));
//        holder.person3.setText(String.valueOf(currentdata.getP3()));
//        holder.date.setText(String.valueOf(currentdata.getDate()));
//        holder.detail.setText(String.valueOf(currentdata.getNarration()));
//
        holder.transId.setText(list.get(position).getTransId());
        holder.totalIncom.setText(String.valueOf(list.get(position).getTotalIncome()));
        holder.person1.setText(String.valueOf(list.get(position).getP1()));
        holder.person2.setText(String.valueOf(list.get(position).getP2()));
        holder.person3.setText(String.valueOf(list.get(position).getP3()));
        holder.date.setText(String.valueOf(list.get(position).getDate()));
        holder.detail.setText(String.valueOf(list.get(position).getDate()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView transId,totalIncom,person1,person2,person3,userId,date,detail;
                public DataViewHolder(@NonNull View itemView) {
                    super(itemView);
                    transId=itemView.findViewById(R.id.transId);
                    totalIncom=itemView.findViewById(R.id.totalincom);
                    person1=itemView.findViewById(R.id.person1);
                    person2=itemView.findViewById(R.id.person2);
                    person3=itemView.findViewById(R.id.person3);
                    userId=itemView.findViewById(R.id.userId);
                    date=itemView.findViewById(R.id.date);
                    detail=itemView.findViewById(R.id.detail);

                }
            }
}
