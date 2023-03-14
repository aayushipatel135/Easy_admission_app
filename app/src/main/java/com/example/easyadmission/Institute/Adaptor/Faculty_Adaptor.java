package com.example.easyadmission.Institute.Adaptor;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.easyadmission.Institute.Database.Faculty_details_institute_database;
import com.example.easyadmission.R;
import com.example.easyadmission.Student.Adaptor.institute_student_Adaptor;
import com.example.easyadmission.Student.Database.StudentInstituteData;
import com.example.easyadmission.Student.Student_institute_onclick;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Faculty_Adaptor extends RecyclerView.Adapter<Faculty_Adaptor.MyViewHolder>{

    Context context;
    ArrayList<Faculty_details_institute_database> list;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase firebasedatabase;


    public Faculty_Adaptor(Context context,ArrayList<Faculty_details_institute_database> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.display_faculty,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        Faculty_details_institute_database faculty_details_institute_database = list.get(position);
        holder.id.setText(faculty_details_institute_database.getId());
        holder.name.setText(faculty_details_institute_database.getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,id;
        CardView display_institute_show;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);

            display_institute_show = itemView.findViewById(R.id.display_institute_show);

        }
    }

}
