public class GameofLife {
	public static int[][] createMatrix(int n, int p){
		int[][] a= new int[n][n];
		int num= (n*n*p)/100;
		for(int i=0;i<n;i++) {
			for(int j=0; j<n;j++) {
				a[i][j]=(int) Math.round(Math.random());
				if(a[i][j]==1) {
					if(num>0) {
						num--;
					}
					else {
						a[i][j]=0;
					}
				}
				else {
					if((n*n-(n*i+(j+1)))<=num) {
						a[i][j]=1;num--;
					}
				}
			}
		}
		return a;
	}
	public static int[][] copy(int[][]a){
		int[][]c=new int[a.length][a.length];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				c[i][j]=a[i][j];
			}
		}
		return c;
	}
	public static void update(int[][]a) {
		int[][]c=copy(a);
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length;j++) {
			    if(c[i][j]==1) {
			    	int count=-1;
			     	for(int h=i-1;h<=i+1;h++) {
			    		for(int k=j-1;k<=j+1;k++) {
			    			if(h>=0&&k>=0&&h<a.length&&k<a.length) {
			    				if(c[h][k]==1) {
			    					count++;
			    			    }
			    			}
			    		}
			    	}
			    	if(count<2||count>3) {
			    		a[i][j]=0;
			    	}
			    	else {a[i][j]=c[i][j];}
			    }
			    else {
			    	int count=0;
			    	for(int h=i-1;h<=i+1;h++) {
			    		for(int k=j-1;k<=j+1;k++) {
			    			if(h>=0&&k>=0&&h<a.length&&k<a.length) {
			    				if(c[h][k]==1) {
			    					count++;
			    			    }
			    			}
			    		}
			    	}
			    	if(count==3) {
			    		a[i][j]=1;
			    	}
			    	else {
			    		a[i][j]=c[i][j];
			    	}
			    }
			}
		}
	}
	public static void show(int[][]a) {
		String n="";
		for(int k=0;k<=2*a.length;k++) {n=n+"-";}
		System.out.println(n);
		for(int i=0;i<a.length;i++) {
			String s="|";
			for(int j=0;j<a.length;j++) {
				if(a[i][j]==0) {
					s=s+" |";
				}
				else{s=s+"1|";}
			}
			System.out.println(s);
		}
		System.out.println(n);
		System.out.println();
	}
	public static void main(String[]args) throws InterruptedException {
		int[][]matrix= createMatrix(10,50);// first argument matrix side length, second argument % live cell in matrix
		while(true) {
			show(matrix);
			update(matrix);
			Thread.sleep(2000);
		}
	}
}