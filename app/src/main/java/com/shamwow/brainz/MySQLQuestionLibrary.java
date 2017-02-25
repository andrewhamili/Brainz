package com.shamwow.brainz;

/**
 * Created by AngeloDesktop on 20/02/2017.
 */

public class MySQLQuestionLibrary {

    private String MySQLQuestion[] = {"1. A ____ is a question or a request.",
            "2. Close MySQL connection",
            "3. What does PDO stands for",
            "4. The ____ statement is used to create a database in MySQL.",
            "5. MySQL is the world's most popular open source ____",
            "",};

    private String MySQLChoices[][] = {
            {"Expansion", "Query", "Extension"},
            {"mysql_escape_string", "mysql_close", "mysql_connect"},
            {"Presenting Direct Objection", "Payment Deposit Office", "PHP Data Objects"},
            {"CREATE DATABASE", "CREATE", "CREATE TABLE"},
            {"Database", "Website", "System"},
            {"", "", ""},
    };

    private String MySQLCorrectAnswer[] = {
            "Query",
            "mysql_close",
            "PHP Data Objects",
            "CREATE DATABASE",
            "Database",
            "",
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
