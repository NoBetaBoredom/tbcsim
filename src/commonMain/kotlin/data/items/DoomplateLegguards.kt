package `data`.items

import `data`.Constants
import `data`.itemsets.ItemSets
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
public class DoomplateLegguards : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 27870

  public override var name: String = "Doomplate Legguards"

  public override var itemLevel: Int = 115

  public override var quality: Int = 3

  public override var icon: String = "inv_pants_plate_12.jpg"

  public override var inventorySlot: Int = 7

  public override var itemSet: ItemSet? = ItemSets.byId(661)

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.ARMOR

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.PLATE

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 0.0

  public override var maxDmg: Double = 0.0

  public override var speed: Double = 0.0

  public override var stats: Stats = Stats(
      strength = 36,
      stamina = 33,
      armor = 1019,
      meleeCritRating = 27.0,
      rangedCritRating = 27.0,
      physicalHitRating = 17.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOf()}

}
