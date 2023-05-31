package com.ex;
import java.io.IOException;
import java.util.Iterator;

/*
 * ���̽� BeautifulSoup�� �̿��� ũ�Ѹ�
 * Java������ Jsoup�� �̿�
 * 
 * ���̺귯�� �ٿ�ε�: http://jsoup.org/download 
 * 
===pom.xml�� Jsoup���̺귯�� ���==================================
 <!-- https://mvnrepository.com/artifact/org.jsoup/jsoup -->
		<dependency>
			<groupId>org.jsoup</groupId>
			<artifactId>jsoup</artifactId>
			<version>1.15.3</version>
		</dependency>
=================================================================		
 * 
 * */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.common.CommonUtil;

public class CrawlingTest {

	public static void main(String[] args) {
		//CGV ��ȭ ������ ��������
		String url="http://www.cgv.co.kr/movies/?";
		
		//https://www.melon.com/chart/index.htm ==> Melon��ũ
		Document doc=null;
		
		try {
			//http�������ݸ� ����. https���������� ���Ȼ� �ȵȴ�
			doc=Jsoup.connect(url).get();
			//�ش� url�� ���������� ��ü �ҽ��� Document�� ��� ��ȯ
			//System.out.println(doc);
			
			//���߿��� �츮�� �ʿ��� �����͸� �����ؾ���
			Elements element=doc.select("div.sect-movie-chart");
			//System.out.println(element);
			
			//Elements rankEle=element.select("strong.rank");
			//System.out.println(rankEle);
			Iterator<Element> movie_rank=element.select("strong.rank").iterator();//��ȭ ����
			//��ȭ ����
			Iterator<Element> movie_name=element.select("strong.title").iterator();
			//��ȭ ������
			Iterator<Element> movie_reserve=element.select("strong.percent span").iterator();			
			//��ȭ ����(eggs)

			Iterator<Element> movie_score=element.select("div > span.percent").iterator();
			//������
			Iterator<Element> open_day=element.select("span.txt-info strong").iterator();
			//System.out.println(open_day);
			
			//��ȭ�̹���
			Iterator<Element> movie_img=element.select("span.thumb-image img").iterator();
			
			int cnt=1;
			while(movie_rank.hasNext()) {
				MovieVO vo=new MovieVO();
				vo.setMovie_no(cnt++);
				vo.setMovie_rank(movie_rank.next().text());
				vo.setMovie_name(movie_name.next().text());
				vo.setMovie_reserve(movie_reserve.next().text());
				vo.setMovie_score(movie_score.next().text());
				vo.setOpen_day(open_day.next().text().substring(0,11));
				
				String imgUrl=movie_img.next().attr("src");//��ȭ�̹��� ���
				vo.setMovie_image(imgUrl);
				
				
				vo.setRank_checkTime(CommonUtil.getDateTime("yyyy-MM-dd HH:mm:ss"));//����� �ú���
				System.out.println("vo: "+vo);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
