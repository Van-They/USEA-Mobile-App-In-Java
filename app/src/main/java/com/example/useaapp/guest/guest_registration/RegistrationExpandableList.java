package com.example.useaapp.guest.guest_registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegistrationExpandableList {

    public static HashMap<String , List<String>> getData() {

        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        List<String> cricket = new ArrayList<>();
        cricket.add("លក្ខខណ្ឌក្នុការចុះឈ្មោះចូលរៀន\n" +
                "ថ្នាក់បរិញ្ញាបត្រនៅ USEA\n" +
                "-  សញ្ញាបត្របញ្ជាក់ជាប់បាក់ឌុប ២សន្លឹក\n" +
                "-  រូបថត ៣ x ៤ ៤សន្លឹក\n" +
                "-  រូបថត ៤ x ៦ ៣សន្លឹក ");

        List<String> football = new ArrayList<>();
        football.add("ចំពោះថ្នាក់បរិញ្ញាបត្រ យើងធ្វើការសិក្សា រយៈពេល៤ឆ្នាំទាំងអស់ លើកលែងតែ" +
                "មុខជំនាញស្ថាបត្យកម្មដែលត្រូវសិក្សារយៈពេល៥ឆ្នាំ ");

        List<String> basketball = new ArrayList<>();
        basketball.add("សាកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ" +
                "មានទីតាំងស្ថិតនៅ ទល់មុខវិទ្យាល័យអង្គរ" +
                "ក្រុងសៀមរៀប ខេត្តសៀមរាប");

        expandableListDetail.put("ការចុះឈ្មោះចូលរៀនសម្រាប់ថ្នាក់បរិញ្ញាបត្ររង",cricket);
        expandableListDetail.put("ការចុះឈ្មោះចូលរៀនសម្រាប់ថ្នាក់បរិញ្ញាបត្រ",football);
        expandableListDetail.put("ការចុះឈ្មោះចូលរៀនសម្រាប់ថ្នាក់បរិញ្ញាបត្រជាន់ខ្ពស់",basketball);

        return expandableListDetail;
    }
}
