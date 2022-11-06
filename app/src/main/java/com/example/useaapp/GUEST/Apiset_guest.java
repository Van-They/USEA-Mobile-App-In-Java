package com.example.useaapp.GUEST;

import com.example.useaapp.GUEST.Career.Response_model_guest_career;
import com.example.useaapp.GUEST.Events.announcement.Response_model_guest_event_announcement;
import com.example.useaapp.GUEST.Events.current.Response_model_guest_event_current;
import com.example.useaapp.GUEST.Events.past.Response_model_guest_event_past;
import com.example.useaapp.GUEST.Events.upcoming.Response_model_guest_event_upcoming;
import com.example.useaapp.GUEST.More.about_us.Response_model_guest_about_us_more;
import com.example.useaapp.GUEST.More.faq.Response_model_guest_faq_more;
import com.example.useaapp.GUEST.Program.Response_model_guest_program_faculty;
import com.example.useaapp.GUEST.Program.associative.Response_model_guest_program_faculty_asso;
import com.example.useaapp.GUEST.Program.bachelor.Response_model_guest_program_faculty_bachelor;
import com.example.useaapp.GUEST.Program.master.Response_model_guest_program_faculty_master;
import com.example.useaapp.GUEST.Registration.Response_model_guest_registration;
import com.example.useaapp.GUEST.Scholarship.Response_model_guest_scholarship;
import com.example.useaapp.STUDENT.StudyPlan.year1.Response_model_SemesterStudyPlan;
import com.example.useaapp.STUDENT.StudyPlan.year1.Response_model_SemesterStudyPlan_Thesis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest
{
    @GET("fetch_guest_career.php")
    Call<List<Response_model_guest_career>> getdata_career();

    @GET("fetch_guest_event_announcement.php")
    Call<List<Response_model_guest_event_announcement>> getdata_event_announcement();

    @GET("fetch_guest_event_current.php")
    Call<List<Response_model_guest_event_current>> getdata_event_current();

    @GET("fetch_guest_event_past.php")
    Call<List<Response_model_guest_event_past>> getdata_event_past();

    @GET("fetch_guest_event_upcoming.php")
    Call<List<Response_model_guest_event_upcoming>> getdata_event_upcoming();

    @GET("fetch_guest_more_about_us.php")
    Call<List<Response_model_guest_about_us_more>> getData_about_us_more();

    @GET("fetch_guest_more_faq.php")
    Call<List<Response_model_guest_faq_more>> getData_faq_more();

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

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍
    @GET("fetch_guest_fac2_mast_major_id2.php")
    Call<List<Response_model_guest_program_faculty_master>> get_guest_pro_fac_mast2();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_th_major_mnm_y1t1.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_th_mnm_y1t1();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_th_major_mnm_y1t2.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_th_mnm_y1t2();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_th_major_mnm_y1t3.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_th_mnm_y1t3();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_th_major_mnm_y2t1.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_th_mnm_y2t1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_th_major_mnm_y2t2.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_th_mnm_y2t2();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_th_major_mnm_y2t3.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_th_mnm_y2t3();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_th_major_mnm_y3t1.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_th_mnm_y3t1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y1t1.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y1t1();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y1t2.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y1t2();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y1t3.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y1t3();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y2t1.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y2t1();

    //   Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y2t2.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y2t2();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y2t3.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y2t3();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y3t1.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y3t1();

    //   Faculty វសេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍ Management
    @GET("fetch_guest_fac2_mast_nth_major_mnm_y3t2.php")
    Call<List<Response_model_SemesterStudyPlan_Thesis>> get_guest_pro_fac_mast2_nth_mnm_y3t2();


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

    @GET("fetch_guest_registration.php")
    Call<List<Response_model_guest_registration>> getdata_registration();

    @GET("fetch_guest_scholarship.php")
    Call<List<Response_model_guest_scholarship>> getdata_scholarship();

}
