// Jack Young


public class Perm {

    // print N! permutation of the characters of the string s (in order)
    public  static void perm1(String s, PermutationStorage ps) { perm1("", s, ps); }
    private static void perm1(String prefix, String s, PermutationStorage ps) {
        int N = s.length();
        if (N == 0) {
        	ps.expandArray(prefix);
        }
        else {
            for (int i = 0; i < N; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N), ps);
        }
    }

    public static void main(String[] args) {
       
    //Given a list of words, in this case being a string array, this program will compute the possible permutations of those words in the list
       String[] L = {"fooo", "barr", "wing", "ding", "wing"};
       String matchedString = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
       int N = L.length;
      
       String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String elements = alphabet.substring(0, N);
       PermutationStorage ps = new PermutationStorage();
       perm1(elements, ps);
       
       convertStrings(N, ps, L, elements);
       
       //the line below will output all possible permutations
       //System.out.println(ps);
       
       
       isThereAMatch(matchedString, ps);
       
    }
    
   //This method will check for a match between the permutations and the string.
    public static void isThereAMatch(String matchedString, PermutationStorage ps){
        int result = 0;
        for(int b = 0; b < ps.getPermutations().length; b++){
        	if(matchedString.indexOf(ps.getPermutations()[b]) != -1){
        		result = matchedString.indexOf(ps.getPermutations()[b]);
        	}
        }
       
        System.out.println("Answer " + result);
    }
    
//This converts the single letter into the specified phrase  
    public static void convertStrings(int N, PermutationStorage ps, String[] L, String elements){
        
        for(int k = 0; k < ps.getNumOfPermutations(); k++){

        	int[] ipos = new int[elements.length()];
        	for(int b = 0; b < elements.length(); b++){
        		ipos[b] = ps.getPermutations()[k].indexOf(elements.charAt(b));
        	}
        
        	String[] ab = new String[N];
        	for(int p = 0; p < ab.length; p++){
        		ab[ipos[p]] = L[p];
        	}
        
        	String computedString = "";
        	for(int x = 0; x < ab.length; x++){
        		computedString += ab[x]; 
        	}
        	ps.setElement(k, computedString);
        
        }
    
    }
    
    
}


