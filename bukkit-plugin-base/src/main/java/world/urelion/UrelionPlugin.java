package world.urelion;

import lombok.extern.slf4j.Slf4j;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import proguard.annotation.Keep;

/**
 * base of any {@link UrelionPlugin}
 *
 * @since 2.0.0
 */
@Slf4j
@Keep
public abstract class UrelionPlugin
extends JavaPlugin {
	/**
	 * defines the {@link UrelionPlugin} loading process<br>
	 * Don't override! Use {@link UrelionPlugin#whileLoad()} instead.
	 *
	 * @see UrelionPlugin#whileLoad()
	 *
	 * @since 2.0.0
	 */
	@Override
	public void onLoad() {
		UrelionPlugin.log.trace(
			"Call sequence to process before plugin loading."
		);
		this.beforeLoad();
		UrelionPlugin.log.trace("Call sequence to process plugin loading.");
		this.whileLoad();
		UrelionPlugin.log.trace("Call sequence to process after plugin loading.");
		this.afterLoad();
		UrelionPlugin.log.debug("Plugin loading finished.");
	}

	/**
	 * defines the {@link UrelionPlugin} enabling process<br>
	 * Don't override! Use {@link UrelionPlugin#whileEnable()} instead.
	 *
	 * @see UrelionPlugin#whileEnable()
	 *
	 * @since 2.0.0
	 */
	@Override
	public void onEnable() {
		UrelionPlugin.log.trace(
			"Call sequence to process before plugin enabling."
		);
		this.beforeEnable();
		UrelionPlugin.log.trace("Call sequence to process plugin enabling.");
		this.whileEnable();
		UrelionPlugin.log.trace(
			"Call sequence to process after plugin enabling."
		);
		this.afterEnable();
		UrelionPlugin.log.debug("Plugin enabling finished.");
	}

	/**
	 * defines the {@link UrelionPlugin} disabling process<br>
	 * Don't override! Use {@link UrelionPlugin#whileDisable()} instead.
	 *
	 * @see UrelionPlugin#whileDisable()
	 *
	 * @since 2.0.0
	 */
	@Override
	public void onDisable() {
		UrelionPlugin.log.trace(
			"Call sequence to process before plugin disabling."
		);
		this.beforeDisable();
		UrelionPlugin.log.trace("Call sequence to process plugin disabling.");
		this.whileDisable();
		UrelionPlugin.log.trace(
			"Call sequence to process after plugin disabling."
		);
		this.afterDisable();
		UrelionPlugin.log.debug("Plugin disabling finished.");
	}

	/**
	 * process the basic {@link UrelionPlugin} initialization,
	 * before {@link Plugin} specific loading
	 *
	 * @see UrelionPlugin#whileLoad()
	 * @see UrelionPlugin#afterLoad()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void beforeLoad() {
		UrelionPlugin.log.info("Loading " + this.getName() + "...");

		UrelionPlugin.log.trace("Call onLoad method from super class.");
		super.onLoad();
	}

	/**
	 * process {@link Plugin} specific loading
	 *
	 * @see UrelionPlugin#beforeLoad()
	 * @see UrelionPlugin#afterLoad()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void whileLoad() {
		UrelionPlugin.log.debug(
			this.getName() + " has no specific loading sequence!"
		);
	}

	/**
	 * finishing the {@link Plugin} loading process
	 *
	 * @see UrelionPlugin#beforeLoad()
	 * @see UrelionPlugin#afterLoad()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void afterLoad() {
		UrelionPlugin.log.info(this.getName() + " loaded.");
	}

	/**
	 * process the basic {@link UrelionPlugin} initialization,
	 * before {@link Plugin} specific enabling
	 *
	 * @see UrelionPlugin#whileEnable()
	 * @see UrelionPlugin#afterEnable()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void beforeEnable() {
		UrelionPlugin.log.info("Enabling " + this.getName() + "...");

		UrelionPlugin.log.trace("Call onEnable method from super class.");
		super.onEnable();
	}

	/**
	 * process {@link Plugin} specific enabling
	 *
	 * @see UrelionPlugin#beforeEnable()
	 * @see UrelionPlugin#afterEnable()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void whileEnable() {
		UrelionPlugin.log.debug(
			this.getName() + " has no specific enabling sequence!"
		);
	}

	/**
	 * finishing the {@link Plugin} enabling process
	 *
	 * @see UrelionPlugin#beforeEnable()
	 * @see UrelionPlugin#afterEnable()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void afterEnable() {
		UrelionPlugin.log.info(this.getName() + " enabled.");
	}

	/**
	 * process the basic {@link UrelionPlugin} initialization,
	 * before {@link Plugin} specific disabling
	 *
	 * @see UrelionPlugin#whileDisable()
	 * @see UrelionPlugin#afterDisable()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void beforeDisable() {
		UrelionPlugin.log.info("Disabling " + this.getName() + "...");

		UrelionPlugin.log.trace("Call onDisable method from super class.");
		super.onDisable();
	}

	/**
	 * process {@link Plugin} specific disabling
	 *
	 * @see UrelionPlugin#beforeDisable()
	 * @see UrelionPlugin#afterDisable()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void whileDisable() {
		UrelionPlugin.log.debug(
			this.getName() + " has no specific disabling sequence!"
		);
	}

	/**
	 * finishing the {@link Plugin} disabling process
	 *
	 * @see UrelionPlugin#beforeDisable()
	 * @see UrelionPlugin#afterDisable()
	 *
	 * @since 2.0.0
	 */
	@Keep
	public void afterDisable() {
		UrelionPlugin.log.info(this.getName() + " disabled.");
	}
}
