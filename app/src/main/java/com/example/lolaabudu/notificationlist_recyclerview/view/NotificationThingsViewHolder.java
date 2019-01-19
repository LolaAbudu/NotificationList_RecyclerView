package com.example.lolaabudu.notificationlist_recyclerview.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolaabudu.notificationlist_recyclerview.R;
import com.example.lolaabudu.notificationlist_recyclerview.SecondActivity;
import com.example.lolaabudu.notificationlist_recyclerview.model.NotificationThings;

public class NotificationThingsViewHolder extends RecyclerView.ViewHolder {

    private TextView description;
    private ImageView item;
    private Intent intent;
    private NotificationThings allThings;
    private static final String TAG = "image_call";

    public NotificationThingsViewHolder(@NonNull View itemView) {
        super(itemView);
        description = itemView.findViewById(R.id.description_textView);
        item = itemView.findViewById(R.id.photo_imageView);
    }

    public void onBind(NotificationThings allNotification) {
        this.allThings = allNotification;
        item.setImageResource(allNotification.getItem());
        description.setText(allNotification.getDescription());
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("things", allThings);
                v.getContext().startActivity(intent);
            }
        });
    }
}

