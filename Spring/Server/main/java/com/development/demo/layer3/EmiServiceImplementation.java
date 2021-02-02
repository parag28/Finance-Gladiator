package com.development.demo.layer3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.demo.layer1.Emi;
import com.development.demo.layer2.EMIRepository;

@Service
public class EmiServiceImplementation implements EmiService {
	@Autowired
	EMIRepository eMIRepository;
	@Override
	public String addEMIService(Emi emi) {
		 try{
		        return eMIRepository.addEMI(emi);
		    }
		    catch(Exception e){
		      System.out.println(e.getMessage());
		      return "fail";
		    }
	}

	@Override
	public Emi getEMIService(int emiId) {
		 try{
		      return eMIRepository.getEMI(emiId);
		    }
		    catch(Exception e){
		      System.out.println(e.getMessage());
		      return null;
		    }
	}

	@Override
	public List<Emi> getAllEMIsService() {
		try{
		      return eMIRepository.getAllEMIs();
		}
		catch(Exception e){
		      System.out.println(e.getMessage());
		      return null;
		}
	}

	@Override
	public String updateEMIService(Emi emi) {
		try{
		      return eMIRepository.updateEMI(emi);
		}
		catch(Exception e){
		    System.out.println(e.getMessage());
		    return "fail";
		}
	}

}
