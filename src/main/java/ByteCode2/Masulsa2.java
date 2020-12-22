package ByteCode2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa2 {
    public static void main(String[] args){
        /**
         * 아래 ByteBuddy를 사용하면 .java는 그대로인데 byte코드를 변환할수 있다.
         * 객체를 먼저 생성하면 classloader를 사용하기 때문에 바이트 코드를 조작할때는
         * 먼저 조작을 하고 객체를 만들어서 출력해야한다.
         * 컴파일을 다시하면 원래 .java코드로 다시 .class파일이 만들어 진다.
         */
        try {
            new ByteBuddy().redefine(Moja.class)
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                    .make().saveIn(new File("C:\\Users\\ahn\\OneDrive\\바탕 화면\\Spring boot\\JavaOperationPrinciple\\target\\classes\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new Moja().pullOut());
    }
}
