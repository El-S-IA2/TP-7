import java.io.*;
import java.text.Normalizer;


public class Codeur {

   public static String normalize(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("[\u0300-\u036F]", "")
                .toUpperCase();
    }

    public static void main(String[] args) throws IOException {

       if (args.length!=4)
    		erreur("4 arguments requis");
    	
       int cle=-1;
       try{
        	cle = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
        	erreur ("args[0] doit etre un entier");
        }
       
       if (cle<1 | cle>25) erreur("clé invalide");
       
        int cle = Integer.parseInt(args[0]);
        String type = args[1];
        Cesar cesar = new Cesar(cle);
        String line;
         
       File file=new File(args[2]);
        if(!file.exists()) erreur ("fichier introuvable");
        if(!file.isFile()) erreur ("fichier invalide");
        BufferedReader lecteur = new BufferedReader(new FileReader(file));

        FileWriter e = new FileWriter(args[3]);
        BufferedWriter ecriture = new BufferedWriter((e));


            if (args[1].equals("code"))        {
            while ((line = lecteur.readLine()) != null)
            {
                ecriture.write(cesar.code(line));
                ecriture.write("\n");
            }
            ecriture.close();
            lecteur.close();
        }
            else if(args[1].equals("decode"))            {
                while ((line = lecteur.readLine()) != null)
                {
                ecriture.write(cesar.deCode(line));
                ecriture.write("\n");
                }
                ecriture.close();
                lecteur.close();
            }
       else erreur("type de procedure invalide");
    }
   
     static void erreur(String msg) {
    	System.err.println(msg);
    	System.exit(1);
    }
}







