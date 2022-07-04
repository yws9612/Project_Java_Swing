
public class grading {
	int word_length;
	String word_arr[];
	boolean grading[];
	
	grading(String [] a) {
		word_length=a.length;
		word_arr=new String[word_length];
		grading=new boolean[word_length];
		word_arr=a;
	}
	
	public boolean[] grade_panel(String input[]) {
		for (int i = 0; i < word_length; i++) {
			if (input[i].equals(word_arr[i])) {
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
