package service;

import java.util.List;

import entity.NewsEntity;
import repository.NewsRepository;

public class NewsService {
	private NewsRepository newrepo=new NewsRepository();
	public  List<NewsEntity> getAllNews(){
		return newrepo.findAll();
	}
}
