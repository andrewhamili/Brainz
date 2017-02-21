package com.shamwow.brainz;

/**
 * Created by AngeloDesktop on 20/02/2017.
 */

public class CompEssentialsQuestionLibrary {

    private String CompEssentialsQuestion[] = {
            "1. Which one of the following would be described as software?",
            "2. A laptop is mst likely to have which one of the following input devices ftted as standard",
            "3. Which one of the following is the cpu in a computer",
            "4. Which one of the following describes window xp",
            "5. Which one of the following is a kilobyte",
            "",};

    private String CompEssentialsChoices [][] = {
            {"Printer","Internet browser","Keyboard"},
            {"Scanner","Mouse","Touchpad"},
            {"Control Process Unit","Calculating Process Unit","Central Processing Unit"},
            {"An operating system","A database application","A backup utility"},
            {"1000 bytes","1024 bits","1024 bytes"},
            {"","",""},
    };

    private String CompEssentialsCorrectAnswer[]={
            "Internet browser",
            "Touchpad",
            "Central Processing Unit",
            "An operating system",
            "1024 bytes",
            "",
    };

    public String CompEssentialsgetListQuestions(int a) {
        String question = CompEssentialsQuestion[a];
        return question;
    }

    public String CompEssentialsgetChoicea(int a) {
        String choicea = CompEssentialsChoices[a][0];
        return choicea;
    }

    public String CompEssentialsgetChoiceb(int a) {
        String choiceb = CompEssentialsChoices[a][1];
        return choiceb;
    }

    public String CompEssentialsgetChoicec(int a) {
        String choicec = CompEssentialsChoices[a][2];
        return choicec;
    }

    public String CompEssentialsgetCorrectAnswer(int a) {
        String answer = CompEssentialsCorrectAnswer[a];
        return answer;
    }
}
