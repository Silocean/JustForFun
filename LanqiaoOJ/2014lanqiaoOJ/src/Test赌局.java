public class Test¶Ä¾Ö {

    private static int m = 0;
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        for(int i=0; i<500000; i++) {
            int p = (int)(Math.random()*6+1);
            int a = (int)(Math.random()*6+1);
            int b = (int)(Math.random()*6+1);
            int c = (int)(Math.random()*6+1);
            m += Pay(p, a, b, c);
        }
        float pl = Math.round(m / 500.0f) / 1000.0f;
        System.out.println(pl);
    }
    public static int Pay(int p, int a, int b, int c) {
        if(p==a && p==b && p==c) return -6;
        if(p==a && p==b) return -2;
        if(p==a && p==c) return -2;
        if(p==b && p==c) return -2;
        if(p==a || p==b || p==c) return -1;
        if(p*a==b*c || p*b==a*c || p*c == a*b) return 0;
        return 1;
    }

}
