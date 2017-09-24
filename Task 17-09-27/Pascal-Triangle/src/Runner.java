public class Runner {


    public static void main(String[] args) {
        int numberRows = new InputData().getNumber("Enter number of rows to show:");
        int [] [] pyramid = new int [numberRows] [numberRows * 2 - 1] ;
        pyramid[0][numberRows-1] = 1;
        if (numberRows > 1) {
            for (int i=1; i<numberRows; i++) {
                pyramid [i][numberRows-i-1] = 1;
                pyramid [i][numberRows+i-1] = 1;
                for (int j=numberRows- i + 1; j <= numberRows + i - 3; j+=2)
                    pyramid[i][j] = pyramid[i-1][j-1] + pyramid [i-1][j+1];
            }
        }
        int maxNumberSize = 0;
        for (int j=0; j < numberRows*2-1; j++)
            if (String.valueOf(pyramid[numberRows-1][j]).length() > maxNumberSize)
                maxNumberSize = String.valueOf(pyramid[numberRows-1][j]).length();
        StringBuffer spaces = new StringBuffer();
        for (int i=0; i<maxNumberSize; i++)
            spaces.append(' ');
        StringBuffer thisRow = new StringBuffer();
        for (int i=0; i< numberRows; i++) {
            for (int j=0; j< numberRows*2-1; j++) {
               if (pyramid[i][j] == 0)
                   thisRow.append(spaces);
               else {
                   for (int k=0; k < maxNumberSize - String.valueOf(pyramid[i][j]).length();k++)
                       thisRow.append(' ');
                   thisRow.append(pyramid [i][j]);
               }
            }
            System.out.println(thisRow);
            thisRow.setLength(0);
        }
    }
}
