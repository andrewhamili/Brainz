package com.shamwow.brainz;

/**
 * Created by AngeloDesktop on 17/02/2017.
 */

public class CiscoQuestionLibrary {

    private String CiscoListQuestion[] = {"1. In what class does this IP address belong to? 170.20.0.1",
            "2. What is the purpose of the Data Link?",
            "3. In the CIDR notation, what subnet mask does /27 represent?",
            "4. What is MTU?",
            "5. What is HDLC?",
            "6. What is the \"magic\" command to reverse the changes or command entered in the global configuration?",
            "7. What is the shortcut key (Windows) command for exiting a mode?",
            "8. 255.0.224.0 is a valid is an invalid subnet mask, how should it be written?",
            "9. Which type of connector does a NIC use?",
            "10. What is the 6th osi layer?",
            ""};

    private String CiscoListChoices[][] =
            {
                    {"Class A",
                     "Class B",
                     "Class C"},

                    {"The job of the Data Link layer is to check messages are sent to the right device.",
                            "The job of the Data Link layer is to answer messages are sent to the right device.",
                            "The job of the Data Link layer is to transfer messages to the right device."},

                    {"255.255.255.128",
                     "255.255.255.240",
                     "255.255.255.224"},

                    {"Maximum Transfer Unit",
                            "Minimum Transmission Unit",
                            "Maximum Transmission Unit"},

                    {"High Level Data Link Control",
                            "Higher Level Data Link Control",
                            "High Level Data Linking Control"},

                    {"disble", "no", "erase"},
                    {"Ctrl + Z","ALT + F4","Ctrl + C"},
                    {"224.255.0.0","255.0.0.0","None of the above"},
                    {"RJ-45","RJ-11","PS-2"},
                    {"Network","Presentation","Transport"},
                    {"","",""}

            };


    private String CiscoCorrectAnswers[] = {"Class B",
            "The job of the Data Link layer is to check messages are sent to the right device.",
            "255.255.255.224",
            "Maximum Transmission Unit",
            "High Level Data Link Control",
            "no",
            "Ctrl + C",
            "224.255.0.0",
            "RJ-45",
            "Presentation",
            ""};

    public String getListQuestions(int a) {
        String question = CiscoListQuestion[a];
        return question;
    }

    public String getChoicea(int a) {
        String choicea = CiscoListChoices[a][0];
        return choicea;
    }

    public String getChoiceb(int a) {
        String choiceb = CiscoListChoices[a][1];
        return choiceb;
    }

    public String getChoicec(int a) {
        String choicec = CiscoListChoices[a][2];
        return choicec;
    }

    public String getCorrectAnswer(int a) {
        String answer = CiscoCorrectAnswers[a];
        return answer;
    }


}






