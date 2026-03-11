package user.implementation;  // Checkstyle may flag package structure depending on config


import java.util.*;   // Wildcard import (Checkstyle violation)

public class StaticAnalysisTestSample {   // Class name OK, but issues inside

    private String name;  // Might trigger SpotBugs if misused

    public StaticAnalysisTestSample(String name) {
        this.name = name;
    }

    public void triggerNullPointer() {
        String s = null;
        System.out.println(s.length());  // SpotBugs: Null pointer dereference
    }

    public void unusedVariableExample() {
        int unusedVar = 10;   // PMD: Unused local variable
    }

    public void emptyCatchExample() {
        try {
            int x = 5 / 0;
        } catch (Exception e) {
            // PMD: Empty catch block
        }
    }

    public boolean complexMethod(int a, int b, int c, int d, int e) {
        // PMD: High cyclomatic complexity
        if (a > 0) {
            if (b > 0) {
                if (c > 0) {
                    if (d > 0) {
                        if (e > 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        // SpotBugs: equals without hashCode
        if (obj instanceof StaticAnalysisTestSample) {
            StaticAnalysisTestSample other = (StaticAnalysisTestSample) obj;
            return this.name == other.name;  // SpotBugs: String comparison using ==
        }
        return false;
    }

    public void formattingIssue(){
    System.out.println("Bad indentation");   // Spotless should flag formatting
    }

    public void longMethod() {
        // PMD may flag long method or too many statements
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
