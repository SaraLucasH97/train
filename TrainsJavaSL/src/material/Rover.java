package material;


public class Rover {
	Punto coordinate;
	String heading;
	
	public Rover( int x,int y, String h){
		this.coordinate=new Punto(x,y);
		this.heading=h;
	}
	public Rover( Punto p, String h){
		this.coordinate=p;
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
	public void turnRight() {
		switch(this.heading){
			case "N":
				this.heading="E";
				break;
			case "S":
				this.heading="W";
				break;
			case "E":
				this.heading="S";
				break;
			case "W":
				this.heading="N";
				break;			
		}
		
	}
	public void turnLeft() {
		switch(this.heading){
		case "N":
			this.heading="W";
			break;
		case "S":
			this.heading="E";
			break;
		case "E":
			this.heading="N";
			break;
		case "W":
			this.heading="S";
			break;			
		}
	}

	public void move() {
		int n;
		switch(this.heading){
		case "N":
			n=this.coordinate.getY();
			this.coordinate.setY(n+1);
			break;
		case "S":
			n=this.coordinate.getY();
			this.coordinate.setY(n-1);
			break;
		case "E":
			n=this.coordinate.getX();
			this.coordinate.setX(n+1);
			break;
		case "W":
			n=this.coordinate.getX();
			this.coordinate.setX(n-1);
			break;			
		}		
	}
	public String toString(){
		return this.getCoordinate()+" "+this.getHeading();
	}
}
