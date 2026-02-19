package user.implementation;

import java.util.*;   // Checkstyle: wildcard import

public class StaticAnalysisValidationTest {

    private String name;

    public StaticAnalysisValidationTest(String name) {
        this.name = name;
    }

    public void triggerNullPointer() {
        String s = null;
        System.out.println(s.length()); // SpotBugs: null dereference
    }

    public void unusedVariableExample() {
        int unusedVar = 10; // PMD: unused variable
    }

    public void emptyCatchBlock() {
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            // PMD: empty catch block
        }
    }

    public boolean highComplexity(int a, int b, int c, int d, int e) {
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
        return false; // PMD: high cyclomatic complexity
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StaticAnalysisValidationTest) {
            StaticAnalysisValidationTest other =
                    (StaticAnalysisValidationTest) obj;
            return this.name == other.name; // SpotBugs: string comparison using ==
        }
        return false;
    }

    public void formattingIssue(){
    System.out.println("Bad indentation"); // Spotless: formatting issue
    }

}
