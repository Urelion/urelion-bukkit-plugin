package world.urelion;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.DrilldownPie;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.graalvm.compiler.core.common.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import proguard.annotation.Keep;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
	 * the {@link Plugin} identifier on the bStats platform
	 *
	 * @since 2.0.0
	 */
	@Getter
	private           int     bStatsPluginId = -1;
	/**
	 * the bStats {@link Metrics} of the {@link Plugin}
	 *
	 * @since 2.0.0
	 */
	@SuppressFBWarnings(
		value = "EI_EXPOSE_REP",
		justification = "Getter is generated by Lombok."
	)
	@Getter
	private @Nullable Metrics metrics        = null;

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
		UrelionPlugin.log.trace(
			"Call sequence to process after plugin loading."
		);
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

	/**
	 * sets the bStats plugin identifier
	 *
	 * @param bStatsPluginId the bStats {@link Plugin} identifier
	 *
	 * @throws IllegalArgumentException if the given {@link Plugin} identifier
	 *                                  is invalid
	 *
	 * @since 2.0.0
	 */
	public void setbStatsPluginId(final int bStatsPluginId)
	throws IllegalArgumentException {
		UrelionPlugin.log.debug(
			"Set the bStats plugin identifier to " + bStatsPluginId + "."
		);
		this.bStatsPluginId = bStatsPluginId;
		UrelionPlugin.log.debug("Create bStats Metrics.");
		this.createMetrics(bStatsPluginId);
	}

	/**
	 * creates a bStats {@link Metrics} for statistics
	 *
	 * @param bStatsPluginId the {@link Plugin} identifier on bStats
	 *
	 * @throws IllegalArgumentException if the {@link Plugin} identifier
	 *                                  is invalid
	 *
	 * @since 2.0.0
	 */
	private void createMetrics(final int bStatsPluginId)
	throws IllegalArgumentException {
		UrelionPlugin.log.debug(
			"Check if the bStats plugin identifier is valid."
		);
		if (bStatsPluginId <= 0) {
			final String errorMessage =
				"The given plugin identifier is invalid: " + bStatsPluginId;
			UrelionPlugin.log.error(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}

		UrelionPlugin.log.debug("Create bStats Metrics.");
		final @NotNull Metrics metrics = new Metrics(
			this,
			bStatsPluginId
		);

		/*
		 * Is not possible, because the metrics will only be sent,
		 * if the plugin is enabled.
		 */
		/*
		UrelionPlugin.log.debug("Create pie chart of plugin enabling.");
		metrics.addCustomChart(new SimplePie(
			"enabled",
			() -> String.valueOf(this.isEnabled())
		));
		*/

		UrelionPlugin.log.trace("Define level categories of max players.");
		final Set<Integer> maxPlayerCategories = (
			new TreeSet<>(Sets.newHashSet(1, 5, 10, 25, 50, 100))
		).descendingSet();

		UrelionPlugin.log.debug("Create pie chart of max players.");
		metrics.addCustomChart(new DrilldownPie("maxPlayers", () -> {
			UrelionPlugin.log.trace("Define overall map of the chart values.");
			final Map<String, Map<String, Integer>> overallMap =
				new HashMap<>();
			UrelionPlugin.log.trace("Get max players of server.");
			final int maxPlayers = this.getServer().getMaxPlayers();
			UrelionPlugin.log.trace("Set max value as highest limit.");
			int upperLimit = Integer.MAX_VALUE;
			UrelionPlugin.log.trace("Iterate over all max player categories.");
			for (int lowerLimit : maxPlayerCategories) {
				UrelionPlugin.log.trace(
					"Check if the max player setting " +
					"is in the current category."
				);
				if (maxPlayers >= lowerLimit) {
					UrelionPlugin.log.trace(
						"Create new inner map of the fixed max player setting."
					);
					Map<String, Integer> innerMap = new HashMap<>();
					UrelionPlugin.log.trace(
						"Set max player setting to chart value."
					);
					innerMap.put(String.valueOf(maxPlayers), 1);

					UrelionPlugin.log.trace("Define category range as name.");
					final String categoryRange;
					UrelionPlugin.log.trace(
						"Check if category is the highest category."
					);
					if (upperLimit < Integer.MAX_VALUE) {
						UrelionPlugin.log.trace(
							"Create name of normal category."
						);
						categoryRange = lowerLimit + " - " + upperLimit;
					} else {
						UrelionPlugin.log.trace(
							"Create name of highest category."
						);
						categoryRange = "> " + lowerLimit;
					}

					UrelionPlugin.log.trace("Add value to chart.");
					overallMap.put(categoryRange, innerMap);
					UrelionPlugin.log.trace("Stop category search.");
					break;
				}
				UrelionPlugin.log.trace(
					"Set lower limit as next upper limit."
				);
				upperLimit = lowerLimit;
			}
			UrelionPlugin.log.trace("Return chart values.");
			return overallMap;
		}));

		UrelionPlugin.log.trace("Set bStats Metrics.");
		this.metrics = metrics;
	}
}
