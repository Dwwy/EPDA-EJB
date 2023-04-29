package com.example.demo1.Service;

import com.example.demo1.Model.Input.StaffInput;
import com.example.demo1.Model.Output.StaffProfile;
import com.example.demo1.Model.UpdateInput.StaffUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;

@Local
public interface StaffBLI {
    StaffProfile getStaffProfilebyUserId(String id);
    StaffProfile getStaffProfilebyStaffId(String staffId);
    Response update(StaffUpdate input);
    Response register(StaffInput input);
}
