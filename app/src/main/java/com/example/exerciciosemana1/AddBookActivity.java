package com.example.exerciciosemana1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBookActivity extends AppCompatActivity {


    public static final String NEW_BOOK = "NEW_BOOK";
    private EditText edTitle;
    private EditText edAuthor;
    private EditText edYear;
    private Button btAdd;
    private Button btCancel;



//    private class OnClickAdd implements

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        btAdd = findViewById(R.id.btAddBook);
        edTitle = findViewById(R.id.etTitle);
        edAuthor = findViewById(R.id.etAuthor);
        edYear = findViewById(R.id.etYear);

        btAdd.setOnClickListener(new View.OnClickListener() {

            private boolean isNullOrEmpty (String s) {
                return (s == null || s.isEmpty());
            }


            @Override
            public void onClick(View v) {
                String title = edTitle.getText().toString();
                String author = edAuthor.getText().toString();
                String year = edYear.getText().toString();

                if(isNullOrEmpty( title) ) {
                    edTitle.setError("Invalid name");
                    return;
                }
                if(isNullOrEmpty( author) ) {
                    edAuthor.setError("Invalid author name");
                    return;
                }
                if(isNullOrEmpty( year) ) {
                    edYear.setError("Invalid year");
                    return;
                }

                final Intent intent = getIntent();

                BookData response = new BookData(0, title, author, Integer.parseInt(year), false, BookData.Type.Drama);
                //intent.putExtra(NEW_BOOK, response);
                Log.d("HLUSTOSA", "Title " + response.getTitle());
                Log.d("HLUSTOSA", "Author " + response.getAuthor());
                Log.d("HLUSTOSA", "imgResourceId " + response.getImageResourceId());

                if(intent != null) {
                    setResult(RESULT_OK, getIntent().putExtra(NEW_BOOK, response));
                }
                AddBookActivity.this.finish();
            }
        });

    }
}
