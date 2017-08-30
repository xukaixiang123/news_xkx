package com.newcapec.edu.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateCode extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("image/jpeg");
		   //
		   BufferedImage image = new BufferedImage(100, 20, BufferedImage.TYPE_INT_RGB);
		   Graphics2D g = (Graphics2D) image.getGraphics();
			Random rd = new Random();
			

		//    g.setColor(new Color(rd.nextInt(256), rd.nextInt(256), rd.nextInt(256)));
		   g.setColor(Color.WHITE);
		   g.fillRect(0, 0, 100, 20);
		  
		   g.setFont(new Font(null, Font.BOLD, 20));
		   String[]b = {"1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		StringBuffer num =new StringBuffer();
			for(int i = 0 ; i < 4 ; i++){
				int nextInt = rd.nextInt(b.length);
				num.append(  b[nextInt]);
		 g.setColor(new Color(rd.nextInt(256), rd.nextInt(256), rd.nextInt(256)));
		 g.drawString(b[nextInt],20*(i+1), 20);
			}
			
			request.getSession().setAttribute("num", num);
		   ImageIO.write(image, "jpg", response.getOutputStream());
		   

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
