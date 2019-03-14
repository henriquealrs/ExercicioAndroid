package com.example.exerciciosemana1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;

    public static final int REQUEST_CODE = 1;

    private List<BookData> books = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            BookData bookData = data.getParcelableExtra(AddBookActivity.NEW_BOOK);
            if(bookData != null) {
                Log.d("HLUSTOSA", "Title " + bookData.getTitle());
                Log.d("HLUSTOSA", "Author " + bookData.getAuthor());
                Log.d("HLUSTOSA", "imgResourceId " + bookData.getImageResourceId());
                if(bookData.getImageResourceId() == 0 || bookData.getImageResourceId() == -1) {
                    bookData.setImageResourceId(R.drawable.java);
                    books.add(bookData);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Treat Recycler View
        // Recycler View
        BookData book = new BookData(R.drawable.java, "1984", "Gorge Orwel", 1931, true, BookData.Type.Philosofy);
        books = new ArrayList<BookData>();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvTitle = v.findViewById(R.id.ivTitle);
                Toast.makeText(MainActivity.this, "Clicked Item " + tvTitle.getText(), Toast.LENGTH_LONG).show();
            }
        };

        books.add(book);
        books.add(book);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new BookDataAdapter(books, listener);
        recyclerView.setAdapter(adapter);



        // Floating Action Button
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);

                intent.putExtra("INFO", "Add Book Data");

                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }
}
