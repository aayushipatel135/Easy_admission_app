package com.example.easyadmission.Student.Adaptor;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.easyadmission.R;
import com.example.easyadmission.Student.Database.StudentInstituteData;
import com.example.easyadmission.Student.Student_institute_onclick;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class institute_student_Adaptor extends RecyclerView.Adapter<institute_student_Adaptor.MyViewHolder>{

    Context context;
    ArrayList<StudentInstituteData> list;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase firebasedatabase;

    public institute_student_Adaptor(Context context,ArrayList<StudentInstituteData> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.display_institute,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        StudentInstituteData studentInstituteData = list.get(position);
        holder.institute_name.setText(studentInstituteData.getInstitute_name());
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.logo);


        holder.display_institute_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Student_institute_onclick.class);
                intent.putExtra("institute_name",list.get(position).getInstitute_name());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView institute_name;
        CardView display_institute_show;
        ImageView logo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            institute_name = itemView.findViewById(R.id.institute_name);
            display_institute_show = itemView.findViewById(R.id.display_institute_show);
            logo = itemView.findViewById(R.id.logo_institute);
        }
    }

}
