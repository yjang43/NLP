package tool;

public class ArrayTool {
	public static int[] copyArr(int arr[]) {
		int tmp[] = new int[arr.length];
		int i;
		for(i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		return tmp;
	}
	
	public static char[] resizeArr(char arr[]) {
		char tmp[] = new char[arr.length + 1];
		int i;
		for(i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		tmp[i] = 0;
		return tmp;
	}
	
	public static String[] resizeArr(String arr[]) {
		String tmp[] = new String[arr.length + 1];
		int i;
		for(i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		tmp[i] = "";
		return tmp;
	}
	
	public static int[][] resizeMulArr(int arr[][]) {
		int tmp[][] = new int[arr.length + 1][arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		for(int i = 0; i < tmp.length; i++) {
			tmp[i][tmp.length - 1] = 0;
			tmp[tmp.length - 1][i] = 0;
		}
		return tmp;
	}
	
	public static char[] clearArr(char arr[]) {
		char tmp[] = new char[0];
		return tmp;
	}
	
	public static String[] clearArr(String arr[]) {
		String tmp[] = new String[0];
		return tmp;
	}
	
	public static boolean isSame(String a, char[] b) {
		char[] newA = a.toCharArray();
		try {
			for(int i = 0; i < ((newA.length >= b.length)?newA.length:b.length); i++) {
				if(newA[i] != b[i]) return false;
			}
				return true;
		} catch(IndexOutOfBoundsException exc) {
			return false;
		}
	}
	public static boolean isSame(String a, String b) {
		char[] newA = a.toCharArray();
		char[] newB = b.toCharArray();
		try {
			for(int i = 0; i < ((newA.length >= newB.length)?newA.length:newB.length); i++) {
				if(newA[i] != newB[i]) return false;
			}
				return true;
		} catch(IndexOutOfBoundsException exc) {
			return false;
		}
	}
	
	public static int getIndex(String str, String[] arr) {
		int i;
		for(i = 0; i < arr.length; i++) {
			if(isSame(str, arr[i])) break;
		}
		return i;
	}
	
	
	
}