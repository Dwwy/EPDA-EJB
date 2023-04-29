package com.example.demo1.Dao;

import com.example.demo1.Model.Staff;

import javax.ejb.Local;
import java.util.List;
@Local
public interface StaffDAOI {
    boolean createStaff(Staff staff);
    boolean updateStaff(Staff staff);
    void deleteStaff(Staff staff);
    List<Staff> getAllStaffs();
    Staff getStaffbyId(String id);
    Staff getStaffbyUserID(String id);
}
