/*
 * Permuter Project
 * PermuterChecker.java
 * Purpose: Prints all permutations of a String using recursion
 *  to form each permutation, and iteration to go through all
 *  of the possibilities. Only works on small strings.
 *
 * @author Jayden Navarro
 * @version 1.0 2/25/14
 */

public class PermuterChecker {
    public static void main(String[] args) {
        String s = "123456";
        for (int i = 1; i <= perms(s.length()); i++) {
            System.out.println(buildPerm(s, i));
        }
    }

    // returns permuted String by recursively calculating
    //  permutation of a substring.
    public static String buildPerm(String s, int loc) {

        if (s.length() == 1) return s;
        String pass = "";
        String build = "";
        int pos = (int) Math.ceil((double) loc / (double) perms(s.length()-1));

        for (int i = 0; i < s.length(); i++) {
            if (i != pos-1) pass += s.charAt(i);
        }


        build += s.charAt(pos-1);

        build += buildPerm(pass, loc - (pos-1)*perms(s.length()-1));

        return build;
    }

    // returns number of permutations possibly with size n
    public static int perms(int n) {
        int factorial = n;
        for (int i = n-1; i > 1; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
