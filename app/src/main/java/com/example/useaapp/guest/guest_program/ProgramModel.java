package com.example.useaapp.guest.guest_program;

public class ProgramModel {
    private final String Subject_program,Credit_program,Hour_program,Label_program;

    public ProgramModel(String subject_program, String credit_program, String hour_program, String label_program) {
        Subject_program = subject_program;
        Credit_program = credit_program;
        Hour_program = hour_program;
        Label_program = label_program;
    }

    public String getSubject_program() {
        return Subject_program;
    }

    public String getCredit_program() {
        return Credit_program;
    }

    public String getHour_program() {
        return Hour_program;
    }

    public String getLabel_program() {
        return Label_program;
    }
}
