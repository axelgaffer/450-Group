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

class Spawner extends ReLogoTurtle {
	def humansSpawned = 0
	def maxHumans = 150
	def lastAisle = 1
	Random rand = new Random()
	
	def step() {
		// If there's no one in the spawn area and we have not spawned everyone
		if ((count(humansHere())==0) && (humansSpawned < maxHumans)) {
			label = "Next!"
			// Create a human
			hatchHumans(1){
				size = 1
				// How much luggage does this human have
				maxLuggage = rand.nextInt(10)
				// How frustrated will this person need to get before sitting
				patience = rand.nextInt(100)
				// Sky blue
				setColor(95)
				// If the last person was sent to aisle 1
				if (lastAisle == 1)
				{
					// This person's aisle is 0
					aisle = 0
					lastAisle = 0
				}
				else {
					aisle = 1
					lastAisle = 1
				}
			}
			// Keep track of how many people have been spawned
			humansSpawned++
		}
		else {
			label = ""
		}
	}
}
