import java.util.ArrayList;

public class MineSweeper {
  
  public static void main(String[]args){
    String [][] fields = {{"4","4"},{"*",".",".",".",},{".",".",".",".",},{".","*",".",".",},{".",".",".",".",}, //
                          {"3","5"},{"*","*",".",".","."},{".",".",".",".","."},{".","*",".",".","."},{"0","0"}};
    
    String [][] newOutPut = convertFields(fields);
    
  }
  
  public static String[][] convertFields(String[][] fieldsInput){
    String[][] fieldsOutput = null;
    ArrayList<String[][]> arrFields = parseInputToArrayList(fieldsInput);
    
    
    //get in the numbers for mines
    
    
    
    return fieldsOutput;
  }
  
  //Check how many mines are touching the square in line "iLine" and column "iColumn" of given field "field"
  public static int giveNumberOfMines(String[][] field, int iLine, int iColumn){
    int numberOfMines=0;
    
    for(int i = iLine-1; i<=iLine+1; i++){
      for(int j=iColumn-1; j<= iColumn+1;j++){
        //check if the indexes do not go out of bounds
        if(i!=-1 && j!=-1 && i!=field.length && j!=field[0].length){ 
          if(field[i][j]=="*"){
            //There is a mine touching this field
            numberOfMines+=1;
          }
        }
      }      
    }
    
    return numberOfMines;
  }
  
  //Parse the given input of fields into seperate 2-dimensional arrays and add them to a ArrayList that gets returned.
  public static void parseInputToArrayList(String[][] fieldsInput){
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
      
      System.out.println(giveNumberOfMines(newField, 1,1)); //Testing giveNumberOfMinesImplementation for index (1,1)
      index += iFieldLines+1;
    }
    
    return arrFields;
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
