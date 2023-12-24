package com.example.quiz;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapater extends RecyclerView.Adapter<QuizAdapater.QuizViewHolder> {
    List<Quiz>question = new ArrayList<>();
    Context context;

    public QuizAdapater(List<Quiz> question, Context context) {
        this.question = question;
        this.context = context;
    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item_layout,parent,false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {

        Quiz quiz = question.get(position);

        holder.questionText.setText(quiz.getQuestions());
        List<String> options = quiz.getOptons();
        holder.rb1.setText(options.get(0));
        holder.rb2.setText(options.get(1));
        holder.rb3.setText(options.get(2));
        holder.rb4.setText(options.get(3));

        holder.rg.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = group.findViewById(checkedId);
                String selectedOption = radioButton.getText().toString();
                showSelectedOptionDialog(selectedOption);

        });

    }
    private void showSelectedOptionDialog(String selectedOption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Selected Option");
        builder.setMessage("You selected: " + selectedOption);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss())    ;
        builder.show();
    }
    @Override
    public int getItemCount() {
        return question.size();
    }


    public  class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView questionText;
        RadioGroup rg;
        RadioButton rb1,rb2,rb3,rb4;
        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);


            questionText = itemView.findViewById(R.id.questionText);
            rg = itemView.findViewById(R.id.radioGroup);
            rb1 = itemView.findViewById(R.id.radioButton1);
            rb2 = itemView.findViewById(R.id.radioButton2);
            rb3= itemView.findViewById(R.id.radioButton3);
            rb4 = itemView.findViewById(R.id.radioButton4);

        }


    }
}
