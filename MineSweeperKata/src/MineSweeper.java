import java.util.ArrayList;

public class MineSweeper {
  
  public static void main(String[]args){
    String [][] fields = {{"4","4"},{"*",".",".",".",},{".",".",".",".",},{".","*",".",".",},{".",".",".",".",}, //
                          {"3","5"},{"*","*",".",".","."},{".",".",".",".","."},{".","*",".",".","."},{"0","0"}};
    
    String [][] newOutPut = convertFields(fields);
    
  }
  
  public static String[][] convertFields(String[][] fieldsInput){
    String[][] fieldsOutput = null;
    ArrayList<String[][]> arrFields = new ArrayList<String[][]>();
    String[][] newField = null;
    int iFieldLines;
    int iFieldColums;
    int index=0;
    
    
    while (fieldsInput[index][0] != 0+""){
      //Parse one field and add to ArrayList
      iFieldLines = Integer.parseInt(fieldsInput[index][0]);
      iFieldColums = Integer.parseInt(fieldsInput[index][1]);
      newField = new String[iFieldLines][iFieldColums];
      
      for(int i = index+1; i<index+iFieldLines+1; i++){
        for(int j = 0; j<iFieldColums; j++){
          newField[i-index-1][j] = fieldsInput[i][j];
        }        
      }
      
      printFields(newField); //Testing if my parsing of fields works.
      arrFields.add(newField);
      
      index += iFieldLines+1;
    }
    
    return fieldsOutput;
  }
  
  //function for console output of two dimensional string arrays.
  public static void printFields(String[][] fields){
    
    for(int i = 0; i<fields.length; i++){
      for(int j=0; j<fields[i].length; j++){
        System.out.print(fields[i][j]);
      }
      System.out.println();
    }
  }
}
