package zombies.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import java.util.Random

import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import zombies.ReLogoTurtle

class Spawner4Random extends ReLogoTurtle {
	def humansSpawned = 0
	def maxHumans = 150
	def lastAisle = 1
	Random rand = new Random()

	def arrayX = new int[150]
	def arrayY = new int[150]
	def count = 0



	def step() {
		for (int i = 15; i >= 1; i--) {
			for (int j = 0; j <12; j++) {
				if (j != 3 && j != 8)
				{
					if (count == 150)
						break
					arrayX[count] = j
					arrayY[count] = i
					count++
				}
			}
		}

		// If there's no one in the spawn area and we have not spawned everyone
		if ((count(humansHere())==0) && (humansSpawned < maxHumans)) {
			label = "Next!"
			// Create a human
			hatchHumans(1){
				size = 1
				// How much luggage does this human have
				// TO DO:maxLuggage = rand.nextInt(10)

				// Sky blue
				setColor(95)
				// If the last person was sent to aisle 1
				targetSeatXCor = arrayX[UserObserver.randomSeats[humansSpawned]]
				targetSeatYCor = arrayY[UserObserver.randomSeats[humansSpawned]]
			}
			// Keep track of how many people have been spawned
			humansSpawned++
		}
		else {
			label = ""
		}
	}
}
