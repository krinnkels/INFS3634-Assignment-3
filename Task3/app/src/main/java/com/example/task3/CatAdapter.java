package com.example.task3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder>  implements Filterable {
    private Context Context;
    private ArrayList<CatType> catlist;
    private ArrayList<CatType> catListFull;
    private OnItemClickListener Listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        Listener = listener;
    }

    public CatAdapter(Context context, ArrayList<CatType> list) {
        Context = context;
        catlist = list;
        catListFull = new ArrayList<>(catlist);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Context).inflate(R.layout.single_cat, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CatType currentCat = catlist.get(position);
        String catBreed = currentCat.getBreed();
    }

    @Override
    public int getItemCount() {
        if (catlist != null) {
            return catlist.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView catBreed;
        public ImageView catPicture;
        public TextView catDescription;

        public ViewHolder(View v) {
            super(v);
            catBreed = itemView.findViewById(R.id.cat_breed);
            catPicture = itemView.findViewById(R.id.cat_picture);
            catDescription = itemView.findViewById(R.id.cat_description);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            Listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


    @Override
    public Filter getFilter(){
        return catFilter;
    }

    private Filter catFilter = new Filter(){
    @Override
        protected FilterResults performFiltering(CharSequence constraint){
            List<CatType> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(catListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(CatType cat : catListFull){
                    if (cat.getBreed().toLowerCase().contains(filterPattern)){
                        filteredList.add(cat);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            catlist.clear();
            System.out.println(results.values);
            if (results.values != null) {
                catlist.addAll((List) results.values);
            }
            notifyDataSetChanged();

        }
    };
}
