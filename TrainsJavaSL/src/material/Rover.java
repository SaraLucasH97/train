package material;

public class Rover {
	Punto coordinate;
	String heading;
	
	public Rover( int x,int y, String h){
		this.coordinate=new Punto(x,y);
		this.heading=h;
	}

	public Punto getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Punto coordinate) {
		this.coordinate = coordinate;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}
}
