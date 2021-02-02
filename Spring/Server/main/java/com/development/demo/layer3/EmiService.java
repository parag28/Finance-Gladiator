package com.development.demo.layer3;

import java.util.List;

import com.development.demo.layer1.Emi;

public interface EmiService {
	public String addEMIService(Emi emi);
    public Emi getEMIService(int emiId);
    public List<Emi> getAllEMIsService();
    public String updateEMIService(Emi emi);
}
