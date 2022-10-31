package entity;

public class Answer {
    private int id;
    private String  content;
    private Question question;
    private boolean isCorrect;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

}
