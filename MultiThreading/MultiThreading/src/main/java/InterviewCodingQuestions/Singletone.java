package InterviewCodingQuestions;

public class Singletone {
	private static volatile Singletone instance;
	
	private Singletone() {}
	
	public static Singletone getInstance() {
		if (instance == null) {
			synchronized (Singletone.class) {
				if (instance == null) {
					instance = new Singletone();
				}
			}
		}
		return instance;
	}
}
