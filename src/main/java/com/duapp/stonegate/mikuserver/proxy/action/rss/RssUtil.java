package com.duapp.stonegate.mikuserver.proxy.action.rss;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class RssUtil {
private Document doc;

public String isHtmlOrXml(String url) throws IOException {
	doc = Jsoup.connect(url)
			.data("query", "Java")
			.userAgent("Mozilla")
			.cookie("auth", "token")
			.timeout(6000)
			.get();
	Elements head = doc.select("rss");
	if (head.size() < 1) {
		Elements rssEl = doc.select("link[type=application/rss+xml]");
		if (rssEl.size() < 1) {
		return "eorr";
		} else {
		return rssEl.get(0).attr("href");
		}
	} else {
		return "xml";
	}
}
}