package com.jalizadeh.springweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jalizadeh.springweb.dao.CarDAO;
import com.jalizadeh.springweb.model.Car;

public class CarContoller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/car.jsp";
	private static String LIST_USER = "/listCar.jsp";
	private CarDAO dao;
	ApplicationContext context;
	
	
	public CarContoller() {
		super();
		context = new ClassPathXmlApplicationContext("spring.xml");
		dao = (CarDAO) context.getBean("CarDAO");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")) {
			int carid = Integer.parseInt(request.getParameter("carid"));
			dao.deleteCar(carid);
			forward = LIST_USER;
			request.setAttribute("cars", dao.getAllCars());
		
		} else if(action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int carid = Integer.parseInt(request.getParameter("carid"));
			Car car = dao.getCarById(carid);
			request.setAttribute("car", car);
		
		} else if(action.equalsIgnoreCase("listCar")) {
			forward = LIST_USER;
			request.setAttribute("cars", dao.getAllCars());		
		
		} else {
			forward = INSERT_OR_EDIT;
		} 
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Car car = (Car) context.getBean("car");
		car.setManufacturer(request.getParameter("manufacturer"));;
		car.setModel(Integer.parseInt(request.getParameter("model")));
		
		String  carId = request.getParameter("carid");
		if(carId == null || carId.isEmpty()) {
			dao.addCar(car);			
		} else {
			car.setCarid(Integer.parseInt(carId));
			dao.updateCar(car);
		}
		
		//at any result, it will forward to list of cars
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("cars", dao.getAllCars());
		view.forward(request, response);
	}
	
}