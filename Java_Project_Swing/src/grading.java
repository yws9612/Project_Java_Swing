
public class grading {
	String word;
	int word_length;
	char word_arr[];
	boolean grading[];
	
	grading(String a, char [] b) {
		word=a;
		word_length=word.length();
		word_arr=new char[word_length];
		grading=new boolean[word_length];
		word_arr=b;
	}
	
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
		int i = 0;
		while (grading[i]) {
			i++;
			if (i >= word_length) {
				break;
			}
		}
		if (word_length==i) {
			return true;
		}
		return false;
	}
}
