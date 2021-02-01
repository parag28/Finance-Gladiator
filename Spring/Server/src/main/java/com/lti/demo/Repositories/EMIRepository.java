package com.lti.demo.Repositories;

import com.lti.demo.POJOs.EMI;

import java.util.List;

public interface EMIRepository {
    public String addEMI(EMI emi);
    public EMI getEMI(int emiId);
    public List<EMI> getAllEMIs();
    public String updateEMI(EMI emi);
}
