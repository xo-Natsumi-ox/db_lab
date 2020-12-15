package com.shevchuk.controller.implementation;

import com.shevchuk.controller.GeneralController;
import com.shevchuk.service.GeneralService;

import java.util.List;

public abstract class GeneralControllerImpl<T, ID> implements GeneralController<T, ID> {

    @Override
    public abstract GeneralService<T, ID> getService();

    @Override
    public T getEntityById(ID id) {
        return getService().findById(id);
    }

    @Override
    public void findAll() {
        List<T> listObj = getService().findAll();
        for (T obj : listObj) {
            System.out.println(obj);
        }
    }

    @Override
    public void findById(ID id) {
        T obj = getService().findById(id);
        System.out.println(obj);
    }

    @Override
    public void create(T entity) {
        getService().create(entity);
        System.out.println("object created");
    }

    @Override
    public void update(T entity) {
        getService().update(entity);
        System.out.println("object updated");
    }

    @Override
    public void delete(ID id) {
        getService().delete(id);
        System.out.println("object deleted");
    }
}
