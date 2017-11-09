package com.atiscom.retrofitrxjavadatabindingexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.atiscom.retrofitrxjavadatabindingexample.databinding.ContactDataBinding;

import java.util.List;

/**
 * Created by Mico on 11/9/2017.
 */

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ContactViewHolder> {

    List<ContactModel> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public RecyclerContactAdapter(List<ContactModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ContactDataBinding dataBinding = ContactDataBinding.inflate(layoutInflater,parent,false);

        return new ContactViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        final ContactModel model = list.get(position);
        holder.bind(model);

        final ContactDataBinding dataBinding = holder.getContactDataBinding();
        dataBinding.setHandler(new ContactItemClickInterface() {
            @Override
            public void contactItemClick() {
                Toast.makeText(context, model.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        ContactDataBinding contactDataBinding;

        public ContactViewHolder(ContactDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.contactDataBinding = dataBinding;
        }

        public void bind(ContactModel model) {
            this.contactDataBinding.setModel(model);
        }

        public ContactDataBinding getContactDataBinding() {
            return contactDataBinding;
        }
    }


}
