package com.billennium.petproject.dao.impl;

import com.billennium.petproject.dao.UserDao;
import com.billennium.petproject.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    private List<UserEntity> users = new ArrayList<>();

    @Override
    public UserEntity get(int id) {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(UserEntity.class);
        Root contactRoot = criteria.from(UserEntity.class);
        return (UserEntity) criteria.select(contactRoot)
                .where(builder.equal(contactRoot.get("id"), id));
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public int save(UserEntity userEntity) {
        return 0;
    }

    @Override
    public void update(UserEntity userEntity) {

    }

    @Override
    public void delete(UserEntity userEntity) {

    }

    @Override
    public UserEntity findUserByEmail(String email) {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(UserEntity.class);
        Root contactRoot = criteria.from(UserEntity.class);
        return (UserEntity) criteria.select(contactRoot)
                .where(builder.equal(contactRoot.get("email"), email));
    }
}
