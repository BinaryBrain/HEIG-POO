import java.util.*;

public class IntSort {
    public static void main(String[] args) {
        int[] tab =  new int[args.length];

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                tab[i] = tab[i] * 10 + args[i].charAt(j) - '0';
            }
        }

        for (int i = 0; i < tab.length ; i++ ) {
            for (int j = 1; j < tab.length - i; j++ ) {
                if (tab[j - 1] > tab[j]) {
                    int temp = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(tab));
    }
    public Int[] static swap(Int[] tab, int el1, int el2) {
        Int tmp =  tab[el1];
        tab[el1] = tab[el2];
        tab[el2] = tmp;

        return tab;
    }

    public static Int[] sort1(Int[] tab) {
        for (int i = 0; i < tab.length ; i++ ) {
            for (int j = 1; j < tab.length - i; j++ ) {
                if (tab[j - 1] > tab[j]) {
                    tab = swap(tab, j, j - 1);
                }
            }
        }

        return tab;
    }
}