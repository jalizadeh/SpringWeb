package com.jalizadeh.springweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jalizadeh.springweb.model.Car;
import com.jalizadeh.springweb.util.DbUtil;

//Car Data Access Object
public class CarDAO {
	private Connection connection;
	
	public CarDAO() {
		this.connection = DbUtil.getConnection();
	}
	
	public void addCar(Car car) {
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into cars(manufacturer,mode) "
												+ "values (?,?)");
			preparedStatement.setString(1, car.getManufacturer());
			preparedStatement.setInt(2, car.getModel());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCar(int carid) {
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("delete from cars "
												+ " where carid = ?");
			preparedStatement.setInt(1, carid);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateCar(Car car) {
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("update Cars set "
												+ " manufacturer = ?"
												+ " model = ?"
												+ " where carid = ?");
			preparedStatement.setString(1, car.getManufacturer());
			preparedStatement.setInt(2, car.getModel());
			preparedStatement.setInt(3, car.getCarid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Car> getAllCars(){
		List<Car> cars = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cars");
			while(rs.next()) {
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getInt("model"));
						
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	
	public Car getCarById(int carid) {
		Car car = new Car();
		
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("select * from cars "
												+ " where carid = ?");
			preparedStatement.setInt(1, carid);
			ResultSet rs = preparedStatement.executeQuery();
			
			//only if there is the result
			if(rs.next()) {
				car.setCarid(rs.getInt("carid"));
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getInt("model"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return car;
	}
	
	
}