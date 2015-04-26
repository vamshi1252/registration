package com.dealz.registration.dao.commons;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import com.dealz.registration.dao.commons.AbstractDAO;

import com.google.common.base.Preconditions;


//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//public  class AbstractDaoImpl<T extends Serializable> implements AbstractDAO<T> {
//
//    private Class<T> entityClass;
//    
//    @Autowired
//    private SessionFactory sessionFactory;
//    
//    /* package private */ AbstractDaoImpl() {
//
//    }
//    
//    public AbstractDaoImpl(Class<T> entityClass) {
//        
//        if (entityClass == null) {
//            throw new IllegalArgumentException("Entity class should not be null");
//        }
//        
//        this.entityClass = entityClass;
//    }
//    
//    /* package private */ void setEntityClass(Class<T> clazz) {
//        this.entityClass = clazz;
//    }
//    
//    public Class<T> getEntityClass() {
//        return this.entityClass;
//    }
//    
//    @SuppressWarnings("unchecked")
//    public T getById(final Serializable id) {
//        Preconditions.checkArgument(id != null, "Id should not be null");
//        return (T)getCurrentSession().get(getEntityClass(), id);
//    }
//    
//    
//    @SuppressWarnings("unchecked")
//	public List<T> getAll() {
//        return getCurrentSession().createCriteria(entityClass).list();
//    }
//    
//    public T save(T object) {
//        getCurrentSession().save(object);
//        return object;
//    }
//    
//    public T update(T object) {
//        getCurrentSession().update(object);
//        return object;
//    }
//    
//    public void flush() {
//        getCurrentSession().flush();
//    }
//    
//    public T saveOrUpdate(T object) {
//        getCurrentSession().saveOrUpdate(object);
//        return object;
//    }
//    
//    @SuppressWarnings("unchecked")
//    public T getByNaturalId(final Serializable naturalId) {
//        Preconditions.checkArgument(naturalId != null, "Natural id should not be null");
//        return (T)getCurrentSession().bySimpleNaturalId(getEntityClass()).load(naturalId);
//    }
//    
//    protected Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }
//    
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//    
//    public void delete(T object){
//        getCurrentSession().delete(object);
//    }
//    
//    public void detach(T object) {
//        getCurrentSession().evict(object);
//    }
//    
//    @SuppressWarnings("unchecked")
//    public T merge(T object) {
//        return (T) getCurrentSession().merge(object);
//    }
//}
//
