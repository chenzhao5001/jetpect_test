package utils;


abstract class A<T> {
    T m;
    T getType() {
        return m;
    }
}
public class Test {
    A a = new A<String>(){};
}
