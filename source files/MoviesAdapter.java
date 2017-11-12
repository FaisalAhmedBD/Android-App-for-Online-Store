package com.example.faisal.cse_600;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> implements Serializable {

    private List<nwMovie> moviesList;
   // private List<nwMovie> tvlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre,q,qua;
        public ImageView pic;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            q = (TextView) view.findViewById(R.id.qqqq);
            qua = (TextView) view.findViewById(R.id.quaa);
           pic=(ImageView)view.findViewById(R.id.pic2);

        }
    }


    public MoviesAdapter(List<nwMovie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        nwMovie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText("Price : "+movie.getYear()+" Taka");
        holder.q.setText(movie.getName());
        holder.qua.setText(movie.getQuantity());
      //  holder.q.setText(String.valueOf((movie.getRES())));
        holder.pic.setImageResource(movie.getRES());
       // int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" +"iphone" , null, null);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
