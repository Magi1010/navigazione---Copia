package com.example.simplenav;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TwokViewHolderUid extends RecyclerView.ViewHolder{
    private TextView  txtText;



    public TwokViewHolderUid(@NonNull View itemView) {
        super(itemView);

        txtText = itemView.findViewById(R.id.textuid);



    }

    public void updateContent(Twok twok) {

        txtText.setText(twok.text);
       // int backgroundColor = Color.parseColor(twok.bgcol);

        try {
            int backgroundColor = Color.parseColor(twok.bgcol);
            txtText.setBackgroundColor(backgroundColor);
        }catch (java.lang.NumberFormatException e){
            int backgroundColor = Color.parseColor(	"#FFFFFF");
            txtText.setBackgroundColor(backgroundColor);
        }catch (java.lang.IllegalArgumentException e){
            int backgroundColor = Color.parseColor(	"#FFFFFF");
            txtText.setBackgroundColor(backgroundColor);
        }




       //



      //  Bitmap bitmap = BitmapFactory.decodeFile("path/to/image.jpg");
    }
}
