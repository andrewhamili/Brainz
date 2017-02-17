package com.shamwow.brainz;

/**
 * Created by AngeloDesktop on 17/02/2017.
 */

public class QuestionLibrary{

    private String ListQuestion[] = {   "What is Routing?",
                                        "What is the purpose of the Data Link?",
                                        "What is a Window in networking terms?",
                                        "What is MTU?",
                                        "What is HDLC?"};

    private String ListChoices[][]=
            {
                    {"Routing is the process of finding a path",
                     "Routing is Cisco.",
                     "Routing is not a part of cisco."},

                    {"The job of the Data Link layer is to check messages are sent to the right device.",
                     "The job of the Data Link layer is to answer messages are sent to the right device.",
                     "The job of the Data Link layer is to transfer messages to the right device."},

                    {"A Window refers to the number of segments that is allowed to be sent from source to destination before an acknowledgement is sent back.",
                     "A Window refers to the number of segments that is allowed to be sent from destination to source before an acknowledgement is sent back.",
                     "A Window refers to the number of segments that is not allowed to be sent from source to destination before an acknowledgement is sent back."},

                    {"Maximum Transfer Unit",
                     "Minimum Transmission Unit",
                     "Maximum Transmission Unit"},

                    {"High Level Data Link Control",
                     "Higher Level Data Link Control",
                     "High Level Data Linking Control"}
            };


            private String CorrectAnswers[]={"Routing is the process of finding a path",
                                            "The job of the Data Link layer is to check messages are sent to the right device.",
                                            "A Window refers to the number of segments that is allowed to be sent from destination to source before an acknowledgement is sent back.",
                                            "Maximum Transmission Unit",
                                            "High Level Data Link Control"};

    public String getListQuestions(int a){
        String question = ListQuestion[a];
        return  question;
    }

    public String getChoicea(int a){
        String choicea = ListChoices[a][0];
        return choicea;
    }

    public String getChoiceb(int a){
        String choiceb = ListChoices[a][1];
        return choiceb;
    }

    public String getChoicec(int a){
        String choicec = ListChoices[a][2];
        return  choicec;
    }

    public String getCorrectAnswer(int a){
        String answer= CorrectAnswers[a];
        return answer;
    }







    }






