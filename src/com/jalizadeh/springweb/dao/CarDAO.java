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
	private String query;
	
	public CarDAO() {
		this.connection = DbUtil.getConnection();
	}
	
	public void addCar(Car car) {
		try {
			query = "insert into"
					+ " cars(manufacturer,model, city, registrationNumber)"
					+ " values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, car.getManufacturer());
			preparedStatement.setInt(2, car.getModel());
			preparedStatement.setString(3, car.getCity());
			preparedStatement.setInt(4, car.getRegistartionNumber());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCar(int carid) {
		try {
			query = "delete"
					+ " from cars"
					+ " where carid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, carid);
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateCar(Car car) {
		try {
			query = "update Cars set "
					+ " manufacturer = ?"
					+ " model = ?"
					+ " city = ?"
					+ " registartionNumber = ?"
					+ " where carid = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, car.getManufacturer());
			preparedStatement.setInt(2, car.getModel());
			preparedStatement.setString(3, car.getCity());
			preparedStatement.setInt(4, car.getRegistartionNumber());
			preparedStatement.setInt(5, car.getCarid());
			
			preparedStatement.executeUpdate();
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
				car.setCity(rs.getString("city"));
				car.setRegistartionNumber(rs.getInt("registartionNumber"));
				
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
			query = "select * from cars "
					+ " where carid = ?";
			
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			preparedStatement.setInt(1, carid);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			//only if there is the result
			if(rs.next()) {
				car.setCarid(rs.getInt("carid"));
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getInt("model"));
				car.setCity(rs.getString("city"));
				car.setRegistartionNumber(rs.getInt("registartionNumber"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return car;
	}
	
	
}