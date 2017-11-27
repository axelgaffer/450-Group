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
	// 2 = walking down the left aisle
	// 3 = walking down the right aisle
	// 4 = arrived at row, not yet sat down
	// 5 = sat down
	def state = 0
	// Frustration: How many time units someone has spent not moving when they could have sat
	//  as this variable increases, they are more likely to take an adjacent seat
	def frustration = 0
	// Patience: If frustration exceeds patience, the person will take their seat
	def patience
	// Aisle: Whether they will target the first or second aisle
	def aisle
	// maxLuggage: How much time someone will spend blocking the aisle putting their luggage away
	def maxLuggage
	// remainingLuggage: How much time is left for putting luggage up
	def remainingLuggage = maxLuggage
	// Is the person seated
	def seated = false
	// Seat the person has chosen
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
				// and you are assigned the left aisle
				if (aisle == 0)
					// Start walking towards the left aisle
					state = 1
				else
					// Start walking up the right aisle
					state = 3
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
		// State: If you're walking up the left aisle
		else if (state == 2) {
			// Need to check if there are any seats not taken ahead of you
			// Count number of rows ahead of you
			def rowsAhead = 15-getYcor()
			// The total number of seats ahead is 7 times the number of rows
			def totalSeatsAhead = rowsAhead * 7
			// Starzt empty seats ahead as total number of seats, and decrease it by 1 for every taken seat
			def emptySeatsAhead = totalSeatsAhead
			// loop from row ahead of you to last row
			for (int i = getXcor()+1; i <=15; i++){
				// loop from window seat to last eligible seat
				for (int j = 0; j <=7; j++) {
						// If the seat at this coordinate is claimed
						// if (isSeatClaimed(zombie((i*10)+j)) == true) {
						if (UserObserver.claimedList[(i*10)+j] == true) {
						//if (isSeatClaimed(minOneOf(zombiesOn(patch(j,i)), {id}) == true) {
							// Decrease number of empty seats
							emptySeatsAhead--
						}
				}
			}
			// If all seats in rows ahead of you are taken
			// TODO: Consider making last row with non empty seats a global target for all people instead of constantly checking
			// TODO: Consider number of people in front of you in line
			if (emptySeatsAhead <= 0)
			{
				// pick the highest priority open seat in the current row
				sitInThisRowLeft((int)getYcor())
				// Enter state 4
				state = 4
			}
			// else if there are empty seats in the rows in front of you
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
				// If you were blocked from moving forward
				else {
					// Increase current frustration
					frustration++				
					// If there is an open seat in your current row
					if (isAnyEmptySeatInRowLeft((int)getYcor())) {					
						// Use frustration to check if you will decide to sit now
						def chanceToSitNow = frustration * 4
						// If you will sit now
						if (chanceToSitNow > patience) {
							// pick your seat, preferring window > outer aisle > inner aisle > outer middle > inner middle close > inner middle far > middle far aisle
							sitInThisRowLeft((int)getYcor())
							// Enter state 4
							state = 4
						}
						// If you will not sit now, do nothing
					}
					// If there is no open seat in your row
					else {
					//Do nothing
					}
				}
			}
		}
		// State: If you're walking up the right aisle
		else if (state == 3) {
			// If there are no empty seats in the rows in front of you
				
				// pick the highest priority open seat in the current row, priority as follows:
				// window > outer aisle > inner aisle > outer middle > inner middle close > inner middle far > far middle aisle
				
				// Mark seat as taken so no one else can take it while you sit down
				// TODO: Account for 2 different people in opposite aisles claiming the same middle seat somehow
				
				// Enter state 4
			
			// else if there are empty seats in the rows in front of you
			
				// Face up
				facexy(getXcor(),getYcor()+1)
				// Check if there's someone blocking you
				def peopleInFront = count(humansOn(patchAhead(1)))
				// If there is no one in front of you
				if (peopleInFront == 0) {
					// Move forward
					forward(1)
				}
				// If you were blocked from moving forward
				else {
					// Increase current frustration
					frustration++
					// Check if there is a seat open in your row
				
					// If there is an open seat in your current row
				
						// Use frustration to check if you will decide to sit now
				
						// If you will sit now
						
							// pick your seat, pereferring window > outer aisle > inner aisle > outer middle > inner middle close > inner middle far > middle far aisle
				
							// Mark seat as taken so no one else can take it while you sit down
				
							// Enter state 4
						
						// If you will not sit now, do nothing
				
					// If there is no open seat in your row, do nothing
				}
		
		}
	// Trying to sit down
	else if (state == 4) {
		// If your remaining luggage is 0
		if (remainingLuggage <= 0) {
			// Set current position to chosen seat
			setXcor(targetSeatXCor)
			setYcor(targetSeatYCor)
			// Set seated to true
			seated = true
			// Enter state 5
			state = 5
		}
		// If your remaining luggage is not 0
		else {
			// Decrease remaining luggage by 1, and do nothing else
			remainingLuggage--
		}
	}
	// Seated
	else if (state == 5) {
		// Do nothing
	}
}
def isSeatClaimed(Zombie zombie) {
	if (zombie.claimed == true)
		return true
	else
		return false
}
def claimSeat(Zombie zombie) {
	zombie.claimed = true
	targetSeat = zombie
}
def isAnyEmptySeatInRowLeft(int i) {
	def numEmpty = 7
	for (int j = 0; j <=7; j++) {
		if (UserObserver.claimedList[(i-1)*10+j])
		// if (isSeatClaimed(zombie(((i-1)*10)+j)) == true)
				numEmpty--
		}
	return (numEmpty > 0)
}
def sitInThisRowLeft(int k) {
	// Seating priority:
	// window > outer aisle > inner aisle > outer middle > inner middle close > inner middle far > far middle aisle
	// column 0 > 2 > 3 > 1 > 4 > 5 > 6
	def priority1 = new int[7]
	priority1[0] = 0
	priority1[1] = 2
	priority1[2] = 3
	priority1[3] = 1
	priority1[4] = 4
	priority1[5] = 5
	priority1[6] = 6
	
	// Loop from the list of seats in order of priority
	for (int i = 0; i < 7; i++){
		// Is someone on this seat?
		if (UserObserver.claimedList[(k-1)*10+priority1[i]] == false) {
		//def Zombie checkingSeat = zombie(((k-1)*10)+priority1[i])
		// def Zombie checkingSeat = minOneOf(zombiesOn(patch(k, priority1[i])), {id})
		// If no,
		//if (checkingSeat.claimed == false) {
			// Mark that seat as taken so no one else can take it while you sit down and set it as target
			UserObserver.claimedList[(k-1)*10+priority1[i]] = true
			
			// claimSeat(checkingSeat)
			targetSeatXCor = priority1[i]
			if (targetSeatXCor >= 3)
				targetSeatXCor++
			targetSeatYCor = k
			break
		}
	}
	// TODO if time: Account for 2 different people in opposite aisles claiming the same middle seat somehow
	// TODO if time: Account for needing to turn around
}
}