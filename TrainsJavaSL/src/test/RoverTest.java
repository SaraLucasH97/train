package test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import material.Punto;
import material.Rover;

import org.junit.Before;
import org.junit.Test;

public class RoverTest {
	Punto p;
	Rover r;
	
	@Before
	public void setUp(){
		p=mock(Punto.class);
		when(p.getX()).thenReturn(3);
		when(p.getY()).thenReturn(4);
		r=new Rover(p,"N");
	}
	
	@Test
	public void coordinateTest() {		
		r.turnLeft();
		assertThat(r.getHeading()).isEqualTo("W");
		r.turnRight();
		assertThat(r.getHeading()).isEqualTo("N");
		r.turnRight();
		assertThat(r.getHeading()).isEqualTo("E");
	}
	
	@Test
	public void moveTest() {			
		r.turnLeft();
		r.move();
		verify(p).setX(4);				
		r.turnRight();
		r.move();
		verify(p).setY(5);				
	}

}
