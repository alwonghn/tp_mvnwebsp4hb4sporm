package demo.dao;
import java.util.List; 
import demo.entity.AppUser;


public interface AppUserDao {
	public List<AppUser> listAll();
}