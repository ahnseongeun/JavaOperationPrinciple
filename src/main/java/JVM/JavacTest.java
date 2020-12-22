package JVM;

import javax.crypto.Cipher;
import java.util.List;

public class JavacTest {
    static String myName; //다른 클래스에서 변수 공유 가능

    static {
        myName="myName is JVM.JavacTest";
    }

    public static void main(String[] args){
        System.out.println(JavacTest.class.getClassLoader());
        System.out.println(List.class.getClassLoader());
        System.out.println(Cipher.class.getClassLoader());
        System.out.println(JavacTest.class.getSuperclass()); //상속받은 부모 클래스를 확인할수 있다.
        System.out.println(JavacTest.class.getClass());
        System.out.println(JavacTest.class.getPackage());
        Class<JVMLoading> jvmLoadingClass = JVMLoading.class;
        System.out.println(jvmLoadingClass);
        new InheritanceTest().Inheritance();
    }
}
