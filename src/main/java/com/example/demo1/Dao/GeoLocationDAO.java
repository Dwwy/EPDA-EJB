package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GeoLocationDAO extends GenericDAO<GeoLocation> implements GeoLocationDAOI{

    public GeoLocationDAO(){
        super(GeoLocation.class);
    }
    public boolean createGeoLocation(GeoLocation location){
        try{
            this.create(location);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateGeoLocation(GeoLocation location){
        try {
            this.update(location);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteGeoLocation(GeoLocation location){
        this.delete(location);
    }
    public List<GeoLocation> getAllGeoLocation() {
        return this.findAll();
    }
    public GeoLocation getGeoLocationbyId(String id) {
        return this.findById(id);
    }
    public List<GeoLocation> getAllGeoLocationbyUserId (String userId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("userId");
        query.setValue(userId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
