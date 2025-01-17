package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
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
public class GuardiansChainGirdle : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 35151

  public override var name: String = "Guardian's Chain Girdle"

  public override var itemLevel: Int = 159

  public override var quality: Int = 4

  public override var icon: String = "inv_belt_13.jpg"

  public override var inventorySlot: Int = 6

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.ARMOR

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.MAIL

  public override var allowableClasses: Array<Constants.AllowableClass>? = arrayOf(
      Constants.AllowableClass.HUNTER,
      Constants.AllowableClass.SHAMAN
      )

  public override var minDmg: Double = 0.0

  public override var maxDmg: Double = 0.0

  public override var speed: Double = 0.0

  public override var stats: Stats = Stats(
      agility = 37,
      stamina = 52,
      intellect = 27,
      armor = 624,
      meleeCritRating = 22.0,
      rangedCritRating = 22.0,
      resilienceRating = 21.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(15811, "Attack Power 46", this)
        )}

}
