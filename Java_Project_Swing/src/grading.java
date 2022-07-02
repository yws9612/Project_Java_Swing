
public class grading {
	String word;
	int word_length=word.length();
	char word_arr[]=new char[word_length];
	boolean grading[]=new boolean[word_length];
	
	
	public boolean[] grade_panel(char input[]) {
		for (int i = 0; i < word_length; i++) {
			if (input[i] == word_arr[i]) {
				grading[i] = true;
			} else {
				grading[i] = false;
			}
		}
		return grading;
	}
	
	public boolean grade_case() {
		int i=0;
		while(grading[i]) {
			i++;
		}
		if(word_length==i) {
			return true;
		}
		return false;
	}
}
