import jdk.incubator.vector.IntVector;

public class SIMD {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        int[] a = new int[400000000];
        int[] b = new int[400000000];
        int[] c = add(a, b);
//        int[] c = addSIMD(a, b);
        System.out.println(c[0]);
    }

    private static int[] add(int[] a, int[] b) {
        int [] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    private static int[] addSIMD(int[] a, int[] b) {
        IntVector va = IntVector.fromArray(IntVector.SPECIES_PREFERRED, a, 0);
        IntVector vb = IntVector.fromArray(IntVector.SPECIES_PREFERRED, b, 0);
        IntVector vc = va.add(vb);
        int[] c = new int[a.length];
        vc.intoArray(c, 0);
        return c;
    }
}
