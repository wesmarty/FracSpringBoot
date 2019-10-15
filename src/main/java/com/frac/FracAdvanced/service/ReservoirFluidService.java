/**
 * 
 */
package com.frac.FracAdvanced.service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frac.FracAdvanced.model.FluidLibraryModel;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.ReservoirFluidModel;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;
import com.frac.FracAdvanced.repository.ReservoirFluidRepo;

/**
 * @author ShubhamGaur
 *
 */

@Service
public class ReservoirFluidService {

		@Autowired
		ReservoirFluidRepo fluidRepo;		
		@Autowired
		ProjectDetailRepo detailRepo;
		
		
		public java.util.List<ReservoirFluidModel> getListMethod(int pid, String ftype) throws Exception
		{			
				//int pid1= Integer.parseInt(pid);			
			java.util.List<ReservoirFluidModel> x12=fluidRepo.findByFluidtypeAndDetails(ftype, detailRepo.getOne(pid));					
			return x12;
		}
		
	public java.util.List<ReservoirFluidModel> methodEditValue(int pid, String ftype, java.util.List<String> value)
				throws Exception
		{		
			//int pid1= Integer.parseInt(pid);
			java.util.List<ReservoirFluidModel> x12=fluidRepo.findByFluidtypeAndDetails(ftype, detailRepo.getOne(pid));					
			for(int i=0;i<x12.size();i++) {			 					
	            x12.get(i).setValue(value.get(i));
	            fluidRepo.save(x12.get(i));			}
			java.util.List<ReservoirFluidModel> x123=fluidRepo.findByFluidtypeAndDetails(ftype, detailRepo.getOne(pid));					
			return x123;		}	
		
		public void methodEditWellType(int pid, String wellType) throws Exception
		{			
				//int pid1= Integer.parseInt(pid);
		    	ProjectDetails p1=detailRepo.getOne(pid);		    	
	            List<ReservoirFluidModel>	all=fluidRepo.findBydetails(p1);
	            for(int i=0;i<all.size();i++)
	            {
	            	
	            		
	            	all.get(i).setWellType(wellType);
	            	fluidRepo.save(all.get(i));
	            }
					}	
		
		
	/*	public List<ReservoirFluidModel> findByPId(Integer pid){
			ProjectDetails details=detailRepo.findById(pid).orElse(null);
			return fluidRepo.findBydetails(details);
		}
		public List<String> fluidType(Integer pid,String fluidtype){
			ProjectDetails details=detailRepo.findById(pid).orElse(null);
			List<ReservoirFluidModel> list;
			List<String> returnlist=new ArrayList<>();
			if(fluidtype.replaceAll("\\s+","").equalsIgnoreCase("oilproperties")) {
				list=fluidRepo.findBydetails(details);
				for(int i=0;i<list.size();i++) {
					if(i<=4) {
					returnlist.add(list.get(i).getParam());
					}
				}
			}else if(fluidtype.replaceAll("\\s+","").equalsIgnoreCase("gasproperties")) {
				if(!(fluidRepo.findByFluidtypeAndDetails("Oil Properties", details).isEmpty())) {
				list=fluidRepo.findByFluidtypeAndDetails("Oil Properties", details);}
				else {
					list=fluidRepo.findBydetails(details);
				}
				for(int i=0;i<list.size();i++) {
					if((i<=7)&&(!(list.get(i).getParam().replaceAll("\\s+","").equalsIgnoreCase("EffectivePermiability(md)")))) {
					returnlist.add(list.get(i).getParam());
					}
				}
			}else if(fluidtype.replaceAll("\\s+","").equalsIgnoreCase("waterproperties")) {
				if(!(fluidRepo.findByFluidtypeAndDetails("Oil Properties", details).isEmpty())) {
					list=fluidRepo.findByFluidtypeAndDetails("Oil Properties", details);}
					else {
						list=fluidRepo.findBydetails(details);
					}
				for(int i=0;i<list.size();i++) {
					if(!(i==6||i==7)&&(!(list.get(i).getParam().replaceAll("\\s+","").equalsIgnoreCase("EffectivePermiability(md)")))) {
					returnlist.add(list.get(i).getParam());
					}
				}
			}
			
			return returnlist;
		}
		
		public void saveReservoirFluid(Integer pid,List<String> param,List<String> value,String fluidtype) {
			ProjectDetails details=detailRepo.findById(pid).orElse(null);
			List<ReservoirFluidModel> list=fluidRepo.findBydetails(details);
			
			for(int i=0;i<list.size();i++) {
				ReservoirFluidModel fluidModel;
				if(list.get(0).getFluidtype().equalsIgnoreCase("N/A"))
				{fluidModel=list.get(i);
				fluidModel.setDetails(details);
				if(i<param.size()) {
					fluidModel.setParam(param.get(i));
					fluidModel.setValue(value.get(i));
					}
					fluidModel.setFluidtype(fluidtype);
					fluidRepo.save(fluidModel);
				}else {
				fluidModel=new ReservoirFluidModel();
				if(i<param.size()) {
					fluidModel.setDetails(details);
					fluidModel.setParam(param.get(i));
					fluidModel.setValue(value.get(i));
					fluidModel.setFluidtype(fluidtype); 
					fluidRepo.save(fluidModel);
					}
				}
			}
		}*/
}
