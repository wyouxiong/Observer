public interface Observer{
	void update(String latestInfo);
}

public class NewsPapper implements Observer{
	void update(String latestInfo){
		System.out.println("NewsPapper" + latestInfo);
	}
}


public class MailPapper implements Observer{
	void update(String latestMail){
		System.out.prinln("MailPapper" + latestMail);
	}
}

public interface Subject{
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObserver(Observer observer);
}

public class Loan implements Subject{
	private String latestInfo;
	private ArrayList<Observer> observers = new ArrayList<Observer>();



	public void registerObserver(Observer observer){
		this.observers.add(observer);
	}

	public void removeObserver(Observer observer){
		this.observers.remove(observer);
	}

	public void notifyObserver(){
		Iterator iterator = this.observers.iterator();
		while(iterator.hasNext()){
			Observer observer = (Observer) iterator.next();
			observer.update(latestInfo);
		}
	}

	public void setLatestInfo(String info){
		this.latestInfo = info;
		notifyObserver();
	}

	@Override
	public void notifyObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}
}


public class ObserverTest{
	public static void main(String[] args) {
		Loan loan = new Loan();
		loan.registerObserver(new NewsPapper());
		loan.registerObserver(new MailPapper());
		loan.setLatestInfo("最新消息1");
		loan.setLatestInfo("最新消息2");
	}
}