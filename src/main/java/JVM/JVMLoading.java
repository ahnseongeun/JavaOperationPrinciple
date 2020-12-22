package JVM;

public class JVMLoading {
    /**
     * 로딩을 하고나면 아래와 같이 class타입이 만들어지고 instance를 생성해서 접근이 가능하다.
     */
    public static void loading(){
        Class<JVMLoading> jvmLoadingClass = JVMLoading.class;
        System.out.println(jvmLoadingClass);

        //인스턴스가 존재한다면 인스턴스를 사용해서 그 객체에 접근이 가능하다.
        JVMLoading jvm=new JVMLoading();
        System.out.println(jvm.getClass());
    }
    private static void ClassLoaderTest() {
        ClassLoader classLoader= JVMLoading.class.getClassLoader();
        System.out.println(classLoader); //App ClassLoader
        System.out.println(classLoader.getParent());//Platform ClassLoader
        System.out.println(classLoader.getParent().getParent());//Bootstrap인데 볼수가 없다. native로 되어있기 때문에 VM마다 다 다르다.
    }

    public static void main(String[] args){
        loading();
        ClassLoaderTest();
    }
}
