import java.util.Arrays;

public class IntSort {
    public static void main(String[] args) {
        int[] tab =  new int[args.length];
        Int[] tabInt = new Int[args.length];

        for (int i = 0; i < args.length; i++) {
        	tabInt[i] = new Int();
            for (int j = 0; j < args[i].length(); j++) {
            	int n = args[i].charAt(j) - '0';
                tab[i] = tab[i] * 10 + n;
                tabInt[i].setValue(tabInt[i].getValue() * 10 + n);
            }
        }

       sort(tab);
       sort1(tabInt);

       System.out.println(Arrays.toString(tab));
       System.out.println(Arrays.toString(tabInt));
    }

	public static void sort(int[] tab) {
    	for (int i = 0; i < tab.length; i++) {
            for (int j = 1; j < tab.length - i; j++) {
                if (tab[j - 1] > tab[j]) {
                    int temp = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = temp;
                }
            }
        }
    }
	
    public static Int[] swap1(Int[] tab, int el1, int el2) {
        Int tmp =  tab[el1];
        tab[el1] = tab[el2];
        tab[el2] = tmp;

        return tab;
    }

    public static Int[] sort1(Int[] tab) {
        for (int i = 0; i < tab.length ; i++ ) {
            for (int j = 1; j < tab.length - i; j++ ) {
                if (tab[j - 1].getValue() > tab[j].getValue()) {
                    tab = swap1(tab, j, j - 1);
                }
            }
        }

        return tab;
    }

    public static void sort2(Int[] tab) {
    	for (int i = 0; i < tab.length; i++) {
            for (int j = 1; j < tab.length - i; j++) {
                if (tab[j - 1].getValue() > tab[j].getValue()) {
                    swap2(tab[j-1], tab[j]);
                }
            }
        }
    }
    
    public static void sort3(Int[] tab) {
    	for (int i = 0; i < tab.length; i++) {
            for (int j = 1; j < tab.length - i; j++) {
                if (tab[j - 1].getValue() > tab[j].getValue()) {
                    tab[j-1].swapValueWith(tab[j]);
                }
            }
        }
    }
    
    public static void swap2(Int int1, Int int2) {
    	int temp = int1.getValue();
    	int1.setValue(int2.getValue());
    	int2.setValue(temp);
    }
}