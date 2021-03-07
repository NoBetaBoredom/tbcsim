package character.classes.warlock.debuffs

import character.Ability
import character.Buff
import character.Debuff
import character.Proc
import character.classes.warlock.abilities.AmplifyCurse
import data.Constants
import mechanics.Spell
import sim.Event
import sim.SimIteration

class CurseOfDoom : Debuff() {
    companion object {
        const val name = "Curse of Doom"
    }

    override val name: String = Companion.name
    override val durationMs: Int = 60000
    override val tickDeltaMs: Int = 60000

    val doom = object : Ability() {
        override val id: Int = 27216
        override val name: String = Companion.name
        override fun gcdMs(sim: SimIteration): Int = 0

        val dmgPerTick = 4200.0
        val school = Constants.DamageType.SHADOW
        override fun cast(sim: SimIteration) {
            // Amplify Curse
            val ampCurseMultiplier = if(sim.buffs[AmplifyCurse.name] != null) { 1.5 } else 1.0
            sim.consumeBuff(object : Buff() {
                override val name: String = AmplifyCurse.name
                override val durationMs: Int = -1
            })

            // Per DBs this is 200% spell damage
            val spellPowerCoeff = 2.0
            val damageRoll = Spell.baseDamageRoll(sim, dmgPerTick, spellPowerCoeff, school) * ampCurseMultiplier

            val event = Event(
                eventType = Event.Type.DAMAGE,
                damageType = school,
                abilityName = name,
                amount = damageRoll,
                result = Event.Result.HIT,
            )
            sim.logEvent(event)

            sim.fireProc(listOf(Proc.Trigger.SHADOW_DAMAGE_NON_PERIODIC), listOf(), this, event)
        }
    }

    override fun tick(sim: SimIteration) {
        doom.cast(sim)
    }
}
