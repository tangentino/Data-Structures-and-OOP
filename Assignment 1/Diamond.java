public class Diamond {
    public static void printDiamond(int k) {
        int i,j;
        int spaces = 1;
        int x = 1;
        for (i=1; i<=(2*k-1); i+=2) { //1,3,5,7
            for (int n = spaces; n<=k; n++) {
                System.out.print('#');
            }
            for (j=1; j<=i; j++) {
                System.out.print('*');
            }
            for (int n = spaces; n<=k; n++) {
                System.out.print('#');
            }
            System.out.println();
            spaces++;
        }
        for (i=2*k-3; i>=1; i-=2) { //5,3,1
            for (int n = 0; n<=x; n++) {
                System.out.print('#');
            }
            for (j=1; j<=i; j++) {
                System.out.print('*');
            }
            for (int n = 0; n<=x; n++) {
                System.out.print('#');
            }
            System.out.println();
            x++;
        }
        
    }
}