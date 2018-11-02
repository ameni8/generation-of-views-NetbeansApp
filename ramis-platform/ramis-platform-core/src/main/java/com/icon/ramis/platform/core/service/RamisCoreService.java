/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.service;

import com.icon.ramis.platform.core.model.Ambulance;
import java.util.List;
import net.vpc.upa.PersistenceUnit;
import net.vpc.upa.UPA;

/**
 *
 * @author ameni
 */
public class RamisCoreService {
    private static final RamisCoreService instance=UPA.getContext().makeSessionAware(new RamisCoreService());

    public static RamisCoreService getInstance() {
        return instance;
    }
    
    

    public void addAmbulance(Ambulance a) {
        UPA.getPersistenceUnit().persist(a);
    }

    public List<Ambulance> findAmbulancesByCity(String cityName) {
        final PersistenceUnit pu = UPA.getPersistenceUnit();
        return pu.createQuery("Select a from Ambulance a where a.city.name=:cityName")
                .setParameter("cityName", cityName)
                .getResultList();
    }
}
