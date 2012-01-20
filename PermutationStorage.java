
public class PermutationStorage {
	
	public String[] permutations;
	public int numOfPermutations = 0;
	public PermutationStorage() { permutations = new String[0]; }
	
//Getters
	public String[] getPermutations() { return permutations; }
	public int getNumOfPermutations() { return numOfPermutations; }
	
//Setters
	public void setNumOfPermutations() { this.numOfPermutations = getPermutations().length; }
	public void setPermutations(String[] permutations) { this.permutations = permutations; }
	public void setElement(int index, String s){ this.permutations[index] = s; }
	
// instead of using an array list, i decide just to use a normal array
// that uses this method to expand(creating a new array plus 1 element).
	public void expandArray(String aString) {
		  int count = getPermutations().length + 1;
		  String[] newArray = new String[count];
		  int incre = 0;
		  for(int k = 0; k < getPermutations().length; k++) {
			  newArray[k] = getPermutations()[k];
			  incre++;
		  }
		  newArray[incre] = aString;
		  setPermutations(newArray);
		  setNumOfPermutations();
	  }
	
// Output the permutations via the toString method
	public String toString(){
		String aString = "";
		for(int x = 0; x < getPermutations().length; x++){
			aString += getPermutations()[x] + "\n";
		}
		return aString;
	}
}
