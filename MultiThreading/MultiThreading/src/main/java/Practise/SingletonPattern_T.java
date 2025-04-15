package Practise;

public class SingletonPattern_T {
	private volatile SingletonPattern_T instancePattern_T;
	private SingletonPattern_T() {}
	public SingletonPattern_T getInstance() {
		if (instancePattern_T!=null) {
			synchronized (SingletonPattern_T.class) {
				if (instancePattern_T!=null) {
					instancePattern_T = new SingletonPattern_T();
				}
			}
		}
		return instancePattern_T;		
	}
}
