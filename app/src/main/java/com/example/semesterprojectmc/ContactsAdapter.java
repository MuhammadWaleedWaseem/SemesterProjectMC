package com.example.semesterprojectmc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private List<Contacts> contactsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView phone;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.contactName);
            phone = (TextView) view.findViewById(R.id.contactPhoneNumber);
        }
    }

    public ContactsAdapter(List<Contacts> contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row
                        , parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Contacts contact = contactsList.get(position);
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}
