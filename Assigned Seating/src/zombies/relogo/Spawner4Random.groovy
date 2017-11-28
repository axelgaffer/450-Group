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
	def count1 = 0
	def count2 = 0

	def step() {
		for (int j = 0; j < 6; j++)
			if (j != 3){
				for (int i = 15; i >=1; i--){
					if (count1 == 150 || count2 == 150)
						break
					arrayX[count1] = j
					arrayY[count1] = i
					count1 = count1 + 2
				}
			}

		for (int j = 11; j >6; j--)
			if (j != 8){
				for (int i = 15; i >=1; i--){
					if (count1 == 150 || count2 == 150)
						break
					arrayX[count2] = j
					arrayY[count2] = i
					count2 = count2 + 2
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
				targetSeatXCor = arrayX[humansSpawned]
				targetSeatYCor = arrayY[humansSpawned]
			}
			// Keep track of how many people have been spawned
			humansSpawned++
		}
		else {
			label = ""
		}
	}
}
