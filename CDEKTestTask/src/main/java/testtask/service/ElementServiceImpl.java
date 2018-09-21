package testtask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testtask.dao.ElementDao;
import testtask.model.Element;

@Service
public class ElementServiceImpl implements ElementService{
	
	ElementDao elementDao;
	
	@Autowired
	public void setElementDao(ElementDao elementDao) {
		this.elementDao = elementDao;
	}

	public List<Element> listAllElements() {
		return elementDao.listAllElements();
	}

	public void addElement(Element element) {
		elementDao.addElement(element);		
	}

	public void updateElement(Element element) {
		elementDao.updateElement(element);
    }
	
	public Element findElementById(int id) {
	    return elementDao.findElementById(id);
	}
}
