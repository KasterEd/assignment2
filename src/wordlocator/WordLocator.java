package wordlocator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.TreeSet;

public class WordLocator implements WordLocatorInterface {
    private File workFile;
    private ArrayList<Location> locs;
    private ArrayList<String> name;
    private TreeSet<String> words;
    

    public WordLocator(String name) throws IOException {
        workFile = new File(name);
        if (workFile.isDirectory()) {
            traverseFunc(workFile);
        }else{
            singleFile(workFile);
        }
        
        

    }

    private void traverseFunc(File topFile) throws IOException {
        File[] fileList = topFile.listFiles();
        for (File subFile : fileList) {
            if (subFile.isFile()) {
                singleFile(subFile);
            } else {
                traverseFunc(subFile);
            }
        }

    }

    public void singleFile(File curFile) throws IOException {
        
        BufferedReader reader = 
        new BufferedReader(new FileReader(curFile));
        
        int ch;
        int ln=0,cl=0,scl=0;
        String token = "";
        words = new TreeSet<String>();
        name = new ArrayList<String>();
        do{
            
            ch = reader.read();
            if(!WordLocatorInterface.isInWord(ch)){
                if(token.length()>0){
                    if()
                    
                    System.out.println("line:"+ln+" col: "+cl+" word:"+token);
                    
                    
                    name.add(token);
                    Location workLoc = new Location(curFile.getPath(),ln,cl);
                    //locs.add(workLoc);
                    
                    token = ""; 
                }

            }else{
                token = token + (char)ch;
            }
            
        }while(ch!=-1);

        reader.close();

        System.out.println(name.isEmpty());
        System.out.println(words.isEmpty());
        System.out.println(name.size());
        
    }

    public TreeSet<String> getWords(){
        return null;
    }

    public TreeSet<String> getFilepaths(){
        return null;
    }

    public int numOccurancesInAllFiles(String word){
        return 0;
    }

    public void printOccurancesInAllFiles(String word){

    }

    public int numOccurancesInFile(String filepath, String word){
        return 0;
    }

    public void printOccurancesInFile(String filepath, String word){

    }
}
