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
public class KirusPresage : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 34671

  public override var name: String = "K'iru's Presage"

  public override var itemLevel: Int = 115

  public override var quality: Int = 3

  public override var icon: String = "inv_mace_34.jpg"

  public override var inventorySlot: Int = 21

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.MACE_1H

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 45.310001373291016

  public override var maxDmg: Double = 145.30999755859375

  public override var speed: Double = 2300.0

  public override var stats: Stats = Stats(
      stamina = 16,
      intellect = 13,
      spirit = 8
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(35338, "Increase Healing 228", this),
        Buffs.byIdOrName(21626, "Increased Mana Regen", this)
        )}

}
