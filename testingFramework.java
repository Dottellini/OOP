/**
A minimalistic testing framework for use with the assert statement
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Author: https://github.com/denkspuren/, Version 1.3, CC BY-NC-SA
The following methods improve the way to formulate tests with assert statements.
This very tiny framework is primarily intended for programmers who use Java's
JShell for smaller self-contained programs and would like to include and write
tests in the simplest possible way using assert statements. The tests included
also serve as a demonstration of that kind of coding and testing practice.
The idea of testing with assert statements is elaborated on and demonstrated in
the other file that comes with the gist this file is in:
https://gist.github.com/denkspuren/c379cd6d4512144e595d1dab98bba5ff
How to use this framework?
- Download this code. Name the file `testingFramework.java`
- Use `/open testingFramework.java` in your JShell file
To automatically provide this framework, run it as a startup script:
~~~
jshell> /set start testingFramework.java
jshell> /reset
jshell> /set start -retain
~~~
(see https://docs.oracle.com/en/java/javase/19/jshell/scripts.html)
*/

// Issue a warning if assertions are not enabled
AssertionError ae;
try { assert false; } catch (AssertionError exception) { ae = exception; }
if (ae == null) System.out.println("WARNING: Turn assertions on for testing puposes, run \"jshell -R-ea\"");

// beTrue: Value assignments and calls to void methods always return true
boolean beTrue(Runnable... methods) { for (Runnable method : methods) method.run(); return true; }
boolean beTrue(Object... values) { return true; }

// isCaught: If expected exception is caught return true, false otherwise.
boolean isCaught(Runnable method, Class... exceptionClasses) {
    try {
        beTrue(method);
        return false;
    } catch (Throwable e) {
        for (Class exceptionClass : exceptionClasses)
            if (exceptionClass.isInstance(e)) return true;
        return false;
    }
}

// Framework tests
{ // create own scope to not pollute scope of framework user
class Test {
    int i, j;
    void method() { }
    void method(int i) { }
}

Test t = new Test();
String intent;

intent = "Test different use cases for beTrue";
assert beTrue() && beTrue(t.i = 3) && beTrue(t.i = 3, t.j = 4) &&
       beTrue(t::method) && beTrue(t::method, t::method) &&
       beTrue(() -> t.method(3)) : intent;

intent = "Test different use cases for isCaught";
assert !isCaught(() -> { assert true; }, AssertionError.class) &&
       isCaught(() -> { assert false; }, AssertionError.class) &&
       !isCaught(() -> { throw new UnsupportedOperationException(); }, AssertionError.class) &&
       !isCaught(() -> { throw new AssertionError(); }, UnsupportedOperationException.class) &&
       isCaught(() -> { assert false; }, UnsupportedOperationException.class, AssertionError.class) &&
       isCaught(() -> { assert false; }, Error.class) : intent;
}