/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import DAO.GenericDao;
import Model.Blood;
import Model.Donor;
import Model.Hospital;
import Model.Request;
import Model.BloodBank;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The Crush
 */
public class TestClass {

    public static void main(String[] args) {
        try {
            GenericDao<Donor> donorDao = new GenericDao<>(Donor.class);
//            GenericDao<Patient> patientDao = new GenericDao<>(Patient.class);
            GenericDao<Request> requestDao = new GenericDao<>(Request.class);
            GenericDao<Hospital> hospitalDao = new GenericDao<>(Hospital.class);
            GenericDao<BloodBank> bloodBankDao = new GenericDao<>(BloodBank.class);
            GenericDao<Blood> bloodDao = new GenericDao<>(Blood.class);

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat df = new DecimalFormat("00");
            
            Donor donor1 = new Donor("IZABAYO", "Samuel", formatter.parse("2000-06-02"), String.format("%010d",788888888), "Kigali", "d1", "d1pass");
            Donor donor2 = new Donor("NIYOMURINZI", "Elisee", formatter.parse("2002-12-04"),String.format("%010d",784090860), "Kigali", "d2", "d2pass");
            Donor donor3 = new Donor("ISIMBI", "Ines", formatter.parse("2006-04-08"),String.format("%010d",782406789), "Bugesera", "d3", "d3pass");
            Donor donor4 = new Donor("UWAMAHORO", "Aline", formatter.parse("2012-08-16"),String.format("%010d",789312468), "Nyagatare", "d4", "d4pass");
            donorDao.createX(donor1);
            donorDao.createX(donor2);
            donorDao.createX(donor3);
            donorDao.createX(donor4);

            BloodBank bb1 = new BloodBank("B1", "Kigali", "bb1", "b1pass");
            BloodBank bb2 = new BloodBank("B2", "Bugesera", "bb2", "b2pass");
            BloodBank bb3 = new BloodBank("B3", "Gatsibo", "bb3", "b3pass");
            BloodBank bb4 = new BloodBank("B4", "Nyanza", "bb4", "b4pass");
            bloodBankDao.createX(bb1);
            bloodBankDao.createX(bb2);
            bloodBankDao.createX(bb3);
            bloodBankDao.createX(bb4);

            Hospital hospital1 = new Hospital("King Faisal", "Kigali", "h1", "h1pass");
            Hospital hospital2 = new Hospital("CHUK", "Kigali", "h2", "h2pass");
            Hospital hospital3 = new Hospital("Muhima", "Kigali", "h3", "h3pass");
            Hospital hospital4 = new Hospital("Kibagabaga", "Kigali", "h4", "h4pass");
            hospitalDao.createX(hospital1);
            hospitalDao.createX(hospital2);
            hospitalDao.createX(hospital3);
            hospitalDao.createX(hospital4);

            Blood blood1 = new Blood("A", 1, donor1, bb1);
            Blood blood2 = new Blood("B", 0.4, donor2, bb2);
            Blood blood3 = new Blood("AB", 0.6, donor3, bb3);
            Blood blood4 = new Blood("O", 0.8, donor4, bb4);
            bloodDao.createX(blood1);
            bloodDao.createX(blood2);
            bloodDao.createX(blood3);
            bloodDao.createX(blood4);

//            Patient patient1 = new Patient("P1", "P11",  formatter.parse("2001-01-01"), 100, GENDER.MALE, "Kigali", hospital1);
//            Patient patient2 = new Patient("P3", "P33",  formatter.parse("2003-03-03"), 300, GENDER.MALE, "Muhanga", hospital2);
//            Patient patient3 = new Patient("P5", "P55",  formatter.parse("2005-05-05"), 500, GENDER.FEMALE, "Huye", hospital3);
//            Patient patient4 = new Patient("P7", "P77",  formatter.parse("2007-07-07"), 700, GENDER.FEMALE, "Rusizi", hospital4);
//            patientDao.createX(patient1);
//            patientDao.createX(patient2);
//            patientDao.createX(patient3);
//            patientDao.createX(patient4);
            Request request1 = new Request("O", formatter.parse("2012-02-02"), hospital4);
            Request request2 = new Request("AB", formatter.parse("2014-07-04"), bb2);
            Request request4 = new Request("B", formatter.parse("2016-09-05"), donor3);
            requestDao.createX(request1);
            requestDao.createX(request2);
            requestDao.createX(request4);
        } catch (ParseException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
