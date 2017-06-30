
public class KOServices {
	private Integer iD;
	private String name;
	private Double price;
	private String type;
	protected Integer getiD() {
		return iD;
	}
	protected void setiD(Integer iD) {
		this.iD = iD;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected Double getPrice() {
		return price;
	}
	protected void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}