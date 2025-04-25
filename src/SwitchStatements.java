import java.util.ArrayDeque;
import java.util.Queue;

public class SwitchStatements {

    public static void main2(String[] args) {
        String str = "a";
        switch(str) {
            case "a":
                System.out.println("String is a");
                break;
            case "b":
                System.out.println("String is b");
                break;
            case "c":
                System.out.println("String is c");
                break;
            default:
                System.out.println("The string is not a b or c");
        }

        switch(str) {
            case "a" -> {
                System.out.println("String is a");
            }
            case "b" -> System.out.println("String is b");
            case "c", "d", "e", "f" -> {
                System.out.println("String is c, d, e, or f");
            }
            default -> {
                System.out.println("String is not a, b, c, d, e, or f");
            }

        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(19);
        queue.add(97);
        queue.add(85);
        queue.add(73);
        queue.add(62);
        queue.add(100);
        queue.add(-10);
        queue.add(10000);
        while (!queue.isEmpty()){
            int current = queue.poll();
            comment2(grade(current));
        }

         for(GradeLetter letter : GradeLetter.values()) {
             System.out.println(letter + ": " + letter.getComment());
         }
         GradeLetter.valueOf("INVALID_SCORE");
    }

    public static GradeLetter grade(int score) {
        if (score>=90){
            return GradeLetter.A;
        } else if (score>=80) {
            return GradeLetter.B;
        }else if (score>=70) {
            return GradeLetter.C;
        }else if (score>=61) {
            return GradeLetter.D;
        }else if (score>=0){
            return GradeLetter.F;
        }else{
            return GradeLetter.INVALID_SCORE;
        }
    }
    public static void comment(GradeLetter grade) {
        switch (grade){
            case GradeLetter.A -> System.out.println("nice");
            case GradeLetter.B -> System.out.println("uh o");
            case GradeLetter.C -> System.out.println("lock in");
            case GradeLetter.D -> System.out.println("try again next year");
            case GradeLetter.F -> System.out.println("dogpoo");
            default -> System.out.println("Invaild");
        }
    }
    public static void comment2(GradeLetter grade) {
        String comment = grade.getComment();
        System.out.println(comment);
    }

    public enum GradeLetter {
        A("nice"),
        B("uh o"),
        C("lock in"),
        D("try again next year"),
        F,
        INVALID_SCORE;

        private final String comment;
        GradeLetter() {
            comment = "No comments";
        }
        GradeLetter(String comment) {
            this.comment = comment;
        }

        public String getComment() {
            return comment;
        }
    }
}
