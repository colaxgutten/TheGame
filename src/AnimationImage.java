
public class AnimationImage {
	public String name;
	public long delay;
	/**
	 * @params
	 * String name - navnet på bildet som skal hentes fra hashmap
	 * long delay - hvor lenge bildet skal vare i animasjonen
	 */
	public AnimationImage(String name, long delay) {
		this.name = name;
		this.delay = delay;
	}
}
