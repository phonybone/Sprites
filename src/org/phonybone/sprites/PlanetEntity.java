package org.phonybone.sprites;
import java.lang.Math.*;

public class PlanetEntity extends Entity {
	private Game game;
	private String name;
	private double mass;
	private final double G=6.67428e-11;	// m^3 * kg^-1 * sec^-2
	private double fx,fy;
	
	public PlanetEntity(Game game,String ref,String name, int x,int y, double dx, double dy, double mass) {
		super(ref,x,y);
		
		this.game = game;
		this.name=name;
		this.dx=dx;
		this.dy=dy;
		this.mass=mass;
	}
	
	public double[] gForce2d(PlanetEntity p2) {
		double f=G*this.mass*p2.mass/distance2d(p2);
		double[] f2d= new double[2];
		f2d[0]=f*java.lang.Math.cos(angle2d(p2));
		f2d[1]=f*java.lang.Math.sin(angle2d(p2));        
        return f2d;
	}
	
	public double distance2d(PlanetEntity p2) {
		double ddx=this.x-p2.x;
		double ddy=this.y-p2.y;
		return ((ddx*ddx)+(ddy*ddy));
	}
	
	public double angle2d(PlanetEntity p2){
		return java.lang.Math.atan((this.y-p2.y)/(this.x-p2.x));
	}
	
	public String to_s() {
		String s=this.name+": mass="+this.mass
			+" x="+this.x
			+" y="+this.y
			+" dx="+this.dx
			+" dy="+this.dy
			+" fx="+this.fx
			+" fy="+this.fy;
		return s;
	}
	
	public static void sumForces2d(PlanetEntity[] planets, int n_planets) {
		int i,j;
		// Clear all forces
		for (i=0; i<n_planets; i++){
			planets[i].fx=planets[i].fy=0;
		}
		for (i=0; i<n_planets; i++){
			for (j=0; j<i; j++){
				double[] f2d=planets[i].gForce2d(planets[j]);
				planets[i].fx+=f2d[0];
				planets[i].fy+=f2d[1];
				planets[j].fx-=f2d[0];
				planets[j].fy-=f2d[1];
			}
		}
	}
};
