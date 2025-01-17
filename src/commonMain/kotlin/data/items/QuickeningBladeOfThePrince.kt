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
public class QuickeningBladeOfThePrince : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 34609

  public override var name: String = "Quickening Blade of the Prince"

  public override var itemLevel: Int = 125

  public override var quality: Int = 4

  public override var icon: String = "inv_sword_64.jpg"

  public override var inventorySlot: Int = 13

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.SWORD_1H

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 96.0

  public override var maxDmg: Double = 180.0

  public override var speed: Double = 1500.0

  public override var stats: Stats = Stats(
      stamina = 27
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(15808, "Attack Power 38", this),
        Buffs.byIdOrName(40680, "Armor Penetration 126", this)
        )}

}
