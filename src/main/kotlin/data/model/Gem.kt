package data.model

import character.Stats
import data.Constants

abstract class Gem(gemStats: List<GemStat>, val color: Color, val quality: Quality): Item() {

    constructor(prefix: Prefix, color: Color, quality: Quality) : this(prefix.stat, color, quality)

    init {
        // Convert GemStats to item stats
        val tmpStats = Stats()
        for(gemStat in gemStats) {
            val value = when(quality) {
                Quality.UNCOMMON -> gemStat.uncommonValue
                Quality.RARE -> gemStat.rareValue
                Quality.EPIC -> gemStat.epicValue
                Quality.META -> gemStat.metaValue
            }
            tmpStats.addByStatType(gemStat.stat, value)
        }

        this.stats = tmpStats
    }

    // Meta gem color requirements
    internal fun socketsByColor(sockets: List<Socket>): Map<Color, Int> {
        // Find all gems that match red/yellow/blue, and count them
        val byColor = mutableMapOf<Color, Int>()
        byColor[Color.RED] = 0
        byColor[Color.YELLOW] = 0
        byColor[Color.BLUE] = 0

        sockets.filter { it.gem != null }.forEach {
            if(Color.matchesColor(it.gem!!, Color.RED)) {
                byColor[Color.RED] = byColor[Color.RED]!! + 1
            }
            if(Color.matchesColor(it.gem!!, Color.YELLOW)) {
                byColor[Color.YELLOW] = byColor[Color.YELLOW]!! + 1
            }
            if(Color.matchesColor(it.gem!!, Color.BLUE)) {
                byColor[Color.BLUE] = byColor[Color.BLUE]!! + 1
            }
        }

        return byColor
    }

    open fun metaActive(sockets: List<Socket>): Boolean {
        val byColor = socketsByColor(sockets)

        // Most meta gems have a requirement of at least 2 of each color
        // Ones that do not will override this
        return byColor[Color.RED] ?: 0 >= 2 &&
                byColor[Color.YELLOW] ?: 0 >= 2 &&
                byColor[Color.BLUE] ?: 0 >= 2
    }

    enum class Quality {
        UNCOMMON,
        RARE,
        EPIC,
        META
    }

    data class GemStat(
        val stat: Constants.StatType,
        val uncommonValue: Int = 0,
        val rareValue: Int = 0,
        val epicValue: Int = 0,
        val metaValue: Int = 0
    )

    enum class Prefix(val stat: List<GemStat>) {
        // Red
        DELICATE(listOf(GemStat(Constants.StatType.AGILITY, 6, 8, 10))),
        BOLD(listOf(GemStat(Constants.StatType.STRENGTH, 6, 8, 10))),
        BRIGHT(listOf(GemStat(Constants.StatType.ATTACK_POWER, 12, 14, 16))),
        TEARDROP(listOf(GemStat(Constants.StatType.SPELL_DAMAGE, 7, 9, 12))),
        RUNED(listOf(GemStat(Constants.StatType.SPELL_DAMAGE, 7, 9, 12))),
        FLASHING(listOf(GemStat(Constants.StatType.PARRY_RATING, 0, 8, 10))),
        SUBTLE(listOf(GemStat(Constants.StatType.DODGE_RATING, 0, 8, 10))),

        // Yellow
        GLEAMING(listOf(GemStat(Constants.StatType.CRIT_RATING, 6, 8, 10))),
        SMOOTH(listOf(GemStat(Constants.StatType.CRIT_RATING, 6, 8, 10))),
        BRILLIANT(listOf(GemStat(Constants.StatType.INTELLECT, 6, 8, 10))),
        THICK(listOf(GemStat(Constants.StatType.DEFENSE_SKILL_RATING, 6, 8, 10))),
        GREAT(listOf(GemStat(Constants.StatType.HIT_RATING, 6, 8, 10))),
        RIGID(listOf(GemStat(Constants.StatType.HIT_RATING, 6, 8, 10))),
        MYSTIC(listOf(GemStat(Constants.StatType.RESILIENCE_RATING, 6, 8, 10))),
        QUICK(listOf(GemStat(Constants.StatType.HASTE_RATING, 6, 8, 10))),

        // Blue
        SOLID(listOf(GemStat(Constants.StatType.STAMINA, 9, 12, 15))),
        SPARKLING(listOf(GemStat(Constants.StatType.SPIRIT, 6, 8, 10))),
        LUSTROUS(listOf(GemStat(Constants.StatType.MANA_PER_5_SECONDS, 2, 3, 4))),
        STORMY(listOf(GemStat(Constants.StatType.SPELL_PEN, 8, 10, 12))),

        // Orange
        INSCRIBED(listOf(
            GemStat(Constants.StatType.STRENGTH, 3, 4, 5),
            GemStat(Constants.StatType.CRIT_RATING, 3, 4, 5)
        )),
        GLINTING(listOf(
            GemStat(Constants.StatType.AGILITY, 3, 4, 5),
            GemStat(Constants.StatType.HIT_RATING, 3, 4, 5)
        )),
        POTENT(listOf(
            GemStat(Constants.StatType.SPELL_DAMAGE, 4, 5, 6),
            GemStat(Constants.StatType.CRIT_RATING, 3, 4, 5)
        )),
        WICKED(listOf(
            GemStat(Constants.StatType.ATTACK_POWER, 6, 8, 10),
            GemStat(Constants.StatType.CRIT_RATING, 3, 4, 5)
        )),
        VEILED(listOf(
            GemStat(Constants.StatType.SPELL_DAMAGE, 4, 5, 6),
            GemStat(Constants.StatType.HIT_RATING, 3, 4, 5)
        )),
        LUMINOUS(listOf(
            GemStat(Constants.StatType.SPELL_DAMAGE, 4, 5, 6),
            GemStat(Constants.StatType.INTELLECT, 3, 4, 5)
        )),
        RECKLESS(listOf(
            GemStat(Constants.StatType.SPELL_DAMAGE, 4, 5, 6),
            GemStat(Constants.StatType.HASTE_RATING, 3, 4, 5)
        )),

        //Green
        JAGGED(listOf(
            GemStat(Constants.StatType.CRIT_RATING, 3, 4, 5),
            GemStat(Constants.StatType.STAMINA, 4, 6, 7)
        )),
        ENDURING(listOf(
            GemStat(Constants.StatType.DEFENSE_SKILL_RATING, 3, 4, 5),
            GemStat(Constants.StatType.STAMINA, 4, 6, 7)
        )),
        DAZZLING(listOf(
            GemStat(Constants.StatType.INTELLECT, 3, 4, 5),
            GemStat(Constants.StatType.MANA_PER_5_SECONDS, 1, 2, 3)
        )),
        RADIANT(listOf(
            GemStat(Constants.StatType.CRIT_RATING, 3, 4, 5),
            GemStat(Constants.StatType.SPELL_PEN, 4, 5, 6)
        )),
        STEADY(listOf(
            GemStat(Constants.StatType.RESILIENCE_RATING, 4, 5, 6),
            GemStat(Constants.StatType.STAMINA, 4, 6, 7)
        )),

        // Purple
        SOVEREIGN(listOf(
            GemStat(Constants.StatType.STRENGTH, 3, 4, 5),
            GemStat(Constants.StatType.STAMINA, 4, 6, 7)
        )),
        SHIFTING(listOf(
            GemStat(Constants.StatType.AGILITY, 3, 4, 5),
            GemStat(Constants.StatType.STAMINA, 4, 6, 7)
        )),
        GLOWING(listOf(
            GemStat(Constants.StatType.SPELL_DAMAGE, 4, 5, 6),
            GemStat(Constants.StatType.STAMINA, 4, 6, 7)
        )),
        BALANCED(listOf(
            GemStat(Constants.StatType.ATTACK_POWER, 6, 8, 10),
            GemStat(Constants.StatType.STAMINA, 4, 6, 7)
        )),
        ROYAL(listOf(
            GemStat(Constants.StatType.SPELL_DAMAGE, 4, 5, 6),
            GemStat(Constants.StatType.MANA_PER_5_SECONDS, 1, 2, 3)
        )),
        INFUSED(listOf(
            GemStat(Constants.StatType.ATTACK_POWER, 6, 8, 10),
            GemStat(Constants.StatType.MANA_PER_5_SECONDS, 1, 2, 2)
        )),
        PURIFIED(listOf(
            GemStat(Constants.StatType.SPELL_DAMAGE, 4, 5, 6),
            GemStat(Constants.StatType.SPIRIT, 3, 4, 5)
        )),
        REGAL(listOf(
            GemStat(Constants.StatType.DODGE_RATING, 0, 4, 5),
            GemStat(Constants.StatType.STAMINA, 0, 6, 6)
        )),
    }
}
