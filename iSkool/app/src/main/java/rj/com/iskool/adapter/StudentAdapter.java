package rj.com.iskool.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rj.com.iskool.R;
import rj.com.iskool.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> mDataset;

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View studentView = inflater.inflate(R.layout.item_student, parent, false);

        // Return a new holder instance
        StudentViewHolder viewHolder = new StudentViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textViewId.setText(mDataset.get(position).getId());
        holder.textViewName.setText(mDataset.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewId;
        public TextView textViewName;

        public StudentViewHolder(View v) {
            super(v);
            textViewId = (TextView) v.findViewById(R.id.student_id);
            textViewName = (TextView) v.findViewById(R.id.student_name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StudentAdapter(List<Student> myDataset) {
        mDataset = myDataset;
    }

}
