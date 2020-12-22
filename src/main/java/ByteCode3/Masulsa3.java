package ByteCode3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa3 {
    public static void main(String[] args){
        /**
         * class를 읽기전에 먼저 byte코드가 조작되어있어야 한다.
         * 이 방법은 classLoader 순서를 고려한 것이라서 실행하면 되기는 하지만 너무 classLoader순서에 의존적이다.
         *
         */
        ClassLoader classLoader = Masulsa3.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);
        try {
            new ByteBuddy().redefine(
                    typePool.describe("ByteCode3.Moja").resolve(),
                    ClassFileLocator.ForClassLoader.of(classLoader))
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit123!"))
                    .make().saveIn(new File("C:\\Users\\ahn\\OneDrive\\바탕 화면\\Spring boot\\JavaOperationPrinciple\\target\\classes\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new Moja().pullOut());
    }
}
