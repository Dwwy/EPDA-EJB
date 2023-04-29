package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.Staff;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StaffDAO extends GenericDAO<Staff> implements StaffDAOI{

    public StaffDAO(){
        super(Staff.class);
    }
    public boolean createStaff(Staff staff){
        try{
            this.create(staff);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateStaff(Staff staff){
        try {
            this.update(staff);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteStaff(Staff staff){
        this.delete(staff);
    }
    public List<Staff> getAllStaffs() {
        return this.findAll();
    }
    public Staff getStaffbyId(String id) {
        return this.findById(id);
    }
    public Staff getStaffbyUserID(String id){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("userId");
        query.setValue(id);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<Staff> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output.get(0);
        }
    }

}
