package testtask.model;

public class Element {
	private Integer id;
	private String name;	
	
	public Element() {
		super();
	}
	public Element(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
