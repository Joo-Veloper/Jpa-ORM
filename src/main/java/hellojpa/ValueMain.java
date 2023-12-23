package hellojpa;

public class ValueMain {
    // 자바의 기본타입은 절대 공유 X

    public static void main(String[] args) {
        Integer a = Integer.valueOf(10);
        Integer b = a;


//        int a = 10;
//        int b = a;
//
//        a = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
