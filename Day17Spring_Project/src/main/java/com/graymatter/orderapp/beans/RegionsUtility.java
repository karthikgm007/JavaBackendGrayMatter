package com.graymatter.orderapp.beans;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;
 
import org.springframework.stereotype.Component;
 
import lombok.AllArgsConstructor;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.ToString;
 
@AllArgsConstructor

@NoArgsConstructor

@Setter

@Getter

@ToString

@Component
public class RegionsUtility implements RegionsInterface{

	Connection con;

	@Override
	public List<Regions> getAll() throws SQLException {
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from Regions");
		List<Regions> rlist = new ArrayList<Regions>();
		while(rs.next())
			rlist.add(new Regions(rs.getInt(1),rs.getString(2)));
		return rlist;
	}

	@Override
	public Regions addRegion(Regions region) throws SQLException {
		PreparedStatement ps = con.prepareStatement("insert into regions values(?,?)");
		ps.setInt(1, region.getRegion_id());
		ps.setString(2, region.getRegion_name());
		ps.executeUpdate();
		
		ps = con.prepareStatement("select *from regions where region_id = ?");
		ps.setInt(1, region.getRegion_id());
		ResultSet rs = ps.executeQuery();
		
		Regions savedRegion = null;
		
		while(rs.next()) {
			savedRegion = new Regions(rs.getInt(1), rs.getString(2));
		}
		return savedRegion;
	}

	@Override
	public Regions getRegionById(int rid) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select *from regions where region_id = ?");
		ps.setInt(1, rid);
		ResultSet rs = ps.executeQuery();
		
		Regions retrievedRegion = null;
		while(rs.next()) {
			retrievedRegion = new Regions(rs.getInt(1), rs.getString(2));
		}
		
		return retrievedRegion;
	}

	@Override
	public Regions updateRegion(Regions region) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select *from regions where region_id = ?");
		ps.setInt(1, region.getRegion_id());
		ResultSet rs = ps.executeQuery();
		
		Regions retrievedRegion = null;
		if(rs.next()) {
			ps = con.prepareStatement("update regions set region_id = ?, region_name=? where region_id = ?");
			ps.setInt(1, region.getRegion_id());
			ps.setString(2, region.getRegion_name());
			ps.setInt(3, region.getRegion_id());
			retrievedRegion = new Regions(region.getRegion_id(), region.getRegion_name());
			System.out.println("region updated");
		}
		else {
			System.out.println("Given region does not exist");
		}
		return retrievedRegion;
	}

	@Override
	public void deleteRegion(int rid) throws SQLException {
	    try (PreparedStatement ps = con.prepareStatement("DELETE FROM regions WHERE region_id = ?")) {
	        ps.setInt(1, rid);
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Region Deleted");
	        } else {
	            System.out.println("No Region Found with ID: " + rid);
	        }
	    }
	}

}

 