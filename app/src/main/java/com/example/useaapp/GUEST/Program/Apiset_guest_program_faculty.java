package com.example.useaapp.GUEST.Program;

import com.example.useaapp.GUEST.Program.associative.Response_model_guest_program_faculty_asso;
import com.example.useaapp.GUEST.Program.bachelor.Response_model_guest_program_faculty_bachelor;
import com.example.useaapp.GUEST.Registration.Response_model_guest_registration;
import com.example.useaapp.STUDENT.StudyPlan.year1.Response_model_SemesterStudyPlan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_program_faculty
{

//    Faculty
   @GET("fetch_guest_program_faculty.php")
    Call<List<Response_model_guest_program_faculty>> get_guest_pro_fac();

//   Faculty វិទ្យាសាស្ត្រសង្គម និងនីតិសាស្ត្រ
    @GET("fetch_guest_fac1_bach_major_id1.php")
    Call<List<Response_model_guest_program_faculty_bachelor>> get_guest_pro_fac_bac1();


    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍
    @GET("fetch_guest_fac2_asso_major_id2.php")
    Call<List<Response_model_guest_program_faculty_asso>> get_guest_pro_fac_ass2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_asso_major_mnm_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_ass2_mnm_y1s1();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_asso_major_mnm_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_ass2_mnm_y1s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_asso_major_mnm_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_ass2_mnm_y2s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_asso_major_mnm_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_ass2_mnm_y2s2();


    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍
    @GET("fetch_guest_fac2_bach_major_id2.php")
    Call<List<Response_model_guest_program_faculty_bachelor>> get_guest_pro_fac_bac2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y1s1();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y1s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y2s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y2s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y3s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y3s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y3s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y3s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y4s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y4s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Accounting
    @GET("fetch_guest_fac2_bach_major_acc_y4s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_acc_y4s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y1s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y1s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y2s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y2s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y3s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y3s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y3s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y3s2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y4s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y4s1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Finance
    @GET("fetch_guest_fac2_bach_major_fin_y4s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac2_fin_y4s2();


    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា
    @GET("fetch_guest_fac3_bach_major_id3.php")
    Call<List<Response_model_guest_program_faculty_bachelor>> get_guest_pro_fac_bac3();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y1s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y1s2();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y2s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y2s2();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y3s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y3s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y3s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y3s2();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y4s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y4s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា IT
    @GET("fetch_guest_fac3_bach_major_it_y4s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_it_y4s2();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y1s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y1s2();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y2s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y2s2();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y3s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y3s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y3s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y3s2();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y4s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y4s1();

    //   Faculty វិទ្យាសាស្ត្រសង្គម និងបច្ចេកវិទ្យា Math
    @GET("fetch_guest_fac3_bach_major_math_y4s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac3_math_y4s2();


    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ
    @GET("fetch_guest_fac4_bach_major_id4.php")
    Call<List<Response_model_guest_program_faculty_bachelor>> get_guest_pro_fac_bac4();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y1s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y1s2();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y2s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y2s2();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y3s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y3s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y3s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y3s2();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y4s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y4s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Management
    @GET("fetch_guest_fac4_bach_major_mnm_y4s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_mnm_y4s2();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y1s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y1s2();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y2s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y2s2();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y3s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y3s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y3s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y3s2();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y4s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y4s1();

    //   Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ Khmer
    @GET("fetch_guest_fac4_bach_major_kh_y4s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_guest_pro_fac_bac4_kh_y4s2();

}
