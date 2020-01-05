package Cryptography;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        char[] temp = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'};
        Process process = new Process();
        process.setPlaintext(temp);
        process.Affine_encrytion();
        System.out.println(Arrays.toString(process.getPlaintext()));
        System.out.println(Arrays.toString(process.getEn_Temp()));
        process.P();
        System.out.println(Arrays.toString(process.getEn_Temp()));
        process.S();
        System.out.println(Arrays.toString(process.getCiphertext()));
        process.rev_S();
        System.out.println(Arrays.toString(process.getDe_Temp()));
        process.rev_P();
        System.out.println(Arrays.toString(process.getDe_Temp()));
        process.Affien_decrytion();
        System.out.println(Arrays.toString(process.getDe_Plaintext()));
    }
}
