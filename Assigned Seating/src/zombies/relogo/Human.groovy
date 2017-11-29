package zombies.relogo

import java.util.Random
import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import zombies.ReLogoTurtle

class Human extends ReLogoTurtle {
	// State:
	// 0 = heading towards both aisles
	// 1 = heading towards left aisle
	// 2 = walking down the current aisle
	// 4 = arrived at row, not yet sat down
	// 5 = sat down
	def state = 0
	// maxLuggage: How much time someone will spend blocking the aisle putting their luggage away
	// int maxLuggage = 20
	// remainingLuggage: How much time is left for putting luggage up
	def remainingLuggage = maxLuggage
	// Seat the person has been assigned
	int targetSeatXCor
	int targetSeatYCor

	def step() {
		// State: If just arrived at plane
		if (state == 0) {
			// Face left
			facexy(getXcor()-1,getYcor())
			// Check if there's someone blocking you
			def peopleInFront = count(humansOn(patchAhead(1)))
			// If there is no one in front of you
			if (peopleInFront == 0) {
				// Move forward
				forward(1)
			}
			// If you've arrived at the right aisle
			if (getXcor() == 8) {
				// and your seat is closer to the left aisle
				if (targetSeatXCor <= 5)
					// Start walking towards the left aisle
					state = 1
				else
					// Start walking up the right aisle
					state = 2
			}
		}
		// State: If you're walking towards the second aisle
		else if (state == 1) {
			// Face left
			facexy(getXcor()-1,getYcor())
			// Check if there's someone blocking you
			def peopleInFront = count(humansOn(patchAhead(1)))
			// If there is no one in front of you
			if (peopleInFront == 0) {
				// Move forward
				forward(1)
			}
			// If you've arrived at the second aisle
			if (getXcor() == 3)
				// Begin walking up the current aisle
				state = 2
		}
		// State: If you're walking up the aisle
		else if (state == 2) {
			// Check if you're currently standing in the correct row
			if ((int)getYcor() >= targetSeatYCor)
				// Enter state 4 - about to sit down
				state = 4
			else {
				// Face up
				facexy(getXcor(),getYcor()+1)
				// Check if there's someone blocking you
				def peopleInFront = count(humansOn(patchAhead(1)))
				// If there is no one in front of you
				if (peopleInFront == 0) {
					// Move forward
					forward(1)
				}
			}
			// If all seats in rows ahead of you are taken
			// else if there are empty seats in the rows in front of you
		}
		// State: Trying to sit down, blocking the aisle
		else if (state == 4) {
			// If your remaining luggage is 0
			if (remainingLuggage <= 0) {
				// Set current position to chosen seat
				setXcor(targetSeatXCor)
				setYcor(targetSeatYCor)
				// Enter state 5
				state = 5
			}
			// If your remaining luggage is not 0
			else {
				// Decrease remaining luggage by 1, and do nothing else
				remainingLuggage--
			}
		}
		// State: Seated
		else if (state == 5) {
			// Do nothing
		}
	}
}