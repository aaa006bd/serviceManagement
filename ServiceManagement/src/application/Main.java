package application;
	
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import data.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static SessionFactory sessionFactory;
	private Stage primaryStage;
	private MainSceneController mainSceneController;
	private final CustomerModel customerModel = new CustomerModel();
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		
		showPrimaryStage(primaryStage);			
		mainSceneController.setMainApp(this);
		

		
	}
	private void showPrimaryStage(Stage primaryStage) {
		try {			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("MainScene.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			mainSceneController = loader.getController();
			
			mainSceneController.setModel(customerModel);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		buildSessionFactory();
//		addUser();
		launch(args);
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static SessionFactory buildSessionFactory() throws HibernateException{
		
		sessionFactory =new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		
		return sessionFactory;
	}
	
	public static void addUser(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(new User("aaa", "aaa006bd@gmail.com", "notgonnatellya"));
		
		tx.commit();
		session.close();
		
	}
}
