package world.urelion;

import lombok.extern.slf4j.Slf4j;
import org.bukkit.plugin.java.JavaPlugin;

@Slf4j
public abstract class UrelionPlugin
extends JavaPlugin {
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

	public void beforeLoad() {
		UrelionPlugin.log.info("Loading " + this.getName() + "...");

		UrelionPlugin.log.trace("Call onLoad method from super class.");
		super.onLoad();
	}

	public void whileLoad() {
		UrelionPlugin.log.debug(
			this.getName() + " has no specific loading sequence!"
		);
	}

	public void afterLoad() {
		UrelionPlugin.log.info(this.getName() + " loaded.");
	}

	public void beforeEnable() {
		UrelionPlugin.log.info("Enabling " + this.getName() + "...");

		UrelionPlugin.log.trace("Call onEnable method from super class.");
		super.onEnable();
	}

	public void whileEnable() {
		UrelionPlugin.log.debug(
			this.getName() + " has no specific enabling sequence!"
		);
	}

	public void afterEnable() {
		UrelionPlugin.log.info(this.getName() + " enabled.");
	}

	public void beforeDisable() {
		UrelionPlugin.log.info("Disabling " + this.getName() + "...");

		UrelionPlugin.log.trace("Call onDisable method from super class.");
		super.onDisable();
	}

	public void whileDisable() {
		UrelionPlugin.log.debug(
			this.getName() + " has no specific disabling sequence!"
		);
	}

	public void afterDisable() {
		UrelionPlugin.log.info(this.getName() + " disabled.");
	}
}
