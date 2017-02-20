package com.shamwow.brainz;

/**
 * Created by AngeloDesktop on 20/02/2017.
 */

public class CompEssentialsQuestionLibrary {

    private String CompEssentialsQuestion[] = {"",
            ""};

    private String CompEssentialsChoices [][] = {
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
    };

    private String CompEssentialsCorrectAnswer[]={
            "",
            ""
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
