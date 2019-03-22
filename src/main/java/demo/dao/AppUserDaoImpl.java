package demo.dao;


import java.util.List; 
import demo.entity.AppUser;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


 
public class AppUserDaoImpl implements AppUserDao {
	
	//@Autowired
    private SessionFactory sessionFactory;
 
    public AppUserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
//    @Override
//    @Transactional
//    public List<AppUser> list() {
//        @SuppressWarnings("unchecked")
//        List<AppUser> listUser = (List<AppUser>) sessionFactory.getCurrentSession()
//                .createCriteria(AppUser.class)
//                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
// 
//        return listUser;
//    }
    
	@SuppressWarnings("unchecked")	
	@Override
	public List<AppUser> listAll() {
		System.out.println("INTO APPUSERDAOIMPL LISTALL()");
		//Session session = this.sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		List<AppUser> appUsersList = session.createQuery("from AppUser").list();	
		for (AppUser u : appUsersList) {
//				logger.info("Phone List::" + p);
			System.out.println("App User List::" + u);
		}
		session.close();// added
		return appUsersList;
	}
 
}
