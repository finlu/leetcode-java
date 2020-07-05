package ds.stack.test;

import ds.stack.StackExample;

public class TestStackExample {
    private static final StackExample stackExample = new StackExample();

    public static void testIsValid() {
        assert stackExample.isValid("()");
        assert stackExample.isValid("()[]{}");
        assert !stackExample.isValid("(]");
        assert !stackExample.isValid("([)]");
        System.out.println("Your code is AC!!!");
    }

    public static void main(String[] args) {
        testIsValid();
    }
}
