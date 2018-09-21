package testtask.dao;

import java.util.List;
import testtask.model.Element;

public interface ElementDao {
	
	public List<Element> listAllElements();
	
	public void addElement(Element element);

	public void updateElement(Element element);

	public Element findElementById(int id);

}
