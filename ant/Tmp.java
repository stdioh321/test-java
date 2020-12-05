import net.bytebuddy.implementation.bind.annotation.*;
import net.bytebuddy.matcher.*;
import net.bytebuddy.*;
import net.bytebuddy.implementation.FixedValue;

@SomaDez
public class Tmp{
    Tmp(){
//         Class<?> dynamicType = new ByteBuddy()
//   .subclass(Object.class)
//   .method(ElementMatchers.named("toString"))
//   .intercept(FixedValue.value("Hello World!"))
//   .make()
//   .load(getClass().getClassLoader())
//   .getLoaded();
    }
    public void doSomething(String msg){
        System.out.println(msg.toString());        
    }
}