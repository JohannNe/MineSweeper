
public class MineSweeper {
  
  public static void main(String[]args){
    String [][] fields = {{"4","4"},{"*",".",".",".",},{".",".",".",".",},{".","*",".",".",},{".",".",".",".",} //
                          {"3","5"},{"*","*",".",".","."},{".",".",".",".","."},{".","*",".",".","."},{"0","0"}};
    //Test console output of inputFields
    for(int i = 0; i<fields.length; i++){
      for(int j=0; j<fields.length; j++){
        System.out.print(fields[i][j]);
      }
      System.out.println();
    }
    
  }
  
  public static String[][] convertFields(String[][] fieldsInput){
    String[][] fieldsOutput;
    
    return fieldsOutput;
  }
}
