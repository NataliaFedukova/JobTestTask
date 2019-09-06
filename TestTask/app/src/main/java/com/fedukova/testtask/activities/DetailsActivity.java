package com.fedukova.testtask.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.fedukova.testtask.R;
import com.fedukova.testtask.entity.Animal;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView = findViewById(R.id.imageView);
        TextView indexTextView = findViewById(R.id.index_text_view);
        TextView textView = findViewById(R.id.text_view);

        Animal animal = (Animal) getIntent().getSerializableExtra(Animal.ANIMAL);
        Picasso.get()
               .load(animal.getUrl())
               .fit()
               .into(imageView);
        indexTextView.setText("" + getIntent().getIntExtra("position", 0));
        textView.setText(animal.getText());
    }
}
