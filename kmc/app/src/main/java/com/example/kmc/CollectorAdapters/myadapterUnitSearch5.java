package com.example.kmc.CollectorAdapters;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmc.CLogin.CollectorUserDetails2;
import com.example.kmc.Individual;
import com.example.kmc.R;
import com.example.kmc.SelectionElements;

import java.util.ArrayList;
import java.util.Locale;

public class myadapterUnitSearch5 extends RecyclerView.Adapter<myadapterUnitSearch5.myviewholder>
{
    ArrayList<Individual> datalist;
    ArrayList<SelectionElements> dataAadhar=new ArrayList<>();
    String district;

    public myadapterUnitSearch5(ArrayList<Individual> datalist, String district) {
        this.datalist = datalist;
        this.district=district;
    }

    @NonNull
    @Override
    public myadapterUnitSearch5.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myadapterUnitSearch5.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapterUnitSearch5.myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.t1.getContext(), CollectorUserDetails2.class);
                i.putExtra("uname",datalist.get(position).getName());
                i.putExtra("ufname",datalist.get(position).getFatherName());
                i.putExtra("uAge",datalist.get(position).getAge());
                i.putExtra("uHnumber",datalist.get(position).getHouseNo());
                i.putExtra("uVillage",datalist.get(position).getVillage());
                i.putExtra("uMandal",datalist.get(position).getMandal());
                i.putExtra("uDistrict",datalist.get(position).getDistrict());
                i.putExtra("uAadharNumber",datalist.get(position).getAadhar());
                i.putExtra("uMobileNo",datalist.get(position).getPhoneNo() );
                i.putExtra("uPreferredUnit",datalist.get(position).getPreferredUnit());
                i.putExtra("uBankName",datalist.get(position).getBankName());
                i.putExtra("uBankAccNumber",datalist.get(position).getBankAccNo());
                i.putExtra("upsUpload",datalist.get(position).getPsUpload());
                i.putExtra("usecOfficerUpload",datalist.get(position).getSecOfficerUpload());
                i.putExtra("uSPRemarks",datalist.get(position).getSp_remarks());
                i.putExtra("uSORemarks",datalist.get(position).getSo_remarks());
                i.putExtra("uSOApproved",datalist.get(position).getSecOfficerApproved());
                i.putExtra("uCollectorApproved",datalist.get(position).getCtrApproved());
                i.putExtra("uCollectorApprovalAmount",datalist.get(position).getApprovalAmount());
                i.putExtra("uDBAccount",datalist.get(position).getDbAccount());
                i.putExtra("uBankIFSC",datalist.get(position).getBankIFSC());
                i.putExtra("district",district);
                i.putExtra("uVendorIFSC",datalist.get(position).getVendorIFSC());
                i.putExtra("uVendorBankAccount",datalist.get(position).getVendorAccountNo());
                i.putExtra("uVendorName",datalist.get(position).getVendorName());
                i.putExtra("uGroundingStatus",datalist.get(position).getGroundingStatus());
                i.putExtra("uGroundingImage",datalist.get(position).getGrounding_img());
                i.putExtra("uApprovalAmount",datalist.get(position).getApprovalAmount());
                i.putExtra("uDbAccount",datalist.get(position).getDbAccount());
                i.putExtra("uDbBankName",datalist.get(position).getDbBankName());
                i.putExtra("uDbAccountNo",datalist.get(position).getDbBankAccNo());
                i.putExtra("uDbIFSC",datalist.get(position).getDbBankIFSC());

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.t1.getContext().startActivity(i);
                ((Activity)holder.t1.getContext()).finish();
            }
        }) ;


        holder.t1.setText(datalist.get(position).getName());
        holder.t2.setText(datalist.get(position).getStatus());
        holder.t3.setText("Preferred Unit: "+datalist.get(position).getPreferredUnit());
<<<<<<< HEAD
        holder.t4.setText("DB Account Balance: "+datalist.get(position).getDbAccount());
        holder.t5.setText("Credited To Vendor: "+datalist.get(position).getApprovalAmount());
        holder.t6.setText("Credited To DB: "+datalist.get(position).getCreditedToDB());
=======
        holder.t4.setText("DB Account Amount: "+datalist.get(position).getDbAccount());
        holder.t5.setText("Approved Amount: "+datalist.get(position).getApprovalAmount());
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
        String inprogress="In Progress";
        String approve="approved";
        String reject="rejected";
        String collector_action_required1="Waiting for Collector Sanction";
        String collector_action_required2="Waiting for Collector Approval";

        if(datalist.get(position).getStatus().toLowerCase(Locale.ROOT).equals(approve.toLowerCase(Locale.ROOT)))
        {
            holder.t2.setTextColor(Color.parseColor("#00873E"));
        }else if(datalist.get(position).getStatus().toLowerCase(Locale.ROOT).equals(reject.toLowerCase(Locale.ROOT)))
        {
            holder.t2.setTextColor(Color.parseColor("#FF0000"));
        }else if(datalist.get(position).getStatus().toLowerCase(Locale.ROOT).equals(collector_action_required1.toLowerCase(Locale.ROOT))||datalist.get(position).getStatus().toLowerCase(Locale.ROOT).equals(collector_action_required2.toLowerCase(Locale.ROOT)))
        {
            holder.t2.setTextColor(Color.parseColor("#06038D"));
        }
        else{
            //#00873E
            holder.t2.setTextColor(Color.parseColor("#F6BE00"));
        }

//        holder.t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(holder.t1.getContext(), CollectorUserDetails.class);
//                i.putExtra("uname",datalist.get(position).getName());
//                i.putExtra("ufname",datalist.get(position).getFatherName());
//                i.putExtra("uAge",datalist.get(position).getAge());
//                i.putExtra("uHnumber",datalist.get(position).getHouseNo());
//                i.putExtra("uVillage",datalist.get(position).getVillage());
//                i.putExtra("uMandal",datalist.get(position).getMandal());
//                i.putExtra("uDistrict",datalist.get(position).getDistrict());
//                i.putExtra("uAadharNumber",datalist.get(position).getAadhar());
//                i.putExtra("uMobileNo",datalist.get(position).getPhoneNo() );
//                i.putExtra("uPreferredUnit",datalist.get(position).getPreferredUnit());
//                i.putExtra("uBankName",datalist.get(position).getBankName());
//                i.putExtra("uBankAccNumber",datalist.get(position).getBankAccNo());
//                i.putExtra("upsUpload",datalist.get(position).getPsUpload());
//                i.putExtra("usecOfficerUpload",datalist.get(position).getSecOfficerUpload());
//                i.putExtra("uSPRemarks",datalist.get(position).getSp_remarks());
//                i.putExtra("uSORemarks",datalist.get(position).getSo_remarks());
//                i.putExtra("uSOApproved",datalist.get(position).getSecOfficerApproved());
//                i.putExtra("uCollectorApproved",datalist.get(position).getCtrApproved());
//                i.putExtra("uCollectorApprovalAmount",datalist.get(position).getApprovalAmount());
//                i.putExtra("uDBAccount",datalist.get(position).getDbAccount());
//                i.putExtra("uBankIFSC",datalist.get(position).getBankIFSC());
//                i.putExtra("village",village);
//                i.putExtra("uVendorIFSC",datalist.get(position).getVendorIFSC());
//                i.putExtra("uVendorBankAccount",datalist.get(position).getVendorAccountNo());
//                i.putExtra("uVendorName",datalist.get(position).getVendorName());
//                i.putExtra("uGroundingStatus",datalist.get(position).getGroundingStatus());
//                i.putExtra("uGroundingImage",datalist.get(position).getGrounding_img());
//                i.putExtra("uApprovalAmount",datalist.get(position).getApprovalAmount());
//                i.putExtra("uDbAccount",datalist.get(position).getDbAccount());
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                holder.t1.getContext().startActivity(i);
//                ((Activity)holder.t1.getContext()).finish();
//            }
//        });
//        holder.t2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(holder.t1.getContext(), CollectorUserDetails.class);
//                i.putExtra("uname",datalist.get(position).getName());
//                i.putExtra("ufname",datalist.get(position).getFatherName());
//                i.putExtra("uAge",datalist.get(position).getAge());
//                i.putExtra("uHnumber",datalist.get(position).getHouseNo());
//                i.putExtra("uVillage",datalist.get(position).getVillage());
//                i.putExtra("uMandal",datalist.get(position).getMandal());
//                i.putExtra("uDistrict",datalist.get(position).getDistrict());
//                i.putExtra("uAadharNumber",datalist.get(position).getAadhar());
//                i.putExtra("uMobileNo",datalist.get(position).getPhoneNo() );
//                i.putExtra("uPreferredUnit",datalist.get(position).getPreferredUnit());
//                i.putExtra("uBankName",datalist.get(position).getBankName());
//                i.putExtra("uBankAccNumber",datalist.get(position).getBankAccNo());
//                i.putExtra("upsUpload",datalist.get(position).getPsUpload());
//                i.putExtra("usecOfficerUpload",datalist.get(position).getSecOfficerUpload());
//                i.putExtra("uSPRemarks",datalist.get(position).getSp_remarks());
//                i.putExtra("uSORemarks",datalist.get(position).getSo_remarks());
//                i.putExtra("uSOApproved",datalist.get(position).getSecOfficerApproved());
//                i.putExtra("uCollectorApproved",datalist.get(position).getCtrApproved());
//                i.putExtra("village",village);
//                i.putExtra("uBankIFSC",datalist.get(position).getBankIFSC());
//                i.putExtra("uVendorIFSC",datalist.get(position).getVendorIFSC());
//                i.putExtra("uVendorBankAccount",datalist.get(position).getVendorAccountNo());
//                i.putExtra("uVendorName",datalist.get(position).getVendorName());
//                i.putExtra("uGroundingStatus",datalist.get(position).getGroundingStatus());
//                i.putExtra("uGroundingImage",datalist.get(position).getGrounding_img());
//                i.putExtra("uApprovalAmount",datalist.get(position).getApprovalAmount());
//                i.putExtra("uDbAccount",datalist.get(position).getDbAccount());
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                holder.t2.getContext().startActivity(i);
//                ((Activity)holder.t2.getContext()).finish();
//            }
//        });
    }




    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
<<<<<<< HEAD
        TextView t6;
=======
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
        ImageView check;
        CardView cardView;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t4=itemView.findViewById(R.id.t4);
            t5=itemView.findViewById(R.id.t5);
<<<<<<< HEAD
            t6=itemView.findViewById(R.id.t6);
=======
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
            check=itemView.findViewById(R.id.check);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }
}

