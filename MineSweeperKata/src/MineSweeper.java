import java.util.ArrayList;
import java.util.Iterator;

public class MineSweeper {
  
  public static void main(String[]args){
    String [][] fields = {{"4","4"},{"*",".",".",".",},{".",".",".",".",},{".","*",".",".",},{".",".",".",".",}, //
                          {"3","5"},{"*","*",".",".","."},{".",".",".",".","."},{".","*",".",".","."},{"0","0"}};
    System.out.println("Input fields");
    printFields(fields);
    String [][] newOutPut = convertFields(fields);
    
    System.out.println("Output fields");
    printFields(newOutPut);
  }
  
  //
  public static String[][] convertFields(String[][] fieldsInput){
    String[][] fieldsOutput = null;
    ArrayList<String[][]> arrFields = parseInputToArrayList(fieldsInput);
    fieldsOutput = new String[fieldsInput.length][100];
    
    
    String[][] strFieldTmp = null;
    //get in the numbers for mines
    int fieldNumber=0;
    int index = 0;
    
    for(Iterator it = arrFields.iterator(); it.hasNext();){
      fieldNumber++;
      strFieldTmp = (String[][]) it.next();
      fieldsOutput[index][0] = "Field #" + fieldNumber + ":";
      
      for(int i = 0; i<strFieldTmp.length; i++){
        index++;
        
        for(int j = 0; j<strFieldTmp[0].length; j++){
          
          if(strFieldTmp[i][j] == "*"){
            fieldsOutput[index][j] = "*";
          }
          else{
            fieldsOutput[index][j] = giveNumberOfMines(strFieldTmp, i,j);
          }
        }
        
        
      }
      //Adding empty row after each field
      index +=2;
      if(index<fieldsOutput.length){
      	fieldsOutput[index][0]="\n";
      }
    }
    
    return fieldsOutput;
  }
  
  //Check how many mines are touching the square in line "iLine" and column "iColumn" of given field "field"
  public static String giveNumberOfMines(String[][] field, int iLine, int iColumn){
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
    
    return numberOfMines + "";
  }
  
  //Parse the given input of fields into seperate 2-dimensional arrays and add them to a ArrayList that gets returned.
  public static ArrayList<String[][]> parseInputToArrayList(String[][] fieldsInput){
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
      
      arrFields.add(newField);
     
      index += iFieldLines+1;
    }
    
    return arrFields;
  }
  
  
  //function for console output of two dimensional string arrays.
  public static void printFields(String[][] fields){
    
    for(int i = 0; i<fields.length; i++){
      for(int j=0; j<fields[i].length; j++){
        if(fields[i][j]!=null){
    	  System.out.print(fields[i][j]);
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
