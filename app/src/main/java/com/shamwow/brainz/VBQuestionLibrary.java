package com.shamwow.brainz;

/**
 * Created by AngeloDesktop on 20/02/2017.
 */

public class VBQuestionLibrary {

    private String VBQuestion[] = {"What happens to the string Letter variable after applying .ToUpper?",
                                   "If the strClasslist variable contains the string “Raymond Perlta”, what will the strClasslist.IndexOf('Umali', 2)  method return?"};

    private String VBChoices [][] = {
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
    };

    private String VBCorrectAnswer[]={
            "",
            ""
    };

    public String VBgetListQuestions(int a) {
        String question = VBQuestion[a];
        return question;
    }

    public String VBgetChoicea(int a) {
        String choicea = VBChoices[a][0];
        return choicea;
    }

    public String VBgetChoiceb(int a) {
        String choiceb = VBChoices[a][1];
        return choiceb;
    }

    public String VBgetChoicec(int a) {
        String choicec = VBChoices[a][2];
        return choicec;
    }

    public String VBgetCorrectAnswer(int a) {
        String answer = VBCorrectAnswer[a];
        return answer;
    }

}
