package character.classes.shaman.talents

import character.Buff
import character.Stats
import character.Talent
import sim.SimParticipant

class AncestralKnowledge(currentRank: Int) : Talent(currentRank) {
    companion object {
        const val name: String = "Ancestral Knowledge"
    }

    override val name: String = Companion.name
    override val maxRank: Int = 5

    val buff = object : Buff() {
        override val name: String = "Ancestral Knowledge"
        override val durationMs: Int = -1
        override val hidden: Boolean = true

        override fun modifyStats(sp: SimParticipant): Stats {
            val talentRanks = sp.character.klass.talents[AncestralKnowledge.name]?.currentRank ?: 0

            val modifier = 1 + (0.01 * talentRanks)
            return Stats(manaMultiplier = modifier)
        }
    }

    override fun buffs(sp: SimParticipant): List<Buff> = listOf(buff)
}
