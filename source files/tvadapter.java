package com.example.faisal.cse_600;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class tvadapter extends RecyclerView.Adapter<tvadapter.MyViewHolder> implements Serializable {

    private List<tv> tvList;
  //  private List<nwMovie> tvlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre,q;
        public ImageView pic;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvtitle);
            genre = (TextView) view.findViewById(R.id.tvgenre);
            year = (TextView) view.findViewById(R.id.tvyear);
            q = (TextView) view.findViewById(R.id.tvqqqq);
            pic=(ImageView)view.findViewById(R.id.tvpic);
        }
    }


    public tvadapter(List<tv> tvlist) {
        this.tvList = tvlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tv_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        tv movie = tvList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.q.setText(movie.getName());
        //  holder.q.setText(String.valueOf((movie.getRES())));
        holder.pic.setImageResource(movie.getRES());
        // int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" +"iphone" , null, null);

    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }
}
