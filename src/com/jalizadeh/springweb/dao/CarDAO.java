package com.jalizadeh.springweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			PreparedStatement preparedStatement = connection.prepareStatement("insert into cars(manufacturer,mode) values (?,?)");
			preparedStatement.setString(1, car.getManufacturer());
			preparedStatement.setInt(2, car.getModel());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCar(int carid) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from cars where carid = ?");
			preparedStatement.setInt(1, carid);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
