package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.CarDao;
import com.mycompany.myproject.persist.entity.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Car> getAllCars() {
        return em.createQuery("FROM Car")
                .getResultList();
    }


    @Override
    public void addNewCar(Car car) {
        em.persist(car);

    }

    @Override
    public void removeCar(Long carId) {
        Car toDeleteCar = this.getCarById(carId);
        em.remove(toDeleteCar);
    }

    @Override
    public Car getCarById(Long carId) {
        List list = em.createQuery("FROM Car where carId=:carId")
                .setParameter("carId",carId).getResultList();
        return (list.isEmpty()) ? null : (Car) list.get(0);

    }

    @Override
    public Car getCarByName(String carName) {

        List list = em.createQuery("FROM Car where carName=:carName")
                .setParameter("carName", carName).getResultList();
        return (list.isEmpty()) ? null : (Car) list.get(0);
    }

    @Override
    public void updateCar(Long carId, String name, Long seats, float rate) {
        Query query = em
             .createQuery("UPDATE Car set seatsNumber=:seats, carName=:name, carPriceRate=:rate  where carId=:carId")
             .setParameter("seats",seats)
             .setParameter("rate", rate)
             .setParameter("name",name)
             .setParameter("carId", carId);
        query.executeUpdate();
    }
}
