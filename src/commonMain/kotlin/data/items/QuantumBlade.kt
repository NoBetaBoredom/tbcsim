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
public class QuantumBlade : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 29356

  public override var name: String = "Quantum Blade"

  public override var itemLevel: Int = 105

  public override var quality: Int = 4

  public override var icon: String = "inv_sword_81.jpg"

  public override var inventorySlot: Int = 17

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.SWORD_2H

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 304.0

  public override var maxDmg: Double = 456.0

  public override var speed: Double = 3500.0

  public override var stats: Stats = Stats(
      stamina = 31,
      meleeCritRating = 30.0,
      rangedCritRating = 30.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(42107, "Attack Power 102", this)
        )}

}
