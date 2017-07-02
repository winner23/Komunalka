import java.util.Calendar;

public class Posluga {
	private String name;
	private String rahunok;
	private float price;
	private int lastCounter;
	private int prevCounter;
	private Calendar date;
	
	public Posluga(String name, String rahunok, float price, int lastCounter, int prevCounter, Calendar date) {

		this.date = date;
		this.name = name;
		this.rahunok = rahunok;
		this.price = price;
		this.lastCounter = lastCounter;
		this.prevCounter = prevCounter;
	}

	public Calendar getDate() {	return date; }

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getRahunok() {
		return rahunok;
	}

	protected void setRahunok(String rahunok) {
		this.rahunok = rahunok;
	}

	protected float getPrice() {
		return price;
	}

	protected void setPrice(float price) throws DataExpetion {
		if(price<=0){
			throw new DataExpetion("Not Correct price!");
			}
		this.price = price;
	}

	protected int getLastCounter() {
		return lastCounter;
	}

	protected void setLastCounter(int lastCounter) throws DataExpetion {
		if(getPrevCounter()>lastCounter){
			throw new DataExpetion("Last Counter lower then Previous Counter!");
		}
		this.lastCounter = lastCounter;
	}

	protected int getPrevCounter() {
		return prevCounter;
	}

	protected void setPrevCounter(int prevCounter) {
		this.prevCounter = prevCounter;
	}
	
}
