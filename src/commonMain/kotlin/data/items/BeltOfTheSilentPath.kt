package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
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
public class BeltOfTheSilentPath : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 34929

  public override var name: String = "Belt of the Silent Path"

  public override var itemLevel: Int = 141

  public override var quality: Int = 4

  public override var icon: String = "inv_belt_03.jpg"

  public override var inventorySlot: Int = 6

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.ARMOR

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.LEATHER

  public override var minDmg: Double = 0.0

  public override var maxDmg: Double = 0.0

  public override var speed: Double = 0.0

  public override var stats: Stats = Stats(
      agility = 34,
      stamina = 33,
      physicalHitRating = 23.0
      )

  public override var sockets: Array<Socket> = arrayOf(
      Socket(Color.YELLOW)
      )

  public override var socketBonus: SocketBonus? = SocketBonuses.byId(3149)

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(15825, "Attack Power 78", this)
        )}

}