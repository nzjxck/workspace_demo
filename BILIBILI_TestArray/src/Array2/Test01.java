package Array2;

public class Test01 {
	public static void main(String[] args) {
		int [][] a ={
					{1,2},
					{3,4},
					};
		int [][] b ={
				{1,2},
				{4,6},
				};
		int [][] c = new int [2][2];
		for(int i=0;i<c.length;i++){
			for(int j=0;j<c.length;j++){
				c[i][j]= a[i][j]+b[i][j];
			}
		}
		System.out.println(c[0][0]+","+c[0][1]);
		System.out.println(c[1][0]+","+c[1][1]);
		/**
		 * ±éÀúÊı×é
		 */
		for(int[] i : c){
			for(int m :i){
				System.out.println(m);
			}
		}
	}
}
