import java.util.*;

/**
 Hasan Semih Aktaş
 20120205311
 Data Structures
 */

class PeakFinder2D {
    int[][] a;
    int peak, sayac1=0, sayac2=0, sayac3=0;

    public PeakFinder2D(int nrow, int ncol){
        a = new int[nrow][ncol];
        Random r = new Random();
        for(int i=0; i<nrow; i++){
            for(int b=0; b<ncol;b++)
            {
                a[i][b]=r.nextInt(100);
            }
        }
    }
    public int greedyAlg(int nrow, int ncol){
        peak = a[0][0];
        for(int row = sayac1; row<nrow; row++) {
            for (int col = sayac2; col<ncol; col++) {
                /**Alttaki iflerde sayac1 i bir ezaltıyorum. Çünkü ilk for sayıyı bir arttıyor ve ben işleme o row dan başlamasını istiyorum. Ama ikinci foru breakla
                 çıktığımdan işlem baştan başlıyor. O yüzden eksiltme işlemine gerek duymadım.**/
                if (row == 0 && col == 0) {
                    if(a[row][col]>a[row][col+1]&&a[row][col]>a[row+1][col]) {
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row][col+1]>a[row][col]&&a[row][col+1]>a[row+1][col]){
                        row=row-1;
                        sayac2=col+1;
                    }
                    else if(a[row+1][col]>a[row][col]&&a[row+1][col]>a[row][col+1]){
                        row=row;
                        sayac2=col;
                    }
                }
                else if (row == 0 && col != 0) {
                    if(a[row][col]>a[row][col-1]&&a[row][col]>a[row][col+1]&&a[row][col]>a[row+1][col]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row][col-1]>a[row][col]&&a[row][col-1]>a[row][col+1]&&a[row][col-1]>a[row+1][col]){
                        row=row-1;
                        sayac2=col-1;
                    }
                    else if(a[row][col+1]>a[row][col]&&a[row][col+1]>a[row][col-1]&&a[row][col+1]>a[row+1][col]){
                        row=row-1;
                        sayac2=col+1;
                    }
                    else if(a[row+1][col]>a[row][col]&&a[row+1][col]>a[row][col+1]&&a[row+1][col]>a[row][col-1]){
                        row=row;
                        sayac2=col;
                    }
                }
                else if (row != 0 && col == 0) {
                    if(a[row][col]>a[row-1][col]&&a[row][col]>a[row+1][col]&&a[row][col]>a[row][col+1]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row-1][col]>a[row][col] && a[row-1][col]>a[row+1][col] && a[row-1][col]>a[row][col+1]){
                        row=row-2;
                        sayac2=col;
                    }
                    else if(a[row+1][col]>a[row][col] && a[row+1][col]>a[row-1][col] && a[row+1][col]>a[row][col+1]){
                        row=row;
                        sayac2=col;
                    }
                    else if(a[row][col+1]>a[row][col] && a[row][col+1]>a[row+1][col] && a[row][col+1]>a[row-1][col]){
                        row=row-1;
                        sayac2=col+1;
                    }
                }
                else if(row==0 && col==ncol-1 && col!=0){
                    if(a[row][col]>a[row+1][col]&&a[row][col]>a[row][col-1]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row+1][col]>a[row][col] && a[row+1][col]>a[row][col-1]){
                        row=row;
                        sayac2=col;
                    }
                    else if(a[row][col-1]>a[row][col] && a[row][col-1]>a[row+1][col]){
                        row=row-1;
                        sayac2=col-1;
                    }
                }
                else if(row==nrow-1 && col==0 && col!=ncol-1){
                    if(a[row][col]>a[row-1][col]&&a[row][col]>a[row][col+1]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row-1][col]>a[row][col] && a[row-1][col]>a[row][col+1]){
                        row=row-2;
                        sayac2=col;
                    }
                    else if(a[row][col+1]>a[row][col]&&a[row][col+1]>a[row-1][col]){
                        row=row-1;
                        sayac2=col+1;
                    }
                }
                else if(row==nrow-1 && col==ncol-1){
                    if(a[row][col]>a[row-1][col]&&a[row][col]>a[row][col-1]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row-1][col]>a[row][col]&& a[row-1][col]>a[row][col-1]){
                        row=row-2;
                        sayac2=col;
                    }
                    else if(a[row][col-1]>a[row][col]&&a[row][col-1]>a[row-1][col]){
                        row=row-1;
                        sayac2=col-1;
                    }
                }
                else if(row==nrow-1 && col!=ncol-1 && col!=0){
                    if(a[row][col]>a[row][col-1] && a[row][col]>a[row][col+1] && a[row][col]>a[row-1][col]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row][col-1]>a[row][col] && a[row][col-1]>a[row][col+1] && a[row][col-1]>a[row-1][col]){
                        row=row-1;
                        sayac2=col-1;
                    }
                    else if(a[row][col+1]>a[row][col] && a[row][col+1]>a[row][col-1] && a[row][col+1]>a[row-1][col]){
                        row=row-1;
                        sayac2=col+1;
                    }
                    else if(a[row-1][col]>a[row][col] && a[row-1][col]>a[row][col-1]&& a[row-1][col]>a[row][col+1]){
                        row=row-2;
                        sayac2=col;
                    }
                }
                else if(row!=nrow-1 && col==ncol-1 && row!=0){
                    if(a[row][col]>a[row-1][col]&&a[row][col]>a[row+1][col]&&a[row][col]>a[row][col-1]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row-1][col]>a[row][col] && a[row-1][col]>a[row+1][col] && a[row-1][col]>a[row][col-1]){
                        row=row-2;
                        sayac2=col;
                    }
                    else if(a[row+1][col]>a[row][col] && a[row+1][col]>a[row-1][col] && a[row+1][col]>a[row][col-1]){
                        row=row;
                        sayac2=col;
                    }
                    else if(a[row][col-1]>a[row][col] && a[row][col-1]>a[row-1][col] && a[row][col-1]>a[row+1][col]){
                        row=row-1;
                        sayac2=col-1;
                    }
                }
                else if(row!=0 && col!=0 && row!=nrow-1 && col!=ncol-1){
                    if(a[row][col]>a[row-1][col] && a[row][col]>a[row+1][col] && a[row][col]>a[row][col-1] && a[row][col]>a[row][col+1]){
                        peak=a[row][col];
                        row=nrow;
                        sayac2=ncol;
                    }
                    else if(a[row-1][col]>a[row][col] && a[row-1][col]>a[row+1][col] && a[row-1][col]>a[row][col-1] && a[row-1][col]>a[row][col+1]){
                        row=row-2;
                        sayac2=col;
                    }
                    else if(a[row+1][col]>a[row][col] && a[row+1][col]>a[row-1][col] && a[row+1][col]>a[row][col-1]  && a[row+1][col]>a[row][col+1]){
                        row=row;
                        sayac2=col;
                    }
                    else if(a[row][col-1]>a[row][col] && a[row][col-1]>a[row-1][col] && a[row][col-1]>a[row+1][col] && a[row][col-1]>a[row][col+1]){
                        row=row-1;
                        sayac2=col-1;
                    }
                    else if(a[row][col+1]>a[row][col] && a[row][col+1]>a[row-1][col] && a[row][col+1]>a[row+1][col] && a[row][col+1]>a[row][col-1]){
                        row=row-1;
                        sayac2=col+1;
                    }
                }
                break;
            }
        }
        return peak;
    }

    public int findMax(int[][] b){
        int imax = 0;
        for(int i = 0; i < a.length; i++ ){
            for (int j = 0; j < a[0].length ; j++) {
                if(a[i][j]> imax){
                    imax = a[i][j];
                }
            }
        }
        return imax;
    }
    public int findMaxOnCol(int col,int nrow){
        int imax = 0;
        for(int i = 0; i < nrow; i++ ){
            if(a[i][col]>a[imax][col]){
                imax = i;
            }
        }
        return imax;
    }

    public int findMaxOnRow(int row,int ncol){
        int imax = 0;
        for(int i = 0; i < ncol; i++ ){
            if(a[row][i]>a[row][imax]){
                imax = i;
            }
        }
        return imax;
    }

    public int divideAndConquer1(int startcol, int endcol,int endrow){
        int midcol = (startcol + endcol)/2;
        int nrow=endrow;
        if(midcol==0){
            int imax = findMaxOnCol(midcol,nrow);
            if(a[imax][midcol] >= a[imax][midcol+1] ) {
                peak=a[imax][midcol];
                return a[imax][midcol];
            }
        }
        else if(midcol==startcol){
            int imax = findMaxOnCol(midcol+1,nrow);
            if(a[imax][midcol+1] >= a[imax][midcol]) {
                peak=a[imax][midcol+1];
                return a[imax][midcol + 1];
            }
        }
        else {
            int imax = findMaxOnCol(midcol, nrow);
            if (a[imax][midcol] >= a[imax][midcol + 1] && a[imax][midcol] >= a[imax][midcol - 1]) {//2 tane
                peak = a[imax][midcol];
                return a[imax][midcol];
            }
            if (a[imax][midcol] >= a[imax][midcol + 1] && a[imax][midcol - 1] >= a[imax][midcol + 1])
                return divideAndConquer1(startcol, midcol, nrow);

            if (a[imax][midcol] >= a[imax][midcol - 1] && a[imax][midcol + 1] >= a[imax][midcol - 1])
                return divideAndConquer1(midcol, endcol, nrow);
        }
        return peak;
    }


    public int divideAndConquer2(int startrow, int startcol, int endrow, int endcol){
        /** Sayac3 çift sayı ise ortadan dikey olarak kesip ikiye ayırıyor. Sayac3 tek ise ortadan yatay olarak kesip ikiye ayırıyor.*/
        if(sayac3%2==0){
            int midcol = (startcol + endcol)/2; //1 tane
            int nrow=endrow;
            if(midcol==0){
                int imax = findMaxOnCol(midcol,nrow);
                if(a[imax][midcol] >= a[imax][midcol+1] ) {
                    peak=a[imax][midcol];
                    return a[imax][midcol];
                }
            }
            else if(midcol==startcol){
                int imax = findMaxOnCol(midcol+1,nrow);
                if(a[imax][midcol+1] >= a[imax][midcol]) {
                    peak=a[imax][midcol+1];
                    return a[imax][midcol + 1];
                }
            }
            else {
                int imax = findMaxOnCol(midcol, nrow); // number of rows: m
                if (a[imax][midcol] >= a[imax][midcol + 1] && a[imax][midcol] >= a[imax][midcol - 1]) {//2 tane
                    peak = a[imax][midcol];
                    return a[imax][midcol];
                }
                if (a[imax][midcol] >= a[imax][midcol + 1] && a[imax][midcol - 1] >= a[imax][midcol + 1]) {
                    sayac3++;
                    return divideAndConquer2(startrow, startcol, endrow, midcol);
                }
                if (a[imax][midcol] >= a[imax][midcol - 1] && a[imax][midcol + 1] >= a[imax][midcol - 1]) {
                    sayac3++;
                    return divideAndConquer2(startrow, midcol, endrow, endcol);
                }
            }
            return peak;
        }
        else if(sayac2%2==1){
            int midrow=(startrow+endrow)/2;
            int ncol = endcol;
            if(midrow==0){
                int imax=findMaxOnRow(midrow,ncol);
                if(a[midrow][imax]>a[midrow+1][imax]){
                    peak=a[midrow][imax];
                    return a[midrow][imax];
                }
            }
            else if(midrow==startrow){
                int imax=findMaxOnRow(midrow+1,ncol);
                if(a[midrow+1][imax]>a[midrow][imax]){
                    peak=a[midrow+1][imax];
                    return a[midrow+1][imax];
                }
            }
            else{
                int imax=findMaxOnRow(midrow,ncol);
                if(a[midrow][imax]>=a[midrow+1][imax] && a[midrow][imax]>=a[midrow-1][imax]) {
                    peak=a[midrow][imax];
                    return a[midrow][imax];
                }
                if(a[midrow][imax]>=a[midrow+1][imax]&&a[midrow-1][imax]>=a[midrow+1][imax]){
                    sayac3++;
                    return divideAndConquer2(startrow,startcol,midrow,endcol);
                }
                if(a[midrow][imax]>=a[midrow-1][imax] && a[midrow+1][imax]>=a[midrow-1][imax]){
                    sayac3++;
                    return divideAndConquer2(midrow,startcol,endrow,endcol);
                }
            }
        }
        return peak;
    }


    public void printArray(){
        for(int i=0;i<a.length;i++){
            for(int k=0;k<a[0].length;k++){
                System.out.print(a[i][k]+ " ");
            }
            System.out.printf("\n");
        }
    }

    public static void testGreedyAlg(){
        PeakFinder2D p = new PeakFinder2D(5,5);
        p.printArray();
        p.greedyAlg(5,5);
        System.out.println(p.peak);
    }


    static void testDivideAndConq1(){
        PeakFinder2D p = new PeakFinder2D(5,5);
        p.printArray();
        p.divideAndConquer1(0,4,4);/**Dizi 0 dan başladıgı için 5 satırlı bir dizisin son satırı 4 e karşılık geliyor.*/
        System.out.println(p.peak);
    }

    static void testDivideAndConq2(){
        PeakFinder2D p = new PeakFinder2D(5,5);/**Dizi 0 dan başladıgı için 5 satırlı bir dizisin son satırı ve son sutunu 4 e karşılık geliyor.*/
        p.printArray();
        p.divideAndConquer2(0,0,4,4);
        System.out.println(p.peak);
    }
}