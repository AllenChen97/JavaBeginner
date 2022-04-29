package A_Basic.异常;


/*
* 常用异常 NullpointerException空指针异常，Exception数组索引抄
*
* 1. what problems is it dueling with?
* 2. how it works?
*   exceptions can be classified as 'defined exceptions' and 'undefined exceptions'.
*   'defined exception' is like the problems of the program might happen.
*   Therefore, when invoking the method have 'defined exception', it must throw exceptions to the above user or dueling with try catch block.
* */
public class _Catch_Exception {
    public static void main(String[] args) {

        try {
            System.out.println(10/0);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            e.printStackTrace();                //在另外一个线程执行

        myException m = new myException("逼逼赖赖");
        m.printStackTrace();
        }
    }
}

class myException extends Exception{
    public myException() {
    }

    public myException(String message) {
        super(message);
    }
}