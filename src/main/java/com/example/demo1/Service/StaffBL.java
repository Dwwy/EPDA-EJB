package com.example.demo1.Service;

import com.example.demo1.Dao.StaffDAOI;
import com.example.demo1.Dao.UserDAOI;
import com.example.demo1.Model.Input.StaffInput;
import com.example.demo1.Model.Output.StaffProfile;
import com.example.demo1.Model.Staff;
import com.example.demo1.Model.UpdateInput.StaffUpdate;
import com.example.demo1.Model.User;
import com.example.demo1.Util.ImgUp_Down;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
@Stateless
public class StaffBL implements StaffBLI{
    @EJB
    StaffDAOI staffDAO;
    @EJB
    UserDAOI userDAO;
    @EJB
    UserBLI userBL;
    public Response register(StaffInput input){
        if (userDAO.createUser(input.toUser())){
            User user = userDAO.getUserbyEmail(input.getEmail());
            try {
                String url = ImgUp_Down.uploadImage(input.getProfile()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (IOException e) {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while uploading image");
            }
            input.setUserId(user.getId());
            if (staffDAO.createStaff(input.toStaff())){
                Staff staff = staffDAO.getStaffbyUserID(user.getId());
                return new Response(new StaffProfile(staff,user));
            }
            else {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while creating staff");
            }
        }
        else {
            return new Response(false, "Error occurred while creating user");
        }
    }
    public Response update(StaffUpdate input){
        if (input.getProfile()!= null){
            try {
                String url = ImgUp_Down.uploadImage(input.getProfile()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (IOException e) {
                return new Response(false, "Error occurred while uploading image");
            }
        }
        Staff staff = staffDAO.getStaffbyId(input.getStaffId());
        if (staff == null){
            return new Response(false, "Staff not found");
        }
        else {
            if (input.getPassword() != null || input.getEmail() != null){
                userBL.update(input.toUserUpdate(staff.getUserId()));
            }
            staffDAO.updateStaff(input.toStaff(staff));
            return new Response(true);
        }
    }
    public StaffProfile getStaffProfilebyStaffId(String staffId){
        Staff staff = staffDAO.getStaffbyId(staffId);
        User user = userDAO.getUserbyId(staff.getUserId());
        return new StaffProfile(staff, user);
    }
    public StaffProfile getStaffProfilebyUserId(String id){
        User user = userDAO.getUserbyId(id);
        Staff staff = staffDAO.getStaffbyUserID(id);
        return new StaffProfile(staff,user);
    }
}
