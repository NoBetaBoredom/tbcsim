package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.itemsets.ItemSets
import `data`.model.Color
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import `data`.socketbonus.SocketBonuses
import character.Buff
import character.Stats
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public class LightbringerPauldrons : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 30996

  public override var name: String = "Lightbringer Pauldrons"

  public override var itemLevel: Int = 146

  public override var quality: Int = 4

  public override var icon: String = "inv_shoulder_60.jpg"

  public override var inventorySlot: Int = 3

  public override var itemSet: ItemSet? = ItemSets.byId(681)

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.ARMOR

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.PLATE

  public override var allowableClasses: Array<Constants.AllowableClass>? = arrayOf(
      Constants.AllowableClass.PALADIN
      )

  public override var minDmg: Double = 0.0

  public override var maxDmg: Double = 0.0

  public override var speed: Double = 0.0

  public override var stats: Stats = Stats(
      stamina = 34,
      intellect = 29,
      armor = 1369,
      spellCritRating = 18.0
      )

  public override var sockets: Array<Socket> = arrayOf(
      Socket(Color.YELLOW),
      Socket(Color.BLUE)
      )

  public override var socketBonus: SocketBonus? = SocketBonuses.byId(2974)

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(36062, "Increase Healing 86", this),
        Buffs.byIdOrName(21629, "Increased Mana Regen", this)
        )}

}
