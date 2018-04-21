package com.niksharma.quiz;

/**
 * Created by NIKHIL on 23-Jan-18.
 */

public class TrueFalse {
    private int qID;
    private boolean answer;
    TrueFalse(int id,boolean ans)
    {
        qID=id;
        answer=ans;


    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
