import java.io.*;
import java.util.*;

public class nqueens{

	public static void main(String args[]){
		System.out.println("Enter the number of Queens: ");
		Scanner sc = new Scanner(System.in);
		int nqueen = sc.nextInt();
		int arr[][] = new int[nqueen][nqueen];
		int i=0, j=0;

		//initialize board with zeros
		for(i=0;i<nqueen; i++){
			for(j=0; j<nqueen; j++){
				arr[i][j]=0;
			}
		}

		placeOnBoard(arr, 0, 0, nqueen);
		
		return;
	}

	public static void printBoard(int nqueen, int arr[][]){
		int i,j;
		System.out.println("--------------------");
		for(i=0;i<nqueen; i++){
			for(j=0; j<nqueen; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static boolean placeOnBoard(int arr[][], int row, int col, int nqueen){
		int i,j;

		if(row>=nqueen){
			printBoard(nqueen, arr);
			return true;
		}

		boolean res = false; 

		for(i=col;i<nqueen; i++){
			if(isPosValid(arr,row,i,nqueen)){
				arr[row][i]=1;
				res = placeOnBoard(arr, row+1, 0, nqueen)|| res;
				arr[row][i]=0;
			}
		}
		return res;
	}

	public static boolean isPosValid(int arr[][], int row, int col, int nqueen){

		int i,j;
		//row check
		for(i=0;i<nqueen;i++){
			if(arr[row][i]==1){
				return false;
			}
		}

		//col check
		for(i=0;i<nqueen;i++){
			if(arr[i][col]==1){
				return false;
			}
		}

		//diag check
		for(i=0;i<nqueen;i++){
			if((row+i)<nqueen && (col+i)<nqueen && arr[row+i][col+i]==1){
				return false;
			}
			else if((row+i)<nqueen && (col-i)>=0 && arr[row+i][col-i]==1){
				return false;
			}
			else if((row-i)>=0 && (col+i)<nqueen && arr[row-i][col+i]==1){
				return false;
			}
			else if((row-i)>=0 && (col-i)>=0 && arr[row-i][col-i]==1){
				return false;
			}
		}

		return true;
	}
}