import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {
    private static SessionFactory _sessionFactory;

    public UserDao(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public static int register(User user){
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int result = (Integer)session.save(user);
        transaction.commit();
        session.close();

        return result;
    }

    public static boolean isRegistered(User user){
        Session session = _sessionFactory.openSession();
        String SQL_QUERY = "FROM User where login=:userLogin";// and password=:userPass";
        org.hibernate.query.Query query = session.createQuery(SQL_QUERY);
        query.setParameter("userLogin", user.getLogin());
        //query.setParameter("userPass", user.getPassword());
        List list = query.list();
        return list.size() > 0;
    }

    public static boolean isEntryDataCorrect(User user){
        Session session = _sessionFactory.openSession();
        String SQL_QUERY = "FROM User where login=:userLogin and password=:userPass";
        org.hibernate.query.Query query = session.createQuery(SQL_QUERY);
        query.setParameter("userLogin", user.getLogin());
        query.setParameter("userPass", user.getPassword());
        List list = query.list();
        return list.size() > 0;
    }
}
