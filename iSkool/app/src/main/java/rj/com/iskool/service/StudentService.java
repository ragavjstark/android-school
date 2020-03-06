package rj.com.iskool.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rj.com.iskool.model.Student;

public interface StudentService {

    @GET("student/getStudents")
    Call<List<Student>> getAllStudents();
}
