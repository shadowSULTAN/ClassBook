package akhil1.mpad.akhilonfire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyviewHolder> {
    Context context;
    ArrayList<user>list;

    public MyAdaptor(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
    }




    @NonNull
    @Override
    public MyAdaptor.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.iteam,parent,false);
        return new MyviewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaptor.MyviewHolder holder, int position) {
        holder.n.setText(list.get(position).getName());
        holder.n.setText(list.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  static class  MyviewHolder extends RecyclerView.ViewHolder{
        public TextView n,p;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            n=itemView.findViewById(R.id.email);
            p=itemView.findViewById(R.id.name);

        }
    }
}
