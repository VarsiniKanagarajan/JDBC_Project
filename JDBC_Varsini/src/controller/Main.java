package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;
public class Main{

	public static void main(String[]args)throws NumberFormatException,IOException,ClassNotFoundException,SQLException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice,option;
		Login login=new Login();
		LoginDAO logindao=new LoginDAO();
		Product product =new Product();
		ProductDAO productdao=new ProductDAO();
		
		do
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("_________________________________");
			choice=Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1: System.out.println("____________________________________");
			System.out.println("Enter the username: ");
			String username=br.readLine();
			System.out.println("Enter the password: ");
			String password=br.readLine();
			login.setUsername(username);
			login.setPassword(password);
			if(logindao.validate(login))
			{
				System.out.println("____________________________________");
				System.out.println("Login Succesfull");
				
				do
				{
					System.out.println("_______________________");
					System.out.println("1.Add Product");
					System.out.println("2.Display Inventory Details");
					System.out.println("3.Logout");
					System.out.println("___________________________________________________");
					option=Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1: System.out.println("Enter the product id: ");
					int productId=Integer.parseInt(br.readLine());
					System.out.println("Enter the product name: ");
					String productname=br.readLine();
					System.out.println("Enter the min selling quantity: ");
					int minsell=Integer.parseInt(br.readLine());
					System.out.println("Enter the product price: ");
					int price=Integer.parseInt(br.readLine());
					System.out.println("Enter the product quantity: ");
					int qunatity=Integer.parseInt (br.readLine());
					product.setProductName(productname);
					product.setProductId(productId);
					product.setMinSellQuantity(minsell);
					product.setPrice(price);
					product.setQuantity(qunatity);
					
					productdao.addProduct(product);
					break;
					
					case 2: productdao.display();
					break;
					
					case 3: break;
					}
				
				}
				while(option!=3);
			}
			else
			{
				System.out.println("________________________________________________");
				System.out.println("Check your Username & Password");
			}
			break;
			
			case 2: System.out.println("____________________________________________");
			System.out.println("Enter the username: ");
			String name=br.readLine();
			System.out.println("Enter the password: ");
			String pass=br.readLine();
			login.setUsername(name);
			login.setPassword(pass);
			if(logindao.validate(login))
			{
				System.out.println("_______________________________________________");
				System.out.println("Login Successfull");
				
				do
				{
					System.out.println("______________________________________");
					System.out.println("1.Flow Inventory");
					System.out.println("2.Logout");
					System.out.println("___________________________________________");
					option=Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1:productdao.display();
					break;
					
					case 2: break;
					}
				}
					while(option!=2);
				}
			}
			}
			while(choice!=3);
	}
}

	


