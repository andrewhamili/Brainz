package com.shamwow.brainz;

/**
 * Created by AngeloDesktop on 20/02/2017.
 */

public class MySQLQuestionLibrary {

    private String MySQLQuestion[] = {"",
                                   ""};

    private String MySQLChoices [][] = {
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
    };

    private String MySQLCorrectAnswer[]={
            "",
            ""
    };

    public String MySQLgetListQuestions(int a) {
        String question = MySQLQuestion[a];
        return question;
    }

    public String MySQLgetChoicea(int a) {
        String choicea = MySQLChoices[a][0];
        return choicea;
    }

    public String MySQLgetChoiceb(int a) {
        String choiceb = MySQLChoices[a][1];
        return choiceb;
    }

    public String MySQLgetChoicec(int a) {
        String choicec = MySQLChoices[a][2];
        return choicec;
    }

    public String MySQLgetCorrectAnswer(int a) {
        String answer = MySQLCorrectAnswer[a];
        return answer;
    }
}
