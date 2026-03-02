class Main{
    public static void main(String[] args) {
        // int a = 10;
        // System.out.println(a);
        QuestionService service = new QuestionService();
        service.displayQuestions();
        service.printScore();
    }
}