package com.example.trupti.myjsonwithrecyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lenovo on 02-01-2018.
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Modal> md;

    public Myadapter(List<Modal> arraylistdata, MainActivity mainActivity) {
        this.activity=mainActivity;
        this.md=arraylistdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.datalist,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Modal m=md.get(position);
        holder.rtitle.setText(m.getAtitle());
        holder.rdescription.setText(m.getAdescription());

    }

    @Override
    public int getItemCount() {
        return md.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rtitle ,rdescription ;
        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);

            rtitle=(TextView)itemView.findViewById(R.id.ltitle);
            rdescription=(TextView)itemView.findViewById(R.id.ldescrption);
            iv=(ImageView)itemView.findViewById(R.id.iview);
        }
    }
}
