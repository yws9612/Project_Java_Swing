
public class grading {
	int word_length;
	char word_arr[];
	boolean grading[];
	
	grading(char [] a) {
		word_length=a.length;
		word_arr=new char[word_length];
		grading=new boolean[word_length];
		word_arr=a;
	}
	
	public boolean[] grade_panel(String input[]) {
		for (int i = 0; i < word_length; i++) {
			if (input[i].equals(Character.toString(word_arr[i]))) {
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
