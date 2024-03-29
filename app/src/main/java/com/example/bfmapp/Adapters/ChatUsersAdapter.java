package com.example.bfmapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.Activities.ChatMessagesActivity;
import com.example.bfmapp.Activities.ChatUsersActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ChatUsersSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.Collection;

public class ChatUsersAdapter extends RecyclerView.Adapter<ChatUsersAdapter.ViewHolder> implements Filterable {

   public static int flag = 0;

    Context context;
    public static ArrayList<ChatUsersSuitcase> usersSuitcaseArrayList = new ArrayList<>();
    ArrayList<ChatUsersSuitcase> suitcaseArrayList;


    public ChatUsersAdapter(Context context, ArrayList<ChatUsersSuitcase> usersSuitcaseArrayList) {
        this.context = context;
        this.usersSuitcaseArrayList = usersSuitcaseArrayList;
        suitcaseArrayList = new ArrayList<>(usersSuitcaseArrayList);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.chatuserscustom,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.profileimg.setImageResource(usersSuitcaseArrayList.get(position).chatuserprofileimg);

        holder.txtchattername.setText(usersSuitcaseArrayList.get(position).chattername);

        holder.txtlastmsg.setText(usersSuitcaseArrayList.get(position).lastmsg);

        holder.txttime.setText(usersSuitcaseArrayList.get(position).time);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    Intent intent = new Intent(context, ChatMessagesActivity.class);
                    intent.putExtra("chattername", usersSuitcaseArrayList.get(position).chattername);
                    intent.putExtra("chatterimg", usersSuitcaseArrayList.get(position).chatuserprofileimg);

//                Pair<View,String> p1 = Pair.create((View)holder.txtchattername,"customprofilename");
//                Pair<View,String> p2 = Pair.create((View)holder.profileimg,"customprofileimg");
//                ActivityOptionsCompat optionsCompat;
//                optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context,p1,p2);
                    context.startActivity(intent/*,optionsCompat.toBundle()*/);

                }else
                    if (ChatUsersActivity.isinActionmode) {
                        ((ChatUsersActivity) context).prepareSelection(position);
                        notifyItemChanged(position);
                    }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                ((ChatUsersActivity)context).prepareToolbar(position);
                flag = 1;

                return true;
            }
        });

        if (ChatUsersActivity.isinActionmode){

            if (ChatUsersActivity.selectedusersarraylist.contains(usersSuitcaseArrayList.get(position))){
                holder.itemView.setBackgroundResource(android.R.color.darker_gray);

            }else {
                holder.itemView.setBackgroundResource(R.color.whitecolor);

            }
        }else {
            holder.itemView.setBackgroundResource(R.color.whitecolor);
        }

    }

    @Override
    public int getItemCount() {
        return usersSuitcaseArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return examplefilter;
    }

    public void removedata(ArrayList<ChatUsersSuitcase> selectedusersarraylist) {

        for (ChatUsersSuitcase chatusersuitcase:selectedusersarraylist) {

            usersSuitcaseArrayList.remove(chatusersuitcase);

        }

        notifyDataSetChanged();
        flag = 0;
    }

  /*  public static ArrayList<ChatUsersSuitcase> getarraylist(){
        return usersSuitcaseArrayList;
    }
*/


    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout chatslayout;
        CircularImageView profileimg;
        TextView txtchattername,txttime,txtlastmsg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            chatslayout = itemView.findViewById(R.id.cucustom_relativelayout);
            profileimg = itemView.findViewById(R.id.cucustom_profileimg);
            txtchattername = itemView.findViewById(R.id.cucustom_chattername);
            txttime = itemView.findViewById(R.id.cucustom_time);
            txtlastmsg = itemView.findViewById(R.id.cucustom_msgs);
        }
    }


    public Filter examplefilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {


            ArrayList<ChatUsersSuitcase> filterlist = new ArrayList<>();

            if (constraint.toString().isEmpty()){
                filterlist.addAll(suitcaseArrayList);
            }else {

                for (ChatUsersSuitcase suitcase : suitcaseArrayList){
                    if (suitcase.chattername.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filterlist.add(suitcase);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterlist;


            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            usersSuitcaseArrayList.clear();
            usersSuitcaseArrayList.addAll((Collection<? extends ChatUsersSuitcase>)results.values);
            notifyDataSetChanged();
        }
    };
}
