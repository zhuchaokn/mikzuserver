package com.duapp.stonegate.mikuserver.proxy.action.rss;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
/**
 * 
 * @author hanfei
 * 
 */
public class Rss {
public static String RSS_DOM_ROOT_TITLE = "//channel/title";

public static String RSS_DOM_ROOT_LINK = "//channel/link";

public static String RSS_DOM_ROOT_DESCRIPTION = "//channel/description";

public static String RSS_DOM_CHILRDEN_ROOT = "//channel/item";

public static String RSS_DOM_CHILRDEN_ROOT_TITLE = "title";

public static String RSS_DOM_CHILRDEN_ROOT_LINK = "link";

public static String RSS_DOM_CHILRDEN_ROOT_PUBDATE = "pubDate";

public static String RSS_DOM_CHILRDEN_ROOT_DESCRIPTION = "description";

public static String DATABASES_PATH = "#rss_databases.mdb";
private Document document;

public Document parse(URL url) throws DocumentException {
	 SAXReader reader = new SAXReader();
	document = reader.read(url);
	return document;
}

public void parseUrl(URL url) throws DocumentException {
	SAXReader reader = new SAXReader();
	
	document = reader.read(url);
	System.out.print("�ĵ�ȫ��"
	+ document.getDocument().getRootElement().getName());
}

@SuppressWarnings("unchecked")
public List<Element> getXmlInfo(String path, URL url) {
	List<Element> info = new ArrayList<Element>();
	try {
	Document document = parse(url);
	info = document.selectNodes(path);
	} catch (DocumentException e) {
	e.printStackTrace();
	}
	return info;
}

@SuppressWarnings("unchecked")
public List<Element> getXmlInfo(String path) throws DocumentException {
	List<Element> info = new ArrayList<Element>();
	info = document.selectNodes(path);
	return info;
}

public Element getFirstNodeTitle(String path, URL url) {
	List<Element> list = getXmlInfo(path, url);
	Element element = list.get(0);
	return element;
}

public Element getFirstNodeTitle(String path) throws DocumentException {
	List<Element> list = getXmlInfo(path);
	Element element = list.get(0);
	return element;
}

/**
* ͨ��rss��ַ��ȡrss����
* 
* @param uri
* @return
*/
public RssBean getRssBean(String uri) {

	RssBean rss = new RssBean();
	URL url;
	try {
	url = new URL(uri);
	parseUrl(url);
	
	List<Element> listRoot = getXmlInfo("//channel");
	for (Iterator<Element> iter = listRoot.iterator(); iter.hasNext();) {
		Element element = (Element) iter.next();
		Node title = element.selectSingleNode(RSS_DOM_ROOT_TITLE);
		Node link = element.selectSingleNode(RSS_DOM_ROOT_LINK);
		Node description = element
		.selectSingleNode(RSS_DOM_ROOT_DESCRIPTION);
		System.out.println(description.getText()
		+ description.getText());
		rss.setTitle(title.getText());
		rss.setDescription(description.getText());
		rss.setLink(link.getText());
		
	}
	List<Element> list = getXmlInfo(RSS_DOM_CHILRDEN_ROOT);
	for (Iterator<Element> iter = list.iterator(); iter.hasNext();) {
		Element element = (Element) iter.next();
		Node title = element
		.selectSingleNode(RSS_DOM_CHILRDEN_ROOT_TITLE);
		Node link = element
		.selectSingleNode(RSS_DOM_CHILRDEN_ROOT_LINK);
		Node time = element
		.selectSingleNode(RSS_DOM_CHILRDEN_ROOT_PUBDATE);
		
		Node description = element
		.selectSingleNode(RSS_DOM_CHILRDEN_ROOT_DESCRIPTION);
		RssBean rs = new RssBean();
		rs.setTitle(title.getText());
		rs.setDate(time.getText());
		rs.setDescription(description.getText());
		rs.setLink(link.getText());
		rss.getItems().add(rs);
		
	 }
	return rss;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

public RssBean getRSSrsult(String url) throws IOException {

	RssUtil r = new RssUtil();
	RssBean rs;

	String result = r.isHtmlOrXml(url);
	
	if ("xml".equals(result)) {
	
		rs = getRssBean(url);
	} else if ("error".equals(result)) {
		rs = null;
	} else {
		rs = getRssBean(result);
	}
	return rs;
}

//public static void main(String args[]) throws IOException {
//
//	String url = "http://news.baidu.com/n?cmd=1&class=socianews&tn=rss";
//	Rss t = new Rss();
//	RssBean rs;
//	rs = t.getRSSrsult(url);
//	System.out.println(rs.getTitle());
//	for(RssBean bean:rs.getItems())
//	{
//		System.out.println(bean.getTitle());
//	}
//
//}
public void setDocument(Document document) {
	this.document = document;
}

public Document getDocument() {
	return document;
 }
}
