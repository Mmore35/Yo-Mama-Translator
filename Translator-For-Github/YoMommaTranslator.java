package yomommatranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class YoMommaTranslator {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        Map<String, String> Lator=new TreeMap<>();
        
        File imput=new File("acronyms.txt");
        Scanner in = new Scanner(imput);
        
        String line;
        
        while (in.hasNextLine()) {
            
            line=in.nextLine();
            String[] splitted= line.split("\\t");
            Lator.put(splitted[0].toUpperCase(), splitted[1]);
            
        }
        in.close();
        
        System.out.print("Hello \"mama\", tell me what you want to say: ");

        Scanner in1 = new Scanner(System.in).useDelimiter("\\n");
        String userinput = in1.next();//Reads full sentence 
        in1.close();

        String[] split = userinput.split("\\s+");//Splits sentence into words
        int j=-1;
        for (String Joe : split) {
           j++;
           split[j]=split[j].toUpperCase();
        }
        

        String acr;
        int i=-1;

        for (String keyS : split){
            i++;

            for (String keyL : Lator.keySet()){
               
                if (keyS.equals(keyL)){
                    String Translated = Lator.get(keyL); 
                   split[i]=Translated;
                    
                }
                
            }

        }
        
          int k=-1;
        for (String Joe : split) {
           k++;
           split[k]=Joe.toLowerCase();
           if (k==0) {
               String Up=Joe.substring(0,1);
               Up=Up.toUpperCase();
               split[k]=String.format(Up+split[k].substring(1,Joe.length()));
           }
               if (split[k].length()==1) {
                   split[k]=split[k].toUpperCase();
               }
           
        }
        
        
        
        for (String Joe : split) {
            
            System.out.print(Joe+" ");
        }
    }
   
}
