/* Class for evaluating your code
 */
package ex02_1_Pkg;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Evaluator {
    // Remove all blanks in a string and convert result to uppercase  
    static String normalize(String line){
        String result="";
        char c;
        for (int i=0; i<line.length();i++){
            c = line.charAt(i);
            if (c!=' ') result += c;
        }
        return result.toUpperCase();
    }
    // load text file to array of normalzed strings. Blank strings are removed
    static ArrayList<String> loadFile(String fileName){
        ArrayList<String> result = new ArrayList();
        File f = new File (fileName);
        String line;
        if (!f.exists()) return null;
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            while ((line = bf.readLine())!=null) {
                line= normalize(line);
                if(line.length()>0) result.add(line);
            }
        }
        catch (Exception e){
            System.out.println("File " + fileName + " doest not exist!");
        }
        return result;
    }
    // Counting similar lines in two arrays
    static int countSimilar (ArrayList<String> solution, ArrayList<String> result){
        int count = 0;
        int min = solution.size();
        if (min>result.size()) min = result.size();
        for (int i=0; i<min; i++ ){
            if (solution.get(i).equals(result.get(i))) count++; 
        }
        return count;
    }
    // Evaluating result 
    // This method must be code depeding on each specific prblem
    static int evaluate (int count, ArrayList<String> solution){
        int totalLine = solution.size();
        int score = 0;
        if (count<=2) score = 1;
        else if (count<=9) score = 2;
        else if (count<=10) score = 4;
        else if (count<=12) score = 6;
        else if (count<=18) score = 8;
        else if (count<=23) score = 10;
        return score;
    }
    public static void main(String[] args){
        String solutionFile = args[0];
        ArrayList<String> solution;
        ArrayList<String> resultSt;
        String solutionFileSt = args[1];
        int score=0;
        File f_solution = new File (solutionFile);
        File f_solutionSt = new File (solutionFileSt);
        if (!f_solution.exists()){
            System.out.println("No solution is prepared!");
        }
        else if (!f_solution.exists())
            System.out.println("Score=" + score);
        else {
            solution=loadFile(solutionFile);
            resultSt = loadFile(solutionFileSt);
            int count = countSimilar(solution, resultSt);
            score = evaluate(count, solution);
        }
        System.out.println("Score=" + score);            
    }       
}
