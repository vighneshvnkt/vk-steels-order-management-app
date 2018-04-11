/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sooad;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author vighnesh
 */
public class Parser {
    String[] values={"VXpopop","10.10.10"};
    Parser(int s_no){
        
        try{
        
        Scanner sc = new Scanner(new File("src/sooad/temp/template.html"));
        File out = new File("src/sooad/temp/output.html");
        out.createNewFile();
        PrintWriter p = new PrintWriter(out);
        String s = "";
        int i=0;
        while (sc.hasNextLine()) {
            s=sc.nextLine();
            if(!s.contains("##"))
                p.write(s+"\n");
            else{
                s=s.replace("##", values[i++]);
                p.write(s+"\n");
            }
        }
        p.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    void parse(){
        
    }
}
