package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.MysqlConfig;
import entity.NewsEntity;


public class NewsRepository {
	public List<NewsEntity> findAll(){
		List<NewsEntity> listNews = new ArrayList<NewsEntity>();
		String query="SELECT * FROM news";
		Connection connection= MysqlConfig.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				NewsEntity newEntity=new NewsEntity();
				newEntity.setId(rs.getInt("id"));
				newEntity.setTitle(rs.getString("title"));
				newEntity.setContent(rs.getString("content"));
				newEntity.setImage_url(rs.getString("image_url"));
				listNews.add(newEntity);
				
			}
		} catch (Exception e) {
			System.out.println("findAll "+ e.getLocalizedMessage());
		}
		return listNews;
		
	}
}
