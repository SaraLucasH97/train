package material;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Plateau {
	ArrayList<Rover> roverOnMars;
	ArrayList<String> commandToRover;
	int maxX;
	int maxY;
	
	public Plateau(){
		this.roverOnMars=new ArrayList<>();
		this.commandToRover=new ArrayList<>();
	}
	public void addRover(Rover r){
		this.roverOnMars.add(r);
	}
	public void addCommand(String c){
		this.commandToRover.add(c);
	}
	
	public void moveRover(){
		Iterator<Rover> itRover=roverOnMars.iterator();
		Iterator<String> itCommand=commandToRover.iterator();
		
		//We suppose that both list have the same size
		while(itRover.hasNext()){
			Rover r=itRover.next();
			String command=itCommand.next();
			for(int i=0;i<command.length();i++){
				switch(command.charAt(i)){
					case 'L':
						r.turnLeft();
						break;
					case'R':
						r.turnLeft();
						break;
					case'M':
						r.move();
						break;
					default:
						throw new RuntimeException("This character is not allowed. Use L,R or M.");					
				}
			}
		}
	}
	
	public static void main(String[ ] arg) {
		if(arg.length==0){
			//Without any txt
			System.out.println("It's necessary to provide a txt file as an argument.");
			System.exit(0);
		}else{
			//We have a txt file as an input.
			File file=null;
			Scanner scanner=null;
			try{
				file= new File (arg[0]);
				scanner= new Scanner(file);
				Plateau plateau= new Plateau();
				String[] s;
				//First the size of the plateau
				if(scanner.hasNextLine()){
					String size=scanner.nextLine();
					s=size.split(" ");
					plateau.setMaxX(Integer.parseInt(s[0]));
					plateau.setMaxY(Integer.parseInt(s[2]));
				}
				
				//Next we have to read rovers and command to them				
				while(scanner.hasNextLine()){
					String rover= scanner.nextLine();
					s=rover.split(" ");
					Rover r= new Rover(Integer.parseInt(s[0]),Integer.parseInt(s[1]),s[2]);
					plateau.addRover(r);
					String command= scanner.nextLine();
					plateau.addCommand(command);
				}
				
				//Then we have all the information to get an output
				plateau.moveRover();
				
			}catch (Exception ex){
				ex.printStackTrace();
			}finally{
				//We must close file even if something throws an exception
				try{
					if(scanner!=null){
						scanner.close();
					}
				}catch (Exception ex){
					ex.printStackTrace();
				}
			}
		}
    }
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
}
