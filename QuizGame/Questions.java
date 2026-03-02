import java.util.Arrays;

public class Questions {
    private int qid;
    private String question;
    private String optionsArr[] = new String[5];
    private String answer;
    
    public int getQid() {
        return qid;
    }
    public Questions(int qid, String question, String[] optionsArr, String answer) {
        this.qid = qid;
        this.question = question;
        this.optionsArr = optionsArr;
        this.answer = answer;
    }
    public void setQid(int qid) {
        this.qid = qid;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String[] getOptionsArr() {
        return optionsArr;
    }
    @Override
    public String toString() {
        return "Questions [qid=" + qid + ", question=" + question + ", optionsArr=" + Arrays.toString(optionsArr)
                + ", answer=" + answer + "]";
    }
    public void setOptionsArr(String[] optionsArr) {
        this.optionsArr = optionsArr;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    

}
