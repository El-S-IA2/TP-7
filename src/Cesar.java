/**
 *  La classe Cesar
 */

public class Cesar {
    int cle;
    

    public Cesar(int cle) {
        this.cle = cle%26;
        if (cle<0)
        	this.cle+=26;
    }

    public char code(char c) {
        if ((c >='a' && c <= 'z') | (c>= 'A' && c<= 'Z'))
        {
            int numc = (int) c + this.cle;
            c = (char) numc;
        }
        return c;
    }

    public char deCode(char c) {
        if ((c >='a' && c <= 'z') | (c>= 'A' && c<= 'Z'))
        {
            return (char) ((int) (c) - this.cle);
        }
        return c;
    }

    public String code(String s) {
        String neW="";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            neW+=code(c);
        }
        return neW;
    }

    public String deCode (String s){
        String S ="";
        for (int i = 0; i < s.length(); i++)
        {
            char c = deCode(s.charAt(i));
            S += c;
        }
        return S;
    }
}
