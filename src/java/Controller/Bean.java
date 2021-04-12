/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GenericDao;
import Model.Account;
import Model.Blood;
import Model.BloodBank;
import Model.Donor;
import Model.Hospital;
import Model.Request;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author The Crush
 */
@ManagedBean(name = "bean")
@SessionScoped
public class Bean {

    public Bean() {
    }

    GenericDao<Donor> donorDao = new GenericDao<>(Donor.class);
    GenericDao<Request> requestDao = new GenericDao<>(Request.class);
    GenericDao<Hospital> hospitalDao = new GenericDao<>(Hospital.class);
    GenericDao<BloodBank> bloodBankDao = new GenericDao<>(BloodBank.class);
    GenericDao<Blood> bloodDao = new GenericDao<>(Blood.class);
    GenericDao<Account> accDao = new GenericDao<>(Account.class);
    private Donor donor = new Donor();
    private Hospital hospital = new Hospital();
    private BloodBank bloodBank = new BloodBank();
    private Request request = new Request();
    private List<Hospital> hospitals;
    private String hospitalName;
    private String bloodBankName;
    private String hospitalUsername;
    private String bloodBankUsername;
    private String hospitalPassword;
    private String bloodBankPassword;
    private String username;
    private String password;
    private String location;

    public String donorsignUp() {
        try {
            Donor donorData = donorDao.findByOne(Donor.class, username);
            if (donorData.getUsername() != null || donorData.getPassword().equals(donorData.getPassword())) {
                FacesMessage msg = new FacesMessage("Password or username already taken");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            donorDao.createX(donor);
            Account account = new Account(donor.getUsername(), donor.getPassword(), "Donor");
            accDao.createX(account);
            return "LoginForm";
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Not saved !!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "DonorSignUp";
        }
    }

    public String hospitalSignUp() {
        try {
            hospitalDao.createX(hospital);
            Account account = new Account(hospital.getUsername(), hospital.getPassword(), "Hospital");
            accDao.createX(account);
            return "LoginForm";
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Not saved !!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "HospitalSignUp";
        }
    }

    public String bloodBankSignUp() {
        try {
            bloodBankDao.createX(bloodBank);
            Account account = new Account(bloodBank.getUsername(), bloodBank.getPassword(), "Blood bank");
            accDao.createX(account);
            return "LoginForm";

        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Not saved !!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "BloodBankSignUp";
        }

    }

    public String signIn() {
        try {
            Account accountUsername = accDao.findByOne(Account.class, username);

            if (accountUsername != null && password.matches(accountUsername.getPassword())
                    && accountUsername.getRole().equals("Donor")) {
                return "DonorWelcomePage";
//                    
            } else if (accountUsername != null && password.matches(accountUsername.getPassword())
                    && accountUsername.getRole().equals("Hospital")) {
                return "HospitalWelcomePage";

            } else if (accountUsername != null && password.matches(accountUsername.getPassword())
                    && accountUsername.getRole().equals("Blood bank")) {
                return "BloodBankWelcomePage";

            } else {
                return "LoginForm";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "LoginForm";
    }

    public List<Hospital> getHospitalList() {

        List<Hospital> list = new ArrayList<>();

        hospitalDao.findAll().forEach((hosp) -> {
            list.add(hosp);
        });
        return list;
    }

    public List<Donor> getDonorList() {

        List<Donor> list = new ArrayList<>();
        donorDao.findAll().forEach((don) -> {
            list.add(don);
        });
        return list;
    }

    public List<BloodBank> getbloodBankList() {

        List<BloodBank> list = new ArrayList<>();
        bloodBankDao.findAll().forEach((bbk) -> {
            list.add(bbk);
        });
        return list;
    }

    public List<Blood> getbloodList() {

        List<Blood> list = new ArrayList<>();
        bloodDao.findAll().forEach((blood) -> {
            list.add(blood);
        });
        return list;
    }

    public List<Request> getRequestList() {

        List<Request> list = new ArrayList<>();
        requestDao.findAll().forEach((req) -> {
            list.add(req);
        });
        return list;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public BloodBank getBloodBank() {
        return bloodBank;
    }

    public void setBloodBank(BloodBank bloodBank) {
        this.bloodBank = bloodBank;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String bloodBankName) {
        this.bloodBankName = bloodBankName;
    }

    public String getHospitalUsername() {
        return hospitalUsername;
    }

    public void setHospitalUsername(String hospitalUsername) {
        this.hospitalUsername = hospitalUsername;
    }

    public String getBloodBankUsername() {
        return bloodBankUsername;
    }

    public void setBloodBankUsername(String bloodBankUsername) {
        this.bloodBankUsername = bloodBankUsername;
    }

    public String getHospitalPassword() {
        return hospitalPassword;
    }

    public void setHospitalPassword(String hospitalPassword) {
        this.hospitalPassword = hospitalPassword;
    }

    public String getBloodBankPassword() {
        return bloodBankPassword;
    }

    public void setBloodBankPassword(String bloodBankPassword) {
        this.bloodBankPassword = bloodBankPassword;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

}
