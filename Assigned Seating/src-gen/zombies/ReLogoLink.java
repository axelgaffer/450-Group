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

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoLink<T> extends BaseLink<T>	{

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
	 * Returns the value of the global variable numHumans.
	 *
	 * @return the value of the global variable numHumans
	 */
	@ReLogoBuilderGeneratedFor("global: numHumans")
	public Object getNumHumans(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numHumans");
	}

	/**
	 * Sets the value of the global variable numHumans.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numHumans")
	public void setNumHumans(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numHumans",value);
	}

	/**
	 * Returns the value of the global variable numZombies.
	 *
	 * @return the value of the global variable numZombies
	 */
	@ReLogoBuilderGeneratedFor("global: numZombies")
	public Object getNumZombies(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numZombies");
	}

	/**
	 * Sets the value of the global variable numZombies.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numZombies")
	public void setNumZombies(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numZombies",value);
	}

	/**
	 * Returns the value of the global variable gestationPeriod.
	 *
	 * @return the value of the global variable gestationPeriod
	 */
	@ReLogoBuilderGeneratedFor("global: gestationPeriod")
	public Object getGestationPeriod(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("gestationPeriod");
	}

	/**
	 * Sets the value of the global variable gestationPeriod.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: gestationPeriod")
	public void setGestationPeriod(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("gestationPeriod",value);
	}


}