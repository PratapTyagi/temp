class kmp{

	static void KmpReset(int[] reset, String pat) {
		int i=1, j=0; 
		int m = pat.length();
		reset[0] = -1;

		while(i < m) {
			while(j >= 0 && pat.charAt(i) != pat.charAt(j))
				j = reset[j];
			i++;
			j++;
			reset[i] = j;
		}
	}

	static void KmpSearch(String str, String pat) {
		int i=0, j=-1;
		int m = str.length();
		int n = pat.length();
		if(m < n) System.out.println(-1);	

		int[] reset = new int[100005];
		KmpReset(reset, pat);

		while(i < m) {
			while(j >= 0 && str.charAt(i) != pat.charAt(j))
				j = reset[j];
			i++;
			j++;
			if (j == n) {
				System.out.println(i-j);
				j = reset[j];
			}
		} 
	}

	public static void main(String[] a) {
		KmpSearch("babababaaabsababaaabs", "babaaa");
	}
}