/**
 * Hasan Semih AKTAŞ
 * @since 12.01.2021
 */


class PrimeNumber {
    
    public static void main(String[] args) {
        int[][] number = new int[10][10];
        int[] primeNumberArray = new int[100];
        int counter=0;
        randomArray(number);
        printArray(number);
        counter=primeNumber(number,primeNumberArray,counter);
        printPrimeNumber(primeNumberArray,counter);
    }
    public static void randomArray(int[][] number)
    {   int y=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                number[i][j]= (int)(Math.random()*100);
            }
        }
    }
    public static void printArray(int[][] number)
    {
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(number[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int primeNumber(int[][] number,int[] primeNumberArray,int counter)
    {
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                boolean check=true;
                if(number[i][j]==0 || number[i][j]==1)
                {
                    check=false;
                }
                for(int a=2;a<=number[i][j]/2; a++){
                    if(number[i][j]%a==0) {
                        check = false;
                        break;
                    }
                }
                boolean check2=true;
                if(check==true)
                {
                    for(int a=0;a<counter;a++)
                    {
                        if(primeNumberArray[a]==number[i][j])
                        {
                            check2=false;
                            break;
                        }
                    }
                    if(check2==true) {
                        primeNumberArray[counter] = number[i][j];
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    public static void printPrimeNumber(int[] primeNumberArray, int counter)
    {
        System.out.println();
        System.out.println("Prime Numbers");
        for(int c=0; c<counter;c++)
        {
            System.out.print(primeNumberArray[c]+" ");
        }
    }
}