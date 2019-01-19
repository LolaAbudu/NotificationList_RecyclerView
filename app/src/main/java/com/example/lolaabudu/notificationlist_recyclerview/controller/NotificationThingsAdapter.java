package com.example.lolaabudu.notificationlist_recyclerview.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lolaabudu.notificationlist_recyclerview.R;
import com.example.lolaabudu.notificationlist_recyclerview.model.NotificationThings;
import com.example.lolaabudu.notificationlist_recyclerview.view.NotificationThingsViewHolder;

import java.util.List;

public class NotificationThingsAdapter extends RecyclerView.Adapter<NotificationThingsViewHolder> {

    private List<NotificationThings> notificationThingsList;

    public NotificationThingsAdapter(List<NotificationThings> notificationThingsList) {
        this.notificationThingsList = notificationThingsList;
    }

    @NonNull
    @Override
    public NotificationThingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_itemview, parent, false);
        return new NotificationThingsViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationThingsViewHolder holder, int position) {
        NotificationThings notificationThings = notificationThingsList.get(position);
        holder.onBind(notificationThings);
    }

    @Override
    public int getItemCount() {
        return notificationThingsList.size();
    }
}
