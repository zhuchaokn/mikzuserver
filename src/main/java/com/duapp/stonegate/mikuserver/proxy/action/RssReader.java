package com.duapp.stonegate.mikuserver.proxy.action;

import com.duapp.stonegate.mikuserver.proxy.action.rss.Rss;
import com.duapp.stonegate.mikuserver.proxy.action.rss.RssBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;



public class RssReader extends ActionBase {
	private  String urlStr="http://news.baidu.com/n?cmd=1&class=socianews&tn=rss"; 
	private int newsCount=3;
    Logger logger= LoggerFactory.getLogger(getClass());
	@Override
	public void handle() {
		// TODO Auto-generated method stub
		getLines();
	}
	public void getLines()
	{
		Rss rss=new Rss();
		String res="现在为您播报新闻，";
		RssBean bean;
		try {
			bean = rss.getRSSrsult(urlStr);
			List<RssBean> list=bean.getItems();
			for(int i=0;i<newsCount;i++)
			{
			   res+=list.get(i).getTitle()+";";
			}
			this.instructionDTO.setLines(res);
		} catch (IOException e) {
			logger.error("getNewsError",e);
		}
		
		
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
}
