package com.example.exerciciosemana1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookDataAdapter extends RecyclerView.Adapter {

    private List<BookData> bookDataList;
    private final View.OnClickListener listener;

    public BookDataAdapter(List<BookData> bookDataList, View.OnClickListener listener) {
        this.bookDataList = bookDataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_data_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BookData bookData = bookDataList.get(position);

        ViewHolder myHolder = (ViewHolder) holder;
        myHolder.bindView(bookData);
    }

    @Override
    public int getItemCount() {
        return bookDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bindView(BookData bookData) {
            ImageView ivMain = itemView.findViewById(R.id.ivMain);
            TextView tvTitle = itemView.findViewById(R.id.ivTitle);
            TextView tvLaunchYear = itemView.findViewById(R.id.tvLaunchYear);
            TextView tvAuthor = itemView.findViewById(R.id.tvAuthor);



            if(bookData.getImageResourceId() != -1) {
                ivMain.setImageResource(bookData.getImageResourceId());
            }
            tvTitle.setText(bookData.getTitle());
            tvLaunchYear.setText(String.valueOf(bookData.getYearPublished()));
            tvAuthor.setText(bookData.getAuthor());

            itemView.setOnClickListener(listener);

        }
    }
}