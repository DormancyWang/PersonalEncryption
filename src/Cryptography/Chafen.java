package Cryptography;

public class Chafen {
    int[] x1 = new int[16];
    int[] x = new int[16];
    Process pro = new Process();
    boolean flagx = true;
    boolean flagx1 = true;
    public void Analysis(){
        while(flagx1){
            increase(x1);
            while (flagx) {
                increase(x);
                char[] temp = new char[16];
                for(int i=0;i<16;i++){
                    temp[i] = (char)(x[i]+x1[i]+'A');
                }
                pro.setPlaintext(temp);
                pro.Affine_encrytion();
                pro.rev_P();
                pro.rev_S();
                pro.getCiphertext();
            }
        }
    }

    private void increase(int[] x) {
        x[15] += 1;
        for (int i = 15; i > 0; i--) {
            if (x[i] == 26) {
                x[i] = 0;
                x[i - 1] += 1;
            }
        }
        if (x[0] == 26&&x==this.x) flagx = false;
        if (x[0] == 26&&x==this.x1) flagx1 = false;
    }
}
