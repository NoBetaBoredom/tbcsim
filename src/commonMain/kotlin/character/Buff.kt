package character

import mu.KotlinLogging
import sim.SimIteration

abstract class Buff {
    open class State {
        val logger = KotlinLogging.logger {}
        var currentStacks: Int = 0
            set(value) {
                field = if(value < 0) {
                    logger.warn { "Buff currentStacks cannot be set below 0 - this is probably a bug" }
                    0
                } else value
            }
        var currentCharges: Int = 0
            set(value) {
                field = if(value < 0) {
                    logger.warn { "currentCharges cannot be set below 0 - this is probably a bug" }
                    0
                } else value
            }
        var appliedAtMs: Int = 0
    }

    enum class Mutex {
        NONE,
        AIR_TOTEM,
        FIRE_TOTEM,
        WATER_TOTEM,
        EARTH_TOTEM,
        BATTLE_ELIXIR,
        GUARDIAN_ELIXIR,
        POTION,
        FOOD,
        WEAPON_TEMP_ENH_MH,
        WEAPON_TEMP_ENH_OH
    }

    open val id: Int = -1
    abstract val name: String
    abstract val durationMs: Int
    open val mutex: List<Mutex> = listOf(Mutex.NONE)

    open val hidden: Boolean = false
    open val maxStacks: Int = 0
    open val maxCharges: Int = 0

    // Buff implementations can implement their own state containers
    internal open fun stateFactory(): State {
        return State()
    }

    internal open fun sharedState(name: String, sim: SimIteration): State {
        // Create state object if it does not exist, and return it
        val state = sim.sharedBuffState[name] ?: stateFactory()
        sim.sharedBuffState[name] = state
        return state
    }

    internal open fun state(sim: SimIteration): State {
        // Create state object if it does not exist, and return it
        val state = sim.buffState[this] ?: stateFactory()
        sim.buffState[this] = state
        return state
    }

    open fun refresh(sim: SimIteration) {
        val state = state(sim)

        // Always refresh buff application time
        state.appliedAtMs = sim.elapsedTimeMs

        // Add stacks if it stacks
        if (maxStacks > 0 && state.currentStacks < maxStacks) {
            // Increase stacks
            state.currentStacks += 1
        }

        // Refresh charges if it has charges
        state.currentCharges = maxCharges
    }

    open fun reset(sim: SimIteration) {
        val state = state(sim)

        state.currentStacks = 0
        state.currentCharges = maxCharges
    }

    open fun isFinished(sim: SimIteration): Boolean {
        val state = state(sim)

        val noChargesLeft = maxCharges > 0 && state.currentCharges <= 0

        // Duration of -1 means static
        val isExpired = durationMs != -1 && remainingDurationMs(sim) <= 0

        return noChargesLeft || isExpired
    }

    open fun remainingDurationMs(sim: SimIteration): Int {
        return if(durationMs == -1) {
            // 24 hours in ms
            1000 * 60 * 60 * 24
        } else {
            val state = state(sim)
            ((state.appliedAtMs + durationMs) - sim.elapsedTimeMs).coerceAtLeast(0)
        }
    }

    open fun modifyStats(sim: SimIteration): Stats? {
        return null
    }

    open fun procs(sim: SimIteration): List<Proc> = listOf()
}