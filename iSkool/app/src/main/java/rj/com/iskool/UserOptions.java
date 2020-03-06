package rj.com.iskool;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rj.com.iskool.adapter.StudentAdapter;
import rj.com.iskool.model.Student;
import rj.com.iskool.service.StudentService;

public class UserOptions extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_options);
        RestServiceHelper restServiceHelper = new RestServiceHelper();
        Retrofit retrofit = restServiceHelper.getRetrofit();
        StudentService studentService = retrofit.create(StudentService.class);
        Call<List<Student>> call = studentService.getAllStudents();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                //progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                //progressDoalog.dismiss();
                Toast.makeText(UserOptions.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Student> students) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new StudentAdapter(students);
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

}
