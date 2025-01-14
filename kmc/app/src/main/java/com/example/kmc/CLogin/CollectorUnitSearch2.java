package com.example.kmc.CLogin;

<<<<<<< HEAD
import android.graphics.Color;
=======
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
=======
import android.widget.ProgressBar;

>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmc.CollectorAdapters.myadapter5Search;
import com.example.kmc.CollectorAdapters.myadapterUnitSearch2;
import com.example.kmc.Individual;
import com.example.kmc.R;
<<<<<<< HEAD
import com.example.kmc.SelectionElements;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
=======
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CollectorUnitSearch2 extends AppCompatActivity implements com.example.kmc.List {
=======
import java.util.List;
import java.util.Locale;

public class CollectorUnitSearch2 extends AppCompatActivity {
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
    ArrayList<Individual> datalist;
    FirebaseFirestore db;
    RecyclerView recyclerView;
    public TextInputEditText searchBox;
<<<<<<< HEAD
    ArrayList<SelectionElements> selected;
=======

>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
    String district;
    ProgressBar progressBar;
    String searchText;
    String village;
    myadapterUnitSearch2 adapter;
<<<<<<< HEAD
    ImageButton checkAll;
    ImageButton cancelAll;
    LinearLayout l1;
    TextInputLayout searchboxLayout;
    ImageButton searchButton;
    View v;
=======
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collector_search);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchBox=findViewById(R.id.searchbox);
<<<<<<< HEAD
        searchButton=findViewById(R.id.searchbutton);
        searchboxLayout=findViewById(R.id.searchboxLayout);
        datalist=new ArrayList<>();
        checkAll=findViewById(R.id.checkAll);
        cancelAll=findViewById(R.id.cancelAll);
        v=findViewById(R.id.view);
        l1=findViewById(R.id.layout1);
=======
        datalist=new ArrayList<>();
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
        searchText="";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            district= extras.getString("district");
         //   village=extras.getString("village");
        }
<<<<<<< HEAD
        adapter=new myadapterUnitSearch2(datalist,district,CollectorUnitSearch2.this,CollectorUnitSearch2.this);
=======
        adapter=new myadapterUnitSearch2(datalist,district);
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
        recyclerView.setAdapter(adapter);
        db=FirebaseFirestore.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchText=searchBox.getText().toString().toLowerCase(Locale.ROOT);
            }
        });

    }

    public void searchbutton(View view) {
        progressBar.setVisibility(View.VISIBLE);
        Log.d("searchtext",searchText);
        db.collection("individuals").orderBy("preferredUnit").startAt(searchText).endAt(searchText+"\uf8ff").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list =queryDocumentSnapshots.getDocuments();
                        datalist.clear();
                        for(DocumentSnapshot d:list)
                        {
                            Individual obj=d.toObject(Individual.class);
                            Log.d("searchtext2",obj.getPreferredUnit());
                            if(obj.getDistrict().equalsIgnoreCase(district))
                            {
                                if (obj.getSpApproved().equals("yes") && !obj.getCtrBenApproved().equalsIgnoreCase("yes"))
                                datalist.add(obj);
                            }
                        }
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
<<<<<<< HEAD
    public void cancelAll(View view) {
        for(SelectionElements s:selected) {

            String approved = "no";
            String status = "Rejected by Collector";
            String spApproved = "NA";
            updateData(s.getAadhar(), approved, status, spApproved);
        }
    }

    public void checkAll(View view) {
        for(SelectionElements s:selected) {
            String approved = "yes";
            String status = "Waiting for Panchayat Secretary Amount Request";
            String spApproved = "yes";
            updateData(s.getAadhar(), approved, status, spApproved);
        }
    }
    private void updateData(String aadharNumber, String approved,String status,String spApproved) {
        Map<String, Object> individualInfo = new HashMap<String, Object>();
        individualInfo.put("status", status);
        individualInfo.put("ctrBenApproved", approved);
        individualInfo.put("spApproved", spApproved);
        db.collection("individuals").whereEqualTo("aadhar",aadharNumber)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Log.d("Hello","hi");
                if(task.isSuccessful() && !task.getResult().isEmpty()){
                    DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                    String documentID=documentSnapshot.getId();
                    db.collection("individuals")
                            .document(documentID)
                            .update(individualInfo)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(CollectorUnitSearch2.this, "Status Approval: "+approved, Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(CollectorListOfBen2.this, CollectorAction2.class);
//                                    intent.putExtra("village",village);
//                                    startActivity(intent);
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(CollectorUnitSearch2.this, "Error occured", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    Toast.makeText(CollectorUnitSearch2.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void push(ArrayList<SelectionElements> list) {
        selected=list;
        if(!selected.isEmpty())
        {
            l1.setBackgroundColor(Color.parseColor("#6200EE"));
            v.setVisibility(View.VISIBLE);
            checkAll.setVisibility(View.VISIBLE);
            cancelAll.setVisibility(View.VISIBLE);
            searchboxLayout.setVisibility(View.GONE);
            searchButton.setVisibility(View.GONE);
        }else{
            l1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            v.setVisibility(View.GONE);
            checkAll.setVisibility(View.GONE);
            cancelAll.setVisibility(View.GONE);
            searchboxLayout.setVisibility(View.VISIBLE);
            searchButton.setVisibility(View.VISIBLE);
        }
    }
=======
>>>>>>> 2f137f127f3002c0b05359f66412b5b8c0f2cc4f
}