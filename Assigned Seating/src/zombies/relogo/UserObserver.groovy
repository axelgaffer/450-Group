package zombies.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import java.util.Random
import java.util.concurrent.ThreadLocalRandom;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import zombies.ReLogoObserver;

class UserObserver extends ReLogoObserver{
	
	
	static def claimedList = new boolean[160]
	static Random rand = new Random()
	static int seatsTaken = 0
	static def randomSeats = new int[150]
	
	@Setup
	def setup(){
		clearAll()
		for (int i = 0; i < 150; i++)
		{
			randomSeats[i] = i
		}
		shuffleArray(randomSeats)
		Random rand = new Random()
		setDefaultShape(Spawner, "triangle")
		createSpawners(1) {
			setxy(11, 0)
			setColor(65)
		}
		setDefaultShape(Human, "person")
		setDefaultShape(Zombie, "square")
		for (int i = 0; i<=159; i++) {
			claimedList[i] = false
		}
		def nextId = 0
		for (int i = 1; i <16; i++) {
			for (int j = 0; j <12; j++) {
				if (j != 3 && j != 8)
				{
					createZombies(1){
						setColor(15)
						setxy(j,i)
						row = i
						column = j
						id = nextId
						size = 0.9
						nextId++
					}
				}
			}
		}
	}
	@Go
	def go(){
		ask(zombies()){
			step()
		}
		ask(humans()){
			step()
		}
		ask(spawners()){
			step()
		}
		if (seatsTaken == maxHumans){
			seatsTaken = 0
			pause()
		}
	}

	def remainingHumans() {
		count(humans())
	}
	def seatsTaken() {
		seatsTaken
	}
	def shuffleArray(int[] ar)
	{
	  Random rnd = ThreadLocalRandom.current()
	  for (int i = ar.length - 1; i > 0; i--)
	  {
		int index = rnd.nextInt(i + 1)
		// Simple swap
		int a = ar[index]
		ar[index] = ar[i]
		ar[i] = a
	  }
	}
}