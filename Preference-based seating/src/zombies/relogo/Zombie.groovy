package zombies.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import zombies.ReLogoTurtle

class Zombie extends ReLogoTurtle {
	
	// Has someone claimed the seat?
	def claimed = false
	// Which row the seat is in, goes from 1 to 15
	def row
	// Which column the seat is in, goes from 0 to 11, with no seats in columns 3 or 8
	def column
	// Id of the seat
	def id
	
	def step() {
		// If there is a person here
		label = id
		if (count(humansHere())==1) {
			setColor(95)
		}
		// If two people have sat down in the same seat
		else if (count(humansHere())>1){
			setColor(45)
		}
	}
	
	//def infect(Human human) {
	//	human.infected = true
	//}
}
