
public class MineSweeper {
  
  public static void main(String[]args){
    String [][] fields = {{"4","4"},{"*",".",".",".",},{".",".",".",".",},{".","*",".",".",},{".",".",".",".",}, //
                          {"3","5"},{"*","*",".",".","."},{".",".",".",".","."},{".","*",".",".","."},{"0","0"}};
    
    
    
  }
  
  public static String[][] convertFields(String[][] fieldsInput){
    String[][] fieldsOutput = null;
    ArrayList<String[][]> arrFields = new ArrayList<String[][]>();
    String[][] newField = null;
    int iFieldLines;
    int iFieldColums;
    int index=0;
    
    
    while (fieldsInput[iIndex][0]!=0){
      //Parse one field and add to ArrayList
      iFieldLines = fieldsInput[i][0];
      iFieldColums = fieldsInput[i][1];
      newField = new String[iFieldLines][iFieldColums];
      
      for(int i = iIndex+1; i<iIndex+iFieldLines+1; i++){
        for(int j = 0; j<iFieldColums; j++){
          newField[i-iIndex-1][j] = fieldsInput[i][j];
        }        
      }
      
      printFields(newField); //Testing if my parsing of fields works.
      arrFields.add(newField);
      
      
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
