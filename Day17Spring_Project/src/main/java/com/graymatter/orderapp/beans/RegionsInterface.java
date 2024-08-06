package com.graymatter.orderapp.beans;

import java.sql.SQLException;
import java.util.List;

public interface RegionsInterface {

	public List<Regions> getAll() throws SQLException;
	public Regions addRegion(Regions region) throws SQLException;
	public Regions getRegionById(int rid) throws SQLException;
	public Regions updateRegion(Regions region) throws SQLException;
	public void deleteRegion(int rid) throws SQLException;
	
	
	
}
