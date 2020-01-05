package Cryptography;

import java.net.http.HttpConnectTimeoutException;

public class Process {
    private char[] Plaintext;
    private char[] Ciphertext;
    private char[] en_Temp;
    private char[] de_Temp;
    private char[] de_Plaintext;

    public String getHex(){
        byte[] temp1 = new byte[Ciphertext.length];
        for(int i=0;i<Ciphertext.length;i++){
            temp1[i] = (byte) Ciphertext[i];
        }

        return bytesToHexString(temp1);
    }

    private String bytesToHexString(byte[] bytes) {
        if (bytes == null) return null;
        StringBuilder ret = new StringBuilder(2 * bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            int b;
            b = 0x0f & (bytes[i] >> 4);
            ret.append("0123456789abcdef".charAt(b));
            b = 0x0f & bytes[i];
            ret.append("0123456789abcdef".charAt(b));
        }
        return ret.toString();
    }

    public void Affine_encrytion(){
        //初始化密文空间
        en_Temp = new char[Plaintext.length];
        //对每个明文字节进行仿射加密
        for(int i=0;i<Plaintext.length;i++){
            int x = Plaintext[i] - 'A';
            x = (x*Key.a+Key.b)%26;
            en_Temp[i] = (char)(x+'A');
        }

    }
    public void Affien_decrytion(){
        de_Plaintext = new char[Plaintext.length];
        //对每个密文进行仿射解密
        for(int i=0;i<de_Temp.length;i++){
            int ans;
            int x = de_Temp[i] - 'A';
            x -= Key.b;
            ans = x*(15);
            ans = ans % 26;
            if(ans<0) de_Plaintext[i] = (char)(ans+26+'A');
            else de_Plaintext[i] = (char)(ans+'A');
        }
    }
    public void P(){
        char[] temp = new char[en_Temp.length];
        //对照数组下标进行置换操作
        for(int i=0;i< en_Temp.length;i++){
            temp[Key.P[i%16]] = en_Temp[i];
        }
        en_Temp = temp;

    }
    public void rev_P(){
        char[] temp = new char[de_Temp.length];
        //对照反向P盒进行解密操作
        for(int i=0;i< de_Temp.length;i++){
            temp[Key.rev_P[i%16]] = de_Temp[i];
        }
        de_Temp = temp;
    }
    public void S(){
        Ciphertext = new char[Plaintext.length];
        for(int i=0;i<en_Temp.length;i++){
            Ciphertext[i] =  (char)Key.s_box[en_Temp[i]];
        }
    }
    public void rev_S(){
        de_Temp = new char[Ciphertext.length];
        for(int i=0;i<Ciphertext.length;i++){
            de_Temp[i] =(char) Key.inv_s_box[Ciphertext[i]];
        }
    }

    public char[] getPlaintext() {
        return Plaintext;
    }

    public void setPlaintext(char[] plaintext) {
        Plaintext = plaintext;
    }

    public char[] getCiphertext() {
        return Ciphertext;
    }

    public void setCiphertext(char[] ciphertext) {
        Ciphertext = ciphertext;
    }

    public char[] getEn_Temp() {
        return en_Temp;
    }

    public void setEn_Temp(char[] en_Temp) {
        this.en_Temp = en_Temp;
    }

    public char[] getDe_Temp() {
        return de_Temp;
    }

    public void setDe_Temp(char[] de_Temp) {
        this.de_Temp = de_Temp;
    }

    public char[] getDe_Plaintext() {
        return de_Plaintext;
    }

    public void setDe_Plaintext(char[] de_Plaintext) {
        this.de_Plaintext = de_Plaintext;
    }
}
