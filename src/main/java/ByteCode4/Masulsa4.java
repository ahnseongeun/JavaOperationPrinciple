package ByteCode4;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa4 {
    public static void main(String[] args){
        /**
         * 외부 Jar파일 이용
         * 이전에 했던 방법은 class파일 자체를 변경하는 것이다.
         * 하지만 외부 Jar파일을 이용해서 하는 방법은 javaagent가 하는일과 관련있다.
         * classloding할때 byte코드를 변경 시켜서 메모리에 변경된 byte코드를 올린다.
         * class파일에서는 변경되지 않은 것을 볼수 있지만 메모리에 올라갈때는 변경된 byte코드가 올라간다.
         */
        System.out.println(new Moja().pullOut());
    }
}
