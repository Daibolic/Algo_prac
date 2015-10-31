import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;


public class Algorithm {
		
	public static void pushZero (int[] lst) {
		int i= 0;
		int j= 0;
		//inv: lst[i,j] includes only 0's
		while (j < lst.length) {
			if (lst[i] == 0) {
				if (lst[j] == 0) {
					j++;
				} else {
					swap(lst,i,j);
					i++;
					j++;
				}
			} else {
				i++;
				j++;
			}
		}
	}
	
	private static void swap (int[] lst, int i, int j) {
		int temp= lst[i];
		lst[i]= lst[j];
		lst[j]= temp;
	}
	
	public String intToRoman(int num) {
        String s= "";
        if (num >= 0 && num < 5) {
            if (num == 0) {
                return s;
            } else if (num == 1) {
                return "I";
            } else if (num == 2) {
                return "II";
            } else if (num == 3) {
                return "III";
            } else {
                return "IV";
            }
        } else if (num >= 5 && num < 10) {
            if (num == 9 ) {
                return "IX";
            } else {
                return ("V" + intToRoman(num - 5));
            }
        } else if (num >= 10 && num < 50) {
            if (num >= 40) {
                return ("XL" + intToRoman(num - 40));
            } else {
                return ("X"+ intToRoman(num-10));
            }
        } else if (num >= 50 && num < 100) {
            if (num >= 90) {
                return ("XC" + intToRoman(num-90));
            } else {
                return ("L" + intToRoman(num-50));
            }
        } else if (num >= 100 && num < 500) {
        	if (num >= 400) {
        		return ("CD" + intToRoman(num-400));
        	} else {
        		return ("C" + intToRoman(num-100));
        	}
        } else if (num >= 500 && num <= 1000) {
        	if (num >= 900) {
        		return ("DM" + intToRoman(num-900));
        	} else {
        		return ("D" + intToRoman(num-500));
        	}
        } else {
        	return ("M" + intToRoman(num-1000));
        }
    }
	
    public static int lengthOfLongestSubstring(String s) {
        int len=0;
        HashMap<Character,Integer> vault = new HashMap<Character,Integer>();
        int i=0;
        int j=0;
        while (i < s.length()) {
            char c= s.charAt(i);
            if (!vault.containsKey(c)) {
                vault.put(c,i);
                i++;
                if (i-j>len) len= i-j;
            } else {
                int k= j;
                j= vault.get(c)+1;
                while (k < j) {
                    vault.remove(s.charAt(k));
                    k++;
                }
                vault.put(c,i);
                i++;
                if (i-j > len) len= i-j;
            }
        }
        return len;
    }
    
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i= 0;
        int result= citations.length;
        while (i<citations.length) {
        	if (result <= citations[i]) {
        		return result;
        	} else {
        		i++;
        		result--;
        	}
        }
        return result;
    }
    
    public static boolean canSqr(int num, int n) {
    	boolean result= false;
    	if (n==1) {
    		if (num==1) {
    			result= true;
    		} else {
    			for (int i= 1; i*i <= num; i++) {
    				if (i*i == num) {
    					result= true;
    				}
    			}
    		}
    	} else {
			for (int k=1; k*k <= num; k++) {
				if (!result) {
    				result= canSqr(num-k*k,n-1);
				}
			}
    	}
    	return result;
    }
    
    public static int numSquare(int num) {
    	boolean canSqr= false;
    	int i= 0;
    	while (!canSqr) {
    		i++;
    		canSqr= canSqr(num,i);
    	}
    	return i;
    }
    
    /*
     * Array b, b[h..t] is sorted, b[t+1..k] is sorted.
     */
    public static void merge(int[] b, int h, int t, int k) {
    	int[] c = Arrays.copyOfRange(b, h, t+1);
    	//initialize loop
    	int i= 0;
    	int m= 0;
    	int j= t+1;
    	while ((i<c.length) && (j<k+1)) {
    		if (c[i] < b[j]) {
    			b[m]= c[i];
    			i++;
    			m++;
    		} else {
    			b[m]= b[j];
    			j++;
    			m++;
    		}
    	}
    	if (i == c.length && j<k+1) {
    		return;
    	} else if (i<c.length && j==k+1){
    		while (i<c.length) {
    			b[m]= c[i];
    			i++;
    			m++;
    		}
    	}
    }
    
    /**
     * CTCI p.91 one Edit Away
     */
    private static boolean checkSameLen (String first, String second) {
    	//first and second have the same length
    	boolean foundDiff = false;
    	int i= 0;
    	while (i < first.length()) {
    		if (first.charAt(i) != second.charAt(i)) {
    			if (foundDiff) {
    				return false;
    			} else {
    				foundDiff= true;
    			}
    		}
    		i++;
    	}
    	return true;
    }
    
    private static boolean checkDiffOne (String s, String o) {
    	//s and o differ in length only by one
    	String longer; String shorter;
    	if (s.length() > o.length()) {longer= s; shorter= o;}
    	else {longer= o; shorter= s;}
    	int i= 0; int j= 0; boolean differed=  false;
    	while (j < shorter.length()) {
    		if (longer.charAt(i) != shorter.charAt(j)) {
    			if (!differed) {
    				differed= true;
    				i++;
    			} else {
    				return false;
    			}
    		} else {
    			i++;
    			j++;
    		}
    	}
    	return true;
    }
    
    public static boolean oneEditAway (String s, String t) {
    	if ((s.length()-t.length()) == 1 || (s.length()-t.length()) == -1) {
    		return checkDiffOne(s,t);
    	} else if (s.length() == t.length()) {
    		return checkSameLen(s,t);
    	} else {
    		return false;
    	}
    }
    
    /**
     * CTIC p.91 String Compression
     */
    public static String compress (String s) {
    	if (s == "") return s;
    	int i= 1;
    	int n= 1;
    	String result= "";
    	while (i<s.length()) {
    		if (s.charAt(i) != s.charAt(i-1)) {
    			result= result + s.charAt(i-1) + n;
    			i++;
    			n= 1; //reset n
    		} else {
    			n++;
    			i++;
    		}
    	}
    	result= result + s.charAt(i-1) + n;
    	if (result.length() < s.length()) {
    		return result;
    	} else {
    		return s;
    	}
    }
}
