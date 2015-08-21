package SKE13;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;

public class Screen extends JFrame{

	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	public int wh;
	public int[] pixels;
	public int h, k;
	public float zz = 0;
	public float rotate = 0;
	public int r = 200;
	public int n = 9;
	
	public Screen (int width, int height) {
		pixels = new int[width*height];
		this.width = width;
		this.height = height;
		wh = width*height;
		h = width/2;
		k = height/2;
		setResizable(false);
		setTitle("Polygon");
		setSize(width, height);
		setLocation(50, 5);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void render(Graphics2D g2d) {
		clear();
		int[] a = new int[5];
		int[] b = new int[5];
		/*g2d.setColor(Color.green);
		g2d.drawString("Hello world", 500, 500);
		g2d.setColor(Color.blue);
		g2d.fillOval(50, 50, 300, 100);
		g2d.setColor(Color.green);
		g2d.drawRoundRect(100, 100, 400, 400, 20, 20);*/
		/*drawLine2(300,300,(int)(300+200*Math.cos(zz)),(int)(300+200*Math.sin(zz)));
		zz += 2*Math.PI/360.0;
		if (zz > 2*Math.PI) zz = 0;*/
		//drawCircle(100,100,10);
		//drawCircle(200,300,10);
		polygon(g2d,rotate);
		rotate+=0.01;
		if (rotate > 100000000) rotate = 0;
		//h+=2;
		//k+=2;
		//h%=width;
		//k%=height;
	}
	
	public void polygon(Graphics2D g2d, float a) {
		
		int[][] zeta = new int[n][2];
		float initZ = a;
		float z = (float) (2*Math.PI/n);
		
		for (int i = 0; i < n; i++) {
			zeta[i][0] = (int) (h + r*Math.sin(initZ));
			zeta[i][1] = (int) (k + r*Math.cos(initZ));
			initZ += z;
		}
		
		for (int i = 0; i < n; i++) {
			int x = zeta[i][0];
			int y = zeta[i][1];
			drawCircle();
		}
		
		for (int i = 0; i < n; i++) {
			int k = (i+1)%n;
			//drawLine2(zeta[i][0], zeta[k][0], zeta[i][1], zeta[k][1]);
			//int k = (i+1)%n;
			drawLine2(zeta[i][0],zeta[i][1],zeta[k][0],zeta[k][1]);
		}
	}
	
	public void drawCircle() {
		double h = width/2;
		double k = height/2;
		double r = 10.00;
		double r2 = r*r;
		for (double i = h-r ; i < h+r; i ++) {
			for (double j = k-r ; j < k+r; j ++) {
				int p = (int) (i+j*width);
				int d = (int) ((i-h)*(i-h) + (j-k)*(j-k));
				if (d < r2 && d > r2-200) pixels[p] = -1;
			}
		}
	}
	
	public void drawLine2(int x1,int y1,int x2,int y2){
		int xmid = (x1+x2) >> 1;
		int ymid = (y1+y2) >> 1;
		if ((x1 == xmid && y1 == ymid) || (x2 == xmid && y2 == ymid)) return;
		int p = xmid + ymid*width;
		if (p > 0 && p < wh) pixels[p] = -1;
		drawLine2(x1,y1,xmid,ymid);
		drawLine2(xmid,ymid,x2,y2);
	}
	
	public void drawLine(float x1,float y1,float x2,float y2) {
		float m = (float) ((y2 - y1 + 0.0)/(x2 - x1));
		
		for (float j = Math.min(x2, x1); j < Math.max(x2, x1); j+=0.1) {
			float l = y1 + m*(j - x1);
			int p = (int) (j + l*width);
			if (p <= wh && p  >= 0) {
				pixels[p] = -1;
				pixels[p-width] = -1;
				pixels[p+width] = -1;
			}
		}
	}

	private void clear() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixels[i+j*width] = 0;
			}
		}
	}
}

