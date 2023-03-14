package com.example.easyadmission.Student.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyadmission.R;
import com.example.easyadmission.Student.Database.StudentCourseInstituteData;
import com.example.easyadmission.Student.Student_institute_onclick;

import java.util.ArrayList;

public class Student_Course_Adaptor extends RecyclerView.Adapter<Student_Course_Adaptor.MyViewHolder> {

    Context context;
    ArrayList<StudentCourseInstituteData> list;

    public Student_Course_Adaptor(Context context,ArrayList<StudentCourseInstituteData> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.display_courses,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        StudentCourseInstituteData studentCourseInstituteData = list.get(position);
        holder.course_id.setText(studentCourseInstituteData.getCourse_id());
        holder.course_name.setText(studentCourseInstituteData.getCourse_name());


        holder.display_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Student_institute_onclick.class);
                intent.putExtra("coursename",list.get(position).getCourse_name());
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

        TextView course_id,course_name;
        CardView display_courses;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            course_id = itemView.findViewById(R.id.course_id);
            course_name = itemView.findViewById(R.id.course_name);
            display_courses = itemView.findViewById(R.id.display_courses);
        }
    }

}
