package zombies;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> hatchHumans(int number, Closure closure) {
		AgentSet<zombies.relogo.Human> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Human");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Human){
				result.add((zombies.relogo.Human)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> hatchHumans(int number) {
		return hatchHumans(number,null);
	}

	/**
	 * Returns an agentset of humans from the patch of the caller.
	 * 
	 * @return agentset of humans from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"human")){
			if (t instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of humans on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of humans at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"human")){
			if (t instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Human>();
		}
	}

	/**
	 * Returns an agentset of humans on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of humans on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansOn(Patch p){
		AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"human")){
			if (t instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of humans on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of humans on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansOn(Turtle t){
		AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"human")){
			if (tt instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of humans on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of humans on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Human>();
		}

		Set<zombies.relogo.Human> total = new HashSet<zombies.relogo.Human>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(humansOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(humansOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Human>(total);
	}

	/**
	 * Queries if object is a human.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a human
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public boolean isHumanQ(Object o){
		return (o instanceof zombies.relogo.Human);
	}

	/**
	 * Returns an agentset containing all humans.
	 * 
	 * @return agentset of all humans
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humans(){
		AgentSet<zombies.relogo.Human> a = new AgentSet<zombies.relogo.Human>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Human.class)) {
			if (e instanceof zombies.relogo.Human){
				a.add((zombies.relogo.Human)e);
			}
		}
		return a;
	}

	/**
	 * Returns the human with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public zombies.relogo.Human human(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Human)
			return (zombies.relogo.Human) turtle;
		return null;
	}

	/**
	 * Makes a number of new spawners and then executes a set of commands on the
	 * created spawners.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawners
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> hatchSpawners(int number, Closure closure) {
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Spawner");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Spawner){
				result.add((zombies.relogo.Spawner)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new spawners and then executes a set of commands on the
	 * created spawners.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawners
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> hatchSpawners(int number) {
		return hatchSpawners(number,null);
	}

	/**
	 * Returns an agentset of spawners from the patch of the caller.
	 * 
	 * @return agentset of spawners from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner")){
			if (t instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of spawners on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of spawners at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner")){
			if (t instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Spawner>();
		}
	}

	/**
	 * Returns an agentset of spawners on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of spawners on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersOn(Patch p){
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"spawner")){
			if (t instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawners on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of spawners on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersOn(Turtle t){
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"spawner")){
			if (tt instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawners on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of spawners on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Spawner>();
		}

		Set<zombies.relogo.Spawner> total = new HashSet<zombies.relogo.Spawner>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(spawnersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(spawnersOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Spawner>(total);
	}

	/**
	 * Queries if object is a spawner.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a spawner
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public boolean isSpawnerQ(Object o){
		return (o instanceof zombies.relogo.Spawner);
	}

	/**
	 * Returns an agentset containing all spawners.
	 * 
	 * @return agentset of all spawners
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawners(){
		AgentSet<zombies.relogo.Spawner> a = new AgentSet<zombies.relogo.Spawner>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Spawner.class)) {
			if (e instanceof zombies.relogo.Spawner){
				a.add((zombies.relogo.Spawner)e);
			}
		}
		return a;
	}

	/**
	 * Returns the spawner with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public zombies.relogo.Spawner spawner(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Spawner)
			return (zombies.relogo.Spawner) turtle;
		return null;
	}

	/**
	 * Makes a number of new spawner2OutsideIns and then executes a set of commands on the
	 * created spawner2OutsideIns.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawner2OutsideIns
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> hatchSpawner2OutsideIns(int number, Closure closure) {
		AgentSet<zombies.relogo.Spawner2OutsideIn> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Spawner2OutsideIn");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Spawner2OutsideIn){
				result.add((zombies.relogo.Spawner2OutsideIn)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new spawner2OutsideIns and then executes a set of commands on the
	 * created spawner2OutsideIns.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawner2OutsideIns
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> hatchSpawner2OutsideIns(int number) {
		return hatchSpawner2OutsideIns(number,null);
	}

	/**
	 * Returns an agentset of spawner2OutsideIns from the patch of the caller.
	 * 
	 * @return agentset of spawner2OutsideIns from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> spawner2OutsideInsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Spawner2OutsideIn> result = new AgentSet<zombies.relogo.Spawner2OutsideIn>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner2OutsideIn")){
			if (t instanceof zombies.relogo.Spawner2OutsideIn)
			result.add((zombies.relogo.Spawner2OutsideIn)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of spawner2OutsideIns on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of spawner2OutsideIns at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> spawner2OutsideInsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Spawner2OutsideIn> result = new AgentSet<zombies.relogo.Spawner2OutsideIn>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner2OutsideIn")){
			if (t instanceof zombies.relogo.Spawner2OutsideIn)
			result.add((zombies.relogo.Spawner2OutsideIn)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Spawner2OutsideIn>();
		}
	}

	/**
	 * Returns an agentset of spawner2OutsideIns on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of spawner2OutsideIns on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> spawner2OutsideInsOn(Patch p){
		AgentSet<zombies.relogo.Spawner2OutsideIn> result = new AgentSet<zombies.relogo.Spawner2OutsideIn>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"spawner2OutsideIn")){
			if (t instanceof zombies.relogo.Spawner2OutsideIn)
			result.add((zombies.relogo.Spawner2OutsideIn)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawner2OutsideIns on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of spawner2OutsideIns on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> spawner2OutsideInsOn(Turtle t){
		AgentSet<zombies.relogo.Spawner2OutsideIn> result = new AgentSet<zombies.relogo.Spawner2OutsideIn>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"spawner2OutsideIn")){
			if (tt instanceof zombies.relogo.Spawner2OutsideIn)
			result.add((zombies.relogo.Spawner2OutsideIn)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawner2OutsideIns on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of spawner2OutsideIns on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> spawner2OutsideInsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Spawner2OutsideIn>();
		}

		Set<zombies.relogo.Spawner2OutsideIn> total = new HashSet<zombies.relogo.Spawner2OutsideIn>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(spawner2OutsideInsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(spawner2OutsideInsOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Spawner2OutsideIn>(total);
	}

	/**
	 * Queries if object is a spawner2OutsideIn.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a spawner2OutsideIn
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public boolean isSpawner2OutsideInQ(Object o){
		return (o instanceof zombies.relogo.Spawner2OutsideIn);
	}

	/**
	 * Returns an agentset containing all spawner2OutsideIns.
	 * 
	 * @return agentset of all spawner2OutsideIns
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public AgentSet<zombies.relogo.Spawner2OutsideIn> spawner2OutsideIns(){
		AgentSet<zombies.relogo.Spawner2OutsideIn> a = new AgentSet<zombies.relogo.Spawner2OutsideIn>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Spawner2OutsideIn.class)) {
			if (e instanceof zombies.relogo.Spawner2OutsideIn){
				a.add((zombies.relogo.Spawner2OutsideIn)e);
			}
		}
		return a;
	}

	/**
	 * Returns the spawner2OutsideIn with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner2OutsideIn")
	public zombies.relogo.Spawner2OutsideIn spawner2OutsideIn(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Spawner2OutsideIn)
			return (zombies.relogo.Spawner2OutsideIn) turtle;
		return null;
	}

	/**
	 * Makes a number of new spawner3BackToFronts and then executes a set of commands on the
	 * created spawner3BackToFronts.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawner3BackToFronts
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> hatchSpawner3BackToFronts(int number, Closure closure) {
		AgentSet<zombies.relogo.Spawner3BackToFront> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Spawner3BackToFront");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Spawner3BackToFront){
				result.add((zombies.relogo.Spawner3BackToFront)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new spawner3BackToFronts and then executes a set of commands on the
	 * created spawner3BackToFronts.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawner3BackToFronts
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> hatchSpawner3BackToFronts(int number) {
		return hatchSpawner3BackToFronts(number,null);
	}

	/**
	 * Returns an agentset of spawner3BackToFronts from the patch of the caller.
	 * 
	 * @return agentset of spawner3BackToFronts from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> spawner3BackToFrontsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Spawner3BackToFront> result = new AgentSet<zombies.relogo.Spawner3BackToFront>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner3BackToFront")){
			if (t instanceof zombies.relogo.Spawner3BackToFront)
			result.add((zombies.relogo.Spawner3BackToFront)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of spawner3BackToFronts on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of spawner3BackToFronts at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> spawner3BackToFrontsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Spawner3BackToFront> result = new AgentSet<zombies.relogo.Spawner3BackToFront>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner3BackToFront")){
			if (t instanceof zombies.relogo.Spawner3BackToFront)
			result.add((zombies.relogo.Spawner3BackToFront)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Spawner3BackToFront>();
		}
	}

	/**
	 * Returns an agentset of spawner3BackToFronts on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of spawner3BackToFronts on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> spawner3BackToFrontsOn(Patch p){
		AgentSet<zombies.relogo.Spawner3BackToFront> result = new AgentSet<zombies.relogo.Spawner3BackToFront>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"spawner3BackToFront")){
			if (t instanceof zombies.relogo.Spawner3BackToFront)
			result.add((zombies.relogo.Spawner3BackToFront)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawner3BackToFronts on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of spawner3BackToFronts on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> spawner3BackToFrontsOn(Turtle t){
		AgentSet<zombies.relogo.Spawner3BackToFront> result = new AgentSet<zombies.relogo.Spawner3BackToFront>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"spawner3BackToFront")){
			if (tt instanceof zombies.relogo.Spawner3BackToFront)
			result.add((zombies.relogo.Spawner3BackToFront)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawner3BackToFronts on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of spawner3BackToFronts on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> spawner3BackToFrontsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Spawner3BackToFront>();
		}

		Set<zombies.relogo.Spawner3BackToFront> total = new HashSet<zombies.relogo.Spawner3BackToFront>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(spawner3BackToFrontsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(spawner3BackToFrontsOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Spawner3BackToFront>(total);
	}

	/**
	 * Queries if object is a spawner3BackToFront.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a spawner3BackToFront
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public boolean isSpawner3BackToFrontQ(Object o){
		return (o instanceof zombies.relogo.Spawner3BackToFront);
	}

	/**
	 * Returns an agentset containing all spawner3BackToFronts.
	 * 
	 * @return agentset of all spawner3BackToFronts
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public AgentSet<zombies.relogo.Spawner3BackToFront> spawner3BackToFronts(){
		AgentSet<zombies.relogo.Spawner3BackToFront> a = new AgentSet<zombies.relogo.Spawner3BackToFront>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Spawner3BackToFront.class)) {
			if (e instanceof zombies.relogo.Spawner3BackToFront){
				a.add((zombies.relogo.Spawner3BackToFront)e);
			}
		}
		return a;
	}

	/**
	 * Returns the spawner3BackToFront with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner3BackToFront")
	public zombies.relogo.Spawner3BackToFront spawner3BackToFront(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Spawner3BackToFront)
			return (zombies.relogo.Spawner3BackToFront) turtle;
		return null;
	}

	/**
	 * Makes a number of new spawner4Randoms and then executes a set of commands on the
	 * created spawner4Randoms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawner4Randoms
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> hatchSpawner4Randoms(int number, Closure closure) {
		AgentSet<zombies.relogo.Spawner4Random> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Spawner4Random");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Spawner4Random){
				result.add((zombies.relogo.Spawner4Random)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new spawner4Randoms and then executes a set of commands on the
	 * created spawner4Randoms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawner4Randoms
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> hatchSpawner4Randoms(int number) {
		return hatchSpawner4Randoms(number,null);
	}

	/**
	 * Returns an agentset of spawner4Randoms from the patch of the caller.
	 * 
	 * @return agentset of spawner4Randoms from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> spawner4RandomsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Spawner4Random> result = new AgentSet<zombies.relogo.Spawner4Random>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner4Random")){
			if (t instanceof zombies.relogo.Spawner4Random)
			result.add((zombies.relogo.Spawner4Random)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of spawner4Randoms on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of spawner4Randoms at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> spawner4RandomsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Spawner4Random> result = new AgentSet<zombies.relogo.Spawner4Random>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner4Random")){
			if (t instanceof zombies.relogo.Spawner4Random)
			result.add((zombies.relogo.Spawner4Random)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Spawner4Random>();
		}
	}

	/**
	 * Returns an agentset of spawner4Randoms on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of spawner4Randoms on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> spawner4RandomsOn(Patch p){
		AgentSet<zombies.relogo.Spawner4Random> result = new AgentSet<zombies.relogo.Spawner4Random>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"spawner4Random")){
			if (t instanceof zombies.relogo.Spawner4Random)
			result.add((zombies.relogo.Spawner4Random)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawner4Randoms on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of spawner4Randoms on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> spawner4RandomsOn(Turtle t){
		AgentSet<zombies.relogo.Spawner4Random> result = new AgentSet<zombies.relogo.Spawner4Random>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"spawner4Random")){
			if (tt instanceof zombies.relogo.Spawner4Random)
			result.add((zombies.relogo.Spawner4Random)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawner4Randoms on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of spawner4Randoms on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> spawner4RandomsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Spawner4Random>();
		}

		Set<zombies.relogo.Spawner4Random> total = new HashSet<zombies.relogo.Spawner4Random>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(spawner4RandomsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(spawner4RandomsOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Spawner4Random>(total);
	}

	/**
	 * Queries if object is a spawner4Random.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a spawner4Random
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public boolean isSpawner4RandomQ(Object o){
		return (o instanceof zombies.relogo.Spawner4Random);
	}

	/**
	 * Returns an agentset containing all spawner4Randoms.
	 * 
	 * @return agentset of all spawner4Randoms
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public AgentSet<zombies.relogo.Spawner4Random> spawner4Randoms(){
		AgentSet<zombies.relogo.Spawner4Random> a = new AgentSet<zombies.relogo.Spawner4Random>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Spawner4Random.class)) {
			if (e instanceof zombies.relogo.Spawner4Random){
				a.add((zombies.relogo.Spawner4Random)e);
			}
		}
		return a;
	}

	/**
	 * Returns the spawner4Random with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner4Random")
	public zombies.relogo.Spawner4Random spawner4Random(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Spawner4Random)
			return (zombies.relogo.Spawner4Random) turtle;
		return null;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.UserTurtle){
				result.add((zombies.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.UserTurtle>();
		}
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.UserTurtle>();
		}

		Set<zombies.relogo.UserTurtle> total = new HashSet<zombies.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof zombies.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtles(){
		AgentSet<zombies.relogo.UserTurtle> a = new AgentSet<zombies.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.UserTurtle.class)) {
			if (e instanceof zombies.relogo.UserTurtle){
				a.add((zombies.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public zombies.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.UserTurtle)
			return (zombies.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Makes a number of new zombies and then executes a set of commands on the
	 * created zombies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created zombies
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> hatchZombies(int number, Closure closure) {
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Zombie");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Zombie){
				result.add((zombies.relogo.Zombie)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new zombies and then executes a set of commands on the
	 * created zombies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created zombies
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> hatchZombies(int number) {
		return hatchZombies(number,null);
	}

	/**
	 * Returns an agentset of zombies from the patch of the caller.
	 * 
	 * @return agentset of zombies from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"zombie")){
			if (t instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of zombies on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of zombies at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"zombie")){
			if (t instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Zombie>();
		}
	}

	/**
	 * Returns an agentset of zombies on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of zombies on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesOn(Patch p){
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"zombie")){
			if (t instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of zombies on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of zombies on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesOn(Turtle t){
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"zombie")){
			if (tt instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of zombies on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of zombies on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Zombie>();
		}

		Set<zombies.relogo.Zombie> total = new HashSet<zombies.relogo.Zombie>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(zombiesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(zombiesOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Zombie>(total);
	}

	/**
	 * Queries if object is a zombie.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a zombie
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public boolean isZombieQ(Object o){
		return (o instanceof zombies.relogo.Zombie);
	}

	/**
	 * Returns an agentset containing all zombies.
	 * 
	 * @return agentset of all zombies
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombies(){
		AgentSet<zombies.relogo.Zombie> a = new AgentSet<zombies.relogo.Zombie>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Zombie.class)) {
			if (e instanceof zombies.relogo.Zombie){
				a.add((zombies.relogo.Zombie)e);
			}
		}
		return a;
	}

	/**
	 * Returns the zombie with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public zombies.relogo.Zombie zombie(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Zombie)
			return (zombies.relogo.Zombie) turtle;
		return null;
	}

	/**
	 * Returns the value from the getTaken() method of the underlying patch.
	 * 
	 * @return getTaken() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Seat2")
	public java.lang.Object getTaken(){
		zombies.relogo.Seat2 p = (zombies.relogo.Seat2)patchHere();
		return p.getTaken();
	}

	/**
	 * Calls the setTaken(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Seat2")
	public void setTaken(java.lang.Object value){
		zombies.relogo.Seat2 p = (zombies.relogo.Seat2)patchHere();
		p.setTaken(value);
	}

	/**
	 * Makes a directed infection from a turtle to the caller then executes a set of
	 * commands on the created infection.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created infection
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection createInfectionFrom(Turtle t, Closure closure){
		zombies.relogo.Infection link = (zombies.relogo.Infection)this.getMyObserver().getNetwork("Infection").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed infection from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created infection
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection createInfectionFrom(Turtle t){
			return createInfectionFrom(t,null);
	}

	/**
	 * Makes directed infections from a collection to the caller then executes a set
	 * of commands on the created infections.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created infections
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> createInfectionsFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<zombies.relogo.Infection> links = new AgentSet<zombies.relogo.Infection>();
		for(Turtle t : a){
			links.add((zombies.relogo.Infection)this.getMyObserver().getNetwork("Infection").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed infections from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created infections
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> createInfectionsFrom(Collection<? extends Turtle> a){
		return createInfectionsFrom(a,null);
	}

	/**
	 * Makes a directed infection to a turtle from the caller then executes a set of
	 * commands on the created infection.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created infection
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection createInfectionTo(Turtle t, Closure closure){
		zombies.relogo.Infection link = (zombies.relogo.Infection)this.getMyObserver().getNetwork("Infection").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed infection to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created infection
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection createInfectionTo(Turtle t){
			return createInfectionTo(t,null);
	}

	/**
	 * Makes directed infections to a collection from the caller then executes a set
	 * of commands on the created infections.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created infections
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> createInfectionsTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<zombies.relogo.Infection> links = new AgentSet<zombies.relogo.Infection>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((zombies.relogo.Infection)this.getMyObserver().getNetwork("Infection").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed infections to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created infections
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> createInfectionsTo(Collection<? extends Turtle> a){
		return createInfectionsTo(a,null);
	}

	/**
	 * Queries if there is a directed infection from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed infection from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public boolean inInfectionNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("Infection").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed infections to the caller.
	 * 
	 * @return agentset with directed infections to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet inInfectionNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("Infection").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed infection from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed infection from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection inInfectionFrom(Turtle t){
		return (zombies.relogo.Infection)this.getMyObserver().getNetwork("Infection").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed infections from other turtles to the caller.
	 * 
	 * @return agentset of directed infections from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> myInInfections(){
		AgentSet<zombies.relogo.Infection> result = new AgentSet<zombies.relogo.Infection>();
		for(Object o :  this.getMyObserver().getNetwork("Infection").getInEdges(this)){
			if (o instanceof zombies.relogo.Infection){
				result.add((zombies.relogo.Infection) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed infections to other turtles from the caller.
	 * 
	 * @return agentset of directed infections to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> myOutInfections(){
		AgentSet<zombies.relogo.Infection> result = new AgentSet<zombies.relogo.Infection>();
		for(Object o :  this.getMyObserver().getNetwork("Infection").getOutEdges(this)){
			if (o instanceof zombies.relogo.Infection){
				result.add((zombies.relogo.Infection) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed infection to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed infection to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public boolean outInfectionNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("Infection").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed infections from the caller.
	 * 
	 * @return agentset with directed infections from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet outInfectionNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("Infection").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed infection to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed infection to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection outInfectionTo(Turtle t){
		return (zombies.relogo.Infection)this.getMyObserver().getNetwork("Infection").getEdge(this, t);
	}

	/**
	 * Reports true if there is a infection connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public boolean infectionNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("Infection").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * infections connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet infectionNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("Infection").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's infections.
	 * 
	 * @return agentset of the caller's infections
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> myInfections(){
		AgentSet<zombies.relogo.Infection> result = new AgentSet<zombies.relogo.Infection>();
		for(Object o : this.getMyObserver().getNetwork("Infection").getEdges(this)){
			if (o instanceof zombies.relogo.Infection){
				result.add((zombies.relogo.Infection)o);
			}
		}
		return result;
	}

	/**
	 * Queries if object is a infection.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a infection
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public boolean isInfectionQ(Object o){
		return (o instanceof zombies.relogo.Infection);
	}

	/**
	 * Returns an agentset containing all infections.
	 * 
	 * @return agentset of all infections
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> infections(){
		AgentSet<zombies.relogo.Infection> a = new AgentSet<zombies.relogo.Infection>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Infection.class)) {
			if (e instanceof zombies.relogo.Infection){
				a.add((zombies.relogo.Infection)e);
			}
		}
		return a;
	}

	/**
	 * Returns the infection between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return infection between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection infection(Number oneEnd, Number otherEnd) {
		return (zombies.relogo.Infection)(this.getMyObserver().getNetwork("Infection").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the infection between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return infection between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection infection(Turtle oneEnd, Turtle otherEnd) {
		return infection(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		zombies.relogo.UserLink link = (zombies.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<zombies.relogo.UserLink> links = new AgentSet<zombies.relogo.UserLink>();
		for(Turtle t : a){
			links.add((zombies.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		zombies.relogo.UserLink link = (zombies.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<zombies.relogo.UserLink> links = new AgentSet<zombies.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((zombies.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink inUserLinkFrom(Turtle t){
		return (zombies.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> myInUserLinks(){
		AgentSet<zombies.relogo.UserLink> result = new AgentSet<zombies.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof zombies.relogo.UserLink){
				result.add((zombies.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> myOutUserLinks(){
		AgentSet<zombies.relogo.UserLink> result = new AgentSet<zombies.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof zombies.relogo.UserLink){
				result.add((zombies.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink outUserLinkTo(Turtle t){
		return (zombies.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> myUserLinks(){
		AgentSet<zombies.relogo.UserLink> result = new AgentSet<zombies.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof zombies.relogo.UserLink){
				result.add((zombies.relogo.UserLink)o);
			}
		}
		return result;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof zombies.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> userLinks(){
		AgentSet<zombies.relogo.UserLink> a = new AgentSet<zombies.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.UserLink.class)) {
			if (e instanceof zombies.relogo.UserLink){
				a.add((zombies.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (zombies.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable maxHumans.
	 *
	 * @return the value of the global variable maxHumans
	 */
	@ReLogoBuilderGeneratedFor("global: maxHumans")
	public Object getMaxHumans(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("maxHumans");
	}

	/**
	 * Sets the value of the global variable maxHumans.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: maxHumans")
	public void setMaxHumans(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("maxHumans",value);
	}

	/**
	 * Returns the value of the global variable maxLuggage.
	 *
	 * @return the value of the global variable maxLuggage
	 */
	@ReLogoBuilderGeneratedFor("global: maxLuggage")
	public Object getMaxLuggage(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("maxLuggage");
	}

	/**
	 * Sets the value of the global variable maxLuggage.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: maxLuggage")
	public void setMaxLuggage(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("maxLuggage",value);
	}


}