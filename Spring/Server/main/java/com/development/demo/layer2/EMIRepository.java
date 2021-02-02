package com.development.demo.layer2;

import com.development.demo.layer1.Emi;


import java.util.List;

public interface EMIRepository {
    public String addEMI(Emi emi);
    public Emi getEMI(int emiId);
    public List<Emi> getAllEMIs();
    public String updateEMI(Emi emi);
}
