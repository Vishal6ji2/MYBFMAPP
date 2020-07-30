package com.example.bfmapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ChatMessages;

import java.util.ArrayList;

public class UsersMessagesAdapter extends RecyclerView.Adapter<UsersMessagesAdapter.ViewHolder> {

    Context context;
    ArrayList<ChatMessages> messagesArrayList = new ArrayList<>();
    int msglefttype = 0;
    int msgrighttype = 1;
    String currentuser;

    public UsersMessagesAdapter(Context context, ArrayList<ChatMessages> messagesArrayList) {
        this.context = context;
        this.messagesArrayList = messagesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == msgrighttype){
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.rightmsglayout,parent,false));
        }else {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.leftmsglayout,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtmsg.setText(messagesArrayList.get(position).message);
        Log.d("allmsg",messagesArrayList.get(position).sender);
        Log.d("allmsg",messagesArrayList.get(position).receiver);


    }

    @Override
    public int getItemCount() {
        return messagesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtmsg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmsg = itemView.findViewById(R.id.textmessage);
        }
    }

    //process is running for messages layout left and right

//    Process is running for messages

//    @Override
//    public int getItemViewType(int position) {
////        firebaseAuth = FirebaseAuth.getInstance();
////        firebaseUser = firebaseAuth.getCurrentUser();
////        currentuser = firebaseUser.getEmail();
//        Log.d("currentuser",currentuser);
////        if (arrayList.get(position).sender.equals(currentuser)){
//            Log.d("realuser",currentuser);
//
//            return msgrighttype;
////        }else {
////            return msglefttype;
//        }
}


